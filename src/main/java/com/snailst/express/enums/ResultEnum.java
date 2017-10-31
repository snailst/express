package com.snailst.express.enums;

/**
 * @author zhuzhongpei
 * @date 2017/10/16 10:21
 * @description
 * @since 1.0
 */
public enum ResultEnum {

    SUCCESS("200", "成功"),
    PARAM_ERROR("400", "参数不合法"),
    PERMISSION_DENIED("401", "没有权限"),
    NO_LOGIN("401", "用户未登录"),
    NOT_FOUND("404", "页面不存在"),
    REQUEST_TIMEOUT("408", "请求超时"),
    SYSTEM_ERROR("500", "服务器异常")

    ;

    private String code;

    private String message;

    ResultEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
