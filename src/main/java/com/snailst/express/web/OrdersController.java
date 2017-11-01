package com.snailst.express.web;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.google.gson.reflect.TypeToken;
import com.snailst.express.entity.*;
import com.snailst.express.service.ILogisticsService;
import com.snailst.express.service.IOrdersService;
import com.snailst.express.utils.Constants;
import com.snailst.express.utils.JsonEnhancer;
import com.snailst.express.utils.LogisticsUtils;
import com.snailst.express.utils.StringUtils;
import com.snailst.express.web.dto.LogisticsDto;
import org.apache.commons.collections.MapUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Map;

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
            // 设置查询条件
            Map<String, Object> condition = param.getCondition();
            String search = MapUtils.getString(condition, "search");
            String createAt = MapUtils.getString(condition, "create_at");
            StringBuffer sql = new StringBuffer();
            if (StringUtils.isNotEmpty(search)) {
                sql.append("(mobile_number like '%").append(search)
                        .append("%' or customer_name like '%").append(search).append("%')");
            }
            if (StringUtils.isNotEmpty(createAt)) {
                if (sql.length() > 0) sql.append(" and ");
                sql.append(" DATE_FORMAT(create_at, '%Y-%m-%d') = '").append(createAt).append("'");
            }
            param.setWhereSql(sql.toString());
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
     *
     * @param param
     * @return
     */
    @RequestMapping(value = "/get_logistics", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<Res> logistic(@RequestBody LogisticsDto param) {
        try {
            // 查询订单信息
            Orders order = ordersService.selectById(param.getOrder_id());
            // 查询物流信息
            Logistics logistic = logisticsService.getLogistics(param.getOrder_id());
            // 如果订单已打印，并且没有物流信息
            if (order.getIs_printed() && (null == logistic || !logistic.getIs_finished())) {
                String context = LogisticsUtils.search(param.getCom(), param.getCode());
                LogisticsRes logisticsRes = JsonEnhancer.fromJson(context,
                        new TypeToken<LogisticsRes>() {
                        }.getType());
                if (logisticsRes.getData().size() > 0 && !order.getIs_send()) {
                    // 有物流信息，更新订单物流状态
                    order.setIs_send(Boolean.TRUE);
                    ordersService.update(order, new EntityWrapper<Orders>()
                            .eq("id", order.getId()));
                }
                // 更新订单对应的物流信息
                logistic = logistic == null ? new Logistics(context, param.getOrder_id()) : logistic.setContext(context);
                if (context.indexOf(Constants.REG_SIGN_FOR) > -1) {
                    logistic.setIs_finished(Boolean.TRUE);
                }
                if (logistic.getId() == null) {
                    logisticsService.insert(logistic);
                } else {
                    logistic.setUpdate_at(new Date());
                    logisticsService.update(logistic, new EntityWrapper<Logistics>()
                            .eq("id", logistic.getId()));
                }
            }
            return SUCCESS(logistic == null ? null : logistic.getContext());
        } catch (Exception e) {
            logger.error("物流信息查询失败，{}", e.getMessage());
            return FAILED();
        }
    }

    /**
     * 添加/修改订单
     *
     * @return
     */
    @RequestMapping(value = "/save_order", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<Res> saveOrder(@RequestBody Orders order) {
        try {
            String[] areas = StringUtils.decodeAddress(order.getAddress());
            order.setProvince(areas[0]);
            order.setCity(areas[1]);
            order.setCounty(areas[2]);
            order.setTown(areas[3]);
            order.setStreet(areas[4]);
            ordersService.saveOrder(order);
            return SUCCESS();
        } catch (Exception e) {
            logger.error("添加订单失败，{}", e.getMessage());
            return FAILED();
        }
    }

    /**
     * 删除订单，如果快递单号未打印，恢复可用
     *
     * @param id
     * @return
     */
    @DeleteMapping(value = "/del_order")
    @ResponseBody
    public ResponseEntity<Res> delOrder(@RequestParam Long id) {
        try {
            ordersService.delOrder(id);
            return SUCCESS();
        } catch (Exception e) {
            logger.error("删除订单失败，{}", e.getMessage());
            return FAILED();
        }
    }

    /**
     * 刷新所有已打印的没有物流信息的订单
     *
     * @return
     */
    @RequestMapping(value = "/refresh_logistics", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<Res> refreshLogistics() {
        try {
            ordersService.refreshLogistics();
            return SUCCESS();
        } catch (Exception e) {
            return FAILED();
        }
    }
}
