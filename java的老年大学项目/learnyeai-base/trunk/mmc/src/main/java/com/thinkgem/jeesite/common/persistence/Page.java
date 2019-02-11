package com.thinkgem.jeesite.common.persistence;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by zpz on 2017/11/9.
 */
public class Page<T> extends cn.com.weye.core.persistence.Page{
    public Page() {
    }

    public Page(HttpServletRequest request, HttpServletResponse response) {
        super(request, response);
    }

    public Page(HttpServletRequest request, HttpServletResponse response, int defaultPageSize) {
        super(request, response, defaultPageSize);
    }

    public Page(int pageNo, int pageSize) {
        super(pageNo, pageSize);
    }

    public Page(String pageNo, String pageSize) {
        super(pageNo, pageSize);
    }

    public Page(String pageNo, String pageSize, String totalCount) {
        super(pageNo, pageSize, totalCount);
    }

    public Page(int pageNo, int pageSize, long count) {
        super(pageNo, pageSize, count);
    }

    public Page(int pageNo, int pageSize, long count, List list) {
        super(pageNo, pageSize, count, list);
    }
}
