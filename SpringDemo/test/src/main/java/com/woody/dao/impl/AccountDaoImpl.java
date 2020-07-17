package com.woody.dao.impl;

import com.woody.dao.AccountDao;
import com.woody.domain.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("accountDao")
public class AccountDaoImpl implements AccountDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    /**
     * 根据名称查询用户
     * @param name
     * @return
     */
    @Override
    public Account findByName(String name) {
        List<Account> accounts = jdbcTemplate.query("select * from account where name = ?", new BeanPropertyRowMapper<Account>(Account.class), name);
        if (accounts.isEmpty()) {
           return null;
        }
        else if (accounts.size() > 1) {
            throw new RuntimeException("有多个用户名");
        }
        else {
            return accounts.get(0);
        }
    }

    /**
     * 更新用户
     * @param account
     */
    @Override
    public void updateAccount(Account account) {
        jdbcTemplate.update("update account set name = ?, money = ? where id = ?",account.getName(), account.getMoney(), account.getId());
    }
}
