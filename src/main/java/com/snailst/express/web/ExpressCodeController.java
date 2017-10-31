package com.snailst.express.web;

import com.snailst.express.entity.Res;
import com.snailst.express.service.IExpressCodeService;
import com.snailst.express.web.dto.ExpressCodeDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author zhuzhongpei
 * @since 2017-10-30
 */
@Controller
public class ExpressCodeController extends BaseController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private IExpressCodeService expressCodeService;

    /**
     * 快递单号充值
     *
     * @param param
     * @return
     */
    @RequestMapping(value = "/recharge_express_code", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<Res> rechargeExpressCode(@RequestBody ExpressCodeDto param) {
        try {
            expressCodeService.rechargeExpressCode(param);
            return SUCCESS();
        } catch (Exception e) {
            logger.error("快递单号充值失败，{}", e.getMessage());
            return FAILED();
        }
    }

    /**
     * 获取下一个未使用的快递单号
     *
     * @param com 快递公司代码
     * @return
     */
    @RequestMapping(value = "/get_next_express_code", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<Res> getNextExpressCode(@RequestParam String com) {
        try {
            String code = expressCodeService.getNextExpressCode(com);
            return SUCCESS(code);
        } catch (Exception e) {
            logger.error("查询下一个快递单号失败，{}", e.getMessage());
            return FAILED();
        }
    }
}
