package com.transactiondemo.service;

import com.transactiondemo.pojo.User;

import java.util.List;

public interface UserBatchService {
    int insertUsers(List<User> users);
}
