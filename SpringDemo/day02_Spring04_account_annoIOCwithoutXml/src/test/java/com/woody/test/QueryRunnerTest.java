package com.woody.test;

import com.woody.serivce.AccountService;
import config.SpringConfiguration;
import org.apache.commons.dbutils.QueryRunner;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class QueryRunnerTest {
    @Test
    public void queryRunnerTest() {
       ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        QueryRunner queryRunner = applicationContext.getBean("runner", QueryRunner.class);
        QueryRunner queryRunner1 = applicationContext.getBean("runner", QueryRunner.class);

        System.out.println(queryRunner == queryRunner1);
    }
}
