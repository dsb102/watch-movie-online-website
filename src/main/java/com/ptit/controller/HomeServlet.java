package com.ptit.controller;

import com.ptit.DAO.AdsDAO;
import com.ptit.DAO.CategoryDAO;
import com.ptit.DAO.MovieDAO;
import com.ptit.model.Category;
import com.ptit.model.Movie;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "HomeServlet", value = "/home")
public class HomeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        MovieDAO md = new MovieDAO();
        CategoryDAO cd = new CategoryDAO();
        List<Movie> series = md.getMovieByType("series");
        List<Movie> phimles = md.getMovieByType("single");
        List<Movie> shows = md.getMovieByType("tvshows");
        List<Movie> hoathinhs = md.getMovieByType("hoathinh");
        List<Category> categories = cd.getAll();

        request.getSession().setAttribute("ads", new AdsDAO().getAdsActive());
        request.setAttribute("md", md);
        request.setAttribute("categories", categories);
        request.setAttribute("series", series);
        request.setAttribute("phimles", phimles);
        request.setAttribute("shows", shows);
        request.setAttribute("hoathinhs", hoathinhs);
        request.setAttribute("news", md.getMovieNewUpdate());

        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
