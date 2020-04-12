package com.pamc.ncds.message.domain;

/**
 * @Author: songqiang
 * @Description :
 * @Date : Create in 2020/3/28 23:22
 * @Modified :
 **/
public class RespBase {
    private String code;
    private String msg;
    private String statu;

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

    public String getStatu() {
        return statu;
    }

    public void setStatu(String statu) {
        this.statu = statu;
    }
}
