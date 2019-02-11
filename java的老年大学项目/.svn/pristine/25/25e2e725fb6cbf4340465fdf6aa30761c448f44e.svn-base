package com.learnyeai.core.support;

import java.util.List;

/**
 * Created by zpz on 2018/4/4.
 */
public class MyPage<T> {
    protected int pageNo;
    protected int pageSize;
    protected long total;
    private int totalPage;

    protected List<T> list;

    public MyPage() {
    }

    public int getPageNo() {
        if(this.pageNo <= 0) {
            this.pageNo = 1;
        } else {
            int totalPage = this.getTotalPage();
            if(totalPage > 0 && this.pageNo > this.getTotalPage()) {
                this.pageNo = totalPage;
            }
        }
        return this.pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public int getPageSize() {
        if(this.pageSize <= 0) {
            this.pageSize = 10;
        }

        return this.pageSize;
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

    public int getTotalPage() {
        long totalRecord = this.getTotal();
        if(totalRecord <= 0) {
            this.totalPage = 0;
        } else {
            int pageSize = this.getPageSize();
            Long ll = totalRecord % pageSize == 0?totalRecord / pageSize:totalRecord / pageSize + 1;
            this.totalPage = ll.intValue();
        }

        return this.totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }
}
