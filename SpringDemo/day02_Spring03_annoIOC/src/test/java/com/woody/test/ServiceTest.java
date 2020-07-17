package com.woody.test;

import com.woody.domain.Account;
import com.woody.serivce.AccountService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * 使用Junit单元测试
 */
public class ServiceTest {

    private ApplicationContext applicationContext = null;
    private AccountService accountService = null;

    @Before
    public void init() {
        applicationContext = new ClassPathXmlApplicationContext("bean.xml");
        accountService = applicationContext.getBean("accountService", AccountService.class);
    }
    @Test
    public void testFindAll() {
        // 执行方法
        List<Account> accounts = accountService.findAllAccount();
        for (Account account : accounts) {
            System.out.println(account);
        }
    }

    @Test
    public void testFindOne() {
        // 执行方法
        List<Account> accounts = accountService.findAccountById(1);
        for (Account account : accounts) {
            System.out.println(account);
        }
    }

    @Test
    public void testSave() {
        Account account = new Account();
        account.setName("woody");
        Float theMoney = 4000.00f;
        account.setMoney(theMoney);

        accountService.saveAccount(account);
    }

    @Test
    public void testUpdate() {
        Account account = new Account();
        account.setId(4);
        account.setName("woody1232");
        Float theMoney = 7000.00f;
        account.setMoney(theMoney);

        accountService.updateAccount(account);
    }

    @Test
    public void testDelete() {
        accountService.deleteAccount(4);
    }
}
