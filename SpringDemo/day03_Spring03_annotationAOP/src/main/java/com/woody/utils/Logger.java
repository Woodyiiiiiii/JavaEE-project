package com.woody.utils;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * 用于记录日志的工具类，它提供了公共代码
 */
@Component("logger")
@Aspect         // 表示当前类是一个切面类
public class Logger {

    @Pointcut("execution(* com.woody.service.impl.*.*(..))")
    private void ptl() {}

    /**
     *  前置通知
     */
    // @Before("ptl()") // 注意要写括号
    public void beforePrintLog() {
        System.out.println("前置通知:Logger类中的beforePrintLog方法开始记录日志了...");
    }

    /**
     *  后置通知
     */
    // @AfterReturning("ptl()") // 注意要写括号
    public void afterReturningPrintLog() {
        System.out.println("后置通知:Logger类中的afterReturningPrintLog方法开始记录日志了...");
    }

    /**
     *  异常通知
     */
    // @AfterThrowing("ptl()") // 注意要写括号
    public void afterThrowingPrintLog() {
        System.out.println("异常通知:Logger类中的afterThrowingPrintLog方法开始记录日志了...");
    }

    /**
     *  最终通知
     */
    // @After("ptl()") // 注意要写括号
    public void afterPrintLog() {
        System.out.println("最终通知:Logger类中的afterPrintLog方法开始记录日志了...");
    }

    /**
     * 环绕通知
     * 问题：
     *      当我们配置了环绕通知之后，切入点方法没有执行，而通知方法执行了
     * 分析：
     *      通过对比动态代理中的环绕通知代码，发现动态代理的环绕通知有明确的切入点方法，而我们的代码中没有
     * 解决：
     *      Spring框架为我们提供了一个接口：ProceedingJoinPoint。该接口有一个方法proceed()，此方法相当于调用切入点方法
     *      该接口可以作为环绕通知的方法参数，在程序执行时，Spring框架会为我们提供该接口的实现类供我们使用
     *
     * Spring中的环绕通知：
     *      它是Spring框架为我们提供的一种可以在代码中手动控制增强方法何时执行的方式
     *
     *  注解AOP中如果不使用环绕通知，其他四种通知会有顺序调用问题(主要是后置/异常通知和最终通知)，所以注解AOP尽量使用环绕通知
     */
    @Around("ptl()") // 注意要写括号
    public Object aroundPrintLog(ProceedingJoinPoint proceedingJoinPoint) {
        Object returnValue = null;
        try {
            Object[] args = proceedingJoinPoint.getArgs();  // 得到方法执行所需的参数

            System.out.println("aroundPrintLog:Logger类中的afterPrintLog方法开始记录日志了...前置");

            returnValue = proceedingJoinPoint.proceed(); // 明确调用业务层方法(切入点方法)

            System.out.println("aroundPrintLog:Logger类中的afterPrintLog方法开始记录日志了...后置");

            return returnValue;
        }catch (Throwable t) {              // Throwable，不能是Exception
            System.out.println("aroundPrintLog:Logger类中的afterPrintLog方法开始记录日志了...异常");
            throw new RuntimeException(t);
        }finally {
            System.out.println("aroundPrintLog:Logger类中的afterPrintLog方法开始记录日志了...最终");
        }

    }
}
