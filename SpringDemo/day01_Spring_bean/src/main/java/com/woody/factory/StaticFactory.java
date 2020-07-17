package com.woody.factory;

import com.woody.service.AccountService;
import com.woody.service.impl.AccountServiceImpl;

public class StaticFactory {
    public static AccountService getAccountService() {
        // 第三种方式，使用静态方式创建对象
        // new是模拟用的
        return new AccountServiceImpl();
    }
}
