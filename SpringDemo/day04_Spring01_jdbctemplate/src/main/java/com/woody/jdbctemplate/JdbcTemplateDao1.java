package com.woody.jdbctemplate;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.sql.DriverManager;

/**
 * JdbcTemplate的最基本用法
 * 首先是没有使用JdbcTemplate的情况
 */
public class JdbcTemplateDao1 {
    public static void main(String[] args) {
        // 准备数据源，Spring的内置数据源
        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
        driverManagerDataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        driverManagerDataSource.setUrl("jdbc:mysql://localhost:3306/springdemo?userUnicode=true" +
                "&charactorEncoding=utf-8&useSSL=false&serverTimezone=GMT");
        driverManagerDataSource.setUsername("root");
        driverManagerDataSource.setPassword("");

        // 1. 创建JdbcTemplate对象
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        // 设置数据源
        jdbcTemplate.setDataSource(driverManagerDataSource);
        // 2. 执行操作
        jdbcTemplate.execute("insert into account(name, money) values ('ccc', 1000)");

    }
}
