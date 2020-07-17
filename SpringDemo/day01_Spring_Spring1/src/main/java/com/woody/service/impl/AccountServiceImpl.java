package com.woody.service.impl;

import com.woody.dao.AccountDao;
import com.woody.dao.impl.AccountDaoImpl;
import com.woody.service.AccountService;

/**
 * 业务层实现类
 */
public class AccountServiceImpl implements AccountService {
    private AccountDao accountDao = null;
    //private AccountDao accountDao = (AccountDao) BeanFactory.getBean("accountDao");

    public void saveAccount() {
        accountDao.saveAccount();
    }
}
