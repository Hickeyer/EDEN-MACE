package com.stylefeng.guns.modular.dist.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.stylefeng.guns.common.annotion.DataSource;
import com.stylefeng.guns.common.constant.DSEnum;
import com.stylefeng.guns.common.constant.dist.IdentityStatus;
import com.stylefeng.guns.common.persistence.dao.*;
import com.stylefeng.guns.common.persistence.model.*;
import com.stylefeng.guns.modular.dist.util.DateUtils;
import com.stylefeng.guns.modular.dist.vo.DisProfitRecordVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.stylefeng.guns.modular.dist.service.IDisSysIntegralRecordService;

import java.math.BigDecimal;
import java.util.List;

/**
 * 系统积分记录Dao
 *
 * @author xiaojiang
 * @Date 2018-07-22 01:43:55
 */
@Service
public class DisSysIntegralRecordServiceImpl implements IDisSysIntegralRecordService {

    @Autowired
    DisRankParamMapper disRankParamMapper;

    @Autowired
    DisMemberInfoMapper disMemberInfoMapper;

    @Autowired
    DisSysIntegralRecordMapper disSysIntegralRecordMapper;

    @Autowired
    SysDicMapper sysDicMapper;

    /**
     * 根据积分设置获取积分
     * @param param
     * @param memberInfo
     */
    @Override
    @DataSource(name= DSEnum.DATA_SOURCE_BIZ)
    public void saveMember(DisProfitRecordVo param,DisMemberInfo memberInfo){

        //dis_pro_type可以是交易分润 上下级分润等等
        //根据平台id和平台属性查询对应的分润信息，如交易分润，开始计算交易分润对应的数据
        //对会员级别的数据进行分润分配，并且加入到余额中去
        //对平台级别的数据进行分润分配，并且加入到余额中去
        Wrapper<DisRankParam> profiParamP=new EntityWrapper<>();
        profiParamP.eq("dis_platform_id",param.getDisPlatformId())
                .eq("dis_pro_type",param.getDisProType());
        List<DisRankParam> profiParamList=disRankParamMapper.selectList(profiParamP);
        if(profiParamList.size()>0){
            if(memberInfo==null){
                return ;
            }
            String levelInfo[]=memberInfo.getDisFullIndex().split("\\.");
            for (DisRankParam disRankParam:profiParamList){
                Integer level=Integer.parseInt(disRankParam.getDisProLevel());
                if(level<=levelInfo.length-1){
                    //如果等级不对也无需计算分润
                    String userId= levelInfo[levelInfo.length-(level+1)];
                    DisMemberInfo subMemberParam=new DisMemberInfo();
                    subMemberParam.setDisUserId(userId);
                    DisMemberInfo subMember=disMemberInfoMapper.selectOne(subMemberParam);
                    //如果用户的用户类型和分润的用户类型不一样则不能分配分润，跳转到下一个，继续执行
                    if(!subMember.getDisUserType().equals(disRankParam.getDisUserType())){
                        continue;
                    }
                    BigDecimal value=new BigDecimal(disRankParam.getDisIntegralValue());
                    BigDecimal newIntegral_bg=new BigDecimal(0);
                    if("0".equals(disRankParam.getDisProMode())){
                        newIntegral_bg=param.getDisAmount().multiply(value).setScale(0,BigDecimal.ROUND_HALF_UP);
                    }else{
                        newIntegral_bg=value.setScale(0,BigDecimal.ROUND_HALF_UP);
                    }
                    Integer newIntegral=Integer.parseInt(String.valueOf(newIntegral_bg));
                    Integer totalIntegral=newIntegral+subMember.getRankIntegral();
                    DisSysIntegralRecord record = new DisSysIntegralRecord();
                    record.setBeforeIntegral(subMember.getRankIntegral());
                    record.setIsUse("N");
                    record.setAfterIntegral(totalIntegral);
                    record.setDisProType(param.getDisProType());
                    record.setAddTime(DateUtils.longToDateAll(System.currentTimeMillis()));
                    record.setDisUserId(userId);
                    record.setSourceUserId(memberInfo.getDisUserId());
                    record.setSysIntegral(totalIntegral);

                    SysDic dic=new SysDic();
                    dic.setDicTypeNo("effectiveTime");
                    SysDic sysDic=sysDicMapper.selectOne(dic);
                    record.setExpireTime(DateUtils.plusDay(Integer.parseInt(sysDic.getDicNo())));
                    record.setSourceRemak("您的下级"+memberInfo.getDisUserId()+"交易"+param.getDisAmount()+"，你获得"+totalIntegral+"积分");
                    //新增积分
                    disSysIntegralRecordMapper.insert(record);
                    subMember.setRankIntegral(totalIntegral);
                    //更新积分
                    disMemberInfoMapper.updateById(subMember);
                }
            }
        }
    }

}
