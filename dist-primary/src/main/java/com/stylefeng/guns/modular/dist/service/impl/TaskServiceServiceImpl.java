package com.stylefeng.guns.modular.dist.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.stylefeng.guns.common.constant.dist.UserRankStatus;
import com.stylefeng.guns.common.persistence.dao.*;
import com.stylefeng.guns.common.persistence.model.*;
import com.stylefeng.guns.modular.dist.service.ISysDicService;
import com.stylefeng.guns.modular.dist.service.ITaskService;
import com.stylefeng.guns.modular.dist.util.DateUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
/**
 * @date 2019-01-07
 * @author xiaojiang
 */
public class TaskServiceServiceImpl implements ITaskService {

    private Logger logger =  LoggerFactory.getLogger(TaskServiceServiceImpl.class);
    @Autowired
    ISysDicService sysDicService;

    @Resource
    DisRankIntegralRecordMapper disRankIntegralRecordMapper;

    @Resource
    SysDicMapper sysDicMapper;

    @Resource
    DisUpgradeParamMapper disUpgradeParamMapper;

    @Resource
    DisMemberInfoMapper disMemberInfoMapper;


    @Resource
    DisUpgradeRecordMapper disUpgradeRecordMapper;

    /**
     * 根据类型处理用户和代理商的水平等级
     * @link {com.stylefeng.guns.common.constant.dist.IdentityStatus }
     * @param type
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void upgradeLevel(String type) {
        //查询大于0的积分代理商或者会员的积分
        Wrapper<DisMemberInfo> wrapper=new EntityWrapper();
        wrapper.gt("rank_integral","0")
                .eq("type", type);
        List<DisMemberInfo> memberInfoList=disMemberInfoMapper.selectList(wrapper);

        if(memberInfoList!=null){
            memberInfoList.forEach((memberInfo)->{
                //开始对会员或者代理商进行处理
                SysDic param=new SysDic();
                //后台设置isTotalIntegral的值（是否按照总积分计算）
                //因为如果平台的宽容政策，以前的积分也进行累计积分判断，
                // 或者根据平台阶段性配置，对以前的积分清零
                //如果按照总积分即totalRankIntegral 不清零的积分 计算
                //如果按照分期积分即按照rankIntegral 清零的积分 计算
                //分销配置>分销字典管理
                param.setDicTypeNo("isTotalIntegral");
                SysDic sysDic = sysDicMapper.selectOne(param);
                //判断是根据总积分还是根据每个阶段的额度进行级别判定
                Integer integral=0;
                if("Y".equals(sysDic.getDicValue())){
                    integral=memberInfo.getTotalRankIntegral();
                }else if("N".equals(sysDic.getDicValue())){
                    integral=memberInfo.getRankIntegral();
                }else {
                    logger.info("类型错误！");
                    return;
                }
                //分销配置>会员垂直升级配置/代理垂直升级配置
                //根据垂直升级配置来实现会员或者垂直代理的升级
                Wrapper<DisUpgradeParam> upgradeParam = new EntityWrapper<>();
                upgradeParam.eq("identity_type", type);
                List<DisUpgradeParam> upgradeParams = disUpgradeParamMapper.selectList(upgradeParam);
                //根据目前的积分获取可以获得的等级
                String rank="";
                if(upgradeParams!=null){
                    Integer finalIntegral = integral;
                    for (DisUpgradeParam upgrade:upgradeParams){
                        int max=upgrade.getBeginIntegral();
                        int min = upgrade.getEndIntegral();
                        if(finalIntegral >=min&& finalIntegral <=max){
                            rank=upgrade.getDisUserRank();
                        }
                    }
                }

                //如果没有配置相关等级，则不更新
                if(StringUtils.isEmpty(rank)){

                    return;
                }

                // 更新积分记录表
                // 将此阶段（此次更新到上次更新阶段）的积分是否使用更新为已使用
                Wrapper<DisRankIntegralRecord> wrapperIntegral=new EntityWrapper();
                wrapperIntegral.eq("dis_user_id",memberInfo.getDisUserId())
                        .eq("is_use","N");
                DisRankIntegralRecord record=new DisRankIntegralRecord();
                record.setIsUse("Y");
                record.setUseTime(DateUtils.getNowDateTime());
                disRankIntegralRecordMapper.update(record,wrapperIntegral);

                //新增升级记录
                DisUpgradeRecord upgradeRecord=new DisUpgradeRecord();
                upgradeRecord.setDisUserId(memberInfo.getDisUserId());
                upgradeRecord.setUpgradeTime(DateUtils.getNowDateTime());
                upgradeRecord.setBeforeUpgradeLevel(memberInfo.getDisUserRank());
                upgradeRecord.setAfterUpgradeLevel(rank);
                Integer diff= UserRankStatus.getMethod(rank).getOrder()-UserRankStatus.getMethod(memberInfo.getDisUserRank()).getOrder();
                upgradeRecord.setLevelDiffer(diff.toString());
                upgradeRecord.setLevelType("1");
                disUpgradeRecordMapper.insert(upgradeRecord);

                //更新积分,等级，rankIntegral清零，并且把等级更新成最新的等级
                memberInfo.setRankIntegral(0);
                memberInfo.setDisUserRank(rank);
                disMemberInfoMapper.updateById(memberInfo);

            });
        }
    }
}
