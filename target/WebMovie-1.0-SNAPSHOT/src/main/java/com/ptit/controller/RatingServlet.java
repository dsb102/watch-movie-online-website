package com.ptit.controller;

import com.ptit.DAO.RatingDAO;
import com.ptit.model.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "RatingServlet", value = "/rate")
public class RatingServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int star = Integer.parseInt(request.getParameter("rating"));
        int id = Integer.parseInt(request.getParameter("id"));
        User user = (User) request.getSession().getAttribute("user");
        int user_id = user.getId();
        RatingDAO rd = new RatingDAO();
        rd.insertRating(user_id, id, star);
//        String page = (String) request.getSession().getAttribute("uriqueryCurrentUser");
//        System.out.println(page);
//        response.sendRedirect("watch?id=" + id);
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
        PrintWriter out = response.getWriter();
        out.println(rate1+"," +rate2+"," +rate3+"," +rate4+"," +rate5+"," +rd.getAverageStar(id));

    }
}
