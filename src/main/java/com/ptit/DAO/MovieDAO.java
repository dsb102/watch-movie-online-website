package com.ptit.DAO;

import com.ptit.dal.DBContext;
import com.ptit.model.Actor;
import com.ptit.model.Category;
import com.ptit.model.Episode;
import com.ptit.model.Movie;
import org.json.simple.parser.ParseException;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static com.ptit.handlerJson.ParseJson.handlerJson;

public class MovieDAO extends DBContext {


    public List<Movie> getMovieNewUpdate() {
        List<Movie> movies = new ArrayList<>();
        String sql = "select * from MOVIE order by id desc offset 1 rows fetch next 10 rows only";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                movies.add(new Movie(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11), rs.getString(12), rs.getString(13), rs.getString(14), rs.getInt(15), rs.getString(16), rs.getString(17)));
            }
            return movies;
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e);
        }
        return null;
    }

    public List<Movie> getAll() {
        List<Movie> movies = new ArrayList();
        String sql = "select * from Movie";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                movies.add(new Movie(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11), rs.getString(12), rs.getString(13), rs.getString(14), rs.getInt(15), rs.getString(16), rs.getString(17)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e);
        }
        return movies;
    }

    public List<Movie> getMovieLikeName(String name) {
        List<Movie> movies = new ArrayList();
        String sql = "select * from Movie where [name] like N'%" + name + "%'";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                movies.add(new Movie(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11), rs.getString(12), rs.getString(13), rs.getString(14), rs.getInt(15), rs.getString(16), rs.getString(17)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e);
        }
        return movies;
    }

    public List<Movie> getMovieByTypeTop8(String type) {
        List<Movie> movies = new ArrayList<>();
        String sql = "select top 8 * from MOVIE where type='" + type + "'";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                movies.add(new Movie(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11), rs.getString(12), rs.getString(13), rs.getString(14), rs.getInt(15), rs.getString(16), rs.getString(17)));
            }
            return movies;
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e);
        }
        return null;
    }

    public List<Movie> getMovieByTypeNext8(String type, int start) {
        List<Movie> movies = new ArrayList<>();
        String sql = "select * from MOVIE where type=? order by id offset ? rows fetch next 8 rows only";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, type);
            st.setInt(2, start);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                movies.add(new Movie(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11), rs.getString(12), rs.getString(13), rs.getString(14), rs.getInt(15), rs.getString(16), rs.getString(17)));
            }
            return movies;
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e);
        }
        return null;
    }


    public List<Movie> getMovieByType(String type) {
        List<Movie> movies = new ArrayList<>();
        String sql = "select * from MOVIE where type='" + type + "'";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                movies.add(new Movie(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11), rs.getString(12), rs.getString(13), rs.getString(14), rs.getInt(15), rs.getString(16), rs.getString(17)));
            }
            return movies;
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e);
        }
        return null;
    }

    public void removeActorMovieByID(int id_movie){
        String sql = "delete from Actor_Movie where movie_id=?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id_movie);
            st.executeUpdate();
            System.out.println("x??a b???ng act_mov th??nh c??ng");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("x??a b???ng cat_mov th???t b???i");
        }
    }
    public void removeCategoryMovieByID(int id_movie) {
        String sql = "delete from Category_Movie where movie_id=?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id_movie);
            st.executeUpdate();
            System.out.println("x??a b???ng cat_mov th??nh c??ng");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e);
            System.out.println("x??a b???ng cat_mov th???t b???i");
        }
    }


    public void removeMovie(int id_movie) {
        String sql = "delete from Movie where id=?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id_movie);
            st.executeUpdate();
            System.out.println("x??a b???ng Movie th??nh c??ng");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("x??a b???ng Movie th???t b???i");
        }
    }

    public void removeMovieById(int id_movie) {
        removeActorMovieByID(id_movie);
        removeCategoryMovieByID(id_movie);
        new EpisodeDAO().removeEpisodeByIDMovie(id_movie);
        removeMovie(id_movie);
    }

    public List<Movie> getMovieByIDCategory(int id_category) {
        List<Movie> movies = new ArrayList<>();
        String sql = "select m.* from movie m, CATEGORY c, CATEGORY_MOVIE cm where m.id = cm.movie_id and cm.category_id = c.id and c.id = " + id_category;
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                movies.add(new Movie(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11), rs.getString(12), rs.getString(13), rs.getString(14), rs.getInt(15), rs.getString(16), rs.getString(17)));
            }
            return movies;
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e);
        }
        return null;
    }

    public List<Movie> getMovieByCountry(String country) {
        List<Movie> movies = new ArrayList<>();
        String sql = "select m.* from movie where country=" + country;
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                movies.add(new Movie(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11), rs.getString(12), rs.getString(13), rs.getString(14), rs.getInt(15), rs.getString(16), rs.getString(17)));
            }
            return movies;
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e);
        }
        return null;
    }

    public Movie getMovieByID(int id) {
        Movie movie = new Movie();
        String sql = "select * from MOVIE where id=";
        sql += id;
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                return new Movie(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11), rs.getString(12), rs.getString(13), rs.getString(14), rs.getInt(15), rs.getString(16), rs.getString(17));
            }
            return movie;
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e);
        }
        return null;
    }

    public Movie getFullMovieByID(int id) {
        Movie movie = new MovieDAO().getMovieByID(id);
        movie.setActors(new ActorDAO().getActorByIDMovie(id));
        movie.setCategorys(new CategoryDAO().getCategoryByIDMovie(id));
        movie.setEpisodes(new EpisodeDAO().getEpisodeByIDMovie(id));
        return movie;
    }

    public int checkMovieByName(String name) {
        Movie movie = new Movie();
        String sqlCategory = "select * from movie where name=N'" + name +"'";
        try {
            PreparedStatement st = connection.prepareStatement(sqlCategory);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                movie = new Movie(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11), rs.getString(12), rs.getString(13), rs.getString(14), rs.getInt(15), rs.getString(16), rs.getString(17));
            }
            return movie.getId();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e);
        }
        return 0;
    }

    public int insertToMovie(Movie movie) {
        try {
            String sql = "insert into Movie values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? ,? ,? ,?)";
            PreparedStatement st = connection.prepareStatement(sql);
            int check = checkMovieByName(movie.getName());
            if (check != 0) {
                System.out.println("???? c?? phim " + movie.getName());
                return check; // n???u ???? c?? th?? tr??? v??? id c???a c??i th??? lo???i c?? trong b???ng r???i
            }
            st.setString(1, movie.getName());
            st.setString(2, movie.getOrinal_name());
            st.setString(3, movie.getContent());
            st.setString(4, movie.getType());
            st.setString(5, movie.getStatus());
            st.setString(6, movie.getThuml_url());
            st.setString(7, movie.getTrailer_url());
            st.setString(8, movie.getTime());
            st.setString(9, movie.getEpisode_current());
            st.setString(10, movie.getEpisode_total());
            st.setString(11, movie.getQuality());
            st.setString(12, movie.getLang());
            st.setString(13, movie.getSlug());
            st.setInt(14, movie.getYear());
            st.setString(15, movie.getDirector());
            st.setString(16, movie.getCountry());
            st.executeUpdate();
            System.out.println("Insert to Movie Success");
        }catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Insert to Movie Fail");
        }
        return checkMovieByName(movie.getName()); // th??m v??o v?? tr??? v??? id c???a th??? lo???i
    }

    public boolean checkActorMovie(int id_actor, int id_movie) {
        String sql = "select * from ACTOR_MOVIE where actor_id = ? and movie_id = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id_actor);
            st.setInt(2, id_movie);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e);
        }
        return false;
    }

    public boolean checkCategoryMovie(int id_category, int id_movie) {
        String sql = "select * from CATEGORY_MOVIE where category_id = ? and movie_id = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id_category);
            st.setInt(2, id_movie);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e);
        }
        return false;
    }

    public void insertToActorMovie(int id_actor, int id_movie) {
        try {
            String sql = "insert into ACTOR_MOVIE values(?,?)";
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id_actor);
            st.setInt(2, id_movie);
            st.executeUpdate();
            System.out.println("Insert to Actor_Movie Success");
        }catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Insert to Actor_Movie Fail");
        }

    }

    public void removeActorMovie(int id_actor, int id_movie) {
        try {
            String sql = "delete from ACTOR_MOVIE where actor_id = ? and movie_id = ?";
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id_actor);
            st.setInt(2, id_movie);
            st.executeUpdate();
            System.out.println("X??a d??? li???u c???a actor_movie th??nh c??ng");
        }catch (SQLException e) {
            e.printStackTrace();
            System.out.println("X??a d??? li???u c???a actor_movie th???t b???i");
        }
    }

    public void insertToCategoryMovie(int id_category, int id_movie) {
        try {
            String sql = "insert into CATEGORY_MOVIE values(?,?)";
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id_category);
            st.setInt(2, id_movie);
            st.executeUpdate();
            System.out.println("Insert to Category_Movie Success");
        }catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Insert to Category_Movie Fail");
        }
    }

    public List<Movie> getMovieByTypeCategory(String type, String filter) {
        List<Movie> movies = new ArrayList<>();

        try {
            String sql = "select m.* from Movie m, CATEGORY c, CATEGORY_MOVIE cm " +
                    "                    where m.id = cm.movie_id and cm.category_id = c.id and " +
                    "                     m.type= ? and " +
                    "                    c.name like N'%" + filter +"%'";
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, type);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                movies.add(new Movie(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11), rs.getString(12), rs.getString(13), rs.getString(14), rs.getInt(15), rs.getString(16), rs.getString(17)));
            }
            return movies;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Movie> getMovieByView(String type) {
        List<Movie> movies = new ArrayList<>();
        try {
            String sql = "select top (10)  m.* from Movie m inner join " +
                    "(select id_movie, sum([view]) as [sum] from Episode group by " +
                    "id_movie ) as e on m.id = e.id_movie and m.type = ?" +
                    " order by [sum] desc";
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, type);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                movies.add(new Movie(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11), rs.getString(12), rs.getString(13), rs.getString(14), rs.getInt(15), rs.getString(16), rs.getString(17)));
            }
            return movies;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Movie> getMovieByTypeYear(String type, int year) {
        List<Movie> movies = new ArrayList<>();
        String sql = "select * from Movie where [type] = ? and [year] = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, type);
            st.setInt(2, year);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                movies.add(new Movie(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11), rs.getString(12), rs.getString(13), rs.getString(14), rs.getInt(15), rs.getString(16), rs.getString(17)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e);
        }
        return movies;
    }



    public void insertToFullMovie(String json) throws ParseException {
        Movie movie = handlerJson(json);
        int id_movie = insertToMovie(movie);
        ActorDAO ad = new ActorDAO();
        for (Actor actor: movie.getActors()) {
            int id_actor = ad.insertToActor(actor);
            if (!checkActorMovie(id_actor, id_movie))
                insertToActorMovie(id_actor, id_movie);
        }

        CategoryDAO cd = new CategoryDAO();
        for (Category category : movie.getCategorys()) {
            int id_category = cd.insertToCategory(category);
            if (!checkCategoryMovie(id_category, id_movie))
                insertToCategoryMovie(id_category, id_movie);
        }

        EpisodeDAO ed = new EpisodeDAO();
        for (Episode episode : movie.getEpisodes())
            ed.insertToEpisode(episode, id_movie);

    }

    public List<Movie> getMovieByKeySearchTop8(String searchKey) {
        List<Movie> movies = new ArrayList<>();

        Movie movie = new Movie();
        String sql = "select top 8 * from  movie where name like N'%" + searchKey + "%' or origin_name like N'%" + searchKey + "%'";

        try {
            PreparedStatement st = connection.prepareStatement(sql);

            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                movies.add(new Movie(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11), rs.getString(12), rs.getString(13), rs.getString(14), rs.getInt(15), rs.getString(16), rs.getString(17)));
            }
            return movies;
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e);
        }
        return null;
    }
