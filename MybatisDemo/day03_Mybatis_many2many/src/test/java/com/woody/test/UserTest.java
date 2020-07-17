package com.woody.test;

import com.woody.dao.UserDao;
import com.woody.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

public class UserTest {
    private InputStream inputStream = null;
    private SqlSessionFactory factory = null;
    private SqlSession session = null;
    private UserDao userDao = null;

    @Before // 用于在测试方法执行之前执行
    public void init() throws Exception {
        // 1. 读取配置文件
        inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        // 2. 创建SqlSessionFactory工厂(工厂模式)
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        factory = builder.build(inputStream);
        // 3. 使用工厂生成SqlSession对象
        session = factory.openSession();
        // 4. 使用SqlSession创建Dao接口的代理对象
        userDao = session.getMapper(UserDao.class);
    }

    @After // 用于在测试方法执行之后执行
    public void destroy() throws Exception {
        // 提交事务
        session.commit();
        // 6. 关闭资源
        session.close();
        inputStream.close();
    }

    /**
     * 测试查询所有方法
     * @throws Exception
     */
    @Test
    public void testFindAll() {
        List<User> users = userDao.findAll();
        for (User user : users) {
            System.out.println("-----------------每个用户的信息---------------------");
            System.out.println(user);
            System.out.println(user.getRoles());
        }
    }

}
