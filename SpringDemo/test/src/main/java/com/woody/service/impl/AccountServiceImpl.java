package com.woody.service.impl;

import com.woody.dao.AccountDao;
import com.woody.domain.Account;
import com.woody.service.AccountService;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * 用户业务层实现类
 */
@Service("accountService")
@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountDao accountDao;

    @Override
    public Account findByName(String name) {
        return accountDao.findByName(name);
    }

    // @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    @Override
    public void updateAccount(Account account) {
        accountDao.updateAccount(account);
    }

    /**
     * 实现转账操作
     * @param sourceName
     * @param targetName
     * @param money
     */
    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void transfer(String sourceName, String targetName, Float money) {
        Account sourceAccount = accountDao.findByName(sourceName);
        Account targetAccount = accountDao.findByName(targetName);
        sourceAccount.setMoney(sourceAccount.getMoney() - money);
        targetAccount.setMoney(targetAccount.getMoney() + money);
        accountDao.updateAccount(sourceAccount);

        // 测试事务是否回滚
         //int i  = 4 / 0;

        accountDao.updateAccount(targetAccount);
    }
}
