package com.woody.dao;

import com.woody.domain.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserDao {
    /***
     * 查询所有操作
     * @woody
     */
    @Select("select * from user")
    List<User> findAll();
}

