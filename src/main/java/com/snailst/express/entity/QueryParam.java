package com.snailst.express.entity;

/**
 * @author zhuzhongpei
 * @date 2017/10/30 16:18
 * @description
 * @since 1.0
 */
public class QueryParam {

    /**
     * 当前页
     */
    private int currentNumber = 1;

    /**
     * 每页大小
     */
    private int pageSize;

    /**
     * 关键字搜索
     */
    private String search;

    /**
     * where 条件
     */
    private String whereSql;

    /**
     * 是否分页
     */
    private boolean isPaging;

    public int getCurrentNumber() {
        return currentNumber;
    }

    public void setCurrentNumber(int currentNumber) {
        this.currentNumber = currentNumber;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }

    public String getWhereSql() {
        return whereSql;
    }

    public void setWhereSql(String whereSql) {
        this.whereSql = whereSql;
    }

    public boolean isPaging() {
        return isPaging;
    }

    public void setPaging(boolean paging) {
        isPaging = paging;
    }

    public int getStart(){
        return (currentNumber - 1) * pageSize;
    }
}
