package com.stylefeng.guns.modular.dist.wapper;

import com.stylefeng.guns.common.constant.dist.AgentRankStatus;
import com.stylefeng.guns.common.constant.dist.IdentityStatus;
import com.stylefeng.guns.common.constant.dist.UserRankStatus;
import com.stylefeng.guns.common.warpper.BaseControllerWarpper;

import java.util.Map;

public class DisRankParamWarpper extends BaseControllerWarpper {
    public DisRankParamWarpper(Object obj) {
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
