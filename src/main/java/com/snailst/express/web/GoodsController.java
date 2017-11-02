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
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author zhuzhongpei
 * @since 2017-10-30
 */
@Controller
public class GoodsController extends BaseController {

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
            long totalRecord = goodsService.getCount(param);
            List<Goods> goods = goodsService.getGoods(param);
            return SUCCESS(new Res(goods, totalRecord));
        } catch (Exception e) {
            logger.error("获取所有的快递公司失败，{}", e.getMessage());
            return FAILED();
        }
    }

    /**
     * 保存商品
     *
     * @param goods
     * @return
     */
    @RequestMapping(value = "/save_goods", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<Res> saveGoods(@RequestBody Goods goods) {
        try {
            goodsService.saveGoods(goods);
            return SUCCESS();
        } catch (Exception e) {
            return FAILED();
        }
    }

    /**
     * 删除商品
     * @param id
     * @return
     */
    @DeleteMapping(value = "/del_goods")
    @ResponseBody
    public ResponseEntity<Res> delGoods(@RequestParam long id) {
        try {
            goodsService.deleteById(id);
            return SUCCESS();
        } catch (Exception e) {
            return FAILED();
        }
    }
}
