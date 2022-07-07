package com.ptit.controller.administration;

import com.ptit.DAO.ActorDAO;
import com.ptit.DAO.MovieDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "UpdateActorMovieServlet", value = "/adminstration/UpdateActor")
public class UpdateActorMovieServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id_actor = Integer.parseInt(request.getParameter("id_actor"));
        int id_movie = Integer.parseInt(request.getParameter("id_movie"));
        new MovieDAO().removeActorMovie(id_actor, id_movie);
        response.sendRedirect("listphim");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
