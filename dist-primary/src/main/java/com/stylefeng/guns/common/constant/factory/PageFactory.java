package com.stylefeng.guns.common.constant.factory;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.stylefeng.guns.common.constant.state.Order;
import com.stylefeng.guns.core.support.HttpKit;
import com.stylefeng.guns.core.util.ToolUtil;

import javax.servlet.http.HttpServletRequest;

/**
 * BootStrap Table默认的分页参数创建
 *
 * @author fengshuonan
 * @date 2017-04-05 22:25
 */
public class PageFactory<T> {

    public Page<T> defaultPage() {
        HttpServletRequest request = HttpKit.getRequest();
        int limit = Integer.valueOf(request.getParameter("limit"));
        int offset = Integer.valueOf(request.getParameter("offset"));
        Page<T> page = PageHelper.startPage((offset / limit + 1), limit,true);
        return page;
    }
}
