package com.ptit.controller.administration;

import com.ptit.controller.addition.UploadMovie;
import org.json.simple.parser.ParseException;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "UploadAllServlet", value = "/adminstration/upload-all")
public class UploadAllServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UploadMovie uploadMovie = new UploadMovie();
        for (int i = 1; i <= 453; i++) {
            try {
                uploadMovie.UploadPage(i);
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
