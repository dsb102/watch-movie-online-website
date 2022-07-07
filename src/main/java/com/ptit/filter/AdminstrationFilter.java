package com.ptit.filter;

import com.ptit.model.User;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "AdminstrationFilter", urlPatterns = {"/adminstration/*"})
public class AdminstrationFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        HttpSession session = httpServletRequest.getSession();
        User user = (User) session.getAttribute("user");
        String page = "";
        if (user == null) {
            page = "login";
        }
        else if (user.getRole() == 1) {
            page = "../404.jsp";
        }
        if (user == null || user.getRole() == 1)
            httpServletResponse.sendRedirect(page);
        else
            chain.doFilter(request, response);
    }
}
