package com.woody.Dao;

import com.woody.domain.Account;

/**
 * 账户的持久层接口
 */
public interface AccountDao {

    /**
     * 根据ID查询账户
     * @param id
     * @return
     */
    Account findAccountById(Integer id);

    /**
     *
     * 根据名称查询账户
     * @param name
     * @return
     */
    Account findAccountByName(String name);

    /**
     * 更新账户
     * @param account
     */
    void updateAccount(Account account);
}
