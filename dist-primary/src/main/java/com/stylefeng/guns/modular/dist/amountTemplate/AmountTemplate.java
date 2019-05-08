package com.stylefeng.guns.modular.dist.amountTemplate;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.stylefeng.guns.common.annotion.DataSource;
import com.stylefeng.guns.common.constant.DSEnum;
import com.stylefeng.guns.common.constant.dist.AccountTypeStatus;
import com.stylefeng.guns.common.constant.dist.SituationStatus;
import com.stylefeng.guns.common.exception.BizExceptionEnum;
import com.stylefeng.guns.common.exception.BussinessException;
import com.stylefeng.guns.common.persistence.dao.DisAmountSituationMapper;
import com.stylefeng.guns.common.persistence.dao.DisMemberAmountMapper;
import com.stylefeng.guns.common.persistence.dao.SysDicMapper;
import com.stylefeng.guns.common.persistence.model.DisAmountSituation;
import com.stylefeng.guns.common.persistence.model.DisMemberAmount;
import com.stylefeng.guns.common.persistence.model.DisMemberInfo;
import com.stylefeng.guns.common.persistence.model.SysDic;
import com.stylefeng.guns.core.util.SpringContextHolder;
import com.stylefeng.guns.modular.dist.amountsign.AmountService;
import com.stylefeng.guns.modular.dist.service.IDisMemberInfoService;
import com.stylefeng.guns.modular.dist.util.DateUtils;

import java.math.BigDecimal;

public abstract class AmountTemplate  {


    private DisAmountSituationMapper disAmountSituationMapper =  SpringContextHolder.getBean(DisAmountSituationMapper.class);

    private SysDicMapper sysDicMapper =  SpringContextHolder.getBean(SysDicMapper.class);

    private DisMemberAmountMapper disMemberAmountMapper = SpringContextHolder.getBean(DisMemberAmountMapper.class);

    IDisMemberInfoService disMemberInfoService  = SpringContextHolder.getBean(IDisMemberInfoService.class) ;


