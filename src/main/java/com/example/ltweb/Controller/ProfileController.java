package com.example.ltweb.Controller;

import com.example.ltweb.Service.IUserService;
import com.example.ltweb.Service.UserService;
import com.example.ltweb.utils.Constant;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import static com.example.ltweb.utils.Constant.UPLOAD_DIRECTORY;
import static com.example.ltweb.utils.Constant.DEFAULT_FILENAME;

@WebServlet(urlPatterns = {"/profile"})
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
        maxFileSize = 1024 * 1024 * 10, // 10MB
        maxRequestSize = 1024 * 1024 * 50) // 50MB
public class ProfileController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("views/web/profile.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uploadPath = "C:" + File.separator + "upload";//upload vào thư mục bất kỳ
        //String uploadPath = getServletContext().getRealPath("") + File.separator + UPLOAD_DIRECTORY;
        //upload vào thư mục project
        String username = req.getParameter("username");
        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists())
            uploadDir.mkdir();
        try {
            String fileName = "";
            for (Part part : req.getParts()) {
                String partName = part.getName();
                if(partName.equals("image")){
                    fileName = getFileName(part);
                    part.write(uploadPath + File.separator + fileName);
                }
            }
            req.setAttribute("message", "File " + fileName + " has uploaded successfully!");
            IUserService userService = new UserService();
            userService.updateImage(username, fileName);
        } catch (FileNotFoundException fne) {
            req.setAttribute("message", "There was an error: " + fne.getMessage());
        }
        getServletContext().getRequestDispatcher("/views/web/profile.jsp").forward(req, resp);
    }

    private String getFileName(Part part) {
        for (String content : part.getHeader("content-disposition").split(";")) {
            if (content.trim().startsWith("filename"))
                return content.substring(content.indexOf("=") + 2, content.length() - 1);
        }
        return Constant.DEFAULT_FILENAME;
    }
}
