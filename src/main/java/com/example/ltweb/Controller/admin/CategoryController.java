package com.example.ltweb.Controller.admin;

import com.example.ltweb.Entity.Category;
import com.example.ltweb.Service.CategoryService;
import com.example.ltweb.Service.ICategoryService;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import com.example.ltweb.utils.Constant;
import javax.servlet.ServletException;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;

@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
        maxFileSize = 1024 * 1024 * 10, // 10MB
        maxRequestSize = 1024 * 1024 * 50) // 50MB

@WebServlet(urlPatterns = {"/admin/categories", "/admin/category/add", "/admin/category/insert",
        "/admin/category/edit", "/admin/category/update", "/admin/category/delete" })
public class CategoryController extends HttpServlet {
    ICategoryService categoryService = new CategoryService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, jakarta.servlet.ServletException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");

        String url = req.getRequestURI();
        if(url.contains("/admin/categories")){
            List<Category> list = categoryService.findAll();
            req.setAttribute("listCategory", list);
            req.getRequestDispatcher("/views/admin/category-list.jsp").forward(req, resp);
        } else if (url.contains("/admin/category/add")) {
            req.getRequestDispatcher("/views/admin/category-add.jsp").forward(req, resp);
        }
        else if (url.contains("/admin/category/edit")) {
            int id  = Integer.parseInt(req.getParameter("id"));
            Category category = categoryService.findById(id);
            req.setAttribute("cate", category);
            req.getRequestDispatcher("/views/admin/category-edit.jsp").forward(req, resp);
        }
        else if (url.contains("/admin/category/delete")) {
            int id  = Integer.parseInt(req.getParameter("id"));
            try {
                categoryService.delete(id);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            resp.sendRedirect(req.getContextPath() + "/admin/categories");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        String url = req.getRequestURI();
        Category category = new Category();

        String fname = "";
        String uploadPath = Constant.UPLOAD_DIRECTORY;
        File uploadDir = new File(uploadPath);

        if(url.contains("/admin/category/insert")){
            //lay du lieu tu form
            String categoryname = req.getParameter("categoryname");
            int status = Integer.parseInt(req.getParameter("status"));
            String image = req.getParameter("image");

            // dua du lieu vao model
            category.setCategoryname(categoryname);
            category.setStatus(status);
            //Xu li anh
            if (!uploadDir.exists()) {
                uploadDir.mkdir();
            }
            try{
                Part part = req.getPart("image1");
                // part.write(uploadPath + "categories/" +fimename);
                if(part.getSize() > 0){
                    fname = this.getname(part);
                    part.write(uploadPath + File.separator + fname);
                    category.setImages(fname);
                } else if (image != null) {
                    category.setImages(image);
                }
                else {
                    category.setImages("avatar.jpg");
                }
            } catch (Exception e){
                e.printStackTrace();
            }
            // goi phuong thuc insert trong service
            categoryService.insert(category);
            // quay ve view
            resp.sendRedirect(req.getContextPath() + "/admin/categories");
        } else if (url.contains("/admin/category/update")) {
            int id = Integer.parseInt(req.getParameter("categoryid"));
            String categoryname = req.getParameter("categoryname");
            int status = Integer.parseInt(req.getParameter("status"));
            String image = req.getParameter("image");

            category = categoryService.findById(id);


            // dua du lieu vao model
            category.setCategoryid(id);
            category.setCategoryname(categoryname);
            category.setStatus(status);

            if (!uploadDir.exists()) {
                uploadDir.mkdir();
            }
            try{
                Part part = req.getPart("image1");
                if(part.getSize() > 0){
                    fname = this.getname(part);
                    part.write(uploadPath + File.separator + fname);
                    category.setImages(fname);
                } else if (!image.isEmpty()) {
                    category.setImages(image);
                }
            } catch (Exception e){
                e.printStackTrace();
            }
            // goi phuong thuc insert trong service
            categoryService.update(category);
            // quay ve view
            resp.sendRedirect(req.getContextPath() + "/admin/categories");
        }
    }

    public String getname(Part part){
        String fname ="";
        String filename = Paths.get(part.getSubmittedFileName()).getFileName().toString();
        int index = filename.lastIndexOf(".");
        String ext = filename.substring(index+ 1);
        fname = System.currentTimeMillis() + "." + ext;
        return fname;
    }
}
