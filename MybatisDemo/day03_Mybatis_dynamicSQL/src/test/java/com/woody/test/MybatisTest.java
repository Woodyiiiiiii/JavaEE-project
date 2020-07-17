package com.woody.test;

import com.woody.dao.UserDao;
import com.woody.domain.QueryVo;
import com.woody.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MybatisTest {

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
        // 5. 使用代理对象执行方法
        List<User> users = userDao.findAll();
        for (User user : users) {
            System.out.println(user);
        }
    }

    /**
     * 测试根据ID查询操作
     */
    @Test
    public void testFindById() {
        // 5. 使用代理对象执行保存方法
        User user = userDao.findById(41);
        System.out.println(user);
    }

    /**
     * 测试根据用户名模糊查询操作
     * 在测试方法上加上%进行模糊查询
     */
    @Test
    public void testFindByName() {
        // 5. 使用代理对象执行保存方法
        List<User> users = userDao.findByName("%王%");
//        List<User> users = userDao.findByName("?");
        for (User user : users) {
            System.out.println(user);
        }
    }

    /**
     * 测试使用QueryVO作为模糊查询条件
     */
    @Test
    public void testFindByVo() {
        QueryVo vo = new QueryVo();
        User user = new User();
        user.setUserName("%王%");
        vo.setUser(user);
        // 5. 使用代理对象执行保存方法
        List<User> users = userDao.findUserByVo(vo);
        for (User user1 : users) {
            System.out.println(user1);
        }
    }

    /**
     * 测试根据条件查询
     * 使用动态SQL语句
     */
    @Test
    public void testFindByCondition() {
        User u = new User();
        u.setUserName("王");
        u.setUserSex("女");

        List<User> users = userDao.findUserByCondition(u);
        for (User user : users) {
            System.out.println(user);
        }
    }

    /**
     * 测试foreach标签的使用
     */
    @Test
    public void testFindInIds() {
        QueryVo vo = new QueryVo();
        List<Integer> list = new ArrayList<>();
        list.add(41);
        list.add(42);
        list.add(46);
        vo.setId(list);

        List<User> users = userDao.findUserInIds(vo);
        for (User user : users) {
            System.out.println(user);
        }
    }
}