    public abstract void addMoney(DisMemberAmount memberAmount,BigDecimal amount,DisAmountSituation situation);
    @DataSource(name = DSEnum.DATA_SOURCE_BIZ)
    public final void addMoney(String userId, BigDecimal amount, String sourceName, String type) {
        DisMemberAmount disMemberAmount=new DisMemberAmount();
        disMemberAmount.setDisUserId(userId);
        DisMemberAmount memberAmount=disMemberAmountMapper.selectOne(disMemberAmount);
        //记录金额
        DisAmountSituation situation=new DisAmountSituation();
        situation.setDisUserId(userId);
        situation.setBeforeChangeAmount(memberAmount.getTotalAmount());
        situation.setChangeAmount(amount);
        BigDecimal avaibleAmount=memberAmount.getAvaibleAmount();
        BigDecimal totalAmount=memberAmount.getTotalAmount();
        memberAmount.setAvaibleAmount(avaibleAmount.add(amount));
        memberAmount.setTotalAmount(totalAmount.add(amount));

        situation.setAfterChangeAmount(memberAmount.getTotalAmount());


        /*每次需要改变的地方*/
        addMoney(memberAmount,amount,situation);
        /*每次需要改变的地方*/


        situation.setType(SituationStatus.INCOME_STATUS.getStatus());
        situation.setAddTime(DateUtils.longToDateAll(System.currentTimeMillis()));

        situation.setAccountType(AccountTypeStatus.ZERO_STATUS.getStatus());
        disMemberAmountMapper.updateById(memberAmount);
        Wrapper<DisAmountSituation> situationWrapper=new EntityWrapper<>();
        situationWrapper.eq("dis_user_id",userId)
                .eq("account_type", AccountTypeStatus.ZERO_STATUS.getStatus());
        Integer count=disAmountSituationMapper.selectCount(situationWrapper);
        if(count == 0){
            DisMemberInfo memberInfo= disMemberInfoService.selectListByUserId(userId);
            DisAmountSituation initSituation=new DisAmountSituation();
            initSituation.setAccountType(AccountTypeStatus.ZERO_STATUS.getStatus());
            initSituation.setDisUserId(userId);
            initSituation.setAddTime(memberAmount.getAddTime());
            initSituation.setDescribe(SituationStatus.AMOUNT_INIT.getDes());
            initSituation.setType(SituationStatus.AMOUNT_INIT.getStatus());
            initSituation.setChangeAmount(new BigDecimal(0));
            disAmountSituationMapper.insert(initSituation);
        }
        String des=SituationStatus.INCOME_STATUS.getDes();
        String lastDes = String.format(des,sourceName, AccountTypeStatus.ZERO_STATUS.getCode(),userId,amount.toString());
        situation.setDescribe(lastDes);
        disAmountSituationMapper.insert(situation);
    }
    public abstract void frozenAmount(DisMemberAmount memberAmount,BigDecimal amount);
    @DataSource(name = DSEnum.DATA_SOURCE_BIZ)
    public final void frozenAmount(String userId, BigDecimal amount) {
        DisMemberAmount disMemberAmount=new DisMemberAmount();
        disMemberAmount.setDisUserId(userId);
        DisMemberAmount memberAmount=disMemberAmountMapper.selectOne(disMemberAmount);


        frozenAmount(memberAmount,amount);

        /*开始扣除金额*/
        memberAmount.setAvaibleAmount(memberAmount.getAvaibleAmount().subtract(amount));
        memberAmount.setFrozenAmount(memberAmount.getFrozenAmount().add(amount));

        disMemberAmountMapper.updateById(memberAmount);
    }
    public abstract void reduceMoney(DisMemberAmount memberAmount,BigDecimal amount,DisAmountSituation situation);
    @DataSource(name = DSEnum.DATA_SOURCE_BIZ)
    public final void reduceMoney(String userId, BigDecimal amount) {
        final String accountType = AccountTypeStatus.ONE_STATUS.getCode();
        //记录金额
        DisAmountSituation situation=new DisAmountSituation();
        situation.setDisUserId(userId);
        situation.setChangeAmount(amount);

        DisMemberAmount disMemberAmount=new DisMemberAmount();
        disMemberAmount.setDisUserId(userId);
        DisMemberAmount memberAmount=disMemberAmountMapper.selectOne(disMemberAmount);
        situation.setBeforeChangeAmount(memberAmount.getTotalAmount());
        situation.setAfterChangeAmount(memberAmount.getTotalAmount().subtract(amount));



        /*开始扣除金额*/
        memberAmount.setTotalAmount(memberAmount.getTotalAmount().subtract(amount));
        memberAmount.setFrozenAmount(memberAmount.getFrozenAmount().subtract(amount));

        reduceMoney(memberAmount,amount,situation);



        situation.setType(SituationStatus.PAY_STATUS.getStatus());
        situation.setAddTime(DateUtils.longToDateAll(System.currentTimeMillis()));
        SysDic sysDicParam=new SysDic();
        sysDicParam.setDicTypeNo("accountType");
        sysDicParam.setDicNotes(accountType);
        SysDic sysDic=sysDicMapper.selectOne(sysDicParam);
        situation.setAccountType(sysDic.getDicNo());
        disMemberAmountMapper.updateById(memberAmount);
        String des=SituationStatus.PAY_STATUS.getDes();
        situation.setDescribe(String.format(des,userId,accountType));
        disAmountSituationMapper.insert(situation);
    }


    public abstract void returnMoney(DisMemberAmount memberAmount,BigDecimal amount);
    @DataSource(name = DSEnum.DATA_SOURCE_BIZ)
    public final void returnMoney(String userId, BigDecimal amount) {
        DisMemberAmount disMemberAmount=new DisMemberAmount();
        disMemberAmount.setDisUserId(userId);
        DisMemberAmount memberAmount=disMemberAmountMapper.selectOne(disMemberAmount);

        /*开始增加金额*/
        memberAmount.setAvaibleAmount(memberAmount.getAvaibleAmount().add(amount));
        memberAmount.setFrozenAmount(memberAmount.getFrozenAmount().subtract(amount));

        returnMoney(memberAmount,amount);
        disMemberAmountMapper.updateById(memberAmount);
    }
}
