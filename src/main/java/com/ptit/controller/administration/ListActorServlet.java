package com.ptit.controller.administration;

import com.ptit.DAO.ActorDAO;
import com.ptit.model.Actor;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ListActorServlet", value = "/adminstration/listactor")
public class ListActorServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ActorDAO ad = new ActorDAO();
        List<Actor> actors = ad.getAll();
        request.setAttribute("actorss", actors);
        request.getRequestDispatcher("listactor.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
