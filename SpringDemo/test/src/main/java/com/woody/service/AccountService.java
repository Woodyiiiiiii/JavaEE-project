package com.woody.service;

import com.woody.domain.Account;
import org.springframework.stereotype.Service;

/**
 * 用户业务层接口
 */
public interface AccountService {

    /**
     * 根据名字查询
     * @param name
     * @return
     */
    public Account findByName(String name);

    /**
     * 更新账户
     * @param account
     */
    public void updateAccount(Account account);

    /**
     * 转账操作
     * @param sourceName
     * @param targetName
     * @param money
     */
    public void transfer(String sourceName, String targetName, Float money);
}
