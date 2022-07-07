package com.ptit.controller.administration;

import com.ptit.DAO.MovieDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "RemoveMovieServlet", value = "/adminstration/RemoveMovie")
public class RemoveMovieServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id_raw = request.getParameter("id");
        Integer id = Integer.parseInt(id_raw);
        new MovieDAO().removeMovieById(id);
        request.getRequestDispatcher("/adminstration/listphim").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
