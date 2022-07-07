package com.ptit.filter;

import com.ptit.DAO.AdsDAO;
import com.ptit.model.Ads;

import javax.servlet.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebFilter(filterName = "ViewAdsFilter", urlPatterns = {"/home"})
public class ViewAdsFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {

    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        AdsDAO ad = new AdsDAO();
        Ads ads = ad.getAdsActive();
        int view = ads.getView();
        ad.updateViewAds(ads.getId(), ++view);
        chain.doFilter(request, response);
    }
}
