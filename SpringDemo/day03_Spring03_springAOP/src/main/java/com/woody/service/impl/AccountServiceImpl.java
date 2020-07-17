package com.woody.service.impl;

import com.woody.service.AccountService;

/**
 * 账户的业务层实现类
 *
 * 模拟方法的意思是：
 * 分别用无参无返回值函数，有参无返回值，无参有返回值函数
 * 展示如何应用Spring中的AOP
 */
public class AccountServiceImpl implements AccountService {
    public void saveAccount() {
        System.out.println("执行了保存");
    }

    public void updateAccount(int i) {
        System.out.println("执行了更新");
    }

    public int deleteAccount() {
        System.out.println("执行了删除");
        return 0;
    }
}
