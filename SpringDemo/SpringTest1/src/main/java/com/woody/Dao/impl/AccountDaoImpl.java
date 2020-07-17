package com.woody.Dao.impl;

import com.woody.Dao.AccountDao;
import com.woody.domain.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository("accountDao")
public class AccountDaoImpl implements AccountDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;


    /**
     * 查询所有
     * @return
     */
    public List<Account> findAll() {
        return jdbcTemplate.query("select * from account",new BeanPropertyRowMapper<Account>(Account.class));
    }

    /**
     * 根据ID查询
     * @param id
     * @return
     */
    public Account findById(Integer id) {
        List<Account> accounts = jdbcTemplate.query("select * from account where id = ?",new BeanPropertyRowMapper<Account>(Account.class),id);
        if (accounts.isEmpty()) {
            throw new RuntimeException("无ID");
        }
        else if (accounts.size() > 1) {
            throw new RuntimeException("ID多于1个");
        }
        else {
            return accounts.get(0);
        }
    }

    /**
     * 根据名称查询
     * @param name
     * @return
     */
    @Override
    public Account findByName(String name) {
        List<Account> accounts = jdbcTemplate.query("select * from account where name = ?",new BeanPropertyRowMapper<Account>(Account.class),name);
        if (accounts.isEmpty()) {
            throw new RuntimeException("无该name");
        }
        else if (accounts.size() > 1) {
            throw new RuntimeException("name多于1个");
        }
        else {
            return accounts.get(0);
        }
    }

    /**
     * 更新账户
     * @param account
     */
    @Override
    public void updateAccount(Account account) {
        jdbcTemplate.update("update account set name = ?, money = ? where id = ?",
                account.getName(), account.getMoney(), account.getId());
    }
}
