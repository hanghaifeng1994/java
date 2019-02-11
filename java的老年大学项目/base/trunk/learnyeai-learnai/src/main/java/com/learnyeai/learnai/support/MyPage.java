package com.learnyeai.learnai.support;

import com.github.pagehelper.Page;

import java.util.Collection;
import java.util.List;

/**
 * Created by zpz on 2018/4/4.
 */
public class MyPage<T> extends com.learnyeai.core.support.MyPage<T> {
//    private int pageNo;
//    private int pageSize;
//
//    private long total;
//    private List<T> list;

    public MyPage() {
    }

    public MyPage(List<T> list) {
        if(list instanceof Page) {
            Page page = (Page)list;
            this.list = page;
            this.total = page.getTotal();

            this.pageNo = page.getPageNum();
            this.pageSize = page.getPageSize();
        } else if(list instanceof Collection) {
            this.list = list;
            this.total = (long)list.size();
            this.pageNo = 1;
            this.pageSize = list.size();
        }
    }

    /*public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }*/
}
