package com.stylefeng.guns.modular.dist.amountTemplate.impl;

import com.stylefeng.guns.common.exception.BizExceptionEnum;
import com.stylefeng.guns.common.exception.BussinessException;
import com.stylefeng.guns.common.persistence.model.DisAmountSituation;
import com.stylefeng.guns.common.persistence.model.DisMemberAmount;
import com.stylefeng.guns.modular.dist.amountTemplate.AmountTemplate;

import java.math.BigDecimal;

/**
 * @ClassName TradeAmountServiceImpl
 * @autor huangpu
 * @DATE 2019/5/8
 **/
public class TradeAmountServiceImpl extends AmountTemplate{


    @Override
    public void addMoney(DisMemberAmount memberAmount, BigDecimal amount,DisAmountSituation situation) {
        BigDecimal afterThirdAmount=new BigDecimal(0);
        BigDecimal beforeThirdAmount=new BigDecimal(0);
        afterThirdAmount=memberAmount.getTradeTotalAmount().add(amount);
        beforeThirdAmount=memberAmount.getTradeTotalAmount();
        memberAmount.setTradeTotalAmount(memberAmount.getTradeTotalAmount().add(amount));
        memberAmount.setTradeAvaibleAmount(memberAmount.getTradeAvaibleAmount().add(amount));
        situation.setSpecificBeforeChangeAmount(beforeThirdAmount);
        situation.setSpecificAfterChangeAmount(afterThirdAmount);
    }

    @Override
    public void frozenAmount(DisMemberAmount memberAmount, BigDecimal amount) {

        BigDecimal  avaibleThirdAmount=new BigDecimal(0);
        avaibleThirdAmount=memberAmount.getTradeAvaibleAmount();
        if(avaibleThirdAmount.compareTo(amount)==-1){
            throw  new BussinessException(BizExceptionEnum.LOW_MONEY);
        }
        memberAmount.setTradeAvaibleAmount(memberAmount.getTradeAvaibleAmount().subtract(amount));
        memberAmount.setTradeFrozenAmount(memberAmount.getTradeFrozenAmount().add(amount));


    }

    @Override
    public void reduceMoney(DisMemberAmount memberAmount, BigDecimal amount,DisAmountSituation situation) {

        BigDecimal  avaibleThirdAmount=new BigDecimal(0);
        avaibleThirdAmount=memberAmount.getTradeFrozenAmount();

        if(avaibleThirdAmount.compareTo(amount)==-1){
            throw  new BussinessException(BizExceptionEnum.LOW_MONEY);
        }
        BigDecimal beforeThirdAmount=new BigDecimal(0);
        beforeThirdAmount=memberAmount.getTradeTotalAmount();


        memberAmount.setTradeFrozenAmount(memberAmount.getTradeFrozenAmount().subtract(amount));
        memberAmount.setTradeTotalAmount(beforeThirdAmount.subtract(amount));
        situation.setSpecificBeforeChangeAmount(beforeThirdAmount);
        situation.setSpecificAfterChangeAmount(beforeThirdAmount.subtract(amount));

    }

    @Override
    public void returnMoney(DisMemberAmount memberAmount, BigDecimal amount) {
        BigDecimal  avaibleThirdAmount=new BigDecimal(0);
        avaibleThirdAmount=memberAmount.getTradeFrozenAmount();
        if(avaibleThirdAmount.compareTo(amount)==-1){
            throw  new BussinessException(BizExceptionEnum.LOW_MONEY);
        }
        memberAmount.setTradeAvaibleAmount(memberAmount.getTradeAvaibleAmount().add(amount));
        memberAmount.setTradeFrozenAmount(memberAmount.getTradeFrozenAmount().subtract(amount));
    }
}

    
    