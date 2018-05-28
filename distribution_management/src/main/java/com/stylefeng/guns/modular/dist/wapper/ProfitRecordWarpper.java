package com.stylefeng.guns.modular.dist.wapper;

import com.stylefeng.guns.common.warpper.BaseControllerWarpper;

import java.util.Map;

public class ProfitRecordWarpper extends BaseControllerWarpper {
    public ProfitRecordWarpper(Object obj) {
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
