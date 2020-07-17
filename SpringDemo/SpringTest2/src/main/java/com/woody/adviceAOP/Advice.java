package com.woody.adviceAOP;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * AOP通知类
 */
//@Component("advice")
//@Aspect
public class Advice {

//    @Pointcut("execution(* com.woody.domain.*.*(..))")
    public void pt1() {
    }

//    @Before("pt1()")
    public void beforeAdvice() {
        System.out.println("前置通知...");
    }

//    @AfterReturning("pt1()")
    public void afterReturningAdvice() {
        System.out.println("后置通知...");
    }

//    @AfterThrowing("pt1()")
    public void afterThrowingAdvice() {
        System.out.println("异常通知...");
    }

//    @After("pt1()")
    public void afterAdvice() {
        System.out.println("最终通知...");
    }

//    @Around("pt1()")
    public Object aroundAdvice(ProceedingJoinPoint proceedingJoinPoint) {
        Object rt = null;
        try {
            Object[] args = proceedingJoinPoint.getArgs();
            beforeAdvice();
            rt = proceedingJoinPoint.proceed(args);
            afterReturningAdvice();
        }catch (Throwable throwable) {
            afterThrowingAdvice();
            throwable.printStackTrace();
        }finally {
            afterAdvice();
        }

        return rt;
    }
}
