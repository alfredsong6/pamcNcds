package com.pamc.test.model.aspect;

/**
 * @Author: songqiang
 * @Description :
 * @Date : Create in 2020/4/11 18:32
 * @Modified :
 **/
//@Component
//@Aspect
public class TestAspect {
//    @Pointcut("@annotation(org.springframework.validation.annotation.Validated)")
//    public void ponitCut(){}
//
//    @Before("ponitCut()")
//    public void validatedMethod(JoinPoint joinPoint) throws BaseException, InterruptedException {
//        Object[] args = joinPoint.getArgs();
//        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
//        Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
//        Set<ConstraintViolation<Object>> constraintViolations = validator.forExecutables()
//                .validateParameters(joinPoint.getThis(), signature.getMethod(), args);
//        StringBuilder sb = new StringBuilder();
//        for (ConstraintViolation<Object> cv:constraintViolations){
//            String message = cv.getMessage();
//            sb.append(message);
//        }
//        Thread.sleep(3000);
//        System.out.println(sb.toString());
//
//        if(sb.length()>0){
//            throw new BaseException(sb.toString());
//        }
//    }
}
