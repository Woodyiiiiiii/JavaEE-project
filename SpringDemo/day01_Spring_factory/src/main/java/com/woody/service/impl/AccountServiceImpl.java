package com.woody.service.impl;

import com.woody.dao.AccountDao;
import com.woody.dao.impl.AccountDaoImpl;
import com.woody.factory.BeanFactory;
import com.woody.service.AccountService;

/**
 * 业务层实现类
 */
public class AccountServiceImpl implements AccountService {
//    private AccountDao accountDao = new AccountDaoImpl();
    private AccountDao accountDao = (AccountDao) BeanFactory.getBean("accountDao");

    public void saveAccount() {
        int i = 1;
        accountDao.saveAccount();
        System.out.println(i);
        i++;
    }
}
