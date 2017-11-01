package com.snailst.express.entity;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

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
    private int pageSize = 20;

    /**
     * 关键字搜索
     */
    private String search;

    /**
     * 查询条件
     */
    private Map<String, Object> condition = new HashMap<>();

    /**
     * where 条件
     */
    private String whereSql;

    /**
     * 排序
     */
    private LinkedHashMap<String, String> orderBy = new LinkedHashMap<>();

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

    public boolean getIsPaging() {
        return isPaging;
    }

    public void setIsPaging(boolean paging) {
        isPaging = paging;
    }

    public int getStart(){
        return (currentNumber - 1) * pageSize;
    }

    public LinkedHashMap<String, String> getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(LinkedHashMap<String, String> orderBy) {
        this.orderBy = orderBy;
    }

    public Map<String, Object> getCondition() {
        return condition;
    }

    public void setCondition(Map<String, Object> condition) {
        this.condition = condition;
    }
}
