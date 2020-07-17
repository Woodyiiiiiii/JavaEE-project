package com.woody.jdbctemplate;

import com.woody.Dao.AccountDao;
import com.woody.domain.Account;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * JdbcTemplate的最基本用法
 * 使用Dao的JdbcTemplate
 */
public class JdbcTemplateDao4 {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");
        AccountDao accountDao = (AccountDao)applicationContext.getBean("accountDao1");
        // System.out.println(accountDao.findAccountById(1));
        // System.out.println(accountDao.findAccountByName("ccc"));
        Account account = new Account();
        account.setId(2);
        account.setName("setfdt");
        account.setMoney(299f);
        accountDao.updateAccount(account);
    }
}
