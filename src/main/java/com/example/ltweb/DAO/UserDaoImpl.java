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
                System.out.println(user.getRoleid());
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
    public boolean checkExistUsername(String username) {
        boolean duplicate = false;
        String query = "select * from Users where username = ?";
        try {
            con = new DBConnectionMySQL().getConnection();
            ps = con.prepareStatement(query);
            ps.setString(1, username);
            rs = ps.executeQuery();
            if (rs.next()) {
                duplicate = true;
            }
            ps.close();
            con.close();
        } catch (Exception ex) {}
        return duplicate;
    }

    @Override
    public UserModel findByUsernameAndEmail(String username, String email) {
        String sql = "SELECT * FROM users WHERE username = ? AND email = ?";
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        UserModel user = null;

        try {
            con = new DBConnectionMySQL().getConnection(); // Tạo kết nối
            ps = con.prepareStatement(sql); // Tạo PreparedStatement
            ps.setString(1, username); // Set giá trị cho tham số username
            ps.setString(2, email); // Set giá trị cho tham số password
            rs = ps.executeQuery(); // Thực thi câu lệnh và lấy kết quả

            // Kiểm tra nếu có dòng nào được trả về
            if (rs.next()) {
                // Lấy thông tin người dùng từ ResultSet và tạo đối tượng UserModel
                user = new UserModel();
                user.setEmail(rs.getString("email"));
                user.setUsername(rs.getString("username"));
                user.setFullname(rs.getString("fullname"));
                user.setPassword(rs.getString("password"));
                user.setRoldid(rs.getString("roleid"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Đóng tài nguyên
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (con != null) con.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

        return user; // Trả về đối tượng UserModel hoặc null nếu không tìm thấy người dùng
    }

    @Override
    public boolean updatePassword(String username, String newPassword) {
        String sql = "UPDATE users SET password = ? WHERE username = ?";
        Connection con = null;
        PreparedStatement ps = null;
        boolean isUpdated = false;

        try {
            con = new DBConnectionMySQL().getConnection(); // Tạo kết nối
            ps = con.prepareStatement(sql); // Tạo PreparedStatement
            ps.setString(1, newPassword); // Set mật khẩu mới
            ps.setString(2, username); // Set giá trị cho tham số username
            int rowsAffected = ps.executeUpdate(); // Thực thi câu lệnh cập nhật

            // Kiểm tra số lượng dòng bị ảnh hưởng
            if (rowsAffected > 0) {
                isUpdated = true; // Cập nhật thành công
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Đóng tài nguyên
            try {
                if (ps != null) ps.close();
                if (con != null) con.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

        return isUpdated; // Trả về kết quả cập nhật
    }



    @Override
    public void insert(UserModel user) {
        System.out.println(user);
        String sql = "INSERT INTO users(email, username, fullname, password,roleid) VALUES (?,?,?,?,?)";
        try {
            con = new DBConnectionMySQL().getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, user.getEmail());
            ps.setString(2, user.getUsername());
            ps.setString(3, user.getFullname());
            ps.setString(4, user.getPassword());
            ps.setString(5,"3");
            ps.executeUpdate();
        } catch (Exception e) {e.printStackTrace();}
    }

    @Override
    public boolean checkExistEmail(String email) {
        boolean duplicate = false;
        String query = "select * from users where email = ?";
        try {
            con = new DBConnectionMySQL().getConnection();
            ps = con.prepareStatement(query);
            ps.setString(1, email);
            rs = ps.executeQuery();
            if (rs.next()) {
                duplicate = true;
            }
            ps.close();
            con.close();
        } catch (Exception ex) {}
        return duplicate;
    }


}

