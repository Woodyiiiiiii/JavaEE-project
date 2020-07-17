package com.itheima.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * Spring的配置类
 */
@Configuration
@ComponentScan("com.itheima")
@EnableAspectJAutoProxy

public class SpringConfig {
}
