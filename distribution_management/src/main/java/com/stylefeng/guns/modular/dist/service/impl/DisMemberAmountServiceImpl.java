package com.stylefeng.guns.modular.dist.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.stylefeng.guns.common.annotion.DataSource;
import com.stylefeng.guns.common.constant.Const;
import com.stylefeng.guns.common.constant.DSEnum;
import com.stylefeng.guns.common.constant.dist.ProTypeStatus;
import com.stylefeng.guns.common.constant.dist.SituationStatus;
import com.stylefeng.guns.common.exception.BizExceptionEnum;
import com.stylefeng.guns.common.exception.BussinessException;
import com.stylefeng.guns.common.persistence.dao.DisAmountSituationMapper;
import com.stylefeng.guns.common.persistence.dao.DisMemberAmountMapper;
import com.stylefeng.guns.common.persistence.dao.DisMemberInfoMapper;
import com.stylefeng.guns.common.persistence.dao.SysDicMapper;
import com.stylefeng.guns.common.persistence.model.DisAmountSituation;
import com.stylefeng.guns.common.persistence.model.DisMemberAmount;
import com.stylefeng.guns.common.persistence.model.DisMemberInfo;
import com.stylefeng.guns.common.persistence.model.SysDic;
import com.stylefeng.guns.core.shiro.ShiroKit;
import com.stylefeng.guns.modular.dist.dao.DisMemberAmountDao;
import com.stylefeng.guns.modular.dist.service.IDisMemberInfoService;
import com.stylefeng.guns.modular.dist.util.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.stylefeng.guns.modular.dist.service.IDisMemberAmountService;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * 账户管理Dao
 *
 * @author xiaojiang
 * @Date 2018-05-08 21:16:47
 */
@Service
@Transactional
public class DisMemberAmountServiceImpl implements IDisMemberAmountService {


    @Resource
    DisMemberAmountMapper disMemberAmountMapper;

    @Resource
    DisMemberAmountDao disMemberAmountDao;

    @Resource
    DisAmountSituationMapper disAmountSituationMapper;

    @Resource
    SysDicMapper sysDicMapper;

    @Autowired
    IDisMemberInfoService disMemberInfoService;


    @Override
    @DataSource(name = DSEnum.DATA_SOURCE_BIZ)
    public void save(String userId, String userName, String type) {
        Wrapper<DisMemberAmount> memberAmountWrapper=new EntityWrapper();
        memberAmountWrapper.eq("dis_user_id",userId);
        Integer count= disMemberAmountMapper.selectCount(memberAmountWrapper);
        if(count==0){
            DisMemberAmount amount=initAmount(userId,userName,type);
            disMemberAmountMapper.insert(amount);
        }
    }

    @Override
    @DataSource(name = DSEnum.DATA_SOURCE_BIZ)
    public List<Map<String, Object>> selectList(String platformId) {
        List<Map<String, Object>> list= disMemberAmountDao.selectList(platformId);
        return list;
    }

