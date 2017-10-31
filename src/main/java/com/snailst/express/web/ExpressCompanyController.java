package com.snailst.express.web;

import com.snailst.express.entity.ExpressCompany;
import com.snailst.express.entity.QueryParam;
import com.snailst.express.entity.Res;
import com.snailst.express.service.IExpressCompanyService;
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
 * @since 2017-10-31
 */
@Controller
public class ExpressCompanyController extends BaseController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private IExpressCompanyService expressCompanyService;

    /**
     * 查询所有的快递公司
     *
     * @return
     */
    @RequestMapping(value = "express_companys", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<Res> getExpressCompanys(@RequestBody QueryParam param) {
        try {
            List<ExpressCompany> expressCompanys = expressCompanyService.getExpressCompanys(param);
            return SUCCESS(expressCompanys);
        } catch (Exception e) {
            logger.error("获取所有的快递公司失败，{}", e.getMessage());
            return FAILED();
        }
    }

}
