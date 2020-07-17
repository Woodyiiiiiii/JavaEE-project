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
     * 测试保存操作
     */
    @Test
    public void testSave() {
        User user = new User();
        user.setUserName("测试中文字符2");
        user.setUserAddress("北京市顺义区");
        user.setUserSex("男");
        user.setUserBirthday(new Date());
        System.out.println("保存前:" + user);

        // 5. 使用代理对象执行保存方法
        userDao.saveUser(user);
        System.out.println("保存后:" + user);
    }

    /**
     * 测试更新操作
     */
    @Test
    public void testUpdate() {
        User user = new User();
        user.setUserId(53);
        user.setUserName("mybatis update user");
        user.setUserAddress("北京市顺义区");
        user.setUserSex("女");
        user.setUserBirthday(new Date());

        // 5. 使用代理对象执行保存方法
        userDao.updateUser(user);
    }

    /**
     * 测试删除操作
     */
    @Test
    public void testDelete() {
        // 5. 使用代理对象执行保存方法
        userDao.deleteUser(52);
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
        List<User> users = userDao.findByName("%王%");   // 加上%，否则不能实现模糊查询
//        List<User> users = userDao.findByName("?");
        for (User user : users) {
            System.out.println(user);
        }
    }

    /**
     * 查询总用户数
     */
    @Test
    public void testFindTotal() {
        System.out.println("用户数为：" + userDao.findTotal());
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
}
