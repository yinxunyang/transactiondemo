package com.transactiondemo.service.impl;

import com.transactiondemo.pojo.User;
import com.transactiondemo.service.TsUserService;
import com.transactiondemo.service.UserBatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserBatchServiceImpl implements UserBatchService {
    @Autowired
    private TsUserService tsUserService;

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public int insertUsers(List<User> userList) {
        int count = 0;
        for (User user : userList) {
            count += tsUserService.insertUser(user);
        }
        return count;
    }
}
