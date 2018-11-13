package com.stylefeng.guns.modular.dist.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.stylefeng.guns.common.annotion.DataSource;
import com.stylefeng.guns.common.constant.DSEnum;
import com.stylefeng.guns.common.constant.dist.SituationStatus;
import com.stylefeng.guns.common.persistence.dao.DisAmountSituationMapper;
import com.stylefeng.guns.common.persistence.model.DisAmountSituation;
import com.stylefeng.guns.common.persistence.model.DisMemberInfo;
import com.stylefeng.guns.modular.dist.dao.DisAmountSituationDao;
import com.stylefeng.guns.modular.dist.vo.DynamicVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.stylefeng.guns.modular.dist.service.IDisAmountSituationService;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 记账表Dao
 *
 * @author xiaojiang
 * @Date 2018-05-30 16:55:44
 */
@Service
public class DisAmountSituationServiceImpl implements IDisAmountSituationService {

    @Resource
    DisAmountSituationDao disAmountSituationDao;

    @Resource
    DisAmountSituationMapper disAmountSituationMapper;

    @Override
    @DataSource(name = DSEnum.DATA_SOURCE_BIZ)
    public List<DynamicVo> getDynamicInfo(String account) {
        List<DisAmountSituation>  list= disAmountSituationDao.selectDynamic(account);
        List<DynamicVo> listDy=new ArrayList<>();
        list.forEach((disAmountSituation)->{
            DynamicVo vo=new DynamicVo();
            vo.setDes(disAmountSituation.getDescribe());
            vo.setTimeMounth(disAmountSituation.getAddTime().substring(0,10));
            vo.setTimeDate(disAmountSituation.getAddTime().substring(10));
            System.out.println(disAmountSituation.getId()+"------------------------------");
            System.out.println(disAmountSituation.getType());
            System.out.println(disAmountSituation.getDisUserId());
            System.out.println(disAmountSituation.getChangeAmount());

            vo.setTitle(disAmountSituation.getDisUserId()+":"+
                    SituationStatus.getMethod(disAmountSituation.getType()).getMes()
                    +":"+disAmountSituation.getChangeAmount());
            listDy.add(vo);
        });
        return listDy;
    }

    @Override
    @DataSource(name = DSEnum.DATA_SOURCE_BIZ)
    public Map<String,Object> myaccount(String account) {
        Map<String,Object> map=new HashMap<>();
        List<String> dateList=new ArrayList<>();
        List<String> amountList=new ArrayList<>();
        List<String> afterList=new ArrayList<>();
        Wrapper<DisAmountSituation> wrapper=new EntityWrapper();
        wrapper.eq("dis_user_id",account).orderBy("add_time",true);
        List<DisAmountSituation> list= disAmountSituationMapper.selectList(wrapper);
        list.forEach(disAmountSituation -> {
            String status=disAmountSituation.getType();
            if(status.equals(SituationStatus.PAY_STATUS.getStatus())){
                amountList.add("-"+disAmountSituation.getChangeAmount().toString());
            }else{
                amountList.add(disAmountSituation.getChangeAmount().toString());
            }
            dateList.add(disAmountSituation.getAddTime());
            afterList.add(disAmountSituation.getAfterChangeAmount().toString());
        });
        map.put("date",dateList);
        map.put("amount",amountList);
        map.put("after",afterList);
        return map;
    }
}
