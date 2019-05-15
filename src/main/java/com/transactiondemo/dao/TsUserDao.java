package com.transactiondemo.dao;


import com.transactiondemo.pojo.User;
import org.springframework.stereotype.Repository;

/**** imports ****/
@Repository
public interface TsUserDao {
    User getUser(String id);

    // 新增用户
    int insertUser(User user);
}