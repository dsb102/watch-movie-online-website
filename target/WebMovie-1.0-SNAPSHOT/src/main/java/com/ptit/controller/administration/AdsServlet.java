package com.ptit.controller.administration;

import com.ptit.DAO.ActorDAO;
import com.ptit.DAO.AdsDAO;
import com.ptit.model.Ads;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "AdsServlet", value = "/adminstration/ads")
public class AdsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("ads", new AdsDAO().getAll());
        request.getRequestDispatcher("ads.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String name_ad = request.getParameter("name_ad");
        String link_ad = request.getParameter("link_ad");
        String img = request.getParameter("img");
        Ads ads = new Ads(0, name_ad, link_ad, img, 0, 0);
        if (name_ad != null && !name_ad.equals(""))
            new AdsDAO().insertAds(ads);
        response.sendRedirect("ads");
    }
}
