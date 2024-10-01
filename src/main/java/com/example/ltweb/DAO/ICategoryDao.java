package com.example.ltweb.DAO;

import com.example.ltweb.Model.CategoryModel;

import java.util.List;

public interface ICategoryDao {
    List<CategoryModel> findAll();
    CategoryModel findById(int id);
    CategoryModel findByName(String name);
    List<CategoryModel> searchByName(String keyword);
    void insert(CategoryModel category);
    void update(CategoryModel category);
    void delete(int id);
    void updateStatus(int id,int status);
}
