package com.snailst.express.utils;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

/**
 * @author zhuzhongpei
 * @date 2017/10/31 09:53
 * @description 物流查询工具类
 * @since 1.0
 */
public class LogisticsUtils {

    private static final String EXPRESS_QUERY_URL = "http://www.kuaidi100.com/query?type=%s&postid=%s&id=1&valicode=&temp=%s";

    /**
     * 物流信息查询
     *
     * @param com
     * @param code
     * @return
     */
    public static String search(String com, String code) throws UnirestException {
        String url = String.format(EXPRESS_QUERY_URL, com, code, Math.random());
        HttpResponse<String> response = Unirest.get(url).asString();
        return response.getBody();
    }
}
