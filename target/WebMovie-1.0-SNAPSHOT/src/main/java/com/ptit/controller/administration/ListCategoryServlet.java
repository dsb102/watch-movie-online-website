package com.ptit.controller.administration;

import com.ptit.DAO.CategoryDAO;
import com.ptit.model.Category;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ListCategoryServlet", value = "/adminstration/listcategory")
public class ListCategoryServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CategoryDAO cd = new CategoryDAO();
        List<Category> categories = cd.getAll();
        request.setAttribute("categories", categories);
        request.getRequestDispatcher("listcategory.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
