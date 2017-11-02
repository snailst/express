package com.snailst.express.mapper;

import com.snailst.express.entity.Goods;
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
public interface GoodsMapper extends BaseMapper<Goods> {

    /**
     * 查询所有的商品
     * @param param
     * @return
     */
    List<Goods> getGoods(QueryParam param);

    /**
     * 查询总记录数
     * @param param
     * @return
     */
    long getCount(QueryParam param);
}