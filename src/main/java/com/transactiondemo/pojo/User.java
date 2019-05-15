package com.transactiondemo.pojo;

import org.apache.ibatis.type.Alias;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


/**** imports ****/
// 标明是一个实体类
@Entity
// 定义映射的表
@Table(name = "t_user")
@Alias("user")
public class User {
    // 标明主键
    @Id
    private String id;

    private String userName;

    private String note;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

}