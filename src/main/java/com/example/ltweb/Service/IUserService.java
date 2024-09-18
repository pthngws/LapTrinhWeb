package com.example.ltweb.Service;

import com.example.ltweb.Model.UserModel;

public interface IUserService {
    UserModel findUserByUsername(String username);
    UserModel findByUsernameAndEmail(String username, String email);
    boolean updatePassword(String username,String newPassword);
    UserModel login(String username, String password);

    void insert(UserModel user);
}
