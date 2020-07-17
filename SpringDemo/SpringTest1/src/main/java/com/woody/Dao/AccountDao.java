package com.woody.Dao;

import com.woody.domain.Account;

import java.util.List;

/**
 * 账户持久层接口
 */
public interface AccountDao {

    /**
     * 查询所有
     * @return
     */
    public List<Account> findAll();

    /**
     * 根据用户ID查找用户
     * @param id
     * @return
     */
    public Account findById(Integer id);

    /**
     * 根据用户名字查找用户
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
