package com.snailst.express.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.google.gson.reflect.TypeToken;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.snailst.express.entity.Logistics;
import com.snailst.express.entity.LogisticsRes;
import com.snailst.express.entity.Orders;
import com.snailst.express.entity.QueryParam;
import com.snailst.express.mapper.OrdersMapper;
import com.snailst.express.service.IExpressCodeService;
import com.snailst.express.service.ILogisticsService;
import com.snailst.express.service.IOrdersService;
import com.snailst.express.utils.JsonEnhancer;
import com.snailst.express.utils.LogisticsUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedHashMap;
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

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private IExpressCodeService expressCodeService;

    @Autowired
    private ILogisticsService logisticsService;

    /**
     * 查询所有的订单
     *
     * @return
     */
    @Override
    public List<Orders> getOrders(QueryParam param) {
        // 排序
        LinkedHashMap<String, String> orderBy = param.getOrderBy();
        orderBy.put("is_printed", "ASC");
        orderBy.put("is_send", "ASC");
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

    /**
     * 刷新所有已打印的没有物流信息的订单
     */
    @Override
    public void refreshLogistics() {
        // 1. 查询所有已打印没有物流信息的订单
        QueryParam param = new QueryParam();
        param.setIsPaging(Boolean.FALSE);
        param.setWhereSql(" is_printed = true and is_send = false");
        List<Orders> orders = baseMapper.getOrders(param);
        for (Orders order : orders) {
            try {
                String context = LogisticsUtils.search(order.getCom(), order.getExpress_code());
                LogisticsRes logisticsRes = JsonEnhancer.fromJson(context,
                        new TypeToken<LogisticsRes>() {}.getType());
                if (logisticsRes.getData().size() > 0) {
                    // 有物流信息，更新订单物流状态
                    order.setIs_send(Boolean.TRUE);
                    baseMapper.update(order, new EntityWrapper<Orders>()
                            .eq("id", order.getId()));
                    // 插入物流信息
                    Logistics logistics = new Logistics(context, order.getId());
                    logisticsService.insert(logistics);
                }
            } catch (UnirestException e) {
                logger.error("网络异常，查询物流信息失败，{}", e.getMessage());
            }
        }
    }
}
