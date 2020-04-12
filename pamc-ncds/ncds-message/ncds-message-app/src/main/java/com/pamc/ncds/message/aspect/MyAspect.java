package com.pamc.ncds.message.aspect;

import com.pamc.ncds.message.domain.RespBase;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.reflect.MethodSignature;

import java.lang.reflect.Parameter;

/**
 * @Author: songqiang
 * @Description :
 * @Date : Create in 2020/4/8 21:32
 * @Modified :
 **/
//@Component
//@Aspect
public class MyAspect {

    //@Pointcut(value = "@annotation(javax.validation.constraints.NotNull)")
    public void pointCut(){}

    //@Before("ponitcut()")
    public RespBase before(JoinPoint joinPoint){
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Object[] args = joinPoint.getArgs();

        Parameter[] parameters = signature.getMethod().getParameters();
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<args.length;i++){
            sb.append(parameters[i]);
        }
        RespBase respBase = new RespBase();
        respBase.setStatu("false");
        respBase.setCode("0101");
        respBase.setMsg(sb.toString());
        return respBase;

    }
}
