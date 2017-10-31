package com.snailst.express.service;

import com.snailst.express.entity.Logistics;
import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zhuzhongpei
 * @since 2017-10-31
 */
public interface ILogisticsService extends IService<Logistics> {

    /**
     * 根据订单ID查询物流信息
     * @param order_id
     * @return
     */
    Logistics getLogistics(long order_id);
}
