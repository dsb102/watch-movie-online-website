package com.ptit.controller;

import com.ptit.DAO.MovieDAO;
import org.json.simple.parser.ParseException;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "AddMovieServlet", value = "/adminstration/add")
public class AddMovieServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String json = request.getParameter("json");
        if (json == null || json.equals("")) {
            request.setAttribute("message", "Vui lòng nhập file JSON");
            request.getRequestDispatcher("AddMovie.jsp").forward(request, response);
        }else {
            try {
                request.setAttribute("success", "Add Movie Success");
                new MovieDAO().insertToFullMovie(json);
            } catch (ParseException e) {
                e.printStackTrace();
                request.setAttribute("success", "Add Movie Fail");
            }
            request.getRequestDispatcher("AddMovie.jsp").forward(request, response);
        }
    }
}
