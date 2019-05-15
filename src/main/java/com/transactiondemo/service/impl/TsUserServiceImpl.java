package com.transactiondemo.service.impl;


import com.transactiondemo.dao.TsUserDao;
import com.transactiondemo.pojo.User;
import com.transactiondemo.service.TsUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**** imports ****/
@Service
public class TsUserServiceImpl implements TsUserService {
    @Autowired
    private TsUserDao tsUserDao;

    @Override
    public User getUser(String id) {
        return tsUserDao.getUser(id);
    }

    // oracle只能支持读写操作和串行化   READ_COMMITTED 读写提交
    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.NESTED)
    public int insertUser(User user) {
        return tsUserDao.insertUser(user);
    }
}