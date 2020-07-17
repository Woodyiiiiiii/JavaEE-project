package com.woody.dao.impl;

import com.woody.dao.AccountDao;
import org.springframework.stereotype.Repository;

/**
 * 账户的持久层实现类
 */
@Repository(value = "accountDao2")
public class AccountDaoImpl2 implements AccountDao {
    public void saveAccount() {
        System.out.println("The account is saved.22222222222222222");
    }
}
