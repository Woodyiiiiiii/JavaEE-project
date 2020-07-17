package com.woody.test;

import com.woody.service.AccountService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Spring测试
 */
public class TestSpring {

    @Test
    public void run() {
        // 加载配置文件
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        // 获取对象
        AccountService accountService = (AccountService)applicationContext.getBean("accountService");
        // 调用方法
        accountService.findAll();
    }
}
