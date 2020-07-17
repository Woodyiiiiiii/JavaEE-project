package com.woody;

import com.woody.Service.AccountService;
import com.woody.config.SpringConfiguration;
import com.woody.domain.Account;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * 使用Junit进行测试
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfiguration.class)
public class ServiceTester {

    @Autowired
    AccountService accountService;

    @Test
    public void testFindAll() {
        List<Account> accounts = accountService.findAll();
        for (Account account : accounts) {
            System.out.println(account);
        }
    }

    @Test
    public void testFindById() {
        System.out.println(accountService.findById(2));
    }

    @Test
    public void testFindByName() {
        System.out.println(accountService.findByName("bbb"));
    }

    @Test
    public void testTransfer() {
        accountService.transfer("aaa","bbb",200f);
    }
}
