package com.stylefeng.guns.modular.dist.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.stylefeng.guns.common.annotion.DataSource;
import com.stylefeng.guns.common.constant.DSEnum;
import com.stylefeng.guns.common.persistence.dao.DisMemberInfoMapper;
import com.stylefeng.guns.common.persistence.dao.DisProfiParamMapper;
import com.stylefeng.guns.common.persistence.dao.DisProfitRecordMapper;
import com.stylefeng.guns.common.persistence.model.DisMemberInfo;
import com.stylefeng.guns.common.persistence.model.DisProfiParam;
import com.stylefeng.guns.common.persistence.model.DisProfitRecord;
import com.stylefeng.guns.core.shiro.ShiroKit;
import com.stylefeng.guns.modular.dist.dao.DisProfitRecordDao;
import com.stylefeng.guns.modular.dist.util.DateUtils;
import com.stylefeng.guns.modular.dist.vo.DisProfitRecordVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.stylefeng.guns.modular.dist.service.IDisProfitRecordService;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * 交易Dao
 *
 * @author fengshuonan
 * @Date 2018-04-06 12:19:23
 */
@Service
public class DisProfitRecordServiceImpl implements IDisProfitRecordService {


    @Autowired
    DisProfitRecordDao disProfitRecordDao;

    @Autowired
    DisProfiParamMapper disProfiParamMapper;

    @Autowired
    DisMemberInfoMapper disMemberInfoMapper;

    @Autowired
    DisProfitRecordMapper disProfitRecordMapper;

    @Override
    @DataSource(name=DSEnum.DATA_SOURCE_BIZ)
    public List<Map<String, Object>> selectList() {
        String account= ShiroKit.getUser().getAccount();
        List<Map<String, Object>> list=disProfitRecordDao.selectList(account);
        return list;
    }

    /**
     *  根据分润形式设置获取分润
     *  1、根据平台获取设置所有分润列表
     *  2、根据平台和id获取发起交易人员信息
     *  3、根据发起交易人员信息获取上级人员信息
     *  4、根据分润列表和上级人员信息进行匹配，进行分润
     * @param param
     */
    @Override
    public void save(DisProfitRecordVo param) {
        //获取有哪些需要分配分润
     /*   DisProfiParam profiParamP=new DisProfiParam();
        profiParamP.setDisPlatformId(param.getDisPlatformId());
        profiParamP.setDisProType(param.getDisProType());*/
        Wrapper<DisProfiParam> profiParamP=new EntityWrapper<>();
        profiParamP.eq("dis_platform_id",param.getDisPlatformId())
                .eq("dis_pro_type",param.getDisProType());
        List<DisProfiParam> profiParamList=disProfiParamMapper.selectList(profiParamP);
        if(profiParamList.size()>0){
            DisMemberInfo memberInfoParam=new DisMemberInfo();
            memberInfoParam.setDisPlatformId(param.getDisPlatformId());
            memberInfoParam.setDisUserId(param.getDisSetUserId());
            DisMemberInfo memberInfo=disMemberInfoMapper.selectOne(memberInfoParam);
            if(memberInfo==null){
                return ;
            }
            String levelInfo[]=memberInfo.getDisFullIndex().split("\\.");
            for (DisProfiParam disProfiParam:profiParamList){
                Integer level=Integer.parseInt(disProfiParam.getDisProLevel());
                if(level<=levelInfo.length-1){
                    String userId= levelInfo[levelInfo.length-(level+1)];
                    DisMemberInfo subMemberParam=new DisMemberInfo();
                    subMemberParam.setDisPlatformId(param.getDisPlatformId());
                    subMemberParam.setDisUserId(userId);
                    DisMemberInfo subMember=disMemberInfoMapper.selectOne(subMemberParam);
                    //如果是平台的话则只能获得平台分润，如果是会员的话则只能获取的会员分润
                    if(!subMember.getDisUserType().equals(disProfiParam.getDisUserType())){
                        continue;
                    }
                    //先设置会员分润
                    DisProfitRecord record=new DisProfitRecord();
                    record.setDisUserType(disProfiParam.getDisUserType());
                    record.setDisSetUserId(param.getDisSetUserId());
                    record.setDisNote(param.getNote());
                    record.setDisOrderId(param.getOrderId());
                    record.setDisProType(param.getDisProType());
                    BigDecimal value=new BigDecimal(disProfiParam.getDisProValue());
                    if("0".equals(disProfiParam.getDisProMode())){
                        record.setDisAmount(param.getDisAmount().multiply(value));
                    }else{
                        record.setDisAmount(value);
                    }

                    record.setDisGetUserId(userId);
                    record.setAddTime(DateUtils.longToDateAll(System.currentTimeMillis()));
                    record.setUpdateTime(DateUtils.longToDateAll(System.currentTimeMillis()));
                    record.setIsDelete("N");
                    disProfitRecordMapper.insert(record);
                }
            }
        }
    }
}
