package com.snailst.express.service.impl;

import com.snailst.express.entity.Orders;
import com.snailst.express.entity.QueryParam;
import com.snailst.express.mapper.OrdersMapper;
import com.snailst.express.service.IOrdersService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zhuzhongpei
 * @since 2017-10-30
 */
@Service
public class OrdersServiceImpl extends ServiceImpl<OrdersMapper, Orders> implements IOrdersService {


    /**
     * 查询所有的订单
     *
     * @return
     */
    @Override
    public List<Orders> getOrders(QueryParam param) {
        return baseMapper.getOrders(param);
    }

    /**
     * 查询总记录数
     *
     * @param param
     * @return
     */
    @Override
    public long getCount(QueryParam param) {
        return baseMapper.getCount(param);
    }
}
