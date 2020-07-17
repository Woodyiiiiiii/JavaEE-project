package com.woody.serivce;

import com.woody.domain.Account;

import java.util.List;

/**
 * 账户业务层接口
 */
public interface AccountService {
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
}
