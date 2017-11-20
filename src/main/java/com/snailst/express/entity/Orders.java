package com.snailst.express.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;
import java.io.Serializable;


/**
 * <p>
 * <p>
 * </p>
 *
 * @author zhuzhongpei
 * @since 2017-10-30
 */
public class Orders extends Model<Orders> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    private Long id;
    /**
     * 快递单号
     */
    private String express_code;
    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy年MM月dd日", timezone = "GMT+8")
    private Date create_at;
    /**
     * 客户名称
     */
    private String customer_name;
    /**
     * 手机号码
     */
    private String mobile_number;
    /**
     * 商品ID
     */
    private Long goods_id;
    /**
     * 商品名称
     */
    @TableField(exist = false)
    private String goods_name;
    /**
     * 商品规格ID
     */
    private Long goods_spec_id;
    /**
     * 商品规格名称
     */
    @TableField(exist = false)
    private String goods_spec_name;
    /**
     * 商品数量
     */
    private Double goods_num;
    /**
     * 代理名称
     */
    private String agent_name;
    /**
     * 代理电话
     */
    private String agent_mobile_number;
    /**
     * 收件地址
     */
    private String address;
    /**
     * 省
     */
    private String province;
    /**
     * 市
     */
    private String city;
    /**
     * 县
     */
    private String county;
    /**
     * 镇/乡/区
     */
    private String town;
    /**
     * 街道详情
     */
    private String street;
    /**
     * 快递公司代码
     */
    private String com;

    /**
     * 快递公司名称
     */
    private String company_name;

    /**
     * 是否已打印
     */
    private Boolean is_printed;

    /**
     * 是否发货
     */
    private Boolean is_send;

    /**
     * 備註
     */
    private String remarks;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getExpress_code() {
        return express_code;
    }

    public void setExpress_code(String express_code) {
        this.express_code = express_code;
    }

    public Date getCreate_at() {
        return create_at;
    }

    public void setCreate_at(Date create_at) {
        this.create_at = create_at;
    }

    public String getCustomer_name() {
        return customer_name;
    }

    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }

    public String getMobile_number() {
        return mobile_number;
    }

    public void setMobile_number(String mobile_number) {
        this.mobile_number = mobile_number;
    }

    public Long getGoods_id() {
        return goods_id;
    }

    public void setGoods_id(Long goods_id) {
        this.goods_id = goods_id;
    }

    public Long getGoods_spec_id() {
        return goods_spec_id;
    }

    public void setGoods_spec_id(Long goods_spec_id) {
        this.goods_spec_id = goods_spec_id;
    }

    public Double getGoods_num() {
        return goods_num;
    }

    public void setGoods_num(Double goods_num) {
        this.goods_num = goods_num;
    }

    public String getAgent_name() {
        return agent_name;
    }

    public void setAgent_name(String agent_name) {
        this.agent_name = agent_name;
    }

    public String getAgent_mobile_number() {
        return agent_mobile_number;
    }

    public void setAgent_mobile_number(String agent_mobile_number) {
        this.agent_mobile_number = agent_mobile_number;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCom() {
        return com;
    }

    public void setCom(String com) {
        this.com = com;
    }

    public String getGoods_name() {
        return goods_name;
    }

    public void setGoods_name(String goods_name) {
        this.goods_name = goods_name;
    }

    public String getGoods_spec_name() {
        return goods_spec_name;
    }

    public void setGoods_spec_name(String goods_spec_name) {
        this.goods_spec_name = goods_spec_name;
    }

    public String getCompany_name() {
        return company_name;
    }

    public void setCompany_name(String company_name) {
        this.company_name = company_name;
    }

    public Boolean getIs_printed() {
        return is_printed;
    }

    public void setIs_printed(Boolean is_printed) {
        this.is_printed = is_printed;
    }

    public Boolean getIs_send() {
        return is_send;
    }

    public void setIs_send(Boolean is_send) {
        this.is_send = is_send;
    }

    public String getSendStr() {
        return is_send ? "有物流" : "暂无物流";
    }

    public String getPrintedStr() {
        return is_printed ? "已打印" : "未打印";
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
