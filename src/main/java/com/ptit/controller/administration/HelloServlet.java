package com.ptit.controller.administration;

import com.ptit.DAO.EpisodeDAO;
import com.ptit.DAO.MovieDAO;
import com.ptit.DAO.RatingDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "HelloServlet", value = "/adminstration/menu")
public class HelloServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        MovieDAO md = new MovieDAO();
        request.setAttribute("single", md.getViewByType("single"));
        request.setAttribute("series", md.getViewByType("series"));
        request.setAttribute("tvshows", md.getViewByType("tvshows"));
        request.setAttribute("hoathinh", md.getViewByType("hoathinh"));

        EpisodeDAO episodeDAO = new EpisodeDAO();
        request.setAttribute("year_2015", episodeDAO.getViewByYear(2015));
        request.setAttribute("year_2016", episodeDAO.getViewByYear(2016));
        request.setAttribute("year_2017", episodeDAO.getViewByYear(2017));
        request.setAttribute("year_2018", episodeDAO.getViewByYear(2018));
        request.setAttribute("year_2019", episodeDAO.getViewByYear(2019));
        request.setAttribute("year_2020", episodeDAO.getViewByYear(2020));
        request.setAttribute("year_2021", episodeDAO.getViewByYear(2021));
        request.setAttribute("year_2022", episodeDAO.getViewByYear(2022));



        request.setAttribute("movieSingle", new RatingDAO().getMovieSumAvgStarByType("single"));
        request.setAttribute("movieSeries", new RatingDAO().getMovieSumAvgStarByType("series"));
        request.setAttribute("movieTvshows", new RatingDAO().getMovieSumAvgStarByType("tvshows"));
        request.setAttribute("movieHoathinh", new RatingDAO().getMovieSumAvgStarByType("hoathinh"));

        request.getRequestDispatcher("menu.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
