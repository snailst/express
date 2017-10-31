package com.snailst.express.service;

import com.baomidou.mybatisplus.service.IService;
import com.snailst.express.entity.Orders;
import com.snailst.express.entity.QueryParam;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zhuzhongpei
 * @since 2017-10-30
 */
public interface IOrdersService extends IService<Orders> {

    /**
     * 查询所有的订单
     * @return
     */
    List<Orders> getOrders(QueryParam param);

    /**
     * 查询总记录数
     * @param param
     * @return
     */
    long getCount(QueryParam param);
}
