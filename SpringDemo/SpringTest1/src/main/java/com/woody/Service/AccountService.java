package com.woody.Service;

import com.woody.domain.Account;

import java.util.List;

/**
 * 账户业务层接口
 */
public interface AccountService {

    public List<Account> findAll();

    public Account findById(Integer id);

    public Account findByName(String name);

    public void updateAccount(Account account);

    public void transfer(String sourceName, String targetName, Float money);
}
