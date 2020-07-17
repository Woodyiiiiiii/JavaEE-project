package com.woody.test;

import com.woody.domain.Account;
import com.woody.serivce.AccountService;
import config.SpringConfiguration;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * 使用Junit单元测试
 *
 * 使用Spring来整合junit进行配置
 *      1. 在pom.xml中导入Spring整合junit的jar(坐标)——spring-test
 *      2. 使用junit提供的一个注解把原有的main方法替换成Spring提供的
 *          Runwith
 *      3. 告知Spring运行器，Spring的IOC创建是基于xml还是注解的，并说明位置
 *          ContextConfiguration
 *              locations：指定xml文件的位置，加上classpath关键字，表示在类路径下
 *              classes：指定注解类所在的位置
 *  当我们使用Spring 5.x版本的时候，要求Junit的jar包必须是4.12及以上。可以在自己计算机的Maven下载位置下查看
 *  如果不是4.12以上，在测试方法时报错是看不到的，可在类名中运行测试(点击类名开始测试)，再查看报错信息可知道错误。
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfiguration.class)
public class ServiceTest {

    @Autowired
    private AccountService accountService = null;

    @Test
    public void testFindAll() {
        // 执行方法
        List<Account> accounts = accountService.findAllAccount();
        for (Account account : accounts) {
            System.out.println(account);
        }
    }

    @Test
    public void testFindOne() {
        // 执行方法
        List<Account> accounts = accountService.findAccountById(1);
        for (Account account : accounts) {
            System.out.println(account);
        }
    }

    @Test
    public void testSave() {
        Account account = new Account();
        account.setName("xuztaolaji");
        Float theMoney = 4000.00f;
        account.setMoney(theMoney);

        accountService.saveAccount(account);
    }

    @Test
    public void testUpdate() {
        Account account = new Account();
        account.setId(4);
        account.setName("woody1232");
        Float theMoney = 7000.00f;
        account.setMoney(theMoney);

        accountService.updateAccount(account);
    }

    @Test
    public void testDelete() {
        accountService.deleteAccount(4);
    }
}
