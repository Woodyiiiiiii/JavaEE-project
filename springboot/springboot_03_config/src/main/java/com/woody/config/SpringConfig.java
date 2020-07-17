package com.woody.config;

import com.woody.service.HelloService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Spring配置类
 * 类似于beans.xml
 */
@Configuration
public class SpringConfig {

    @Bean(name = "helloService")
    public HelloService rtHelloService() {
        System.out.println("加载HelloService进入Beans...");
        return new HelloService();
    }
}
