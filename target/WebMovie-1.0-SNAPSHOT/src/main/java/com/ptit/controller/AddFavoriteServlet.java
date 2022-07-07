package com.ptit.controller;

import com.ptit.DAO.UserDAO;
import com.ptit.model.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "AddFavoriteServlet", value = "/addFavorite")
public class AddFavoriteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String check_raw = request.getParameter("value");
        String id_raw = request.getParameter("id");
        int check = Integer.parseInt(check_raw);
        int id = Integer.parseInt(id_raw);
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        UserDAO userDAO = new UserDAO();
        if (check == 1) {
            userDAO.addMovieToFavorite(user.getId(), id);
        }else {
            userDAO.removeMovieFromFavorite(user.getId(), id);
        }

    }
}
