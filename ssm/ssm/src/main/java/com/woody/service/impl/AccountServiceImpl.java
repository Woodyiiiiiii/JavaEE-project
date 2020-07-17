package com.woody.service.impl;

import com.woody.dao.AccountDao;
import com.woody.domain.Account;
import com.woody.service.AccountService;
import org.junit.After;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 账户业务层实现类
 */
@Service("accountService")
public class AccountServiceImpl implements AccountService {

    @Qualifier("accountDao")
    @Autowired
    private AccountDao accountDao;

    @Override
    public List<Account> findAll() {
        // System.out.println("findAll");
        return accountDao.findAll();
    }

    @Override
    public void saveAccount(Account account) {
        // System.out.println("saveAccount");
        accountDao.saveAccount(account);
    }
}
