package com.woody.dao;

import com.woody.domain.User;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

/**
 * 在Mybatis中针对CRUD有四个注解
 * : @Select @Insert @Delete @Update
 */

public interface UserDao {
    /**
     * 查询所有用户及相应的账户信息
     * @return
     */
    @Select(value = "select * from user")
    @Results(id = "userMap",
            value={
                @Result(id = true, column = "id", property = "userId"),
            @Result(column = "username", property = "userName"),
            @Result(column = "address", property = "userAddress"),
            @Result(column = "sex", property = "userSex"),
            @Result(column = "birthday", property = "userBirthday"),
                    // 注意：是accounts，不是account，property对应的是实体类属性名字，不是属性
                @Result(property = "accounts", column = "id",
                            many = @Many(select = "com.woody.dao.AccountDao.findAccountByUid",
                                    fetchType = FetchType.LAZY))
            }
    )
    List<User> findAll();

    /**
     * 根据ID查询用户
     * @param id
     * @return
     */
    @Select("select * from user where id=#{id}")
    @ResultMap(value = "userMap") // value可省略
    User findById(Integer id);

    /**
     * 根据用户名称模糊查询
     * @param username
     * @return
     */
    @Select("select * from user where username like #{username}")
    @ResultMap("userMap")
    List<User> findByName(String username);
}
