package com.woody.config;

import org.springframework.context.annotation.*;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Spring配置类
 */
@Configuration
@ComponentScan("com.woody")
@Import({JdbcConfig.class, TxManager.class})
@PropertySource(value = "jdbcPro.properties")
@EnableTransactionManagement
public class SpringConfig {

}
