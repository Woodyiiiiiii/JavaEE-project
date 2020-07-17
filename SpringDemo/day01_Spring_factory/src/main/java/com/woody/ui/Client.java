package com.woody.ui;

import com.woody.factory.BeanFactory;
import com.woody.service.AccountService;
import com.woody.service.impl.AccountServiceImpl;

/**
 * 模拟表现层，用来调用业务层
 * 实际开发中应该为Servlet
 */
public class Client {
    public static void main(String[] args) {
        // AccountService accountService = new AccountServiceImpl();
        for (int i = 0; i < 5; ++i) {
            AccountService accountService = (AccountService) BeanFactory.getBean("accountService");
            System.out.println(accountService);
        }
        // accountService.saveAccount();
    }
}
