package com.ptit.controller;

import com.ptit.DAO.UserDAO;
import com.ptit.controller.addition.HashMD5;
import com.ptit.model.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;

@WebServlet(name = "RegisterServlet", value = "/register")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String page = "";
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        if (user == null)
            page = "register.jsp";
        else
            page = "home";
        response.sendRedirect(page);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String confirm = request.getParameter("confirm");
        UserDAO ud = new UserDAO();
        User checkUN = ud.checkUsername(username);
        User checkE = ud.checkEmailUser(email);
        System.out.println(checkUN);
        System.out.println(checkE);
        if (checkUN != null)
            request.setAttribute("message", "Tài khoản đã tồn tại");

        if (checkE != null)
            request.setAttribute("message", "Email đã tồn tại");

        if (username.equals("") || email.equals("") || password.equals("") || confirm.equals("")) {
            request.setAttribute("message", "Không được bỏ trống trường nào");
        }

        boolean confirmPass = password.equals(confirm);
        if (!confirmPass)
            request.setAttribute("message", "Mật khẩu không khớp");

        if (checkUN == null && checkE == null && confirmPass) {
            try {
                ud.addUser(username, email, new HashMD5().getHashMD5(password));
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }
            response.sendRedirect("login");
        }

        request.getRequestDispatcher("register.jsp").forward(request, response);
    }
}






















