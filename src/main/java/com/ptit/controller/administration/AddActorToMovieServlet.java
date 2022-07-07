package com.ptit.controller.administration;

import com.ptit.DAO.ActorDAO;
import com.ptit.DAO.MovieDAO;
import com.ptit.model.Actor;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "AddActorToMovieServlet", value = "/adminstration/AddActor")
public class AddActorToMovieServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String name = request.getParameter("name-actor");
        int id_movie = Integer.parseInt(request.getParameter("id_movie-actor"));
        ActorDAO ad =  new ActorDAO();
        int id_actor = ad.insertToActor(new Actor(0, name));
        new MovieDAO().insertToActorMovie(id_actor, id_movie);
        response.sendRedirect("listphim");
    }
}
