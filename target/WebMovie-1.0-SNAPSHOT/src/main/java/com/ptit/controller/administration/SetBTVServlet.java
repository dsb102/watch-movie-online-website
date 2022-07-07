package com.ptit.controller.administration;

import com.ptit.DAO.UserDAO;
import com.ptit.model.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "SetBTVServlet", value = "/adminstration/setBTV")
public class SetBTVServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String page = "";
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        if (user.getRole() != 3) {
            page = "../404.jsp";
        } else {
            String id_raw = request.getParameter("id");
            Integer id = Integer.parseInt(id_raw);

            new UserDAO().setUserBTV(id);
            System.out.println("đã thêm btv");

            page = "listuser";
        }
        request.getRequestDispatcher(page).forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
