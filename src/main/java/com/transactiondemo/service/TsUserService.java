package com.transactiondemo.service;


import com.transactiondemo.pojo.User;

public interface TsUserService {
    User getUser(String id);

    int insertUser(User user);
}