package com.woody;

import com.woody.dao.AccountDao;
import com.woody.dao.UserDao;
import com.woody.domain.Account;
import com.woody.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class AccountTest {
    /**
     * 测试基于注解的Mybatis使用
     */

    private InputStream inputStream = null;
    private SqlSessionFactory sqlSessionFactory = null;
    private SqlSession sqlSession = null;
    private AccountDao accountDao = null;

    @Before
    public void init() throws IOException {
        inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        sqlSession = sqlSessionFactory.openSession();
        accountDao = sqlSession.getMapper(AccountDao.class);
    }

    /**
     * 查询所有
     */
    @Test
    public void testFindAll() {
        List<Account> accounts = accountDao.findAll();
        for (Account account : accounts) {
            System.out.println("-------------每个账户的信息---------------");
            System.out.println(account);
            System.out.println(account.getUser());
        }
    }

    /**
     * 根据用户ID查询账户信息
     */
    @Test
    public void testFindAccountByUid() {
        List<Account> accounts = accountDao.findAccountByUid(41);
        for (Account account : accounts) {
            System.out.println("-------------每个账户的信息---------------");
            System.out.println(account);
            System.out.println(account.getUser());
        }
    }


    @After
    public void destroy() throws IOException {
        sqlSession.commit();
        sqlSession.close();
        inputStream.close();
    }
}