//    String sql = "select * from MOVIE where type=? order by id offset ? rows fetch next 8 rows only";
    public List<Movie> getMovieByKeySearchNext8(String searchKey, int start) {
        List<Movie> movies = new ArrayList<>();

        Movie movie = new Movie();
        String sql = "select * from  movie where name like N'%" + searchKey + "%' or origin_name like N'%" + searchKey + "%' order by id offset ? rows fetch next 8 rows only";

        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, start);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                movies.add(new Movie(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11), rs.getString(12), rs.getString(13), rs.getString(14), rs.getInt(15), rs.getString(16), rs.getString(17)));
            }
            return movies;
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e);
        }
        return null;
    }

    public void updateInfo(int id, String name, String origil_name, String thumb_url, String trailer, String content, String episode_total, String quality, int year, String director) {
        try {
            String sql = "update Movie set name = ?, origin_name = ? " +
                    ", thumb_url = ?,trailer_url = ?,content = ? " +
                    ", episode_total = ?, quality = ? , year = ? " +
                    ", director = ? where id=?";
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, name);
            st.setString(2, origil_name);
            st.setString(3, thumb_url);
            st.setString(4, trailer);
            st.setString(5, content);
            st.setString(6, episode_total);
            st.setString(7, quality);
            st.setInt(8, year);
            st.setString(9, director);
            st.setInt(10, id);
            st.executeUpdate();
            System.out.println("Update Movie Success");
        }catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Update Movie Fail");
        }
    }

    public int getViewByType(String type) {
        String sql = "select sum([view]) from Movie m inner join EPISODE e on m.id = e.id_movie where m.type = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, type);
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

    public List<Movie> getMovieByActorID(int id_actor) {
        List<Movie> movies = new ArrayList<>();
        String sql = "select m.* from Movie m inner join ACTOR_MOVIE am on m.id = am.movie_id \n" +
                "\t\t\t\t\tinner join ACTOR a on am.actor_id = a.id where a.id = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id_actor);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                movies.add(new Movie(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11), rs.getString(12), rs.getString(13), rs.getString(14), rs.getInt(15), rs.getString(16), rs.getString(17)));
            }
            return movies;
        } catch (SQLException e){
            e.printStackTrace();
            System.out.println(e);
        }
        return movies;
    }

    public static void main(String[] args) {
//        System.out.println(new MovieDAO().getViewByType("single"));

//        new MovieDAO().updateInfo(1, "Khi g??i v??n ph??ng l??m th??m...", "Officetel Skillful Ones", "https://img.ophim.tv/uploads/movies/khi-gai-van-phong-lam-them-thumb.jpg", "", "<p>M???t c?? g??i n???i ti???ng t??n l?? Joo-hee bu??n b??n t??nh d???c ????? ki???m ti???n. C?? ???y t???ng l?? ng?????i gi???i nh???t, nh??ng c?? ???y ???? ng???ng nh???n cu???c g???i. B???n c???a c??, Ji-yeong, b???n r???n v???i nhi???u cu???c h???n. Joo-hee ghen t??? v???i Ji-yeong, cho ?????n khi c?? nghe ???????c t??? m???t kh??ch h??ng c?? r???ng Ji-yeong ??ang cung c???p d???ch v??? g??y s???c. T???c gi???n v?? s??? th???t r???ng Ji-yeong ???? ????nh c???p kh??ch h??ng c???a c??, h??? b???t ?????u m???t cu???c thi d???ch v???. C??c kh??ch h??ng ??ang ph??t cu???ng v?? d???ch v??? n??y, nh??ng Joo-hee v?? Ji-yeong m???t m???i v?? ?????ng ?? ch??? l??m nh???ng vi???c t????ng t???. Sau ????, h??? ?????t nhi??n tr??? n??n nh??n r???i, kh??ng c?? b???t k??? cu???c g???i n??o, cho ?????n khi h??? nghe r???ng Yeong-joo t??? c??ng m???t quan ch???c ???? chuy???n ?????n m???t v??n ph??ng ?????i th??? v?? ??ang cung c???p c??c d???ch v??? g??y s???c. Joo-hee v?? Ji-yeong quy???t ?????nh h???p t??c v?? l???y l???i kh??ch h??ng c???a h???. H??? cung c???p d???ch v??? 2: 1 v?? kh??ch h??ng s??? kh??ng d???ng l???i ...</p>", "1", "HD", 2018, "Chun Sung Joon");
        for (Movie movie : new MovieDAO().getMovieNewUpdate())
            System.out.println(movie);
    }


