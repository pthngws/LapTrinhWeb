package com.example.ltweb.Controller;

import com.example.ltweb.DAO.UserDaoImpl;
import com.example.ltweb.Model.UserModel;
import com.example.ltweb.Service.IUserService;
import com.example.ltweb.Service.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(urlPatterns = "/forgotpassword")
public class ForgotPasswordController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private IUserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("views/forgotpass.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String username = req.getParameter("username");
        String email = req.getParameter("email");
        String password = req.getParameter("new_psw");
        UserModel user = userService.findByUsernameAndEmail(username,email);
        String msg;
        if (user == null) {
            // Thiết lập thông báo lỗi hoặc thông báo không hợp lệ
            msg = "Tên người dùng hoặc mật khẩu không đúng.";
        } else {
            // Nếu người dùng đã tồn tại, cập nhật mật khẩu
            // Lưu ý: Thực tế bạn không nên cập nhật mật khẩu ở đây nếu chỉ xác thực
            if(userService.updatePassword(username,password))
                msg = "Đổi mật khẩu thành công!";
            else
                msg = "Đổi mật khẩu thất bại";
        }

// Sử dụng biến msg để phản hồi hoặc hiển thị thông báo cho người dùng
        System.out.println(msg);
        req.setAttribute("alert", msg);

        // Chuyển hướng đến trang đăng nhập
        req.getRequestDispatcher("views/login.jsp").forward(req, res);


    }
}
