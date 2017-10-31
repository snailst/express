package com.snailst.express.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhuzhongpei
 * @date 2017/10/31 10:04
 * @description 物流信息查询结果
 * @since 1.0
 */
public class LogisticsRes {

    private String message;

    private String nu;

    private String ischeck;

    private String condition;

    private String com;

    private String status;

    private String state;

    private List<Logistics> data = new ArrayList<>();

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getNu() {
        return nu;
    }

    public void setNu(String nu) {
        this.nu = nu;
    }

    public String getIscheck() {
        return ischeck;
    }

    public void setIscheck(String ischeck) {
        this.ischeck = ischeck;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getCom() {
        return com;
    }

    public void setCom(String com) {
        this.com = com;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public List<Logistics> getData() {
        return data;
    }

    public void setData(List<Logistics> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "LogisticsRes{" +
                "message='" + message + '\'' +
                ", nu='" + nu + '\'' +
                ", ischeck='" + ischeck + '\'' +
                ", condition='" + condition + '\'' +
                ", com='" + com + '\'' +
                ", status='" + status + '\'' +
                ", state='" + state + '\'' +
                ", data=" + data +
                '}';
    }
}
