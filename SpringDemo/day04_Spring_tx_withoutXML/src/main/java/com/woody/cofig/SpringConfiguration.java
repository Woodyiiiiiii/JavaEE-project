package com.woody.cofig;

import org.springframework.context.annotation.*;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Spring的配置类，相当于bean.xml文件
 */
@Configuration
@ComponentScan("com.woody")
@Import({JdbcConfig.class, TransactionConfig.class})
@PropertySource(value = "jdbcConfig.properties")
@EnableTransactionManagement

public class SpringConfiguration {

}
