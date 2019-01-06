package com.demo2.example.domain;

/**
 * Created by asus on 2018/12/18.
 */
public class PageParam {
    private int beginLine;                   //起始行
    private Integer pageSize = 3;
    private Integer currentPage=0;        // 当前页
    //getter setter 省略

    public void setBeginLine(int beginLine) {
        this.beginLine = beginLine;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public int getBeginLine() {
        return pageSize*currentPage;        //自动计算起始行
    }
}
