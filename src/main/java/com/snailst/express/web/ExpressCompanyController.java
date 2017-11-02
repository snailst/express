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
import org.springframework.web.bind.annotation.*;

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
            long totalRecord = expressCompanyService.getCount(param);
            List<ExpressCompany> expressCompanys = expressCompanyService.getExpressCompanys(param);
            return SUCCESS(new Res(expressCompanys, totalRecord));
        } catch (Exception e) {
            logger.error("获取所有的快递公司失败，{}", e.getMessage());
            return FAILED();
        }
    }

    /**
     * 保存
     *
     * @param company
     * @return
     */
    @RequestMapping(value = "/save_express_company", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<Res> saveExpressCompany(@RequestBody ExpressCompany company) {
        try {
            expressCompanyService.saveExpressCompany(company);
            return SUCCESS();
        } catch (Exception e) {
            return FAILED();
        }
    }

    /**
     * 删除快递单
     * @param id
     * @return
     */
    @RequestMapping(value = "/del_express_company", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<Res> delExpressCompany(@RequestParam Long id) {
        try {
            expressCompanyService.deleteById(id);
            return SUCCESS();
        } catch (Exception e) {
            logger.error("删除快递公司失败，{}", e.getMessage());
            return FAILED();
        }
    }

}
