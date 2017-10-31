package com.snailst.express.service.impl;

import com.snailst.express.entity.Logistics;
import com.snailst.express.mapper.LogisticsMapper;
import com.snailst.express.service.ILogisticsService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zhuzhongpei
 * @since 2017-10-31
 */
@Service
public class LogisticsServiceImpl extends ServiceImpl<LogisticsMapper, Logistics> implements ILogisticsService {

    /**
     * 根据订单ID查询物流信息
     *
     * @param order_id
     * @return
     */
    @Override
    public Logistics getLogistics(long order_id) {
        return baseMapper.getLogistics(order_id);
    }
}
