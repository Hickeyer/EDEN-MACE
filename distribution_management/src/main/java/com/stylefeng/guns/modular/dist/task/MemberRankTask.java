package com.stylefeng.guns.modular.dist.task;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.stylefeng.guns.common.constant.dist.IdentityStatus;
import com.stylefeng.guns.common.constant.dist.UserRankStatus;
import com.stylefeng.guns.common.persistence.dao.*;
import com.stylefeng.guns.common.persistence.model.*;
import com.stylefeng.guns.core.util.BaseJob;
import com.stylefeng.guns.modular.dist.util.DateUtils;
import com.stylefeng.guns.modular.system.service.ISysDicService;
import org.apache.commons.lang.StringUtils;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 *积分任务调度
 * 规则：
 * 在当前时间下 所有的没有过期的 并且没有使用过的积分进行计算，给用户分配级别
 * 并且将对应的积分设置成已过期
 */
public class MemberRankTask implements BaseJob {


    private Logger logger =  LoggerFactory.getLogger(MemberRankTask.class);

    @Resource
    DisRankIntegralRecordMapper disRankIntegralRecordMapper;

    @Autowired
    ISysDicService sysDicService;

    @Resource
    SysDicMapper sysDicMapper;

    @Resource
    DisUpgradeParamMapper disUpgradeParamMapper;

    @Resource
    DisMemberInfoMapper disMemberInfoMapper;


    @Resource
    DisUpgradeRecordMapper disUpgradeRecordMapper;

    @Override
    @Transactional
    public void execute(JobExecutionContext context) throws JobExecutionException {
        //查询大于0的积分
        Wrapper<DisMemberInfo> wrapper=new EntityWrapper();
        wrapper.gt("rank_integral","0")
                .eq("type",IdentityStatus.USER_STATUS.getStatus());
        List<DisMemberInfo> memberInfoList=disMemberInfoMapper.selectList(wrapper);
        if(memberInfoList!=null){
            memberInfoList.forEach((memberInfo)->{
                SysDic param=new SysDic();
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
                //根据积分判断对应的等级
                Wrapper<DisUpgradeParam> upgradeParam = new EntityWrapper<>();
                upgradeParam.eq("identity_type", IdentityStatus.USER_STATUS.getStatus());
                List<DisUpgradeParam> upgradeParams = disUpgradeParamMapper.selectList(upgradeParam);
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


                if(StringUtils.isEmpty(rank)){

                    return;
                }

                // 更新积分记录表
                Wrapper<DisRankIntegralRecord> wrapperIntegral=new EntityWrapper();
                wrapperIntegral.eq("dis_user_id",memberInfo.getDisUserId())
                        .eq("is_use","N");
                DisRankIntegralRecord record=new DisRankIntegralRecord();
                record.setIsUse("Y");
                record.setUseTime(DateUtils.getNowDateTime());
                disRankIntegralRecordMapper.update(record,wrapperIntegral);

                //新增升级记录表

                DisUpgradeRecord upgradeRecord=new DisUpgradeRecord();
                upgradeRecord.setDisUserId(memberInfo.getDisUserId());
                upgradeRecord.setUpgradeTime(DateUtils.getNowDateTime());
                upgradeRecord.setBeforeUpgradeLevel(memberInfo.getDisUserRank());
                upgradeRecord.setAfterUpgradeLevel(rank);
                Integer diff= UserRankStatus.getMethod(rank).getOrder()-UserRankStatus.getMethod(memberInfo.getDisUserRank()).getOrder();
                upgradeRecord.setLevelDiffer(diff.toString());
                upgradeRecord.setLevelType("1");
                disUpgradeRecordMapper.insert(upgradeRecord);
                //更新积分,等级

                memberInfo.setRankIntegral(0);
                memberInfo.setDisUserRank(rank);
                disMemberInfoMapper.updateById(memberInfo);

            });
        }
    }


}
