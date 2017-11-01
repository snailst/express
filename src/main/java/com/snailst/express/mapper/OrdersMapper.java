package com.snailst.express.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.snailst.express.entity.Orders;
import com.snailst.express.entity.QueryParam;
import org.apache.ibatis.annotations.Param;

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

    /**
     * 设置打印状态
     * @param whereSql
     * @param state
     */
    void setPrintState(@Param("whereSql") String whereSql, @Param("state") Boolean state);
}