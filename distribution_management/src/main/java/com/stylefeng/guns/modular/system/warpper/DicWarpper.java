package com.stylefeng.guns.modular.system.warpper;

import com.stylefeng.guns.common.constant.factory.ConstantFactory;
import com.stylefeng.guns.common.persistence.model.SysDic;
import com.stylefeng.guns.common.warpper.BaseControllerWarpper;
import com.stylefeng.guns.core.util.ToolUtil;

import java.util.List;
import java.util.Map;

public class DicWarpper extends BaseControllerWarpper {

    public DicWarpper(Object obj) {
        super(obj);
    }

    @Override
    protected void warpTheMap(Map<String, Object> map) {

        StringBuffer detail = new StringBuffer();
        String dicTypeNo = (String) map.get("dicTypeNo");
        List<SysDic> dicts = ConstantFactory.me().findDicList(dicTypeNo);
        if(dicts != null){
            for (SysDic dict : dicts) {
                detail.append(dict.getDicNo() + ":" +dict.getDicValue() + ",");
            }
            map.put("detail", ToolUtil.removeSuffix(detail.toString(),","));
        }
    }
}
