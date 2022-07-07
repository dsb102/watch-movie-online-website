package com.ptit.controller.administration;

import com.ptit.DAO.CategoryDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "UpdateCategoryServlet", value = "/adminstration/EditCategory")
public class UpdateCategoryServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id_raw = request.getParameter("id");
        Integer id = Integer.parseInt(id_raw);
        request.setAttribute("category", new CategoryDAO().getCategoryByID(id));
        request.getRequestDispatcher("EditCategory.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String id_raw = request.getParameter("id");
        Integer id = Integer.parseInt(id_raw);
        String name = request.getParameter("name");
        new CategoryDAO().updateNameCategory(id, name);
        response.sendRedirect("listcategory");
    }
}
