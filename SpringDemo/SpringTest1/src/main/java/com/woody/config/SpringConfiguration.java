package com.woody.config;

import org.springframework.context.annotation.*;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Spring配置类
 * 相当于XML
 */
@Configuration
@ComponentScan(basePackages = "com.woody")
@PropertySource(value = "jdbcConfig.properties")
@Import({JdbcConfig.class, TransactionManager.class})
@EnableTransactionManagement
@EnableAspectJAutoProxy
public class SpringConfiguration {

}
