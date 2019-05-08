package com.stylefeng.guns.modular.dist.amountTemplate;

import com.stylefeng.guns.common.constant.dist.AccountTypeStatus;
import com.stylefeng.guns.modular.dist.amountTemplate.impl.InviteAmountServiceImpl;
import com.stylefeng.guns.modular.dist.amountTemplate.impl.LevelAmountServiceImpl;
import com.stylefeng.guns.modular.dist.amountTemplate.impl.TradeAmountServiceImpl;

/**
 * 新增金额控制
 * @see  AccountTypeStatus
 */
public class AmountTemplateFactoryContext {

    public AmountTemplate amountTemplate;

    public AmountTemplateFactoryContext(String type) {
        switch (type){
            case "0":
                amountTemplate = new TradeAmountServiceImpl();
                break;
            case  "1":
                amountTemplate = new LevelAmountServiceImpl();
                break;
            case  "2":
                amountTemplate = new InviteAmountServiceImpl();
                break;
            default:
                break;
        }
    }
}
