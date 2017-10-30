package com.snailst.express.service.impl;

import com.snailst.express.entity.Orders;
import com.snailst.express.mapper.OrdersMapper;
import com.snailst.express.service.IOrdersService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

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
	
}
