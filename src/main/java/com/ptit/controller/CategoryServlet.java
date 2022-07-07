package com.ptit.controller;

import com.ptit.DAO.ActorDAO;
import com.ptit.DAO.CategoryDAO;
import com.ptit.DAO.MovieDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "CategoryServlet", value = {"/category", "/actor"})
public class CategoryServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id_raw = request.getParameter("id");
        CategoryDAO cd = new CategoryDAO();
        String context = request.getRequestURI();
        MovieDAO md = new MovieDAO();
        Integer id = Integer.parseInt(id_raw);
        if (context.contains("category")) {
            if (id == null) {
                request.setAttribute("category", md.getMovieByIDCategory(1));
            } else {
                request.setAttribute("category", cd.getCategoryByID(id));
                request.setAttribute("movie", md.getMovieByIDCategory(id));
            }
            request.setAttribute("categories", cd.getAll());
        }else if (context.contains("actor")) {
            request.setAttribute("actor", new ActorDAO().getActorByID(id));
            request.setAttribute("movie", md.getMovieByActorID(id));
        }

        request.getRequestDispatcher("category.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
