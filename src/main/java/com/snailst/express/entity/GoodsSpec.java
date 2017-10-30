package com.snailst.express.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;


/**
 * <p>
 * 
 * </p>
 *
 * @author zhuzhongpei
 * @since 2017-10-30
 */
@TableName("goods_spec")
public class GoodsSpec extends Model<GoodsSpec> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
	private Long id;
    /**
     * 规格名称
     */
	private String goods_spec_name;
    /**
     * 备注
     */
	private String remarks;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getGoods_spec_name() {
		return goods_spec_name;
	}

	public void setGoods_spec_name(String goods_spec_name) {
		this.goods_spec_name = goods_spec_name;
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
