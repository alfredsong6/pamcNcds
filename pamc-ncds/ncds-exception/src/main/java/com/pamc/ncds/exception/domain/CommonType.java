package com.pamc.ncds.exception.domain;

/**
 * @Author: songqiang
 * @Description :
 * @Date : Create in 2020/4/9 22:26
 * @Modified :
 **/
public class CommonType {
    private String index;
    private String code;
    private String msg;
    private String type;
    private String commons;
    private String data;

    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCommons() {
        return commons;
    }

    public void setCommons(String commons) {
        this.commons = commons;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
