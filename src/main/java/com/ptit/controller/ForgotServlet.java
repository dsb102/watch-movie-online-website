package com.ptit.controller;

import com.ptit.DAO.UserDAO;
import com.ptit.controller.addition.SendMail;
import com.ptit.model.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ForgotServlet", value = "/forgot")
public class ForgotServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("quenmatkhau.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        UserDAO userDAO = new UserDAO();
        User user = new UserDAO().getUserByEmail(email);
        int checkEmail = 0;
        String message = "";
        if (user != null) checkEmail = 1;
        if (checkEmail == 0) {
            message = "Email không tồn tại!";
        } else {
            int checkSendMail = new SendMail().sendGmail(user);
            if (checkEmail == 1) {
                message = "Vui lòng kiểm tra hộp thư để nhận mật khẩu";
            } else {
                message = "Có lỗi xảy ra xin vui lòng thử lại!";
            }
        }

        request.setAttribute("message", message);
        request.getRequestDispatcher("quenmatkhau.jsp").forward(request, response);
    }
}
