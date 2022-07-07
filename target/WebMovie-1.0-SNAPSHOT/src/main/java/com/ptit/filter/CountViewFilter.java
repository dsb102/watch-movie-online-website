package com.ptit.filter;

import com.ptit.DAO.AdsDAO;
import com.ptit.DAO.EpisodeDAO;
import com.ptit.DAO.MovieDAO;
import com.ptit.model.Ads;
import com.ptit.model.Episode;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "CountViewFilter", urlPatterns = {"/watch"})
public class CountViewFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {

    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        String query = httpServletRequest.getQueryString();
        if (query == null) {
            ((HttpServletResponse) response).sendRedirect("home");
            return;
        }
        int id;
        String name="";
        if (query.contains("&")) {
            String[] s = query.split("&");
            id = Integer.parseInt(s[0].split("=")[1]);
            name = s[1].split("=")[1];
        } else {
            id = Integer.parseInt(query.split("=")[1]);
            if (new EpisodeDAO().countEpisode(id) == 1) name = "Full";
            else name = "1";
        }
//        System.out.println("id: " + id);
//        System.out.println(name);
        Integer view;
        EpisodeDAO ed = new EpisodeDAO();
        Episode episode = ed.getEpisodeByNameIDMovie(id, name);
        if (episode != null) {
            view = episode.getView();
        }else {
            view = 0;
        }
//        System.out.println(view);
        if (httpServletRequest.getSession().getAttribute("user") != null)
            ed.updateView(episode.getId(), ++view);
        chain.doFilter(request, response);
    }
}