    @Override
    public void addMoney(String userId, BigDecimal amount, String accountType,String sourceId,String type) {
        DisMemberAmount disMemberAmount=new DisMemberAmount();
        disMemberAmount.setDisUserId(userId);
        DisMemberAmount memberAmount=disMemberAmountMapper.selectOne(disMemberAmount);
        if(memberAmount==null){
            memberAmount=initAmount(userId,userId,type);
            disMemberAmountMapper.insert(memberAmount);
        }
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
        BigDecimal afterThirdAmount=new BigDecimal(0);
        BigDecimal beforeThirdAmount=new BigDecimal(0);
        if(ProTypeStatus.ZERO_STATUS.getCode().equals(accountType)){
            afterThirdAmount=memberAmount.getTradeTotalAmount().add(amount);
            beforeThirdAmount=memberAmount.getTradeTotalAmount();
            memberAmount.setTradeTotalAmount(memberAmount.getTradeTotalAmount().add(amount));
            memberAmount.setTradeAvaibleAmount(memberAmount.getTradeAvaibleAmount().add(amount));
        }else if(ProTypeStatus.ONE_STATUS.getCode().equals(accountType)){
            afterThirdAmount=memberAmount.getLevelTotalAmount().add(amount);
            beforeThirdAmount=memberAmount.getLevelTotalAmount();
            memberAmount.setLevelTotalAmount(memberAmount.getLevelTotalAmount().add(amount));
            memberAmount.setLevelAvaibleAmount(memberAmount.getLevelAvaibleAmount().add(amount));
        }
        situation.setSpecificBeforeChangeAmount(beforeThirdAmount);
        situation.setSpecificAfterChangeAmount(afterThirdAmount);
        situation.setType(SituationStatus.INCOME_STATUS.getStatus());
        situation.setAddTime(DateUtils.longToDateAll(System.currentTimeMillis()));
        SysDic sysDicParam=new SysDic();
        sysDicParam.setDicTypeNo("disProType");
        sysDicParam.setDicNotes(accountType);
        SysDic sysDic=sysDicMapper.selectOne(sysDicParam);
        situation.setDisProType(sysDic.getDicNo());
        disMemberAmountMapper.updateById(memberAmount);
        Wrapper<DisAmountSituation> situationWrapper=new EntityWrapper<>();
        situationWrapper.eq("dis_user_id",userId)
                .eq("dis_pro_type",sysDic.getDicNo());
        Integer count=disAmountSituationMapper.selectCount(situationWrapper);
        if(count==0){
            DisMemberInfo memberInfo= disMemberInfoService.selectListByUserId(userId);
            DisAmountSituation initSituation=new DisAmountSituation();
            initSituation.setDisProType(sysDic.getDicNo());
            initSituation.setDisUserId(userId);
            initSituation.setAddTime(memberAmount.getAddTime());
            initSituation.setDescribe(SituationStatus.AMOUNT_INIT.getDes());
            initSituation.setType(SituationStatus.AMOUNT_INIT.getStatus());
            initSituation.setChangeAmount(new BigDecimal(0));
            disAmountSituationMapper.insert(initSituation);
        }
        String des=SituationStatus.INCOME_STATUS.getDes();
        situation.setDescribe(String.format(des,sourceId,accountType,userId,amount.toString()));
        disAmountSituationMapper.insert(situation);
    }

    /**
     * 冻结用户金额，用于提现，首先判断用户可用金额是否足够，
     * 如果用户金额足够则执行
     * @param userId
     * @param amount
     * @param accountType
     */
    @Override
    public void frozenAmount(String userId, BigDecimal amount, String accountType) {
        DisMemberAmount disMemberAmount=new DisMemberAmount();
        disMemberAmount.setDisUserId(userId);
        DisMemberAmount memberAmount=disMemberAmountMapper.selectOne(disMemberAmount);
        BigDecimal  avaibleThirdAmount=new BigDecimal(0);
        if("trade".equals(accountType)){
            avaibleThirdAmount=memberAmount.getTradeAvaibleAmount();
        }else if("level".equals(accountType)){
            avaibleThirdAmount=memberAmount.getLevelAvaibleAmount();
        }
        if(avaibleThirdAmount.compareTo(amount)==-1){
            throw  new BussinessException(BizExceptionEnum.LOW_MONEY);
        }
        /*开始扣除金额*/
        memberAmount.setAvaibleAmount(memberAmount.getAvaibleAmount().subtract(amount));
        memberAmount.setFrozenAmount(memberAmount.getFrozenAmount().add(amount));
        if("trade".equals(accountType)){
            memberAmount.setTradeAvaibleAmount(memberAmount.getTradeAvaibleAmount().subtract(amount));
            memberAmount.setTradeFrozenAmount(memberAmount.getTradeFrozenAmount().add(amount));
        }else if("level".equals(accountType)){
            memberAmount.setLevelAvaibleAmount(memberAmount.getLevelAvaibleAmount().subtract(amount));
            memberAmount.setLevelFrozenAmount(memberAmount.getLevelFrozenAmount().add(amount));
        }
        disMemberAmountMapper.updateById(memberAmount);
    }

