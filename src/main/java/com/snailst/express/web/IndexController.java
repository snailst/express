package com.snailst.express.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author zhuzhongpei
 * @date 2017/10/30 10:48
 * @description
 * @since 1.0
 */
@Controller
public class IndexController {
    /**
     * 跳转到首页
     *
     * @return
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index() {
        return "index";
    }
}
