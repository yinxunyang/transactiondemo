package com.transactiondemo.controller;

import com.transactiondemo.pojo.User;
import com.transactiondemo.service.TsUserService;
import com.transactiondemo.service.UserBatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**** imports ****/
// 返回json格式
@RestController
public class TsController {

    @Autowired
    private TsUserService tsUserService;
    @Autowired
    private UserBatchService userBatchService;

    @RequestMapping("/getUser")
    public User getUser(String id) {
        return tsUserService.getUser(id);
    }

    @RequestMapping("/insertUser")
    public Map<String, Object> insertUser(String userName, String note) {
        User user = new User();
        user.setId(UUID.randomUUID().toString().replace("-", ""));
        user.setNote(note);
        user.setUserName(userName);
        int update = tsUserService.insertUser(user);
        Map<String, Object> result = new HashMap<>();
        result.put("success", update == 1);
        result.put("user", user);
        return result;
    }

    @RequestMapping("/insertUsers")
    public Map<String, Object> insertUsers(String userName1, String note1, String userName2, String note2) {
        User user1 = new User();
        user1.setId(UUID.randomUUID().toString().replace("-", ""));
        user1.setNote(note1);
        user1.setUserName(userName1);
        User user2 = new User();
        user2.setId(UUID.randomUUID().toString().replace("-", ""));
        user2.setNote(note2);
        user2.setUserName(userName2);
        List<User> userList = new ArrayList<>();
        userList.add(user1);
        userList.add(user2);
        int inserts = userBatchService.insertUsers(userList);
        Map<String, Object> result = new HashMap<>();
        result.put("success", inserts > 0);
        result.put("user", userList);
        return result;
    }
}