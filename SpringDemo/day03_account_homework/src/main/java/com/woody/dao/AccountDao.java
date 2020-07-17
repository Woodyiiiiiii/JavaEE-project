package com.woody.dao;

import com.woody.domain.Account;

import java.util.List;

/**
 * 账户的持久层接口
 */
public interface AccountDao {
    /**
     * 查询所有
     * @return
     */
    List<Account> findAllAccount();

    /**
     * 根据ID查询账户
     * @param accountId
     * @return
     */
    List<Account> findAccountById(Integer accountId);

    /**
     * 保存账户
     * @param account
     */
    void saveAccount(Account account);

    /**
     * 更新账户
     * @param account
     */
    void updateAccount(Account account);

    /**
     * 根据ID删除账户
     * @param accountId
     */
    void deleteAccount(Integer accountId);

    /**
     * 根据名称查询账户
     * @param accountName
     * @return      如果有唯一的结果，就返回；如果没有结果，则返回Null
     *              如果结果集超过一个，就抛出异常
     */
    Account findAccountByName(String accountName);
}
