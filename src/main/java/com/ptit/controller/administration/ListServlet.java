package com.ptit.controller.administration;

import com.ptit.DAO.MovieDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ListServlet", value = "/adminstration/listphim")
public class ListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        MovieDAO md = new MovieDAO();
        request.setCharacterEncoding("UTF-8");
        String key = request.getParameter("key");
        if (key == null) key = "";
        request.setAttribute("movies", md.getMovieLikeName(key));
        request.getRequestDispatcher("listphim.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
