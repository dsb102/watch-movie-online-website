package com.ptit.DAO;

import com.ptit.controller.addition.MovieViewStar;
import com.ptit.dal.DBContext;
import com.ptit.model.Rating;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RatingDAO extends DBContext {

    public Rating checkRating(int user_id, int movie_id) {
        // return Rating nếu đã rate else null
        String sql = "select * from Rating where [user_id] = ? and [movie_id] = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, user_id);
            st.setInt(2, movie_id);
            ResultSet rs =  st.executeQuery();
            if (rs.next()) {
                return new Rating(rs.getInt(1), rs.getInt(2), rs.getInt(3));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("xóa bảng Episode thất bại");
        }
        return null;
    }

    public int getQuantityStar(int star, int movie_id) {
        try {
            String sql = "select count(*) as [count] from Rating where [stars] = ? and movie_id = ?";
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, star);
            st.setInt(2, movie_id);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
            }
        }catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e);
        }
        return 0;
    }

    public double getAverageStar(int movie_id) {
        try {
            String sql = "Select\n" +
                    "    AVG(Cast(stars as Float)),\n" +
                    "    SUM(stars)\n" +
                    "From\n" +
                    "    Rating where [movie_id] = ?";
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, movie_id);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                return rs.getDouble(1);
            }
        }catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e);
        }
        return 0;
    }

    public void updateRating(int user_id, int movie_id, int star) {
        String sql = "update Rating set [stars] = ? where [user_id] = ? and [movie_id] = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, star);
            st.setInt(2, user_id);
            st.setInt(3, movie_id);
            st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertRating(int user_id, int movie_id, int star) {
        if (checkRating(user_id, movie_id) == null) {
            String sql = "insert into Rating values(?, ?, ?)";
            try {
                PreparedStatement st = connection.prepareStatement(sql);
                st.setInt(1, user_id);
                st.setInt(2, movie_id);
                st.setInt(3, star);
                st.executeUpdate();
                System.out.println("Thêm vào Rating thành công");
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("Thêm vào Rating thất bại");
            }
        } else {
            updateRating(user_id, movie_id, star);
        }
    }

    public List<MovieViewStar> getMovieSumAvgStarByType(String type) {
        List<MovieViewStar> movieViewStars = new ArrayList<>();
        String sql = "select top(10) m.id, m.name, e.sum, ra.avg_star from Movie m inner join \n" +
                "                    (select id_movie, sum([view]) as [sum] from Episode group by \n" +
                "                    id_movie ) as e on m.id = e.id_movie\n" +
                "\t\t\t\t\tinner join (Select r.movie_id, AVG(Cast(stars as Float)) as [avg_star] From Rating r group by r.movie_id) as ra\n" +
                "\t\t\t\t\ton e.id_movie = ra.movie_id where m.type = ? order by e.sum desc, ra.avg_star desc";

        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, type);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                movieViewStars.add(new MovieViewStar(rs.getString(2), rs.getInt(3), Math.round(rs.getDouble(4) * 10.0)/10.0));
            }
        }catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e);
        }
        return movieViewStars;
    }

    public static void main(String[] args) {
        for (MovieViewStar movieViewStar : new RatingDAO().getMovieSumAvgStarByType("series"))
            System.out.println(movieViewStar);
    }
}
