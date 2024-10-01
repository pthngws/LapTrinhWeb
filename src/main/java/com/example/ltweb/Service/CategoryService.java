package com.example.ltweb.Service;

import com.example.ltweb.DAO.CategoryDaoImpl;
import com.example.ltweb.DAO.ICategoryDao;
import com.example.ltweb.DAO.IUserDao;
import com.example.ltweb.Model.CategoryModel;

import java.util.List;

public class CategoryService implements ICategoryService {
    ICategoryDao categoryDao = new CategoryDaoImpl();

    @Override
    public List<CategoryModel> findAll() {
        return categoryDao.findAll();
    }

    @Override
    public CategoryModel findById(int id) {
        return categoryDao.findById(id);
    }

    @Override
    public CategoryModel findByName(String name) {
        return categoryDao.findByName(name);
    }

    @Override
    public List<CategoryModel> searchByName(String keyword) {
        return categoryDao.searchByName(keyword);
    }

    @Override
    public void insert(CategoryModel category) {
            categoryDao.insert(category);
    }

    @Override
    public void update(CategoryModel category) {
        CategoryModel categoryModel = this.findById(category.getCategoryid());
        if (categoryModel != null) {
            categoryDao.update(category);
        }
    }

    @Override
    public void delete(int id) {
        CategoryModel categoryModel = this.findById(id);
        if (categoryModel != null) {
            categoryDao.delete(id);
        }
    }

    @Override
    public void updateStatus(int id, int status) {
        categoryDao.updateStatus(id, status);
    }
}
