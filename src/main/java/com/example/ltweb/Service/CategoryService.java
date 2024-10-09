package com.example.ltweb.Service;

import com.example.ltweb.DAO.CategoryDaoImpl;
import com.example.ltweb.DAO.ICategoryDao;
import com.example.ltweb.Entity.Category;

import java.util.List;

public class CategoryService implements ICategoryService {
    public ICategoryDao categoryDao = new CategoryDaoImpl();
    @Override
    public List<Category> findAll() {
        return categoryDao.findAll();
    }

    @Override
    public Category findById(int id) {
        return categoryDao.findById(id);
    }

    @Override
    public Category findByName(String name) {
        return categoryDao.findByName(name);
    }

    @Override
    public List<Category> searchByName(String keyword) {
        return categoryDao.searchByName(keyword);
    }

    @Override
    public void insert(Category category) {
        // goi ham ktra trung name
        Category cate = this.findByName(category.getCategoryname());
        if (cate == null) {
            categoryDao.insert(category);
        }
    }


    @Override
    public void update(Category category) {
        //categoryDao.update(category);
        Category cate = this.findByName(category.getCategoryname());
        System.out.println(cate == null);
        if (cate == null) {
            categoryDao.update(category);
        }
    }

    @Override
    public void delete(int id) throws Exception {
        categoryDao.delete(id);
    }
}