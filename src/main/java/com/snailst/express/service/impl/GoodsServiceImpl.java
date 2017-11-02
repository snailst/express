package com.snailst.express.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.snailst.express.entity.Goods;
import com.snailst.express.entity.QueryParam;
import com.snailst.express.mapper.GoodsMapper;
import com.snailst.express.service.IGoodsService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

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

    /**
     * 保存商品
     *
     * @param goods
     */
    @Override
    public void saveGoods(Goods goods) {
        if (goods.getId() == null) {
            baseMapper.insert(goods);
        } else {
            baseMapper.update(goods, new EntityWrapper<Goods>()
                    .eq("id", goods.getId()));
        }
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
