package com.stylefeng.guns.modular.system.warpper;

import com.stylefeng.guns.common.constant.dist.JobStatus;
import com.stylefeng.guns.common.warpper.BaseControllerWarpper;

import java.util.Map;

public class SysJobWarpper extends BaseControllerWarpper {


    public SysJobWarpper(Object obj) {
        super(obj);
    }

    @Override
    protected void warpTheMap(Map<String, Object> map) {
        Integer jobStatus= (Integer) map.get("jobStatus");
        if(jobStatus==1){
            map.put("statusInfo", JobStatus.FIRST_STATUS.getMes());
        }else {
            map.put("statusInfo", JobStatus.SECOND_STATUS.getMes());
        }
    }
}
