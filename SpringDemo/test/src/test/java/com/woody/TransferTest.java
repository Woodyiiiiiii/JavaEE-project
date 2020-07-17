package com.woody;

import com.woody.config.SpringConfig;
import com.woody.domain.Account;
import com.woody.service.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 测试类
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {SpringConfig.class})
public class TransferTest {

    @Autowired
    private AccountService accountService;

    @Test
    public void testFindByName() {
        System.out.println(accountService.findByName("aaa"));
    }

    @Test
    public void testUpdate() {
        Account account = new Account();
        account.setId(1);
        account.setName("aaa1");
        account.setMoney(1000f);
        accountService.updateAccount(account);
    }

    @Test
    public void testTransfer() {
        accountService.transfer("aaa1","bbb",200f);
    }
}
