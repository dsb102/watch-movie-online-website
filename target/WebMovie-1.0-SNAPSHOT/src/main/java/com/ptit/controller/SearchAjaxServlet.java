package com.ptit.controller;

import com.ptit.DAO.CategoryDAO;
import com.ptit.DAO.MovieDAO;
import com.ptit.model.Movie;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "SearchAjaxServlet", value = "/searchAjax")
public class SearchAjaxServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String searchKey = request.getParameter("searchKey");
        MovieDAO md = new MovieDAO();
        List<Movie> movies;
        if (searchKey != null && !searchKey.equals("")) {

            movies = md.getMovieByKeySearchTop8(searchKey);
            PrintWriter out = response.getWriter();
            for (Movie movie : movies) {
                out.println("<div class=\"movie-list-item movie-list-quantity3\">\n" +
            "                    <a class=\"movie-list-item-img\" href=\"watch?id=" + movie.getId() + "\"\n" +
            "                       style=\"background-image: url('" + movie.getThuml_url() + "')\">\n" +
            "\n" +
            "                    </a>\n" +
            "                    <a class=\"movie-list-item-title\" href=\"watch?id=" + movie.getId() + "\" target=\"_blank\">" + movie.getName() + "</a>\n" +
            "                </div>");
            }
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");
        MovieDAO md = new MovieDAO();
        String searchKey = request.getParameter("searchKey");
        PrintWriter out = response.getWriter();
        String start_raw = request.getParameter("start");
        Integer start = Integer.parseInt(start_raw);
        List<Movie> movies = md.getMovieByKeySearchNext8(searchKey, start);
        for (Movie movie : movies) {
            out.println("<div class=\"movie-list-item movie-list-quantity3\">\n" +
                    "                    <a class=\"movie-list-item-img\" href=\"watch?id=" + movie.getId() + "\"\n" +
                    "                       style=\"background-image: url('" + movie.getThuml_url() + "')\">\n" +
                    "\n" +
                    "                    </a>\n" +
                    "                    <a class=\"movie-list-item-title\" href=\"watch?id=" + movie.getId() + "\" target=\"_blank\">" + movie.getName() + "</a>\n" +
                    "                </div>");
        }
    }
}
