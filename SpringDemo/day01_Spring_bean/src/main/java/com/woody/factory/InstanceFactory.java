package com.woody.factory;

import com.woody.service.AccountService;
import com.woody.service.impl.AccountServiceImpl;

/**
 * 模拟一个工厂类(该类可能是存在于jar包中，我们无法通过修改源码的方式来提供默认构造函数)
 * 于是利用第二种创建bean对象的方法
 */
public class InstanceFactory {

    // new是模拟用的
    public AccountService getAccountService() {
        return new AccountServiceImpl();
    }
}
