package com.example.ltweb.Controller;

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

@WebServlet(urlPatterns = "/profile")
@MultipartConfig(fileSizeThreshold = 1024 * 1024,
        maxFileSize = 1024 * 1024 * 5,
        maxRequestSize = 1024 * 1024 * 5 * 5)
public class ProfileController extends HttpServlet {
    ;

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/views/web/profile.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uploadPath = File.separator + UPLOAD_DIRECTORY; //upload vào thư mục bất kỳ


        //String uploadPath = getServletContext().getRealPath("") + File.separator + UPLOAD_DIRECTORY; //upload vào thư mục project


        File uploadDir = new File(uploadPath);


        if (!uploadDir.exists())


            uploadDir.mkdir();



        try {


            String fileName = "";


            for (Part part : req.getParts()) {


                fileName = getFileName(part);


                part.write(uploadPath + File.separator + fileName);


            }





            req.setAttribute("message", "File " + fileName + " has uploaded successfully!");


        } catch (FileNotFoundException fne) {


            req.setAttribute("message", "There was an error: " + fne.getMessage());


        }


        getServletContext().getRequestDispatcher("/views/result.jsp").forward(req, resp);


    }
    private String getFileName(Part part) {


        for (String content : part.getHeader("content-disposition").split(";")) {


            if (content.trim().startsWith("filename"))


                return content.substring(content.indexOf("=") + 2, content.length() - 1);


        }


        return DEFAULT_FILENAME;


    }
}