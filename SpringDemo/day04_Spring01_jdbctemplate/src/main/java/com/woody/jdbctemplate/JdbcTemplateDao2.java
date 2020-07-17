package com.woody.jdbctemplate;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 * 优化Dao1，初步探索JdbcTemplate
 * JdbcTemplate的最基本用法
 */
public class JdbcTemplateDao2 {
    public static void main(String[] args) {
        // 1. 获取资源
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");
        // 2. 获取对象
        JdbcTemplate jdbcTemplate = (JdbcTemplate)applicationContext.getBean("jdbcTemplate", JdbcTemplate.class);
        // 3. 执行操作
        jdbcTemplate.execute("insert into account(name, money) values ('ddd', 1000)");

//        // 准备数据源，Spring的内置数据源
//        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
//        driverManagerDataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
//        driverManagerDataSource.setUrl("jdbc:mysql://localhost:3306/springdemo?userUnicode=true" +
//                "&charactorEncoding=utf-8&useSSL=false&serverTimezone=GMT");
//        driverManagerDataSource.setUsername("root");
//        driverManagerDataSource.setPassword("");
//
//        // 1. 创建JdbcTemplate对象
//        JdbcTemplate jdbcTemplate = new JdbcTemplate();
//        // 设置数据源
//        jdbcTemplate.setDataSource(driverManagerDataSource);
//        // 2. 执行操作
//        jdbcTemplate.execute("insert into account(name, money) values ('ccc', 1000)");

    }
}
