package com.pamc.ncds.exception;

/**
 * @Author: songqiang
 * @Description :
 * @Date : Create in 2020/4/9 22:40
 * @Modified :
 **/
public enum ExceptionEnum {
    SYS_ERROR("0101","服务器开小差"),
    PARAM_VALIDATE_ERROR("0102","参数校验失败"),
    PARAM_TYPE_ERROR("0103","参数类型错误")
    ;
    private String code;
    private String msg;

    ExceptionEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
