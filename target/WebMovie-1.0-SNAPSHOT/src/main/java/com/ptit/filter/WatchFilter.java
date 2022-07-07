package com.ptit.filter;

import com.ptit.model.User;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "WatchFilter", urlPatterns = {"/watch"})
public class WatchFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpSession session = ((HttpServletRequest) request).getSession();
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        if (((User) session.getAttribute("user")) == null) {
            session.setAttribute("uriqueryCurrentUser", httpServletRequest.getRequestURI() + "?" + httpServletRequest.getQueryString());
            httpServletResponse.sendRedirect("login");
        } else
            chain.doFilter(request, response);
    }
}
