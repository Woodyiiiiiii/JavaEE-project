package com.woody.Service.impl;

import com.woody.Dao.AccountDao;
import com.woody.Service.AccountService;
import com.woody.domain.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 账户业务层实现类
 */
@Service("accountService")
@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountDao accountDao;

    public List<Account> findAll() {
        return accountDao.findAll();
    }

    public Account findById(Integer id) {
        return accountDao.findById(id);
    }

    public Account findByName(String name) {
        return accountDao.findByName(name);
    }

    @Override
    public void updateAccount(Account account) {
        accountDao.updateAccount(account);
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void transfer(String sourceName, String targetName, Float money) {
        // 2. 执行操作
        // 2.1 根据名称查询转出账户
        Account source = accountDao.findByName(sourceName);
        // 2.2 根据名称查询转入账户
        Account target = accountDao.findByName(targetName);
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
