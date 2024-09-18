package com.example.ltweb.DAO;

import com.example.ltweb.Model.UserModel;

import java.util.List;

public interface IUserDao {
    UserModel findByUserName(String userName);
    List<UserModel> findAll();
    UserModel findById(int id);
    void insert(UserModel user);
}