//        MovieDAO md = new MovieDAO();
//        List<Movie> movies = (List<Movie>) md.getMovieById(1);
//        Movie movie = md.getFullMovieByID(2);

//        for (Movie movie:
//             movies) {
//            System.out.println(movie);
//        }
//        System.out.println(movie);
//        System.out.println(movie.showNameActors());
//        System.out.println(movie.showNameCategorys());

//        try {
//            String json = "{\"status\":true,\"msg\":\"\",\"movie\":{\"modified\":{\"time\":\"2022-05-05T12:21:01.000Z\"},\"_id\":\"627376e93a2c0c6289bc82f6\",\"name\":\"Senzo: V??? s??t h???i ng??i sao b??ng ????\",\"origin_name\":\"Senzo: Murder of a Soccer Star\",\"content\":\"<p>C???u th??? b??ng ???? Senzo Meyiwa v???n l?? anh h??ng d??n t???c tr?????c khi v??? s??t h???i anh khi???n Nam Phi ch???n ?????ng. Ai gi???t anh v?? v?? sao? Lo???t phim t??i li???u n??y s??? ????o s??u ch???ng c???.</p>\",\"type\":\"series\",\"status\":\"completed\",\"thumb_url\":\"https://img.ophim.tv/uploads/movies/senzo-vu-sat-hai-ngoi-sao-bong-da-thumb.jpg\",\"is_copyright\":\"off\",\"sub_docquyen\":\"off\",\"trailer_url\":\"\",\"time\":\"42ph??t/t???p\",\"episode_current\":\"Ho??n T???t (5/5)\",\"episode_total\":\"5 T???p\",\"quality\":\"HD\",\"lang\":\"Vietsub\",\"notify\":\"\",\"showtimes\":\"\",\"slug\":\"senzo-vu-sat-hai-ngoi-sao-bong-da\",\"year\":2022,\"actor\":[\"\"],\"director\":[\"\"],\"category\":[{\"name\":\"T??i Li???u\"}],\"country\":[{\"name\":\"Nam Phi\"}]},\"episodes\":[{\"server_name\":\"Vietsub #1\",\"server_data\":[{\"name\":\"1\",\"slug\":\"1\",\"filename\":\"Senzo_ V??? s??t h???i ng??i sao b??ng ????_S01E01_Vu?? c??????p d????n ??????n gi????t ng??????i\",\"link_embed\":\"https://kd.hd-bophim.com/share/5723ce74503ca035097ea19fd040e5bb\",\"link_m3u8\":\"https://kd.hd-bophim.com/20220505/10942_70098561/index.m3u8\"},{\"name\":\"2\",\"slug\":\"2\",\"filename\":\"Senzo_ V??? s??t h???i ng??i sao b??ng ????_S01E02_Nh??n ti??nh\",\"link_embed\":\"https://kd.hd-bophim.com/share/ee76626ee11ada502d5dbf1fb5aae4d2\",\"link_m3u8\":\"https://kd.hd-bophim.com/20220505/10943_184b8164/index.m3u8\"},{\"name\":\"3\",\"slug\":\"3\",\"filename\":\"Senzo_ V??? s??t h???i ng??i sao b??ng ????_S01E03_Ti??nh tay ba\",\"link_embed\":\"https://kd.hd-bophim.com/share/0680e1f35026262317cb7cec207e04c5\",\"link_m3u8\":\"https://kd.hd-bophim.com/20220505/10944_37f223ce/index.m3u8\"},{\"name\":\"4\",\"slug\":\"4\",\"filename\":\"Senzo_ V??? s??t h???i ng??i sao b??ng ????_S01E04_Gia?? thuy???t m????i\",\"link_embed\":\"https://kd.hd-bophim.com/share/122915b6774a4467be946ddae541af52\",\"link_m3u8\":\"https://kd.hd-bophim.com/20220505/10945_08df06a7/index.m3u8\"},{\"name\":\"5\",\"slug\":\"5\",\"filename\":\"Senzo_ V??? s??t h???i ng??i sao b??ng ????_S01E05_Tay sa??t thu??\",\"link_embed\":\"https://kd.hd-bophim.com/share/a43fc3d27915b373b163da088684d4a9\",\"link_m3u8\":\"https://kd.hd-bophim.com/20220505/10947_ca77a001/index.m3u8\"}]}]}";
//            new MovieDAO().insertToFullMovie(json);
//        }catch (Exception e) {
//            e.printStackTrace();
//        }
//        new MovieDAO().removeMovieById(2);
////        for (Movie movie : new MovieDAO().getMovieLikeName("xin")) {
////            System.out.println(movie);
////        }
//    }



}
