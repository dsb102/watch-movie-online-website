package com.ptit.controller.administration;

import com.ptit.DAO.ActorDAO;
import com.ptit.DAO.MovieDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "EditActorMovieServlet", value = "/adminstration/EditActor")
public class EditActorMovieServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id_actor = Integer.parseInt(request.getParameter("id_actor"));
        int id_movie = Integer.parseInt(request.getParameter("id_movie"));
        request.setAttribute("id_movie", id_movie);
        ActorDAO ad = new ActorDAO();
        request.setAttribute("actor", ad.getActorByID(id_actor));
        request.getRequestDispatcher("UpdateActorMovie.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        int id_actor = Integer.parseInt(request.getParameter("id_actor"));
        String name_actor = request.getParameter("name_actor");
        int id_movie = Integer.parseInt(request.getParameter("id_movie"));
        new ActorDAO().updateActorByID(id_actor, name_actor);
        response.sendRedirect("listphim");
    }
}
