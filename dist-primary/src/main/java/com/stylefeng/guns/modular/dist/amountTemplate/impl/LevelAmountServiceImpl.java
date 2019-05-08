package com.stylefeng.guns.modular.dist.amountTemplate.impl;

import com.stylefeng.guns.common.exception.BizExceptionEnum;
import com.stylefeng.guns.common.exception.BussinessException;
import com.stylefeng.guns.common.persistence.model.DisAmountSituation;
import com.stylefeng.guns.common.persistence.model.DisMemberAmount;
import com.stylefeng.guns.modular.dist.amountTemplate.AmountTemplate;

import java.math.BigDecimal;

/**
 * @ClassName LevelAmountServiceImpl
 * @autor huangpu
 * @DATE 2019/5/8
 **/
public class LevelAmountServiceImpl extends AmountTemplate{


    @Override
    public void addMoney(DisMemberAmount memberAmount, BigDecimal amount,DisAmountSituation situation) {
        BigDecimal afterThirdAmount=new BigDecimal(0);
        BigDecimal beforeThirdAmount=new BigDecimal(0);
        afterThirdAmount=memberAmount.getLevelTotalAmount().add(amount);
        beforeThirdAmount=memberAmount.getLevelTotalAmount();
        memberAmount.setLevelTotalAmount(memberAmount.getLevelTotalAmount().add(amount));
        memberAmount.setLevelAvaibleAmount(memberAmount.getLevelAvaibleAmount().add(amount));
        situation.setSpecificBeforeChangeAmount(beforeThirdAmount);
        situation.setSpecificAfterChangeAmount(afterThirdAmount);
    }

    @Override
    public void frozenAmount(DisMemberAmount memberAmount, BigDecimal amount) {

        BigDecimal  avaibleThirdAmount=new BigDecimal(0);
        avaibleThirdAmount=memberAmount.getLevelAvaibleAmount();
        if(avaibleThirdAmount.compareTo(amount)==-1){
            throw  new BussinessException(BizExceptionEnum.LOW_MONEY);
        }
        memberAmount.setLevelAvaibleAmount(memberAmount.getLevelAvaibleAmount().subtract(amount));
        memberAmount.setLevelFrozenAmount(memberAmount.getLevelFrozenAmount().add(amount));


    }

    @Override
    public void reduceMoney(DisMemberAmount memberAmount, BigDecimal amount,DisAmountSituation situation) {

        BigDecimal  avaibleThirdAmount=new BigDecimal(0);
        avaibleThirdAmount=memberAmount.getLevelFrozenAmount();

        if(avaibleThirdAmount.compareTo(amount)==-1){
            throw  new BussinessException(BizExceptionEnum.LOW_MONEY);
        }
        BigDecimal beforeThirdAmount=new BigDecimal(0);
        beforeThirdAmount=memberAmount.getLevelTotalAmount();


        memberAmount.setLevelFrozenAmount(memberAmount.getLevelFrozenAmount().subtract(amount));
        memberAmount.setLevelTotalAmount(beforeThirdAmount.subtract(amount));
        situation.setSpecificBeforeChangeAmount(beforeThirdAmount);
        situation.setSpecificAfterChangeAmount(beforeThirdAmount.subtract(amount));

    }

    @Override
    public void returnMoney(DisMemberAmount memberAmount, BigDecimal amount) {
        BigDecimal  avaibleThirdAmount=new BigDecimal(0);
        avaibleThirdAmount=memberAmount.getLevelFrozenAmount();
        if(avaibleThirdAmount.compareTo(amount)==-1){
            throw  new BussinessException(BizExceptionEnum.LOW_MONEY);
        }
        memberAmount.setLevelAvaibleAmount(memberAmount.getLevelAvaibleAmount().add(amount));
        memberAmount.setLevelFrozenAmount(memberAmount.getLevelFrozenAmount().subtract(amount));
    }
}

    
    