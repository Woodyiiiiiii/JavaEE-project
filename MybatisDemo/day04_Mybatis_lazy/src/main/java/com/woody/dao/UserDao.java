package com.woody.dao;

import com.woody.domain.User;

import java.util.List;

public interface UserDao {
    /**
     * 查询所有操作，同时获取到用户下所有账户的信息
     * @return
     */
    List<User> findAll();

    /**
     * 根据ID查询用户
     * @param uid
     * @return
     */
    User findUserById(int uid);
}
