package com.snailst.express.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.snailst.express.entity.Orders;
import com.snailst.express.entity.QueryParam;
import com.snailst.express.mapper.OrdersMapper;
import com.snailst.express.service.IExpressCodeService;
import com.snailst.express.service.IOrdersService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author zhuzhongpei
 * @since 2017-10-30
 */
@Service
public class OrdersServiceImpl extends ServiceImpl<OrdersMapper, Orders> implements IOrdersService {

    @Autowired
    private IExpressCodeService expressCodeService;

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

    /**
     * 新增/修改订单
     *
     * @param order
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void saveOrder(Orders order) {
        if (order.getId() == null) {
            expressCodeService.setState(Boolean.FALSE, order.getExpress_code());
            baseMapper.insert(order);
        } else {
            baseMapper.update(order, new EntityWrapper<Orders>()
                    .eq("id", order.getId()));
        }
    }

    /**
     * 删除订单
     *
     * @param id
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delOrder(Long id) {
        Orders orders = baseMapper.selectById(id);
        if (!orders.getIs_printed()) {
            // 如果未打印，恢复快递单号
            expressCodeService.setState(Boolean.TRUE, orders.getExpress_code());
        }
        // 删除订单
        baseMapper.deleteById(id);
    }
}
