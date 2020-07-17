package com.woody.Dao;

import com.woody.domain.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * 用户Dao层接口
 */
public interface UserDao {

    /**
     * 查询所有
     * @return
     */
    @Select("select * from user")
    List<User> findAll();

    /**
     * 根据ID查询
     * @param id
     * @return
     */
    @Select("select * from user where id = #{uid}")
    User findById(Integer id);

    /**
     * 根据名称查询
     * @param name
     * @return
     */
    @Select("select * from user where username like #{name}")
    List<User> findByName(String name);

    /**
     * 插入用户
     * @param user
     */
    @Insert("insert into user(id, username, birthday, sex, address) values(#{id}, " +
            "#{username}, #{birthday}, #{sex}, #{address})")
    void insertUser(User user);

    /**
     * 根据ID删除用户
     * @param id
     */
    @Delete("delete from user where id = #{id}")
    void deleteUser(Integer id);

    /**
     * 更新用户
     * @param user
     */
    @Update("update user set username = #{username}, birthday = #{birthday}," +
            "sex = #{sex}, address = #{address} where id = #{id}")
    void updateUser(User user);
}
