package com.woody.dao;

import com.woody.domain.User;

import java.util.List;

/**
 * Dao层接口
 */
public interface UserDao {

    /**
     * 查询所有方法
     * @return
     */
    List<User> findAll();
}
