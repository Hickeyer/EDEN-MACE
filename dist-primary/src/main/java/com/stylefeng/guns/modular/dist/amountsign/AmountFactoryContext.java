package com.stylefeng.guns.modular.dist.amountsign;

import com.stylefeng.guns.common.constant.dist.AccountTypeStatus;
import com.stylefeng.guns.modular.dist.amountsign.impl.InviteAmountServiceImpl;
import com.stylefeng.guns.modular.dist.amountsign.impl.LevelAmountServiceImpl;
import com.stylefeng.guns.modular.dist.amountsign.impl.TradeAmountServiceImpl;

/**
 * 新增金额控制
 * @see  AccountTypeStatus
 */
public class AmountFactoryContext {

    public AmountService amountService;

    public AmountFactoryContext(String type) {
        switch (type){
            case "0":
                amountService = new TradeAmountServiceImpl();
                break;
            case  "1":
                amountService = new LevelAmountServiceImpl();
                break;
            case  "2":
                amountService = new InviteAmountServiceImpl();
                break;
            default:
                break;
        }
    }
}
