package com.example.ltweb.DAO;

import com.example.ltweb.Config.DBConnectionMySQL;
import com.example.ltweb.Model.CategoryModel;
import com.example.ltweb.Model.UserModel;
import com.sun.tools.javac.Main;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoryDaoImpl implements ICategoryDao {
    private static final long serialVersionUID = 1L;
    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    @Override
    public List<CategoryModel> findAll() {
        String sql = "SELECT * FROM categories";
        List<CategoryModel> list = new ArrayList<>();

        try {
            Connection con = new DBConnectionMySQL().getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            // Duyệt qua từng hàng (row) trong ResultSet và thêm vào danh sách
            while (rs.next()) {
                CategoryModel categoryModel = new CategoryModel();
                categoryModel.setCategoryid(rs.getInt("category_id"));
                categoryModel.setCategoryname(rs.getString("category_name"));
                categoryModel.setImage(rs.getString("image"));
                categoryModel.setStatus(rs.getInt("status"));
                list.add(categoryModel);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list; // Trả về danh sách các category
    }


    @Override
    public CategoryModel findById(int id) {
        String sql = "select * from categories where category_id=?";
        try{
            Connection con = new DBConnectionMySQL().getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1,id);
            ResultSet rs = ps.executeQuery();

            CategoryModel categoryModel = new CategoryModel();
            while (rs.next()){
                categoryModel.setCategoryid(rs.getInt("category_id"));
                categoryModel.setCategoryname(rs.getString("category_name"));
                categoryModel.setImage(rs.getString("image"));
                categoryModel.setStatus(rs.getInt("status"));
            }
            return categoryModel;
        }
        catch(Exception e){
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public CategoryModel findByName(String name) {
        String sql = "select * from categories where category_name=?";
        try{
            Connection con = new DBConnectionMySQL().getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1,name);
            ResultSet rs = ps.executeQuery();

            CategoryModel categoryModel = new CategoryModel();
            if(rs.next()){
                categoryModel.setCategoryid(rs.getInt("category_id"));
                categoryModel.setCategoryname(rs.getString("category_name"));
                categoryModel.setImage(rs.getString("image"));
                categoryModel.setStatus(rs.getInt("status"));
            }
            return categoryModel;
        }
        catch(Exception e){
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public List<CategoryModel> searchByName(String keyword) {
        String sql = "select * from categories where category_name like ?";
        try{
            Connection con = new DBConnectionMySQL().getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1,"%" +keyword + "%");
            ResultSet rs = ps.executeQuery();
            List<CategoryModel> listCategory = new ArrayList<>();
            CategoryModel categoryModel = new CategoryModel();
            while (rs.next()){
                categoryModel.setCategoryid(rs.getInt("category_id"));
                categoryModel.setCategoryname(rs.getString("category_name"));
                categoryModel.setImage(rs.getString("image"));
                categoryModel.setStatus(rs.getInt("status"));
                listCategory.add(categoryModel);
            }
            return listCategory;
        }
        catch(Exception e){
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public void insert(CategoryModel category) {
        System.out.println("123");
        String sql = "INSERT INTO categories(category_name,image, status) VALUES (?,?,?)";
        try {
            con = new DBConnectionMySQL().getConnection();
            ps = con.prepareStatement(sql);
//            ps.setInt(1, category.getCategoryid());
            ps.setString(1, category.getCategoryname());
            ps.setString(2, category.getImage());
            ps.setInt(3, category.getStatus());
            ps.executeUpdate();
        } catch (Exception e) {e.printStackTrace();}
    }

    @Override
    public void update(CategoryModel category) {
        String sql = "update categories set (category_name,image,status) values(?,?,?) where category_id=?";
        try {
            con = new DBConnectionMySQL().getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, category.getCategoryname());
            ps.setString(2, category.getImage());
            ps.setInt(3,category.getStatus());
            ps.setInt(4,category.getCategoryid());
            ps.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM categories where category_id=?";
        try {
            con = new DBConnectionMySQL().getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1,id);
            ps.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateStatus(int id,int status) {
        String sql = "update categories set status = ? where category_id=?";
        try {
            con = new DBConnectionMySQL().getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1,status);
            ps.setInt(2,id);
            ps.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
