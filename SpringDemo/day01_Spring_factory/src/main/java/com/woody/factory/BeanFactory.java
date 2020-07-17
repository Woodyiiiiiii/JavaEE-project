package com.woody.factory;

import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * 工厂模式解耦
 * 目的：
 *      在删除DaoImpl的情况下，不会出现运行时错误，只出现编译期错误
 *
 * 一个创建Bean对象的工厂
 *
 * Bean在计算机英语中，有可重用组件的含义(在公用英语中指豆类)
 * JavaBean：用Java语言编写的可重用组件
 *          JavaBean不等于实体类，JavaBean远大于实体类
 *
 *  它就是创建我们的Service和Dao对象的
 *
 *  1. 需要一个配置文件来配置我们的Service和Dao
 *          配置的内容：唯一标识 = 全限定类名 (key=value)
 *  2. 通过读取配置文件中的内容，反射创建对象
 *
 *  可选用xml或者properties来当配置文件
 */
public class BeanFactory {
    // 定义一个properties对象
    private static Properties properties;

    // 定义一个Map，用于存放我们要创建的对象，我们把它称之为容器
    private static Map<String, Object> beans;

    // 使用静态代码块为Properties对象赋值
    static {
        try {
            // 初始化
            properties = new Properties();
            // 获取Properties文件的流对象
            InputStream inputStream = BeanFactory.class.getClassLoader().getResourceAsStream("bean.properties");
            properties.load(inputStream);
            // 实例化容器
            beans = new HashMap<String, Object>();
            // 取出配置文件中所有的keys
            Enumeration keys =  properties.keys();
            // 遍历枚举
            while (keys.hasMoreElements()) {
                // 取出每个key
                String key = keys.nextElement().toString();
                // 根据key获取value
                String beanPath = properties.getProperty(key);
                // 反射创建对象
                Object value = Class.forName(beanPath).newInstance();
                // 把key和value存入容器之中
                beans.put(key, value);
            }
        }catch (Exception e) {
            throw new ExceptionInInitializerError("程序初始化失败");
        }

    }

    /**
     * 根据bean的名称获取对象
     * 但不同于下一个方法，是单例的
     * @param beanName
     * @return
     */
    public static Object getBean(String beanName) {
        return beans.get(beanName);
    }

//    /**
//     * 根据Bean的名称获取Bean对象
//     * @param beanName
//     * @return
//     */
//    public static Object getBean(String beanName) {
//        Object bean = null;
//        try {
//            String beanPath = properties.getProperty(beanName);
//            bean = Class.forName(beanPath).newInstance();
//        }catch (Exception e) {
//            e.printStackTrace();
//        }
//        return bean;
//    }
}
