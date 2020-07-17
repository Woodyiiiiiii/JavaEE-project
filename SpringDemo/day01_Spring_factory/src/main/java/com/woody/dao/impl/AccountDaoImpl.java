package com.woody.dao.impl;

import com.woody.dao.AccountDao;

/**
 * 账户的持久层实现类
 */
public class AccountDaoImpl implements AccountDao {
    public void saveAccount() {
        System.out.println("The account is saved.");
    }
}
