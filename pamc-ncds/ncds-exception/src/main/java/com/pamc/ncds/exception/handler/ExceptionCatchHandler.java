package com.pamc.ncds.exception.handler;

import com.pamc.ncds.exception.domain.Result;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @Author: songqiang
 * @Description :
 * @Date : Create in 2020/4/9 22:56
 * @Modified :
 **/
@RestControllerAdvice
public class ExceptionCatchHandler {

    private DefaultExceptionHandler defaultHandler;


    public ExceptionCatchHandler(){
         this.defaultHandler=new DefaultExceptionHandler();
    }


    @ExceptionHandler(value = Exception.class)
    public Result resolverException(Exception ex){
        return defaultHandler.resolver(ex);
    }


}
