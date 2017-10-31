package com.snailst.express.service.impl;

import com.snailst.express.entity.Goods;
import com.snailst.express.entity.QueryParam;
import com.snailst.express.mapper.GoodsMapper;
import com.snailst.express.service.IGoodsService;
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
public class GoodsServiceImpl extends ServiceImpl<GoodsMapper, Goods> implements IGoodsService {

    /**
     * 查询所有的商品
     *
     * @param param
     * @return
     */
    @Override
    public List<Goods> getGoods(QueryParam param) {
        return baseMapper.getGoods(param);
    }
}
