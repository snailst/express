package com.snailst.express.service;

import com.snailst.express.entity.Goods;
import com.baomidou.mybatisplus.service.IService;
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
public interface IGoodsService extends IService<Goods> {

    /**
     * 查询所有的商品
     * @param param
     * @return
     */
    List<Goods> getGoods(QueryParam param);

    /**
     * 保存商品
     * @param goods
     */
    void saveGoods(Goods goods);

    /**
     * 查询总记录数
     * @param param
     * @return
     */
    long getCount(QueryParam param);
}
