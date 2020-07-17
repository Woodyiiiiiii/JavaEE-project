package com.woody.dao;

import com.woody.domain.Account;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

public interface AccountDao {
    /**
     * 查询所有账户，并且获取每个账户所属的用户信息
     * @return
     */
    @Select("select * from account a, user u")
    @Results(id = "accountMap",
            value = {
                    @Result(id = true, column = "id", property = "id"),
                    @Result(column = "uid", property = "uid"),
                    @Result(column = "money", property = "money"),
                    // ! 封装User的属性
                    // 根据ID链接！select中写全限定方法名
                    // fetchType可选择三种
                    // 1. EAGER 立即加载 2. LAZY 延迟加载 3.DEFAULT 默认
                    // 这里是一对一，所以用EAGER立即加载
                    @Result(property = "user", column = "uid", one = @One(select = "com.woody.dao.UserDao.findById", fetchType = FetchType.EAGER))
            }
    )
    List<Account> findAll();

    /**
     * 根据用户ID查询账户信息
     * @param userId
     * @return
     */
    @Select("select * from account where uid = #{userId}")
    List<Account> findAccountByUid(Integer userId);
}
