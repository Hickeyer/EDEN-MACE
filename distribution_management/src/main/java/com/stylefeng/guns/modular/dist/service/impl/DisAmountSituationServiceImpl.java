package com.stylefeng.guns.modular.dist.service.impl;

import com.stylefeng.guns.common.annotion.DataSource;
import com.stylefeng.guns.common.constant.DSEnum;
import com.stylefeng.guns.common.constant.dist.SituationStatus;
import com.stylefeng.guns.common.persistence.model.DisAmountSituation;
import com.stylefeng.guns.modular.dist.dao.DisAmountSituationDao;
import com.stylefeng.guns.modular.dist.vo.DynamicVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.stylefeng.guns.modular.dist.service.IDisAmountSituationService;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

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


    @Override
    @DataSource(name = DSEnum.DATA_SOURCE_BIZ)
    public List<DynamicVo> getDynamicInfo() {
        List<DisAmountSituation>  list= disAmountSituationDao.selectDynamic();
        List<DynamicVo> listDy=new ArrayList<>();
        list.forEach((disAmountSituation)->{
            DynamicVo vo=new DynamicVo();
            vo.setDes(disAmountSituation.getDescribe());
            vo.setTimeMounth(disAmountSituation.getAddTime().substring(0,10));
            vo.setTimeDate(disAmountSituation.getAddTime().substring(10));
            vo.setTitle(disAmountSituation.getDisUserId()+":"+
                    SituationStatus.getMethod(disAmountSituation.getType()).getMes()
                    +":"+disAmountSituation.getChangeAmount());
            listDy.add(vo);
        });
        return listDy;
    }
}
