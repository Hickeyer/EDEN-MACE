package com.stylefeng.guns.modular.dist.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.stylefeng.guns.common.annotion.DataSource;
import com.stylefeng.guns.common.constant.DSEnum;
import com.stylefeng.guns.common.constant.dist.AccountTypeStatus;
import com.stylefeng.guns.common.constant.dist.IdentityStatus;
import com.stylefeng.guns.common.persistence.dao.DisMemberInfoMapper;
import com.stylefeng.guns.common.persistence.dao.DisProfitRecordMapper;
import com.stylefeng.guns.common.persistence.dao.DisTradeRecordMapper;
import com.stylefeng.guns.common.persistence.dao.DisWithdrawRecordMapper;
import com.stylefeng.guns.common.persistence.model.DisMemberInfo;
import com.stylefeng.guns.common.persistence.model.DisProfitRecord;
import com.stylefeng.guns.common.persistence.model.DisTradeRecord;
import com.stylefeng.guns.common.persistence.model.DisWithdrawRecord;
import com.stylefeng.guns.modular.dist.dao.DisTradeRecordDao;
import com.stylefeng.guns.modular.dist.service.IStatisticsService;
import com.stylefeng.guns.modular.dist.util.DateUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.*;

/**
 * @author  xiaojiang
 */
@Service
public class StatisticsServiceImpl  implements IStatisticsService {

    @Resource
    DisMemberInfoMapper disMemberInfoMapper;

    @Resource
    DisProfitRecordMapper disProfitRecordMapper;

    @Resource
    DisWithdrawRecordMapper disWithdrawRecordMapper;

    @Resource
    DisTradeRecordMapper disTradeRecordMapper;

    @Resource
    DisTradeRecordDao disTradeRecordDao;

    @Override
    @DataSource(name = DSEnum.DATA_SOURCE_BIZ)
    public String findStatisticsInfo() {
        Map map = new HashMap();
        Wrapper<DisMemberInfo> memberInfoWrapper=new EntityWrapper();
        memberInfoWrapper.eq("type", IdentityStatus.USER_STATUS.getStatus());
        int memberCount =  disMemberInfoMapper.selectCount(memberInfoWrapper);
        map.put("memberCount",memberCount);

        Wrapper<DisMemberInfo> agentMemberWrapper=new EntityWrapper();
        agentMemberWrapper.eq("type", IdentityStatus.PLAT_STATUS.getStatus());
        int agentCount =  disMemberInfoMapper.selectCount(agentMemberWrapper);
        map.put("agentCount",agentCount);

        Wrapper<DisProfitRecord> tradeWrapper = new EntityWrapper<>();
        tradeWrapper.eq("account_type",AccountTypeStatus.ZERO_STATUS.getStatus());
        int tradeCount = disProfitRecordMapper.selectCount(tradeWrapper);
        map.put("tradeCount",tradeCount);


        Wrapper<DisProfitRecord> levelWrapper = new EntityWrapper<>();
        levelWrapper.eq("account_type",AccountTypeStatus.ONE_STATUS.getStatus());
        int levelCount = disProfitRecordMapper.selectCount(levelWrapper);
        map.put("levelCount",levelCount);

        Wrapper<DisProfitRecord> inviteWrapper = new EntityWrapper<>();
        inviteWrapper.eq("account_type",AccountTypeStatus.TWO_STATUS.getStatus());
        int inviteCount = disProfitRecordMapper.selectCount(inviteWrapper);
        map.put("inviteCount",inviteCount);


        /*交易分润提现*/
        Wrapper<DisWithdrawRecord> tradedrawWrapper = new EntityWrapper<>();
        tradedrawWrapper.eq("account_type",AccountTypeStatus.ZERO_STATUS.getStatus());
        int tradedrawCount = disWithdrawRecordMapper.selectCount(tradedrawWrapper);
        map.put("tradedrawCount",tradedrawCount);

        /*升级分润提现*/
        Wrapper<DisWithdrawRecord> leveldrawWrapper = new EntityWrapper<>();
        leveldrawWrapper.eq("account_type",AccountTypeStatus.ONE_STATUS.getStatus());
        int leveldrawCount = disWithdrawRecordMapper.selectCount(leveldrawWrapper);
        map.put("leveldrawCount",leveldrawCount);

        /*邀请分润提现*/
        Wrapper<DisWithdrawRecord> invitedrawWrapper = new EntityWrapper<>();
        invitedrawWrapper.eq("account_type",AccountTypeStatus.TWO_STATUS.getStatus());
        int invitedrawCount = disWithdrawRecordMapper.selectCount(invitedrawWrapper);
        map.put("invitedrawCount",invitedrawCount);

        getTradeInfo(map);

        return JSON.toJSONString(map);
    }


    /**
     * 交易统计，
     * @param map
     * @return
     */
    public  Map getTradeInfo(Map map){


        List tradeCounts = new ArrayList();
        List tradeAmounts = new ArrayList();
        int max = LocalDateTime.now().getHour();
        for (int i=1;i<=max;i++){
            List tradeCount = new ArrayList();
            List tradeAmount = new ArrayList();
            String time = DateUtils.preNowDate();
            String hour ="";
            if (i<10){
                hour = "0"+i;
            }else{
                hour = i+"";
            }
            String startTime = time +" "+ hour +":00:00";
            String endTime = time + " "+hour +":59:59";
            String frontTime =hour + ":00";
            Wrapper<DisTradeRecord> tradeWrapper = new EntityWrapper<>();
            tradeWrapper.ge("trade_time",startTime);
            tradeWrapper.le("trade_time",endTime);
            Integer count = disTradeRecordMapper.selectCount(tradeWrapper);
            tradeCount.add(frontTime);
            tradeCount.add(count);

            BigDecimal am = disTradeRecordDao.findSumAmount(startTime,endTime);
            tradeAmount.add(frontTime);
            tradeAmount.add(am);

            tradeCounts.add(tradeCount);
            tradeAmounts.add(tradeAmount);
        }


        map.put("tradeCounts",tradeCounts);
        map.put("tradeAmounts",tradeAmounts);
        return map;
    }
}
