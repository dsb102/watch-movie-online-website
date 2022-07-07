package com.ptit.controller.administration;

import com.ptit.controller.addition.UploadMovie;
import org.json.simple.parser.ParseException;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "UploadPageServlet", value = "/adminstration/upload-page")
public class UploadPageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String page_raw = request.getParameter("page");
        int page = Integer.parseInt(page_raw);
        if (page == 0) {

        } else {
            UploadMovie uploadMovie = new UploadMovie();
            try {
                uploadMovie.UploadPage(page);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        response.sendRedirect("listphim");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
