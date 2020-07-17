package com.woody.ui;

import com.woody.dao.AccountDao;
import com.woody.service.AccountService;
import com.woody.service.impl.AccountServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * 模拟表现层，用来调用业务层
 * 实际开发中应该为Servlet
 */
public class Client {

    /**
     * 获取Spring容器的IOC核心容器，并根据ID获取对象
     *
     * ApplicationContext的三个实现类：    单例对象适用      开发中更多采用此接口
     *      1. ClassPathXmlApplication:可以加载类路径下的配置文件，要求配置文件必须在类路径下，如果不在，则加载不了(开发中比2更常用)
     *      2. FileSystemXmlApplication:可以加载磁盘任意路径下的配置文件(必须有访问权限)，技巧：在Idea左边目录下右键点击copy path选项，选择Absolute path
     *      3. AnnotationConfigApplication:用于读取注解创建容器的，是第二天的内容
     *
     * 核心容器的两个接口引发出的问题：
     * 1. ApplicationContext:   多例对象适用
     *      它在构建核心容器时，创建对象采取的策略是立即加载的方式，换句话说，只要一读取文件(bean.xml)就马上创建配置文件中配置的对象
     * 2. BeanFactory:
     *      它在构建核心容器时，创建对象采取的策略是延迟加载的方式，换句话说，什么时候根据ID获取对象了，什么时候才真正创建对象
     *
     * 两种方法都没有类成员产生，所以没有线程安全；
     *
     * @param args
     */
    public static void main(String[] args) {
        // 1. 获取核心容器对象
        // ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml"); 相对路径
        ApplicationContext applicationContext = new FileSystemXmlApplicationContext("D:\\\\someDemo\\\\SpringDemo\\\\day01_Spring_Spring1\\\\src\\\\main\\\\resources\\\\bean.xml");
        // 2. 根据ID获取bean对象
        //      2.1 可以强转
        //      2.2 可以传class字节码，则不需要强转
        AccountService accountService = (AccountService)applicationContext.getBean("accountService");
        AccountDao accountDao = applicationContext.getBean("accountDao", AccountDao.class);

        System.out.println(accountService);
        System.out.println(accountDao);
        // 明明生成了对象，为什么不能调用方法?
        // 因为之间的依赖关系没有实现，即要依靠接下来的DI。
        accountService.saveAccount();
    }
}
