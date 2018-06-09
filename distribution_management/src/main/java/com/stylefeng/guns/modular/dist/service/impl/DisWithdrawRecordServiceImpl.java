package com.stylefeng.guns.modular.dist.service.impl;

import com.stylefeng.guns.common.annotion.DataSource;
import com.stylefeng.guns.common.constant.DSEnum;
import com.stylefeng.guns.common.constant.dist.WithdrawStatus;
import com.stylefeng.guns.common.exception.BizExceptionEnum;
import com.stylefeng.guns.common.exception.BussinessException;
import com.stylefeng.guns.common.persistence.dao.DisWithdrawRecordMapper;
import com.stylefeng.guns.common.persistence.model.DisWithdrawRecord;
import com.stylefeng.guns.modular.dist.dao.DisWithdrawRecordDao;
import com.stylefeng.guns.modular.dist.service.IDisMemberAmountService;
import com.stylefeng.guns.modular.dist.service.IDistWithdrawParamService;
import com.stylefeng.guns.modular.dist.util.DateUtils;
import com.stylefeng.guns.modular.system.service.ISysDicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.stylefeng.guns.modular.dist.service.IDisWithdrawRecordService;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * 提现记录Dao
 *
 * @author xiaojiang
 * @Date 2018-05-30 16:55:08
 */
@Service
@Transactional
public class DisWithdrawRecordServiceImpl implements IDisWithdrawRecordService {


    @Autowired
    IDisMemberAmountService disMemberAmountService;

    @Autowired
    IDistWithdrawParamService distWithdrawParamService;

    @Resource
    DisWithdrawRecordMapper disWithdrawRecordMapper;

    @Resource
    DisWithdrawRecordDao disWithdrawRecordDao;

    @Autowired
    ISysDicService sysDicService;

    @Override
    @DataSource(name = DSEnum.DATA_SOURCE_BIZ)
    public void withdrawMoney(String userId, BigDecimal amount, String disProMode) {
        String accountType="";
        if("0".equals(disProMode)){
            accountType="trade";
        }else{
            accountType="level";
        }
        Map<String,Object> map= distWithdrawParamService.calAmount(amount);
        disMemberAmountService.frozenAmount(userId,amount,accountType);

        DisWithdrawRecord record=new DisWithdrawRecord();
        record.setDisUserId(userId);
        record.setWithdrawTime(DateUtils.getNowDateTime());
        record.setTotalAmount(amount);
        record.setRealAmount((BigDecimal) map.get("realAmount"));
        record.setFeeAmount((BigDecimal)map.get("feeAmount"));
        record.setWithdrawStatus(WithdrawStatus.FIRST_STATUS.getStatus());
        record.setDisProMode(disProMode);
        record.setWithdrawNum(sysDicService.getOrderNo("withdrawl"));
        disWithdrawRecordMapper.insert(record);
    }

    @Override
    @DataSource(name = DSEnum.DATA_SOURCE_BIZ)
    public List<Map<String, Object>> selectList() {
        return disWithdrawRecordDao.selectList();
    }

    @Override
    @DataSource(name = DSEnum.DATA_SOURCE_BIZ)
    public void dealWithdrawl(Integer id,String type) {
        DisWithdrawRecord record= disWithdrawRecordMapper.selectById(id);
        if(record.getWithdrawStatus().equals(WithdrawStatus.FIRST_STATUS.getStatus())){
            String accountType="";
            if("0".equals(record.getDisProMode())){
                accountType="trade";
            }else{
                accountType="level";
            }
            record.setHandleTime(DateUtils.longToDateAll(System.currentTimeMillis()));
            if(type.equals(WithdrawStatus.SECOND_STATUS.getStatus())){
                record.setWithdrawStatus(WithdrawStatus.SECOND_STATUS.getStatus());
                disMemberAmountService.reduceMoney(record.getDisUserId(),record.getTotalAmount(),accountType);
                disWithdrawRecordMapper.updateAllColumnById(record);
            }else if(type.equals(WithdrawStatus.THIRD_STATUS.getStatus())){
                record.setWithdrawStatus(WithdrawStatus.THIRD_STATUS.getStatus());
                disMemberAmountService.returnMoney(record.getDisUserId(),record.getTotalAmount(),accountType);
                disWithdrawRecordMapper.updateAllColumnById(record);
            }
        }else{
            throw  new BussinessException(BizExceptionEnum.WITHDRAWL_STATUS);
        }
    }
}
