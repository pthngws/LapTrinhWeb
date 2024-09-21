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
    public UserModel findByUsernameAndEmail(String username, String email) {
        return userDao.findByUsernameAndEmail(username, email);
    }

    @Override
    public boolean updatePassword(String username, String newPassword) {
        return userDao.updatePassword(username, newPassword);
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


    @Override
    public boolean register(String fullname, String email, String
            username, String password) {
        if (userDao.checkExistUsername(username)) {
            return false;
        }
        long millis=System.currentTimeMillis();
        java.sql.Date date=new java.sql.Date(millis);
        userDao.insert(new UserModel(fullname,email,username,password));
        return true;
    }
    @Override
    public boolean checkExistEmail(String email) {
        return userDao.checkExistEmail(email);
    }
    @Override
    public boolean checkExistUsername(String username) {
        return userDao.checkExistUsername(username);
    }
    @Override
    public void insert(UserModel user) {
        userDao.insert(user);
    }

}
