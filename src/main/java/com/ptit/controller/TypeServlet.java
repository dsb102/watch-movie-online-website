package com.ptit.controller;

import com.ptit.DAO.CategoryDAO;
import com.ptit.DAO.MovieDAO;
import com.ptit.DAO.UserDAO;
import com.ptit.model.Category;
import com.ptit.model.Movie;
import com.ptit.model.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "SerieServlet", value = {"/serie", "/single", "/shows", "/cartoon", "/favorite"})
public class TypeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String context = request.getRequestURI();
        MovieDAO md = new MovieDAO();
        CategoryDAO cd = new CategoryDAO();
        List<Movie> series = md.getMovieByTypeTop8("series");
        List<Movie> phimles = md.getMovieByTypeTop8("single");
        List<Movie> shows = md.getMovieByTypeTop8("tvshows");
        List<Movie> hoathinhs = md.getMovieByTypeTop8("hoathinh");
        List<Category> categories = cd.getAll();

        request.setAttribute("md", md);
        request.setAttribute("categories", categories);

        request.setAttribute("phimles", phimles);
        request.setAttribute("shows", shows);
        request.setAttribute("hoathinhs", hoathinhs);
        HttpSession session = request.getSession();
        if (context.contains("serie")) {

            session.setAttribute("URI", "serie");
            String para = request.getParameter("para");
            PrintWriter out = response.getWriter();
            request.setAttribute("series", series);

        } else if (context.contains("single")) {
            session.setAttribute("URI", "single");
            String para = request.getParameter("para");
            request.setAttribute("single", phimles);
        } else if (context.contains("shows")) {
            session.setAttribute("URI", "shows");
            String para = request.getParameter("para");
            request.setAttribute("shows", shows);
        } else if (context.contains("cartoon")) {
            session.setAttribute("URI", "cartoon");
            String para = request.getParameter("para");
            request.setAttribute("cartoon", hoathinhs);

        } else if (context.contains("favorite")) {
            session.setAttribute("URI", "favorite");
            String para = request.getParameter("para");
            request.setAttribute("favorite", new UserDAO().getMovieByUser(((User) request.getSession().getAttribute("user")).getId()));
        }
        request.setAttribute("context", context);
        request.getRequestDispatcher("danhsach.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
