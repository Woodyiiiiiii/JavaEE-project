package com.woody.jdbctemplate;

import com.woody.domain.Account;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * 优化Dao2，初步探索JdbcTemplate
 * JdbcTemplate的最基本用法
 * JdbcTemplate的单表CRUD操作
 */
public class JdbcTemplateDao3 {
    public static void main(String[] args) {
        // 1. 获取资源
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");
        // 2. 获取对象
        JdbcTemplate jdbcTemplate = (JdbcTemplate)applicationContext.getBean("jdbcTemplate");
        // 3. 执行操作(单表)
        // 3.1 保存
        // jdbcTemplate.update("insert into account(name, money) values (?, ?)", "rrr", 333);
        // 3.2 更新
        // jdbcTemplate.update("update account set money = money - ? where id = ?", 99, 8);
        // 3.3 删除
        // jdbcTemplate.update("delete from account where id = ?",8);
        // 3.4 查询所有
        // 3.4.1 自己封装
        // List<Account> accounts = jdbcTemplate.query("select * from account where money > ?",new AccountRowMapper(),999);
        // 3.4.2 Spring封装
//        List<Account> accounts = jdbcTemplate.query("select * from account where money > ?",new BeanPropertyRowMapper<Account>(Account.class),999);
//        for (Account account : accounts) {
//            System.out.println(account);
//        }
        // 3.5 查询一个
//        List<Account> accounts1 = jdbcTemplate.query("select * from account where id = ?",new BeanPropertyRowMapper<Account>(Account.class),1);
//        System.out.println(accounts1.isEmpty() ? "no result" : accounts1.get(0));
        // 3.6 查询返回一行一列(使用聚合函数，但不加group by子句)
        Long count = jdbcTemplate.queryForObject("select count(*) from account where money > ?", Long.class, 1000f);
        System.out.println(count);
    }
}

/**
 * 不用Spring的自定义封装
 * 定义Account的封装策略
 */
class AccountRowMapper implements RowMapper<Account> {
    /**
     * 把结果集中的数据封装到Account中，然后由Spring把每个Account加到集合中
     * @param resultSet
     * @param i
     * @return
     * @throws SQLException
     */
    @Override
    public Account mapRow(ResultSet resultSet, int i) throws SQLException {
        Account account = new Account();
        account.setId(resultSet.getInt("id"));
        account.setName(resultSet.getString("name"));
        account.setMoney(resultSet.getFloat("money"));
        return account;
    }
}
