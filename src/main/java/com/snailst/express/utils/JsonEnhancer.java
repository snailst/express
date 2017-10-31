package com.snailst.express.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.lang.reflect.Type;

/**
 * @author zhuzhongpei
 * @version 1.0
 * @date 2017/05/08 17:36
 * @description Json 工具类
 */
public final class JsonEnhancer {

    private static final Gson gson = new GsonBuilder().create();

    /**
     * 把JSON字符串转换成一个有泛型的复杂对象
     * @param json JSON字符串
     * @param type 泛型类的类型
     * @param <T> 泛型
     * @return
     */
    public static <T> T fromJson(String json, Type type){
        try{
            return gson.fromJson(json, type);
        }catch (Exception e){
            return null;
        }
    }
}
