package com.snailst.express.mapper;

import com.snailst.express.entity.Logistics;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
  *  Mapper 接口
 * </p>
 *
 * @author zhuzhongpei
 * @since 2017-10-31
 */
public interface LogisticsMapper extends BaseMapper<Logistics> {

    /**
     * 根据订单ID查询物流信息
     * @param order_id
     * @return
     */
    Logistics getLogistics(@Param("order_id") long order_id);
}