    @Override
    public void reduceMoney(String userId, BigDecimal amount, String accountType) {

        //记录金额
        DisAmountSituation situation=new DisAmountSituation();
        situation.setDisUserId(userId);
        situation.setChangeAmount(amount);

        DisMemberAmount disMemberAmount=new DisMemberAmount();
        disMemberAmount.setDisUserId(userId);
        DisMemberAmount memberAmount=disMemberAmountMapper.selectOne(disMemberAmount);
        situation.setBeforeChangeAmount(memberAmount.getTotalAmount());
        situation.setAfterChangeAmount(memberAmount.getTotalAmount().subtract(amount));
        BigDecimal  avaibleThirdAmount=new BigDecimal(0);
        if("trade".equals(accountType)){
            avaibleThirdAmount=memberAmount.getTradeFrozenAmount();
        }else if("level".equals(accountType)){
            avaibleThirdAmount=memberAmount.getLevelFrozenAmount();
        }
        if(avaibleThirdAmount.compareTo(amount)==-1){
            throw  new BussinessException(BizExceptionEnum.LOW_MONEY);
        }
        /*开始扣除金额*/
        memberAmount.setTotalAmount(memberAmount.getTotalAmount().subtract(amount));
        memberAmount.setFrozenAmount(memberAmount.getFrozenAmount().subtract(amount));
        BigDecimal beforeThirdAmount=new BigDecimal(0);
        if("trade".equals(accountType)){
            beforeThirdAmount=memberAmount.getTradeTotalAmount();
            memberAmount.setTradeFrozenAmount(memberAmount.getTradeFrozenAmount().subtract(amount));
            memberAmount.setTradeTotalAmount(beforeThirdAmount.subtract(amount));
        }else if("level".equals(accountType)){
            beforeThirdAmount=memberAmount.getLevelTotalAmount();
            memberAmount.setTradeFrozenAmount(memberAmount.getTradeFrozenAmount().subtract(amount));
            memberAmount.setLevelTotalAmount(beforeThirdAmount.subtract(amount));
        }

        situation.setSpecificBeforeChangeAmount(beforeThirdAmount);
        situation.setSpecificAfterChangeAmount(beforeThirdAmount.subtract(amount));
        situation.setType(SituationStatus.PAY_STATUS.getStatus());
        situation.setAddTime(DateUtils.longToDateAll(System.currentTimeMillis()));
        SysDic sysDicParam=new SysDic();
        sysDicParam.setDicTypeNo("disProType");
        sysDicParam.setDicNotes(accountType);
        SysDic sysDic=sysDicMapper.selectOne(sysDicParam);
        situation.setDisProType(sysDic.getDicNo());
        disMemberAmountMapper.updateById(memberAmount);
        String des=SituationStatus.PAY_STATUS.getDes();
        situation.setDescribe(String.format(des,userId,accountType));
        disAmountSituationMapper.insert(situation);
    }

    @Override
    public void returnMoney(String userId, BigDecimal amount, String accountType) {
        DisMemberAmount disMemberAmount=new DisMemberAmount();
        disMemberAmount.setDisUserId(userId);
        DisMemberAmount memberAmount=disMemberAmountMapper.selectOne(disMemberAmount);
        BigDecimal  avaibleThirdAmount=new BigDecimal(0);
        if("trade".equals(accountType)){
            avaibleThirdAmount=memberAmount.getTradeFrozenAmount();
        }else if("level".equals(accountType)){
            avaibleThirdAmount=memberAmount.getLevelFrozenAmount();
        }
        if(avaibleThirdAmount.compareTo(amount)==-1){
            throw  new BussinessException(BizExceptionEnum.LOW_MONEY);
        }
        /*开始增加金额*/
        memberAmount.setAvaibleAmount(memberAmount.getAvaibleAmount().add(amount));
        memberAmount.setFrozenAmount(memberAmount.getFrozenAmount().subtract(amount));
        if("trade".equals(accountType)){
            memberAmount.setTradeAvaibleAmount(memberAmount.getTradeAvaibleAmount().add(amount));
            memberAmount.setTradeFrozenAmount(memberAmount.getTradeFrozenAmount().subtract(amount));
        }else if("level".equals(accountType)){
            memberAmount.setLevelAvaibleAmount(memberAmount.getLevelAvaibleAmount().add(amount));
            memberAmount.setLevelFrozenAmount(memberAmount.getLevelFrozenAmount().subtract(amount));
        }
        disMemberAmountMapper.updateById(memberAmount);
    }

    @DataSource(name = DSEnum.DATA_SOURCE_BIZ)
    public DisMemberAmount initAmount(String userId, String userName, String type){
        DisMemberAmount amount=new DisMemberAmount();
        amount.setDisUserId(userId);
        amount.setDisUserName(userName);
        amount.setType(type);
        amount.setAmountStatus("0");
        amount.setAvaibleAmount(new BigDecimal(0));
        amount.setFrozenAmount(new BigDecimal(0));
        amount.setTotalAmount(new BigDecimal(0));
        amount.setLevelAvaibleAmount(new BigDecimal(0));
        amount.setLevelFrozenAmount(new BigDecimal(0));
        amount.setLevelTotalAmount(new BigDecimal(0));
        amount.setTradeAvaibleAmount(new BigDecimal(0));
        amount.setTradeFrozenAmount(new BigDecimal(0));
        amount.setTradeTotalAmount(new BigDecimal(0));
        amount.setAddTime(DateUtils.longToDateAll(System.currentTimeMillis()));
        amount.setUpdateTime(DateUtils.longToDateAll(System.currentTimeMillis()));
        return amount;
    }
}
