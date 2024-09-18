package com.example.ltweb.Service;

import com.example.ltweb.DAO.IUserDao;
import com.example.ltweb.DAO.UserDaoImpl;
import com.example.ltweb.Model.UserModel;

public class UserService implements IUserService {
    IUserDao userDao = new UserDaoImpl();

    @Override
    public UserModel findUserByUsername(String username) {
        return userDao.findByUserName(username);
    }

    @Override
    public UserModel login(String username, String password) {
        UserModel userModel = this.findUserByUsername(username);
        if (userModel != null) {
            if (userModel.getPassword().equals(password)) {
                return userModel;
            }
        }
        return null;
        }
}
