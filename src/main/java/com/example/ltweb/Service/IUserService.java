package com.example.ltweb.Service;

import com.example.ltweb.Model.UserModel;

public interface IUserService {
    UserModel findUserByUsername(String username);


    UserModel login(String username, String password);
}
