package com.example.ltweb.DAO;

import com.example.ltweb.Config.DBConnectionMySQL;
import com.example.ltweb.Model.UserModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements IUserDao{
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    @Override
    public UserModel findByUserName(String userName) {
        String sql = "select * from users where username = ?";
        try{
            Connection con = new DBConnectionMySQL().getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, userName);
            ResultSet rs = ps.executeQuery();
            UserModel user = new UserModel();
            if(rs.next()){
                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setRoldid(rs.getString("roleid"));
                System.out.println(user.getRoldid());
            }
            return user;
        }
        catch(Exception e){
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public List<UserModel> findAll() {
        List<UserModel> users = new ArrayList<>();
        String sql = "SELECT * FROM [Users] W";
        try {
            con = new DBConnectionMySQL().getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                UserModel user = new UserModel();
                user.setId(rs.getInt("id"));
                user.setEmail(rs.getString("email"));
                user.setUsername(rs.getString("username"));
                user.setFullname(rs.getString("fullname"));
                user.setPassword(rs.getString("password"));
                user.setRoldid(rs.getString("roleid"));
                user.setPhone(rs.getString("phone"));
                user.setCreateDate(rs.getDate("createdDate"));
                users.add(user);
            }
            return users;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public UserModel findById(int id) {
        String sql = "SELECT * FROM [Users] WHERE id = ? ";
        try {
            con = new DBConnectionMySQL().getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                UserModel user = new UserModel();
                user.setId(rs.getInt("id"));
                user.setEmail(rs.getString("email"));
                user.setUsername(rs.getString("username"));
                user.setFullname(rs.getString("fullname"));
                user.setPassword(rs.getString("password"));
                user.setRoldid(rs.getString("roleid"));
                user.setPhone(rs.getString("phone"));
                user.setCreateDate(rs.getDate("createdDate"));
                return user;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void insert(UserModel user) {

    }

//    public void insert(UserModel user) {
//        String sql = "INSERT INTO users(id,username, password, images, fullname, email, phone, roleid, createdDate) VALUES(?,?,?,?,?,?,?,?,?)";
//        try {
//            con = new DBConnectionMySQL().getConnection();
//            ps = con.prepareStatement(sql);
//            ps.setInt(1, user.getId());
//            ps.setString(2, user.getUsername());
//            ps.setString(3, user.getFullname());
//            ps.setString(4, user.getEmail());
//            ps.setString(5, user.getPassword());
//            ps.executeUpdate();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
}
