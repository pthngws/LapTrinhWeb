package com.example.ltweb.DAO;

import com.example.ltweb.Model.UserModel;

import java.util.List;

public interface IUserDao {
    UserModel findByUserName(String userName);
    List<UserModel> findAll();
    UserModel findById(int id);
    void insert(UserModel user);
    boolean checkExistEmail(String email);
    boolean checkExistUsername(String username);
    UserModel findByUsernameAndEmail(String username, String email);
    boolean updatePassword(String username, String password);
    void updateProfile(UserModel user);
    boolean updateImage(String username, String image);
}
