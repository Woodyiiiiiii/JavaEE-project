package com.woody.service.impl;

import com.woody.service.AccountService;

/**
 * 业务层实现类
 */
public class AccountServiceImpl implements AccountService {

    // 默认构造函数，使得bean对象创建的第一种方式有效
    public AccountServiceImpl() {
        System.out.println("对象创建了");
    }

    /**
     * 此时没有与Dao层联动
     * 如果要调用Dao层，则要靠DI(依赖注入)
     */
    public void saveAccount() {
        System.out.println("service中的saveAccount()方法执行了");
    }

    public void init() {
        System.out.println("对象初始化了");
    }

    public void destroy() {
        System.out.println("对象被销毁了");
    }
}
