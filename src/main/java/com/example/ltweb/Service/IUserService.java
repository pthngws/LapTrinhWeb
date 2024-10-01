package com.example.ltweb.Service;

import com.example.ltweb.Model.UserModel;

public interface IUserService {
    UserModel findUserByUsername(String username);
    UserModel findByUsernameAndEmail(String username, String email);
    boolean updatePassword(String username,String newPassword);
    UserModel login(String username, String password);
    boolean checkExistEmail(String email);

    boolean register(String fullname, String email, String
            username, String password);

    boolean updateImage(String username, String filename);
    boolean checkExistUsername(String username);

    void insert(UserModel user);
}
