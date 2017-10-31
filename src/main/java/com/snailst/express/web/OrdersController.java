package com.snailst.express.web;

import com.snailst.express.entity.Logistics;
import com.snailst.express.entity.Orders;
import com.snailst.express.entity.QueryParam;
import com.snailst.express.entity.Res;
import com.snailst.express.service.ILogisticsService;
import com.snailst.express.service.IOrdersService;
import com.snailst.express.utils.LogisticsUtils;
import com.snailst.express.web.dto.LogisticsDto;
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
 * 前端控制器
 * </p>
 *
 * @author zhuzhongpei
 * @since 2017-10-30
 */
@Controller
public class OrdersController extends BaseController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private IOrdersService ordersService;

    @Autowired
    private ILogisticsService logisticsService;

    /**
     * 查询所有的订单
     *
     * @return
     */
    @RequestMapping(value = "/get_orders", method = RequestMethod.POST)
    public ResponseEntity<Res> orders(@RequestBody QueryParam param) {
        try {
            long totalRecords = ordersService.getCount(param);
            List<Orders> orders = ordersService.getOrders(param);
            return SUCCESS(new Res(orders, totalRecords));
        } catch (Exception e) {
            logger.error("查询订单失败，{}", e.getMessage());
            return FAILED();
        }
    }

    /**
     * 物流信息查询
     * @param param
     * @return
     */
    @RequestMapping(value = "/get_logistics", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<Res> logistic(@RequestBody LogisticsDto param){
        try {
            Logistics logistic = logisticsService.getLogistics(param.getOrder_id());
            if(null == logistic){
                String context = LogisticsUtils.search(param.getCom(), param.getCode());
                logistic = new Logistics(context, param.getOrder_id());
                logisticsService.insert(logistic);
            }
            return SUCCESS(logistic.getContext());
        }catch (Exception e){
            logger.error("物流信息查询失败，{}", e.getMessage());
            return FAILED();
        }
    }
}
