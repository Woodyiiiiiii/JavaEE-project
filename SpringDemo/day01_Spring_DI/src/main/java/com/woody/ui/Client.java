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
        // 2.1 使用构造函数提供
        AccountService accountService = (AccountService)applicationContext.getBean("accountService");
        accountService.saveAccount();

        // 2.2 使用set方法提供
        AccountService accountService2 = (AccountService)applicationContext.getBean("accountService2");
        accountService2.saveAccount();

        // 2.3 使用
        AccountService accountService3 = (AccountService)applicationContext.getBean("accountService3");

        accountService3.saveAccount();
    }
}
