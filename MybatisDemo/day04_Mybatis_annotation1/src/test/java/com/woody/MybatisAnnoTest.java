package com.woody;

import com.woody.dao.UserDao;
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
import java.util.Date;
import java.util.List;

public class MybatisAnnoTest {
    /**
     * 测试基于注解的Mybatis使用
     */

    private InputStream inputStream = null;
    private SqlSessionFactory sqlSessionFactory = null;
    private SqlSession sqlSession = null;
    private UserDao userDao = null;

    @Before
    public void init() throws IOException {
        inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        sqlSession = sqlSessionFactory.openSession();
        userDao = sqlSession.getMapper(UserDao.class);
    }

    /**
     * 查询所有
     */
    @Test
    public void testFindAll() {
        List<User> users = userDao.findAll();
        for (User user : users) {
            System.out.println(user);
        }
    }

    /**
     * 增加操作
     */
    @Test
    public void testSaveUser() {
        User user = new User();
        user.setSex("m");
        user.setAddress("Shenzhen");
        user.setUsername("Hui");

        userDao.saveUser(user);
    }

    /**
     * 更新操作
     */
    @Test
    public void testUpdateUser() {
        User user = new User();
        user.setId(52);
        user.setSex("m");
        user.setAddress("1w1231");
        user.setUsername("DuMing");

        userDao.updateUser(user);
    }

    /**
     * 删除操作
     */
    @Test
    public void testDeleteUser() {
        userDao.deleteUser(52);
    }

    /**
     * 根据ID查询用户
     */
    @Test
    public void testFindById() {
        User user = userDao.findById(41);
        System.out.println(user);
    }

    /**
     * 根据用户名模糊查询用户
     * 注意%%号，要么在注解中写，要么在测试中写
     */
    @Test
    public void testFindByName() {
        // List<User> users = userDao.findByName("%?%");
        List<User> users = userDao.findByName("?");
        for (User user : users) {
            System.out.println(user);
        }
    }

    /**
     * 查询用户总数
     */
    @Test
    public void testFindTotal() {
        System.out.println(userDao.findTotal());
    }

    @After
    public void destroy() throws IOException {
        sqlSession.commit();
        sqlSession.close();
        inputStream.close();
    }
}
