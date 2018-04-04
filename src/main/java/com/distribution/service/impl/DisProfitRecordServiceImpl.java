package com.distribution.service.impl;

import com.distribution.common.mapper.DisMemberInfoMapper;
import com.distribution.common.mapper.DisProfiParamMapper;
import com.distribution.common.mapper.DisProfitRecordMapper;
import com.distribution.common.model.DisMemberInfo;
import com.distribution.common.model.DisProfiParam;
import com.distribution.common.model.DisProfitRecord;
import com.distribution.common.util.DateUtils;
import com.distribution.model.DisProfitRecordVo;
import com.distribution.service.DisProfitRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by huangpu on 2017/6/9.
 */
@Service
public class DisProfitRecordServiceImpl implements DisProfitRecordService {

    @Autowired
    DisProfiParamMapper disProfiParamMapper;

    @Autowired
    DisMemberInfoMapper disMemberInfoMapper;

    @Autowired
    DisProfitRecordMapper disProfitRecordMapper;

    /**
     *  根据分润形式设置获取分润
     *  1、根据平台获取设置所有分润列表
     *  2、根据平台和id获取发起交易人员信息
     *  3、根据发起交易人员信息获取上级人员信息
     *  4、根据分润列表和上级人员信息进行匹配，进行分润
     * @param param
     */
    public void save(DisProfitRecordVo param) {

        //获取有哪些需要分配分润
        DisProfiParam profiParamP=new DisProfiParam();
        profiParamP.setDisPlatformId(param.getDisPlatformId());
        profiParamP.setDisProType(param.getDisProType());
        List<DisProfiParam> profiParamList=disProfiParamMapper.selectValueList(profiParamP);
        if(profiParamList.size()>0){
            DisMemberInfo memberInfoParam=new DisMemberInfo();
            memberInfoParam.setDisPlatformId(param.getDisPlatformId());
            memberInfoParam.setDisUserId(param.getDisSetUserId());
            DisMemberInfo memberInfo=disMemberInfoMapper.select(memberInfoParam);
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
                    DisMemberInfo subMember=disMemberInfoMapper.select(subMemberParam);
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

    @Override
    public List<DisProfitRecord> list(DisProfitRecord param) {
        List<DisProfitRecord> list=disProfitRecordMapper.selectList(param);
        return list;
    }
}
