package com.woody.dao;

import com.woody.domain.QueryVo;
import com.woody.domain.User;

import java.util.List;

public interface UserDao {
    /**
     * 查询所有操作
     */
    List<User> findAll();

    /**
     * 保存用户(增)
     * @param user
     */
    void saveUser(User user);

    /**
     * 更新用户
     * @param user
     */
    void updateUser(User user);

    /**
     * 根据ID删除用户
     * @param userId
     */
    void deleteUser(Integer userId);

    /**
     * 根据ID查询用户
     * @param userId
     * @return
     */
    User findById(Integer userId);

    /**
     * 根据名称模糊查询
     * @param userName
     * @return
     */
    List<User> findByName(String userName);

    /**
     * 查询用户数
     * @return
     */
    int findTotal();

    /**
     * 根据queryvo中的条件查询用户
     * @param vo
     * @return
     */
    List<User> findUserByVo(QueryVo vo);
}
