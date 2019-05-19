package com.stylefeng.guns.modular.dist.wapper;

import com.stylefeng.guns.common.constant.dist.*;
import com.stylefeng.guns.common.warpper.BaseControllerWarpper;

import java.util.Map;

public class ProfiParamWarpper extends BaseControllerWarpper {
    public ProfiParamWarpper(Object obj) {
        super(obj);
    }

    @Override
    protected void warpTheMap(Map<String, Object> map) {
        String disUserType = (String) map.get("disUserType");
        String disUserRank = (String) map.get("disUserRank");
        String newRank = "";
        if(disUserType.equals(UserTypeStatus.PLAT_STATUS.getMes())){
            newRank = AgentRankStatus.getMethod(disUserRank).getMes();
        }else{
            newRank =UserRankStatus.getMethod(disUserRank).getMes();
        }
        map.put("disUserRankDetail", newRank);
    }
}
