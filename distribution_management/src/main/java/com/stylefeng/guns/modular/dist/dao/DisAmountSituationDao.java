package com.stylefeng.guns.modular.dist.dao;

import com.stylefeng.guns.common.persistence.model.DisAmountSituation;
import com.stylefeng.guns.modular.dist.vo.DynamicVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 记账表Dao
 *
 * @author xiaojiang
 * @Date 2018-05-30 16:55:44
 */
public interface DisAmountSituationDao {

    public List<DisAmountSituation> selectDynamic(@Param("account") String account);

}
