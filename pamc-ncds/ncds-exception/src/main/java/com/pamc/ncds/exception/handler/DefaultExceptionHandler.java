package com.pamc.ncds.exception.handler;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.pamc.ncds.exception.ExceptionEnum;
import com.pamc.ncds.exception.domain.CommonType;
import com.pamc.ncds.exception.domain.Result;
import com.pamc.ncds.exception.exception.BaseException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.MethodParameter;
import org.springframework.core.io.Resource;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import javax.annotation.PostConstruct;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

/**
 * @Author: songqiang
 * @Description :
 * @Date : Create in 2020/4/9 22:23
 * @Modified :
 **/

public class DefaultExceptionHandler implements ExceptionResolverHandler {

    private static List<CommonType> defaultExceptionTypes;

    @Value("classPath:default-exception.json")
    private Resource resource;

    @PostConstruct
    public void init() throws IOException {
        //提取配置文件中默认的异常类型
        System.out.println("执行PostConstruct。。");
        InputStream is = resource.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        StringBuilder sb = new StringBuilder();
        String line;

        while((line = br.readLine()) != null){
            sb.append(line);
        }
        JSONArray jsonArray = JSON.parseArray(sb.toString());
        defaultExceptionTypes = JSONArray.parseArray(jsonArray.toString(), CommonType.class);

    }

    @Override
    public Result resolver(Exception ex) {
        if(ex instanceof BindException){
             BindException exception = (BindException) ex;
            BindingResult br = exception.getBindingResult();
            List<ObjectError> allErrors = br.getAllErrors();
            StringBuilder sb = new StringBuilder();
            for(ObjectError error :allErrors){
                sb.append(error.getDefaultMessage());
            }
            return new Result(ExceptionEnum.PARAM_TYPE_ERROR.getCode(),sb.toString());

        }
        if(ex instanceof MethodArgumentNotValidException){
            MethodArgumentNotValidException exception = (MethodArgumentNotValidException) ex;
            BindingResult bindingResult = exception.getBindingResult();
            List<FieldError> errors = bindingResult.getFieldErrors();
            StringBuilder sb = new StringBuilder();
            for(FieldError fe: errors){
                String message = fe.getDefaultMessage();
                sb.append(message);
            }
            return new Result(ExceptionEnum.PARAM_VALIDATE_ERROR.getCode(),sb.toString());
        }
        if(ex instanceof MethodArgumentTypeMismatchException){
            MethodArgumentTypeMismatchException exception = (MethodArgumentTypeMismatchException) ex;
            MethodParameter parameter = exception.getParameter();
            String parameterName = parameter.getParameterName();
            return new Result(ExceptionEnum.PARAM_TYPE_ERROR.getCode(),"参数名："+parameterName);
        }
        for(CommonType commonType:defaultExceptionTypes){
            String name = ex.getClass().getName();
            if(name.equals(commonType.getCommons())){
                return new Result(commonType.getCode(),commonType.getMsg());
            }
        }

        if(ex instanceof BaseException){
            return new Result(ExceptionEnum.PARAM_VALIDATE_ERROR.getCode(),((BaseException) ex).getMsg());
        }

        return null;
    }
}
