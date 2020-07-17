package com.woody.utils;

import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Connection;

/**
 * 和事务管理相关的工具类，它包含了开启事务，提交事务，回滚事务和释放连接
 */
@Aspect
public class TransactionManager {

    @Autowired
    private ConnectionUtils connectionUtils;

    public void setConnectionUtils(ConnectionUtils connectionUtils) {
        this.connectionUtils = connectionUtils;
    }

    @Pointcut("execution(* com.woody.service.impl.*.*(..))")
    public void pt1() {
    }

    /**
     * 开启事务
     */
    @Before("pt1()")
    public void beginTransaction() {
        try {
            connectionUtils.getThreadConnection().setAutoCommit(false);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 提交事务
     */
    @AfterReturning("pt1()")
    public void commit() {
        try {
            connectionUtils.getThreadConnection().commit();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 回滚事务
     */
    @AfterThrowing("pt1()")
    public void rollback() {
        try {
            connectionUtils.getThreadConnection().rollback();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 释放连接
     */
    @After("pt1()")
    public void release() {
        try {
            connectionUtils.getThreadConnection().close();  // 还回连接池中，并没有关闭
            connectionUtils.removeConnection();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

}
