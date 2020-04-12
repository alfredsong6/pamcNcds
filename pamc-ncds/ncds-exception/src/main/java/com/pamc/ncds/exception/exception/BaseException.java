package com.pamc.ncds.exception.exception;

/**
 * @Author: songqiang
 * @Description :
 * @Date : Create in 2020/4/9 22:52
 * @Modified :
 **/
public class BaseException extends RuntimeException{
    private String code;
    private String msg;
    public BaseException(){

    }
    public BaseException(String code,String msg){
        this.code = code;
        this.msg = msg;
    }
    public BaseException(String msg){
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
