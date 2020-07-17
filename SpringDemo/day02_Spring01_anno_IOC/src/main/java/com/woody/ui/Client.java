package com.woody.ui;

import com.woody.dao.AccountDao;
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
        // AccountDao accountDao = applicationContext.getBean("accountDao", AccountDao.class);
        // System.out.println(accountDao);

        System.out.println(accountService);

        accountService.saveAccount();

    }
}
