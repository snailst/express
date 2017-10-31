package com.snailst.express.web.dto;

/**
 * @author zhuzhongpei
 * @date 2017/10/31 14:00
 * @description
 * @since 1.0
 */
public class LogisticsDto {

    private long order_id;

    private String code;

    private String com;

    public long getOrder_id() {
        return order_id;
    }

    public void setOrder_id(long order_id) {
        this.order_id = order_id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCom() {
        return com;
    }

    public void setCom(String com) {
        this.com = com;
    }

    @Override
    public String toString() {
        return "LogisticsDto{" +
                "order_id=" + order_id +
                ", code='" + code + '\'' +
                ", com='" + com + '\'' +
                '}';
    }
}
