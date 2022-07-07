package com.ptit.DAO;

import com.ptit.dal.DBContext;
import com.ptit.model.Actor;
import com.ptit.model.Category;
import com.ptit.model.Episode;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EpisodeDAO extends DBContext {
    public List<Episode> getEpisodeByIDMovie(int id_movie) {
        List<Episode> episodes = new ArrayList<>();
        String sqlEpisode = "select * from EPISODE e, MOVIE m where m.id = e.id_movie and m.id = " + id_movie;
        try {
            PreparedStatement st = connection.prepareStatement(sqlEpisode);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                episodes.add(new Episode(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(7)));
            }
            return episodes;
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e);
        }
        return null;
    }

    public Episode getEpisodeByNameIDMovie(int id_movie, String name) {
        try {
            String sqlEpisode = "select * from EPISODE where [id_movie] = ? and [name] = ?";
            PreparedStatement st = connection.prepareStatement(sqlEpisode);
            st.setInt(1, id_movie);
            st.setString(2, name);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                return new Episode(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(7));
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e);
        }

        return null;
    }

    public int checkEpisodeName(String name, int id_movie) {
        Episode episode = new Episode();
        String sql = "select * from episode where name=N'" + name + "' and id_movie=" + id_movie;
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                String name_episode = rs.getString(2);
                int id_movie_check = rs.getInt(6);
                if (name_episode.equalsIgnoreCase(name) && id_movie_check == id_movie) return 1;
            }
            return 0;
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e);
        }
        return 0;
    }

    public void insertToEpisode(Episode episode, int id_movie) {
        try {
            String sql = "insert into episode values(?, ?, ?, ?, ?, 0)";
            PreparedStatement st = connection.prepareStatement(sql);
            if (checkEpisodeName(episode.getName(), id_movie) == 1) {
                System.out.println("Đã có tập này");
            } else {
                st.setString(1, episode.getName());
                st.setString(2, episode.getSlug());
                st.setString(3, episode.getFilename());
                st.setString(4, episode.getLink_embed());
                st.setInt(5, id_movie);
                st.executeUpdate();
                System.out.println("Insert to Episode Success");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Insert to Episode Fail");

        }
    }

    public void removeEpisodeByIDMovie(int id_movie) {
        String sql = "delete from Episode where id_movie=?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id_movie);
            st.executeUpdate();
            System.out.println("xóa bảng Episode thành công");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("xóa bảng Episode thất bại");
        }
    }

    public void updateView(int id, int view) {
        String sql = "update Episode set [view] = ? where id=?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, view);
            st.setInt(2, id);
            st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int countEpisode(int id_movie) {
        String sql = "  select count(e.id_movie) as [so_tap] from Movie m inner join Episode e on m.id = e.id_movie where m.id = ? group by m.id";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id_movie);
            ResultSet rs = st.executeQuery();
            if (rs.next())
                return rs.getInt(1);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e);
        }
        return 0;
    }

    public int getViewByYear(int year) {
        String sql = "select sum(sum_view) from Movie m inner join \n" +
                "\t(select e.id_movie, sum([view]) as [sum_view] from Episode e group by e.id_movie) as [v] \n" +
                "\ton m.id = v.id_movie where [year] = ? group by [year]";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, year);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e);
        }

        return 0;
    }

    public static void main(String[] args) {
//        for (Episode category : new EpisodeDAO().getEpisodeByIDMovie(2)) {
//            System.out.println(category);
//        }
        System.out.println(new EpisodeDAO().getViewByYear(2022));
//        System.out.println(new EpisodeDAO().checkEpisodeName("3", 3));
//        new EpisodeDAO().insertToEpisode(new Episode(0, "3", "3", "xin-cau-day-lop-truong-please-classmate-tap-3", "https://hd.1080phim.com/share/3bc412ad4910c19f6710515540190792", 0), 2);
//        System.out.println(new EpisodeDAO().getEpisodeByNameIDMovie(44, "Full"));
    }
}
