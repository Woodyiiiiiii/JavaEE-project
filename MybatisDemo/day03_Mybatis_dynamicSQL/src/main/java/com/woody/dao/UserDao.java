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
     * 根据queryvo中的条件查询用户
     * @param vo
     * @return
     */
    List<User> findUserByVo(QueryVo vo);

    /**
     * 根据传入参数条件
     * @param user 查询的条件，有可能有用户名，
     *             有可能有性别，有可能有地址，还有可能都有
     * @return
     */
    List<User> findUserByCondition(User user);

    /**
     * 根据Query VO中提供的id集合，查询用户信息
     * @param vo
     * @return
     */
    List<User> findUserInIds(QueryVo vo);
}
