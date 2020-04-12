package com.pamc.ncds.message.aspect;

import com.pamc.ncds.exception.exception.BaseException;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Set;

/**
 * @Author: songqiang
 * @Description :
 * @Date : Create in 2020/4/9 22:04
 * @Modified :
 **/
@Aspect
@Component
public class ValidatedAspect {

    @Pointcut("@annotation(org.springframework.validation.annotation.Validated)")
    public void ponitCut(){}

    @Before("ponitCut()")
    public void validatedMethod(JoinPoint joinPoint) throws BaseException, InterruptedException {
        Object[] args = joinPoint.getArgs();
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
        Set<ConstraintViolation<Object>> constraintViolations = validator.forExecutables()
                .validateParameters(joinPoint.getThis(), signature.getMethod(), args);
        StringBuilder sb = new StringBuilder();
        for (ConstraintViolation<Object> cv:constraintViolations){
            String message = cv.getMessage();
            sb.append(message);
        }
        Thread.sleep(3000);
        System.out.println(sb.toString());

        if(sb.length()>0){
            throw new BaseException(sb.toString());
        }
    }
}
