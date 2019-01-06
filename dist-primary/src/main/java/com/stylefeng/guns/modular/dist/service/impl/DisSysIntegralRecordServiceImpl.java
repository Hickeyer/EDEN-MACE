package com.stylefeng.guns.modular.dist.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.stylefeng.guns.common.annotion.DataSource;
import com.stylefeng.guns.common.constant.DSEnum;
import com.stylefeng.guns.common.constant.dist.AccountTypeStatus;
import com.stylefeng.guns.common.constant.dist.IdentityStatus;
import com.stylefeng.guns.common.persistence.dao.*;
import com.stylefeng.guns.common.persistence.model.*;
import com.stylefeng.guns.modular.dist.util.DateUtils;
import com.stylefeng.guns.modular.dist.vo.DisProfitRecordVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.stylefeng.guns.modular.dist.service.IDisSysIntegralRecordService;

import javax.annotation.Resource;
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

    @Resource
    DisRankParamMapper disRankParamMapper;

    @Resource
    DisMemberInfoMapper disMemberInfoMapper;

    @Resource
    DisRankIntegralRecordMapper disRankIntegralRecordMapper;

    @Resource
    SysDicMapper sysDicMapper;

    /**
     * 根据积分设置获取积分
     * @param accountType
     * @param amount
     * @param memberInfo
     */
    @Override
    @DataSource(name= DSEnum.DATA_SOURCE_BIZ)
    public void saveIntegral(String accountType,BigDecimal amount,DisMemberInfo memberInfo) throws Exception {

        //dis_pro_type可以是交易，升级、邀请等等
        Wrapper<DisRankParam> profiParamP=new EntityWrapper<>();
        profiParamP.eq("dis_platform_id",memberInfo.getDisPlatformId())
                .eq("account_type",accountType);
        List<DisRankParam> profiParamList=disRankParamMapper.selectList(profiParamP);
        if(profiParamList.size()>0){
            if(memberInfo==null){
                return ;
            }
            String[] levelInfo=memberInfo.getDisFullIndex().split("\\.");
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
                    BigDecimal newIntegralBg=new BigDecimal(0);
                    if("0".equals(disRankParam.getCalModel())){
                        newIntegralBg=amount.multiply(value).setScale(0,BigDecimal.ROUND_HALF_UP);
                    }else{
                        newIntegralBg=value.setScale(0,BigDecimal.ROUND_HALF_UP);
                    }
                    Integer newIntegral=Integer.parseInt(String.valueOf(newIntegralBg));
                    Integer totalIntegral=newIntegral+subMember.getRankIntegral();
                    DisRankIntegralRecord record = new DisRankIntegralRecord();
                    record.setBeforeIntegral(subMember.getRankIntegral());
                    record.setIsUse("N");
                    record.setAfterIntegral(totalIntegral);
                    record.setAccountType(accountType);
                    record.setAddTime(DateUtils.longToDateAll(System.currentTimeMillis()));
                    record.setDisUserId(userId);
                    record.setSourceUserId(memberInfo.getDisUserId());
                    record.setSysIntegral(newIntegral);

                    SysDic dic=new SysDic();
                    dic.setDicTypeNo("effectiveTime");
                    SysDic sysDic=sysDicMapper.selectOne(dic);
                    record.setExpireTime(DateUtils.plusDay(Integer.parseInt(sysDic.getDicNo())));
                    String sourceRemark="";
                    if("0".equals(accountType)){
                        String des= AccountTypeStatus.ZERO_STATUS.getIntDes();
                        sourceRemark=String.format(des,memberInfo.getDisUserId()
                                ,amount.toString()
                                ,totalIntegral);
                    }else if("1".equals(accountType)){
                        String des= AccountTypeStatus.ONE_STATUS.getIntDes();
                        sourceRemark=String.format(des,memberInfo.getDisUserId()
                                ,totalIntegral);
                    }else if("2".equals(accountType)){
                        String des= AccountTypeStatus.TWO_STATUS.getIntDes();
                        sourceRemark=String.format(des,memberInfo.getDisUserId()
                                ,totalIntegral);
                    }else {
                        throw  new Exception("没有对应积分账户类型");
                    }
                    record.setSourceRemak(sourceRemark);
                    //新增积分
                    disRankIntegralRecordMapper.insert(record);
                    subMember.setRankIntegral(totalIntegral);
                    subMember.setTotalRankIntegral(totalIntegral);
                    //更新积分
                    disMemberInfoMapper.updateById(subMember);
                }
            }
        }
    }

}
