package com.woody.Dao.Impl;

import com.woody.Dao.AccountDao;
import com.woody.domain.Account;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import java.util.List;

/**
 * 继承JdbcTemplate的Dao
 * 1. extends JdbcDaoSupport
 * 2. getJdbcTemplate()
 */
public class AccountDaoImpl1 extends JdbcDaoSupport implements AccountDao {
    @Override
    public Account findAccountById(Integer id) {
        List<Account> accounts = getJdbcTemplate().query("select * from account where id = ?", new BeanPropertyRowMapper<Account>(Account.class), id);
        return accounts.isEmpty() ? null : accounts.get(0);
    }

    @Override
    public Account findAccountByName(String name) {
        // 注意与以上不同的是name可能不唯一，可能多个，而id唯一
        List<Account> accounts = getJdbcTemplate().query("select * from account where name = ?", new BeanPropertyRowMapper<Account>(Account.class), name);
        if (accounts.isEmpty()) {
            return null;
        }
        else if (accounts.size() > 1) {
            throw new RuntimeException("名字不唯一");
        }
        else {
            return accounts.get(0);
        }
    }

    @Override
    public void updateAccount(Account account) {
        getJdbcTemplate().update("update account set name =  ? , money = ? where id = ?",account.getName(), account.getMoney(), account.getId());
    }
}
