package com.snailst.express.mapper;

import com.snailst.express.entity.Orders;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.snailst.express.entity.QueryParam;

import java.util.List;

/**
 * <p>
  *  Mapper 接口
 * </p>
 *
 * @author zhuzhongpei
 * @since 2017-10-30
 */
public interface OrdersMapper extends BaseMapper<Orders> {

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