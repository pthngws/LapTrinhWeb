//package com.example.ltweb.Controller;
//
//import com.example.ltweb.Entity.Category;
//import com.example.ltweb.Model.CategoryModel;
//import com.example.ltweb.Service.CategoryService;
//import com.example.ltweb.Service.ICategoryService;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//
//import java.io.IOException;
//import java.io.PrintWriter;
//import java.util.List;
//@WebServlet(urlPatterns = {"/admin/categories","/admin/category/add","/admin/category/insert","/admin/category/edit"})
//public class CategoryController extends HttpServlet{
//        private static final long serialVersionUID = 1L;
//        public ICategoryService categoryService = new CategoryService();
//        @Override
//        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//            req.setCharacterEncoding("UTF-8");
//            resp.setCharacterEncoding("UTF-8");
//            resp.setContentType("text/html;charset=UTF-8");
//            String url = req.getRequestURI();
//            if(url.contains("/admin/category/add")) {
//                System.out.println("lo");
//                req.getRequestDispatcher("/views/admin/category-add.jsp").forward(req, resp);
//            }
//            else if(url.contains("/admin/categories")){
//                List<Category> listCategory = categoryService.findAll();
//                req.setAttribute("listCategory", listCategory);
//                req.getRequestDispatcher("/views/admin/category-list.jsp").forward(req, resp);
//            }
//            else if(url.contains("/admin/category/edit")) {
//                int id = Integer.parseInt(req.getParameter("id"));
//                Category categoryModel = categoryService.findById(id);
//                req.getRequestDispatcher("/views/admin/category-edit.jsp").forward(req, resp);
//            }
//        }
//
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        req.setCharacterEncoding("UTF-8");
//        resp.setCharacterEncoding("UTF-8");
//        resp.setContentType("text/html;charset=UTF-8");
//        String url = req.getRequestURI();
//        if(url.contains("admin/category/insert")){
//
//            Category category = new Category();
//            category.setCategoryname(req.getParameter("categoryname"));
//            category.setImages(req.getParameter("image"));
//            category.setStatus(Integer.parseInt(req.getParameter("status")));
//            System.out.println(category);
//            categoryService.insert(category);
//            resp.sendRedirect( req.getContextPath()+"/admin/categories");
//        }
//    }
//}
