package com.ptit.controller;

import com.ptit.DAO.CategoryDAO;
import com.ptit.DAO.MovieDAO;
import com.ptit.DAO.RatingDAO;
import com.ptit.DAO.UserDAO;
import com.ptit.model.Episode;
import com.ptit.model.Movie;
import com.ptit.model.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "WatchServlet", value = "/watch")
public class WatchServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id_raw = request.getParameter("id");
        String name_episode = request.getParameter("name");
        String url = String.valueOf(request.getRequestURL());
        Integer id = Integer.parseInt(id_raw);
        MovieDAO md = new MovieDAO();
        Movie movie = md.getFullMovieByID(id);
        if (name_episode == null) {
            request.setAttribute("episode", movie.getEpisodes().get(0));
            request.setAttribute("tap", "1");
        }
        request.setAttribute("movie", movie);
        for (Episode episode:movie.getEpisodes()) {
            if (episode.getName().equals(name_episode)) {
                request.setAttribute("episode", episode);
            }
        }
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        request.setAttribute("checkFavorite", new UserDAO().checkFavorite(user.getId(), id));
        Movie movieCurrent = md.getMovieByID(id);
        request.setAttribute("ralatedMovie", md.getMovieByView(movieCurrent.getType()));

        RatingDAO rd = new RatingDAO();
        Integer rate1 = rd.getQuantityStar(1, id);
        Integer rate2 = rd.getQuantityStar(2, id);
        Integer rate3 = rd.getQuantityStar(3, id);
        Integer rate4 = rd.getQuantityStar(4, id);
        Integer rate5 = rd.getQuantityStar(5, id);

        request.setAttribute("rate1", rate1);
        request.setAttribute("rate2", rate2);
        request.setAttribute("rate3", rate3);
        request.setAttribute("rate4", rate4);
        request.setAttribute("rate5", rate5);
        request.setAttribute("avg", rd.getAverageStar(id));

        request.setAttribute("relation-movie", md.getMovieByType(movie.getType()));
        request.setAttribute("tap", (movie.getEpisodes().size() > 1) ? name_episode : "1");
        request.setAttribute("categories", new CategoryDAO().getAll());
        request.setAttribute("linkComment", "http://127.0.0.1:8080/WebMovie_war_exploded/watch?id=7" + id +"&amp;name="+ name_episode);
        request.setAttribute("contextPath", url);

        request.getRequestDispatcher("xem-phim.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
