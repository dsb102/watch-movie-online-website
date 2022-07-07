package com.ptit.controller.administration;

import com.ptit.DAO.MovieDAO;
import com.ptit.model.Movie;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "EditMovieServlet", value = "/adminstration/UpdateMovie")
public class UpdateMovieServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id_raw = request.getParameter("id");
        Integer id = Integer.parseInt(id_raw);
        Movie movie = new MovieDAO().getFullMovieByID(id);
        request.setAttribute("movie", movie);
        request.setAttribute("actors", movie.getActors());
        request.setAttribute("categories", movie.getCategorys());
        request.setAttribute("episodes", movie.getEpisodes());
        request.setAttribute("id_movie", id);
        request.getRequestDispatcher("EditMovie.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String origil_name = request.getParameter("orinal_name");
        String thumb_url = request.getParameter("thumb_url");
        String trailer = request.getParameter("trailer_url");
        String content = request.getParameter("content");
        String episode_total = request.getParameter("episode_total");
        String quality = request.getParameter("quality");
        int year = Integer.parseInt(request.getParameter("year"));
        String director = request.getParameter("director");
        System.out.println(id);
        System.out.println(name);
        System.out.println(origil_name);
        new MovieDAO().updateInfo(id, name, origil_name, thumb_url, trailer, content, episode_total, quality, year, director);
//        request.getRequestDispatcher("listphim.jsp").forward(request, response);
        response.sendRedirect("listphim");
    }
}
