package com.snailst.express.entity;

import java.io.Serializable;

/**
 * @author zhuzhongpei
 * @date 2017/10/16 10:19
 * @description
 * @since 1.0
 */
public class Res<T> implements Serializable {
    /**
     * 状态码
     */
    private String code;

    /**
     * 消息
     */
    private String message;

    /**
     * 数据
     */
    private T data;

    /**
     * 总记录数
     */
    private long totalRecords;

    public Res() {
    }

    public Res(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public Res(String code, String message, T o) {
        this.code = code;
        this.message = message;
        this.data = o;
    }

    public Res(T data, long totalRecords) {
        this.data = data;
        this.totalRecords = totalRecords;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public long getTotalRecords() {
        return totalRecords;
    }

    public void setTotalRecords(long totalRecords) {
        this.totalRecords = totalRecords;
    }

    @Override
    public String toString() {
        return "Res{" +
                "code='" + code + '\'' +
                ", message='" + message + '\'' +
                ", data=" + data +
                ", totalRecords=" + totalRecords +
                '}';
    }
}
