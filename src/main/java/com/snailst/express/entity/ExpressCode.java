package com.snailst.express.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;


/**
 * <p>
 * <p>
 * </p>
 *
 * @author zhuzhongpei
 * @since 2017-10-30
 */
@TableName("express_code")
public class ExpressCode extends Model<ExpressCode> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    private Long id;
    /**
     * 快递单号
     */
    private String code;
    /**
     * 快递公司
     */
    private String com;
    /**
     * 快递公司名称
     */
    @TableField(exist = false)
    private String company_name;
    /**
     * 是否可用
     */
    private Boolean state;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Boolean getState() {
        return state;
    }

    public void setState(Boolean state) {
        this.state = state;
    }

    public String getCompany_name() {
        return company_name;
    }

    public void setCompany_name(String company_name) {
        this.company_name = company_name;
    }

    public String getStateStr() {
        return state ? "已使用" : "未使用";
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
