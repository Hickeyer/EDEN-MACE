package com.stylefeng.guns.modular.dist.amountTemplate.impl;

import com.stylefeng.guns.common.exception.BizExceptionEnum;
import com.stylefeng.guns.common.exception.BussinessException;
import com.stylefeng.guns.common.persistence.model.DisAmountSituation;
import com.stylefeng.guns.common.persistence.model.DisMemberAmount;
import com.stylefeng.guns.modular.dist.amountTemplate.AmountTemplate;

import java.math.BigDecimal;

/**
 * @ClassName InviteAmountServiceImpl
 * @autor huangpu
 * @DATE 2019/5/8
 **/
public class InviteAmountServiceImpl extends AmountTemplate{


    @Override
    public void addMoney(DisMemberAmount memberAmount, BigDecimal amount,DisAmountSituation situation) {
        BigDecimal afterThirdAmount=new BigDecimal(0);
        BigDecimal beforeThirdAmount=new BigDecimal(0);
        afterThirdAmount=memberAmount.getInviteTotalAmount().add(amount);
        beforeThirdAmount=memberAmount.getInviteTotalAmount();
        memberAmount.setInviteTotalAmount(memberAmount.getInviteTotalAmount().add(amount));
        memberAmount.setInviteAvaibleAmount(memberAmount.getInviteAvaibleAmount().add(amount));
        situation.setSpecificBeforeChangeAmount(beforeThirdAmount);
        situation.setSpecificAfterChangeAmount(afterThirdAmount);
    }

    @Override
    public void frozenAmount(DisMemberAmount memberAmount, BigDecimal amount) {

        BigDecimal  avaibleThirdAmount=new BigDecimal(0);
        avaibleThirdAmount=memberAmount.getInviteAvaibleAmount();
        if(avaibleThirdAmount.compareTo(amount)==-1){
            throw  new BussinessException(BizExceptionEnum.LOW_MONEY);
        }
        memberAmount.setInviteAvaibleAmount(memberAmount.getInviteAvaibleAmount().subtract(amount));
        memberAmount.setInviteFrozenAmount(memberAmount.getInviteFrozenAmount().add(amount));


    }

    @Override
    public void reduceMoney(DisMemberAmount memberAmount, BigDecimal amount,DisAmountSituation situation) {

        BigDecimal  avaibleThirdAmount=new BigDecimal(0);
        avaibleThirdAmount=memberAmount.getInviteFrozenAmount();

        if(avaibleThirdAmount.compareTo(amount)==-1){
            throw  new BussinessException(BizExceptionEnum.LOW_MONEY);
        }
        BigDecimal beforeThirdAmount=new BigDecimal(0);
        beforeThirdAmount=memberAmount.getInviteTotalAmount();


        memberAmount.setInviteFrozenAmount(memberAmount.getInviteFrozenAmount().subtract(amount));
        memberAmount.setInviteTotalAmount(beforeThirdAmount.subtract(amount));
        situation.setSpecificBeforeChangeAmount(beforeThirdAmount);
        situation.setSpecificAfterChangeAmount(beforeThirdAmount.subtract(amount));

    }

    @Override
    public void returnMoney(DisMemberAmount memberAmount, BigDecimal amount) {
        BigDecimal  avaibleThirdAmount=new BigDecimal(0);
        avaibleThirdAmount=memberAmount.getInviteFrozenAmount();
        if(avaibleThirdAmount.compareTo(amount)==-1){
            throw  new BussinessException(BizExceptionEnum.LOW_MONEY);
        }
        memberAmount.setInviteAvaibleAmount(memberAmount.getInviteAvaibleAmount().add(amount));
        memberAmount.setInviteFrozenAmount(memberAmount.getInviteFrozenAmount().subtract(amount));
    }
}

    
    