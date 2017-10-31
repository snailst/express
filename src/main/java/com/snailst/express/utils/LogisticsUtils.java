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
        HttpResponse<String> response = Unirest.get(url)
                .header("Host", "www.kuaidi100.com")
                .header("Referer", "http://www.kuaidi100.com/frame/hao123/query.html")
                .header("User-Agen", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_12_6) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/61.0.3163.100 Safari/537.36")
                .asString();
        return response.getBody();
    }
}
