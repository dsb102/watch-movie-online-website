package com.ptit.controller;

import com.ptit.DAO.MovieDAO;
import com.ptit.model.Movie;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "LoadMoreServlet", value = "/load")
public class LoadMoreServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        MovieDAO md = new MovieDAO();
        String context = request.getRequestURI();
        PrintWriter out = response.getWriter();
        String start_raw = request.getParameter("start");
        String para = request.getParameter("para");
        HttpSession session = request.getSession();
        String Uri = (String) session.getAttribute("URI");

        if (Uri.contains("serie")) {
            if (start_raw != null) {
                Integer start = Integer.parseInt(start_raw);
                List<Movie> series = md.getMovieByTypeNext8("series", start);
                for (Movie movie : series) {
                    out.println("<div class=\"movie-list-item movie-list-quantity\">\n" +
                "                    <a class=\"movie-list-item-img\" href=\"watch?id=" + movie.getId() + "\"\n" +
                "                       style=\"background-image: url('" + movie.getThuml_url() + "')\"></a>\n" +
                "                    <a class=\"movie-list-item-title\" href=\"watch?id=" + movie.getId() + "\"\n" +
                "                       target=\"_blank\">" + movie.getName() + "</a>\n" +
                "                </div>");
                }

            }
            if (para != null) {
                if (para.equals("2022")) {
                    List<Movie> series = md.getMovieByTypeYear("series", 2022);
                    for (Movie movie : series) {
                        out.println("<div class=\"movie-list-item movie-list-quantity\">\n" +
                                "                    <a class=\"movie-list-item-img\" href=\"watch?id=" + movie.getId() + "\"\n" +
                                "                       style=\"background-image: url('" + movie.getThuml_url() + "')\"></a>\n" +
                                "                    <a class=\"movie-list-item-title\" href=\"watch?id=" + movie.getId() + "\"\n" +
                                "                       target=\"_blank\">" + movie.getName() + "</a>\n" +
                                "                </div>");
                    }
                }else if (para.equals("tinhcam")) {
                    List<Movie> series = md.getMovieByTypeCategory("series", "Tình cảm");
                    for (Movie movie : series) {
                        out.println("<div class=\"movie-list-item movie-list-quantity\">\n" +
                                "                    <a class=\"movie-list-item-img\" href=\"watch?id=" + movie.getId() + "\"\n" +
                                "                       style=\"background-image: url('" + movie.getThuml_url() + "')\"></a>\n" +
                                "                    <a class=\"movie-list-item-title\" href=\"watch?id=" + movie.getId() + "\"\n" +
                                "                       target=\"_blank\">" + movie.getName() + "</a>\n" +
                                "                </div>");
                    }
                }else if (para.equals("hanhdong")) {
                    List<Movie> series = md.getMovieByTypeCategory("series", "Hành động");
                    for (Movie movie : series) {
                        out.println("<div class=\"movie-list-item movie-list-quantity\">\n" +
                                "                    <a class=\"movie-list-item-img\" href=\"watch?id=" + movie.getId() + "\"\n" +
                                "                       style=\"background-image: url('" + movie.getThuml_url() + "')\"></a>\n" +
                                "                    <a class=\"movie-list-item-title\" href=\"watch?id=" + movie.getId() + "\"\n" +
                                "                       target=\"_blank\">" + movie.getName() + "</a>\n" +
                                "                </div>");
                    }
                }else if (para.equals("view")) {
                    List<Movie> series = md.getMovieByView("series");
                    for (Movie movie : series) {
                        out.println("<div class=\"movie-list-item movie-list-quantity\">\n" +
                                "                    <a class=\"movie-list-item-img\" href=\"watch?id=" + movie.getId() + "\"\n" +
                                "                       style=\"background-image: url('" + movie.getThuml_url() + "')\"></a>\n" +
                                "                    <a class=\"movie-list-item-title\" href=\"watch?id=" + movie.getId() + "\"\n" +
                                "                       target=\"_blank\">" + movie.getName() + "</a>\n" +
                                "                </div>");
                    }
                }
            }
        }
        else if(Uri.contains("single")) {
            if (start_raw != null) {
                Integer start = Integer.parseInt(start_raw);
                List<Movie> series = md.getMovieByTypeNext8("single", start);
                for (Movie movie : series) {
                    out.println("<div class=\"movie-list-item movie-list-quantity1\">\n" +
                            "                    <a class=\"movie-list-item-img\" href=\"watch?id=" + movie.getId() + "\"\n" +
                            "                       style=\"background-image: url('" + movie.getThuml_url() + "')\"></a>\n" +
                            "                    <a class=\"movie-list-item-title\" href=\"watch?id=" + movie.getId() + "\"\n" +
                            "                       target=\"_blank\">" + movie.getName() + "</a>\n" +
                            "                </div>");
                }

            }
            if (para != null) {
                if (para.equals("2022")) {
                    List<Movie> series = md.getMovieByTypeYear("single", 2022);
                    for (Movie movie : series) {
                        out.println("<div class=\"movie-list-item movie-list-quantity1\">\n" +
                                "                    <a class=\"movie-list-item-img\" href=\"watch?id=" + movie.getId() + "\"\n" +
                                "                       style=\"background-image: url('" + movie.getThuml_url() + "')\"></a>\n" +
                                "                    <a class=\"movie-list-item-title\" href=\"watch?id=" + movie.getId() + "\"\n" +
                                "                       target=\"_blank\">" + movie.getName() + "</a>\n" +
                                "                </div>");
                    }
                }else if (para.equals("tinhcam")) {
                    List<Movie> series = md.getMovieByTypeCategory("single", "Tình cảm");
                    for (Movie movie : series) {
                        out.println("<div class=\"movie-list-item movie-list-quantity1\">\n" +
                                "                    <a class=\"movie-list-item-img\" href=\"watch?id=" + movie.getId() + "\"\n" +
                                "                       style=\"background-image: url('" + movie.getThuml_url() + "')\"></a>\n" +
                                "                    <a class=\"movie-list-item-title\" href=\"watch?id=" + movie.getId() + "\"\n" +
                                "                       target=\"_blank\">" + movie.getName() + "</a>\n" +
                                "                </div>");
                    }
                }else if (para.equals("hanhdong")) {
                    List<Movie> series = md.getMovieByTypeCategory("single", "Hành động");
                    for (Movie movie : series) {
                        out.println("<div class=\"movie-list-item movie-list-quantity1\">\n" +
                                "                    <a class=\"movie-list-item-img\" href=\"watch?id=" + movie.getId() + "\"\n" +
                                "                       style=\"background-image: url('" + movie.getThuml_url() + "')\"></a>\n" +
                                "                    <a class=\"movie-list-item-title\" href=\"watch?id=" + movie.getId() + "\"\n" +
                                "                       target=\"_blank\">" + movie.getName() + "</a>\n" +
                                "                </div>");
                    }
                }else if (para.equals("view")) {
                    List<Movie> series = md.getMovieByView("single");
                    for (Movie movie : series) {
                        out.println("<div class=\"movie-list-item movie-list-quantity1\">\n" +
                                "                    <a class=\"movie-list-item-img\" href=\"watch?id=" + movie.getId() + "\"\n" +
                                "                       style=\"background-image: url('" + movie.getThuml_url() + "')\"></a>\n" +
                                "                    <a class=\"movie-list-item-title\" href=\"watch?id=" + movie.getId() + "\"\n" +
                                "                       target=\"_blank\">" + movie.getName() + "</a>\n" +
                                "                </div>");
                    }
                }
            }
        }else if (Uri.contains("shows")) {
            if (start_raw != null) {
                Integer start = Integer.parseInt(start_raw);
                List<Movie> series = md.getMovieByTypeNext8("tvshows", start);
                for (Movie movie : series) {
                    out.println("<div class=\"movie-list-item movie-list-quantity2\">\n" +
                            "                    <a class=\"movie-list-item-img\" href=\"watch?id=" + movie.getId() + "\"\n" +
                            "                       style=\"background-image: url('" + movie.getThuml_url() + "')\"></a>\n" +
                            "                    <a class=\"movie-list-item-title\" href=\"watch?id=" + movie.getId() + "\"\n" +
                            "                       target=\"_blank\">" + movie.getName() + "</a>\n" +
                            "                </div>");
                }

            }
            if (para != null) {
                if (para.equals("2022")) {
                    List<Movie> series = md.getMovieByTypeYear("tvshows", 2022);
                    for (Movie movie : series) {
                        out.println("<div class=\"movie-list-item movie-list-quantity2\">\n" +
                                "                    <a class=\"movie-list-item-img\" href=\"watch?id=" + movie.getId() + "\"\n" +
                                "                       style=\"background-image: url('" + movie.getThuml_url() + "')\"></a>\n" +
                                "                    <a class=\"movie-list-item-title\" href=\"watch?id=" + movie.getId() + "\"\n" +
                                "                       target=\"_blank\">" + movie.getName() + "</a>\n" +
                                "                </div>");
                    }
                }else if (para.equals("tinhcam")) {
                    List<Movie> series = md.getMovieByTypeCategory("tvshows", "Tình cảm");
                    for (Movie movie : series) {
                        out.println("<div class=\"movie-list-item movie-list-quantity2\">\n" +
                                "                    <a class=\"movie-list-item-img\" href=\"watch?id=" + movie.getId() + "\"\n" +
                                "                       style=\"background-image: url('" + movie.getThuml_url() + "')\"></a>\n" +
                                "                    <a class=\"movie-list-item-title\" href=\"watch?id=" + movie.getId() + "\"\n" +
                                "                       target=\"_blank\">" + movie.getName() + "</a>\n" +
                                "                </div>");
                    }
                }else if (para.equals("hanhdong")) {
                    List<Movie> series = md.getMovieByTypeCategory("tvshows", "Hành động");
                    for (Movie movie : series) {
                        out.println("<div class=\"movie-list-item movie-list-quantity2\">\n" +
                                "                    <a class=\"movie-list-item-img\" href=\"watch?id=" + movie.getId() + "\"\n" +
                                "                       style=\"background-image: url('" + movie.getThuml_url() + "')\"></a>\n" +
                                "                    <a class=\"movie-list-item-title\" href=\"watch?id=" + movie.getId() + "\"\n" +
                                "                       target=\"_blank\">" + movie.getName() + "</a>\n" +
                                "                </div>");
                    }
                }else if (para.equals("view")) {
                    List<Movie> series = md.getMovieByView("tvshows");
                    for (Movie movie : series) {
                        out.println("<div class=\"movie-list-item movie-list-quantity2\">\n" +
                                "                    <a class=\"movie-list-item-img\" href=\"watch?id=" + movie.getId() + "\"\n" +
                                "                       style=\"background-image: url('" + movie.getThuml_url() + "')\"></a>\n" +
                                "                    <a class=\"movie-list-item-title\" href=\"watch?id=" + movie.getId() + "\"\n" +
                                "                       target=\"_blank\">" + movie.getName() + "</a>\n" +
                                "                </div>");
                    }
                }
            }
        }else if (Uri.contains("cartoon")) {
            if (start_raw != null) {
                Integer start = Integer.parseInt(start_raw);
                List<Movie> series = md.getMovieByTypeNext8("hoathinh", start);
                for (Movie movie : series) {
                    out.println("<div class=\"movie-list-item movie-list-quantity3\">\n" +
                            "                    <a class=\"movie-list-item-img\" href=\"watch?id=" + movie.getId() + "\"\n" +
                            "                       style=\"background-image: url('" + movie.getThuml_url() + "')\"></a>\n" +
                            "                    <a class=\"movie-list-item-title\" href=\"watch?id=" + movie.getId() + "\"\n" +
                            "                       target=\"_blank\">" + movie.getName() + "</a>\n" +
                            "                </div>");
                }

            }
            if (para != null) {
                if (para.equals("2022")) {
                    List<Movie> series = md.getMovieByTypeYear("hoathinh", 2022);
                    for (Movie movie : series) {
                        out.println("<div class=\"movie-list-item movie-list-quantity3\">\n" +
                                "                    <a class=\"movie-list-item-img\" href=\"watch?id=" + movie.getId() + "\"\n" +
                                "                       style=\"background-image: url('" + movie.getThuml_url() + "')\"></a>\n" +
                                "                    <a class=\"movie-list-item-title\" href=\"watch?id=" + movie.getId() + "\"\n" +
                                "                       target=\"_blank\">" + movie.getName() + "</a>\n" +
                                "                </div>");
                    }
                }else if (para.equals("tinhcam")) {
                    List<Movie> series = md.getMovieByTypeCategory("hoathinh", "Tình cảm");
                    for (Movie movie : series) {
                        out.println("<div class=\"movie-list-item movie-list-quantity3\">\n" +
                                "                    <a class=\"movie-list-item-img\" href=\"watch?id=" + movie.getId() + "\"\n" +
                                "                       style=\"background-image: url('" + movie.getThuml_url() + "')\"></a>\n" +
                                "                    <a class=\"movie-list-item-title\" href=\"watch?id=" + movie.getId() + "\"\n" +
                                "                       target=\"_blank\">" + movie.getName() + "</a>\n" +
                                "                </div>");
                    }
                }else if (para.equals("hanhdong")) {
                    List<Movie> series = md.getMovieByTypeCategory("hoathinh", "Hành động");
                    for (Movie movie : series) {
                        out.println("<div class=\"movie-list-item movie-list-quantity3\">\n" +
                                "                    <a class=\"movie-list-item-img\" href=\"watch?id=" + movie.getId() + "\"\n" +
                                "                       style=\"background-image: url('" + movie.getThuml_url() + "')\"></a>\n" +
                                "                    <a class=\"movie-list-item-title\" href=\"watch?id=" + movie.getId() + "\"\n" +
                                "                       target=\"_blank\">" + movie.getName() + "</a>\n" +
                                "                </div>");
                    }
                }else if (para.equals("view")) {
                    List<Movie> series = md.getMovieByView("hoathinh");
                    for (Movie movie : series) {
                        out.println("<div class=\"movie-list-item movie-list-quantity3\">\n" +
                                "                    <a class=\"movie-list-item-img\" href=\"watch?id=" + movie.getId() + "\"\n" +
                                "                       style=\"background-image: url('" + movie.getThuml_url() + "')\"></a>\n" +
                                "                    <a class=\"movie-list-item-title\" href=\"watch?id=" + movie.getId() + "\"\n" +
                                "                       target=\"_blank\">" + movie.getName() + "</a>\n" +
                                "                </div>");
                    }
                }
            }
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
