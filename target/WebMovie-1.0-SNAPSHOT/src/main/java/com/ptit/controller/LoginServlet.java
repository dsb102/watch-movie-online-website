package com.ptit.controller;

import com.ptit.DAO.UserDAO;
import com.ptit.controller.addition.HashMD5;
import com.ptit.model.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;


@WebServlet(name = "LoginServlet", value = "/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String page = "";
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        if (user == null)
            page = "login.jsp";
        else
            page = "home";

        response.sendRedirect(page);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password_raw = request.getParameter("password");
        String password = "";
        try {
            password = new HashMD5().getHashMD5(password_raw);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        User user = new UserDAO().getUserByUserPass(username, password);
        String page = "";
        if (user == null) {
            request.setAttribute("message", "Tài khoản hoặc mật khẩu sai");
            page = "login";
        } else {
            HttpSession session = request.getSession();
            session.setAttribute("user", user);
            int role = user.getRole();
            if (role == 3) {
                page = "adminstration/menu";
            } else {
                page = "home";
            }
            String uri = (String) session.getAttribute("uriqueryCurrentUser");
            session.removeAttribute("uriqueryCurrentUser");
            if (uri != null) {
                page = uri;
            }

        }
        response.sendRedirect(page);

    }
}
