package com.snailst.express.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import java.io.Serializable;


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
     * 订单ID
     */
	private Long order_id;

    public Logistics() {
    }

    public Logistics(String context, Long order_id) {
        this.context = context;
        this.order_id = order_id;
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

	public void setContext(String context) {
		this.context = context;
	}

	public Long getOrder_id() {
		return order_id;
	}

	public void setOrder_id(Long order_id) {
		this.order_id = order_id;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

}
