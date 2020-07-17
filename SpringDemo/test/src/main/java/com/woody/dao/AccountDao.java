package com.woody.dao;

import com.woody.domain.Account;
import org.springframework.stereotype.Repository;

/**
 * 持久层接口
 */
public interface AccountDao {

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
}
