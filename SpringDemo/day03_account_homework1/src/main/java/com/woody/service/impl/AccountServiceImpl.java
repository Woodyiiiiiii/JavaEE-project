package com.woody.service.impl;

import com.woody.dao.AccountDao;
import com.woody.domain.Account;
import com.woody.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 账户业务层实现类
 *
 * 事务控制应该都是在业务层
 */
@Service("accountService")
public class AccountServiceImpl implements AccountService {

    @Resource(name = "accountDao")
    private AccountDao accountDao;

    public List<Account> findAllAccount() {
        return accountDao.findAllAccount();
    }

    public List<Account> findAccountById(Integer accountId) {
        return accountDao.findAccountById(accountId);
    }

    public void saveAccount(Account account) {
        accountDao.saveAccount(account);
    }

    public void updateAccount(Account account) {
        accountDao.updateAccount(account);
    }

    public void deleteAccount(Integer accountId) {
        accountDao.deleteAccount(accountId);
    }

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

            // test exception
            int i = 5/0;

            // 2.6 更新转入账户
            accountDao.updateAccount(target);
    }
}
