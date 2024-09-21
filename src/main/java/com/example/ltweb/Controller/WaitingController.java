package com.example.ltweb.Controller;

import com.example.ltweb.Model.UserModel;
import jakarta.servlet.annotation.WebServlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
@WebServlet(urlPatterns="/waiting")
public class WaitingController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws
            ServletException, IOException {
        HttpSession session = req.getSession();
        if (session != null && session.getAttribute("account") != null) {
            UserModel u = (UserModel) session.getAttribute("account");
            // Lưu username vào session
            session.setAttribute("username", u.getUsername());
            if (u.getRoleid().equals("1")) {
                resp.sendRedirect(req.getContextPath() + "/admin/home");
            } else if (u.getRoleid().equals("2")) {
                resp.sendRedirect(req.getContextPath() + "/manager/home");
            } else {
                resp.sendRedirect(req.getContextPath() + "/home");
            }
        } else {
            resp.sendRedirect(req.getContextPath() + "/login");
        }

    }
}

