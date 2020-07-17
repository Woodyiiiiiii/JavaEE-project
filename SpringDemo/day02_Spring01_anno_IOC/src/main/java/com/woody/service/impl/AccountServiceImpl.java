package com.woody.service.impl;

import com.woody.dao.AccountDao;
import com.woody.service.AccountService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 业务层实现类
 *
 * 曾经XML的配置：
 * <bean id = "accountService" class = "com.woody.service.impl.AccountServiceImpl"
 *      scope = "", init-method = "", destroy-method = "",
 *      <property name = "" value = "" | ref = ""></property>
 * ></bean>
 *
 * 用于创建对象的注解：
 *      他们的作用就跟在XML配置文件中编写一个<bean></bean>标签实现的功能是一样的。
 *          Component：
 *              作用：用于把当前类对象存入Spring容器中
 *              属性：
 *                  value：用于指定当前bean的ID。当我们不写时，它的默认值是当前类名，且首字母为小写
 *          Controller：一般用在表现层
 *          Service：一般用在业务层
 *          Repository:一般用于持久层
 *          以上三个注解的作用和属性都与Component一模一样的。
 *          他们三个是Spring框架为我们提供明确的三层使用的注解，使我们的三层对象更加清晰
 *          创建对象后，仍不能调用方法。要配置下面注入数据的注解。
 *
 * 用于注入数据的注解：
 *      他们的作用就跟在XML配置文件中编写一个<property></property>标签实现的功能是一样的。
 *          Autowired：
 *              作用：自动按照类型注入，只要容器中有唯一的一个bean类型对象和注入的类型匹配，就可以注入成功。
 *              出现位置：可以是变量上，也可以是方法上
 *              细节：在使用注解方法时，set方式不是必须的
 *                  如果IOC容器中没有任何bean的类型和要注入的变量匹配，则报错
 *                  如果ICO容器中有两个以上的bean类型匹配时，就会接着匹配变量名
 *          Qualifier：
 *              作用：在按照类中注入的基础之上再按照名称注入，它在给类成员注入时不能单独使用，要和Autowired配合使用，但是在给方法参数注入时可以
 *              属性：
 *                  value：用于指定注入bean的ID
 *          Resource：
 *              作用：直接按照bean的ID注入，它可以独立使用
 *              属性：
 *                  name：用于指定bean的ID
 *              注意：要在pom.xml中导入 <artifactId>javax.annotation-api</artifactId>，并且在bean.xml中配置<context:annotation-config></context:annotation-config>
 *          以上三个注入只能注入bean类型的数据，而基本类型和String类型无法使用上述注解实现。
 *          另外集合类型的注入只能通过xml来实现
 *
 *          Value：
 *              作用：用于注入基本类型和String类型的数据
 *              属性：
 *                  value：用于指定数据的值，它可以使用Spring中SqEl(EL表达式)
 *                      SqEL的写法：${}
 * 用于改变作用范围的注解：
 *      他们的作用就跟在XML配置文件中编写一个<scope></scope>标签实现的功能是一样的。
 *      Scope：
 *          作用：用于指定bean的作用范围
 *          属性：
 *              value：指定范围的取值，常用取值：singleton, prototype，默认为单例
 * 和生命周期相关的注解(了解)：
 *      他们的作用就跟在XML配置文件中编写一个<init-method></init-method><destroy-method></destroy-method>标签实现的功能是一样的。
 *      PreDestroy：
 *          作用：用于指定销毁方法
 *      PostConstruct：
 *          作用：用于指定初始化方法
 */
@Service(value = "accountService")
public class AccountServiceImpl implements AccountService {
//    @Autowired
//    @Qualifier(value = "accountDao1") 等价于
    @Resource(name = "accountDao2")
    private AccountDao accountDao = null;

    // test @value
    @Value("fuck")
    private String string;

    public void saveAccount() {
        System.out.println(string);
        accountDao.saveAccount();
    }
}
