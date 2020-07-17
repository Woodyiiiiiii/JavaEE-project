package com.woody.test;

import com.woody.service.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 使用Junit单元测试
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:bean.xml")
public class ServiceTest {

    @Autowired
    @Qualifier(value = "proxyAccountService")
    private AccountService accountService = null;

    @Test
    public void testTransfer() {
        accountService.transfer("aaa", "bbb",100f);
    }
}
