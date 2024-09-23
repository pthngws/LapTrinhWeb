package com.example.ltweb.Controller;

import com.example.ltweb.DAO.UserDaoImpl;
import com.example.ltweb.Model.UserModel;
import com.example.ltweb.Service.IUserService;
import com.example.ltweb.Service.UserService;
import com.example.ltweb.utils.Constant;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;

import java.io.IOException;
import java.io.PrintWriter;


@WebServlet(name = "login", urlPatterns = "/login")
public class LoginController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private IUserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        if (session != null && session.getAttribute("account") != null) {
            resp.sendRedirect(req.getContextPath() + "/waiting");
            return;
        }
// Check cookie
        Cookie[] cookies = req.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("username")) {
                    session = req.getSession(true);
                    session.setAttribute("username", cookie.getValue());
                    resp.sendRedirect(req.getContextPath() + "/waiting");
                    return;
                }
            }
        }
        req.getRequestDispatcher("views/login.jsp").forward(req, resp);
    }


    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try{
            resp.setContentType("text/html");
            resp.setCharacterEncoding("UTF-8");
            req.setCharacterEncoding("UTF-8");
            String username = req.getParameter("uname");
            String password = req.getParameter("psw");
            boolean isRememberMe = false;
            String remember = req.getParameter("remember");

            if("on".equals(remember)){
                isRememberMe = true;
            }

            String alertMsg = "";
            if (username.isEmpty() || password.isEmpty()) {
                alertMsg = "Tài khoản hoặc mật khẩu không được rỗng";
                req.setAttribute("alert", alertMsg);
                req.getRequestDispatcher("/views/login.jsp").forward(req, resp);
                return;
            }

            IUserService service = new UserService();
            UserModel user = service.login(username, password);
            if (user != null) {
                HttpSession session = req.getSession(true);
                session.setAttribute("account", user);
                if(isRememberMe){
                    saveRememberMe(resp, username);
                }
                resp.sendRedirect(req.getContextPath() + "/waiting");
                System.out.println(user);
            } else {
                alertMsg = "Tài khoản hoặc mật khẩu không đúng";
                req.setAttribute("alert", alertMsg);
                req.getRequestDispatcher("/views/login.jsp").forward(req, resp);
            }
        }catch (Exception e)
        {
            String alertMsg = "Không tìm thấy username này";
            req.setAttribute("alert", alertMsg);
            req.getRequestDispatcher("/views/login.jsp").forward(req, resp);
        }
    }

    private void saveRememberMe(HttpServletResponse resp, String username) {
        Cookie cookie = new Cookie(Constant.COOKIE_REMEMBER, username);
        cookie.setMaxAge(60 * 60 * 24 * 30);
        resp.addCookie(cookie);

    }


}

