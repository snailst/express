package com.snailst.express.web;

import com.snailst.express.entity.Goods;
import com.snailst.express.entity.QueryParam;
import com.snailst.express.entity.Res;
import com.snailst.express.service.IGoodsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zhuzhongpei
 * @since 2017-10-30
 */
@Controller
public class GoodsController extends BaseController{

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private IGoodsService goodsService;

    /**
     * 查询所有的商品
     *
     * @return
     */
    @RequestMapping(value = "/get_goods", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<Res> getGoods(@RequestBody QueryParam param) {
        try {
            List<Goods> goods = goodsService.getGoods(param);
            return SUCCESS(goods);
        } catch (Exception e) {
            logger.error("获取所有的快递公司失败，{}", e.getMessage());
            return FAILED();
        }
    }
}
