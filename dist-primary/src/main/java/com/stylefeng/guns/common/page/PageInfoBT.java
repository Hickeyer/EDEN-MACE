package com.stylefeng.guns.common.page;

import com.baomidou.mybatisplus.plugins.Page;

import java.util.List;

/**
 * 分页结果的封装(for Bootstrap Table)
 *
 * @author fengshuonan
 * @Date 2017年1月22日 下午11:06:41
 */
public class PageInfoBT<T> {

    /**
     * HTTP日期时间格式化器
     */
    private List<T> rows;

    /**
     * 总数
     */
    private long total;

    public PageInfoBT(List<T> list,long rows) {
        this.rows = list;
        this.total = rows;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }
}
