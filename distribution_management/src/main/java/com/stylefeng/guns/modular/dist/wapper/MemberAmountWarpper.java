package com.stylefeng.guns.modular.dist.wapper;

import com.stylefeng.guns.common.constant.factory.ConstantFactory;
import com.stylefeng.guns.common.persistence.model.SysDic;
import com.stylefeng.guns.common.warpper.BaseControllerWarpper;
import com.stylefeng.guns.core.util.ToolUtil;

import java.util.List;
import java.util.Map;

public class MemberAmountWarpper extends BaseControllerWarpper {

    public MemberAmountWarpper(Object obj) {
        super(obj);
    }

    @Override
    protected void warpTheMap(Map<String, Object> map) {
        String type = (String) map.get("type");
        String typeDetail="未知";
        if("0".equals(type)){
            typeDetail="用户分润";
        }else if("1".equals(type)){
            typeDetail="平台分润";
        }
        map.put("typeDetail",typeDetail);
    }
}
