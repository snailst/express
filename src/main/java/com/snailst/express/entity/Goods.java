package com.snailst.express.entity;

import com.baomidou.mybatisplus.activerecord.Model;

import java.io.Serializable;


/**
 * <p>
 * <p>
 * </p>
 *
 * @author zhuzhongpei
 * @since 2017-10-30
 */
public class Goods extends Model<Goods> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    private Long id;
    /**
     * 商品名称
     */
    private String goods_name;
    /**
     * 备注
     */
    private String remarks;


    public Long getId() {
        return id;
    }

    public String getIds() {
        return String.valueOf(id);
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGoods_name() {
        return goods_name;
    }

    public void setGoods_name(String goods_name) {
        this.goods_name = goods_name;
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
