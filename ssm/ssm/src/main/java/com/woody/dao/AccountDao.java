package com.woody.dao;

import com.woody.domain.Account;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 账户持久层接口
 */
@Repository("accountDao")
public interface AccountDao {

    /**
     * 查询所有
     * @return
     */
    @Select("select * from account")
    public List<Account> findAll();

    /**
     * 保存账户
     */
    @Insert("insert into account(name, money) values(#{name}, #{money})")
    public void saveAccount(Account account);
}
