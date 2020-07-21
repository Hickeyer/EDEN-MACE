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
        String identityType = (String) map.get("identityType");
        String disUserRank = (String) map.get("disUserRank");
        String newRank = "";
        if(identityType.equals(IdentityStatus.PLAT_STATUS.getStatus())){
            newRank = AgentRankStatus.getMethod(disUserRank).getMes();
        }else{
            newRank =UserRankStatus.getMethod(disUserRank).getMes();
        }
        map.put("disUserRankDetail", newRank);
    }
}
