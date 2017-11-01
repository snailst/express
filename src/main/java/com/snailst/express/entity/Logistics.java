package com.snailst.express.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import java.io.Serializable;
import java.util.Date;


/**
 * <p>
 * 
 * </p>
 *
 * @author zhuzhongpei
 * @since 2017-10-31
 */
public class Logistics extends Model<Logistics> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
	private Long id;
    /**
     * 物流信息
     */
	private String context;

    /**
     * 是否签收
     */
	private Boolean is_finished;
    /**
     * 订单ID
     */
	private Long order_id;

    /**
     * 更新时间
     */
	private Date update_at;

    public Logistics() {
    }

    public Logistics(String context, Long order_id) {
        this.context = context;
        this.order_id = order_id;
        this.update_at = new Date();
    }

    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getContext() {
		return context;
	}

	public Logistics setContext(String context) {
		this.context = context;
		return this;
	}

	public Long getOrder_id() {
		return order_id;
	}

	public void setOrder_id(Long order_id) {
		this.order_id = order_id;
	}

    public Boolean getIs_finished() {
        return is_finished;
    }

    public void setIs_finished(Boolean is_finished) {
        this.is_finished = is_finished;
    }

    public Date getUpdate_at() {
        return update_at;
    }

    public void setUpdate_at(Date update_at) {
        this.update_at = update_at;
    }

    @Override
	protected Serializable pkVal() {
		return this.id;
	}

}
