package com.pamc.ncds.exception.domain;

/**
 * @Author: songqiang
 * @Description :
 * @Date : Create in 2020/4/9 22:22
 * @Modified :
 **/
public class Result {
    private String code;
    private String msg;

    public Result(String code, String msg) {
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
