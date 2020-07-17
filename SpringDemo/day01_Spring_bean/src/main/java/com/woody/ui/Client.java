package com.woody.ui;

import com.woody.service.AccountService;
import com.woody.service.impl.AccountServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * 模拟表现层，用来调用业务层
 * 实际开发中应该为Servlet
 */
public class Client {
    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        // 1. 获取核心容器对象
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");
        // 2. 根据ID获取bean对象
        AccountService accountService = (AccountService)applicationContext.getBean("accountService");

        accountService.saveAccount();

        /**
         * 证明了bean默认创建时是单例的
         */
//        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");
//        AccountService ac1 = applicationContext.getBean("accountService", AccountService.class);
//        AccountService ac2 = applicationContext.getBean("accountService", AccountService.class);
//        System.out.println(ac1 == ac2);
    }
}
