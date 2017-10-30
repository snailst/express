package com.snailst.express.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import java.util.Date;
import java.io.Serializable;


/**
 * <p>
 * 
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
     * 商品规格ID
     */
	private Long goods_spec_id;
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
	private String aggress;
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
     * 快递公司
     */
	private String com;


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

	public String getAggress() {
		return aggress;
	}

	public void setAggress(String aggress) {
		this.aggress = aggress;
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

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

}
