package com.woody.service;

import com.woody.domain.Account;

/**
 * 账户的业务层接口
 */
public interface AccountService {

    /**
     * 根据id查询用户ID
     * @param id
     * @return
     */
    Account findAccountById(Integer id);

    /**
     * 转账
     * @param sourceName    转出账户名称
     * @param targetName    转入账户名称
     * @param money         金额
     */
    void transfer(String sourceName, String targetName, Float money);
}
