package com.woody.test;

import com.woody.domain.Account;
import com.woody.serivce.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * 使用Junit单元测试
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:bean.xml")
public class ServiceTest {

    @Autowired
    private AccountService accountService = null;

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
        accountService.deleteAccount(5);
    }
}
