package com.ptit.controller;

import com.ptit.DAO.CategoryDAO;
import com.ptit.DAO.MovieDAO;
import com.ptit.model.Movie;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "SearchServlet", value = "/search")
public class SearchServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String searchKey = request.getParameter("searchKey");
        if (searchKey != null && !searchKey.equals("")) {
            request.setAttribute("key", searchKey);
            request.setAttribute("movies", new MovieDAO().getMovieByKeySearchTop8(searchKey));
        }
        request.getRequestDispatcher("search.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
