package com.woody;

import com.woody.bean.Person;
import com.woody.service.HelloService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

/**
 * SpringBoot单元测试
 * 可以在测试期间很方便地类似编码一样进行自动注入等容器的功能
 */
@SpringBootTest
class Springboot03ConfigApplicationTests {

    @Autowired
    Person person;

    @Autowired
    ApplicationContext ioc;

    @Test
    void contextLoads() {
        System.out.println(person);
    }

    /**
     * 测试Spring容器中有没有HelloService对象
     */
    @Test
    void testHelloService() {
        boolean isContain = ioc.containsBean("helloService");
        System.out.println(isContain);
    }

}
