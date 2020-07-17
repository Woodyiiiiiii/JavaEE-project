package com.woody.service.impl;

import com.woody.Dao.AccountDao;
import com.woody.domain.Account;
import com.woody.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * 账户业务层实现类
 *
 * 事务控制应该都是在业务层
 */
@Service("accountService")
@Transactional(readOnly = true , propagation = Propagation.SUPPORTS) // 这里开启Spring对事务注解的支持，是对所有方法的
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountDao accountDao;

    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    @Override
    public Account findAccountById(Integer accountId) {
        return accountDao.findAccountById(accountId);
    }

    // 开启对某一个方法的事务AOP注解
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void transfer(String sourceName, String targetName, Float money) {
            // 2. 执行操作
            // 2.1 根据名称查询转出账户
            Account source = accountDao.findAccountByName(sourceName);
            // 2.2 根据名称查询转入账户
            Account target = accountDao.findAccountByName(targetName);
            // 2.3 转出账户减钱
            source.setMoney(source.getMoney() - money);
            // 2.4 转入账户加钱
            target.setMoney(target.getMoney() + money);
            // 2.5 更新转出账户
            accountDao.updateAccount(source);

            int i = 5/0;

            // 2.6 更新转入账户
            accountDao.updateAccount(target);
    }
}
