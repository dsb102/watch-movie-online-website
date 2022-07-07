package com.ptit.DAO;

import com.ptit.dal.DBContext;
import com.ptit.model.Movie;
import com.ptit.model.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAO extends DBContext {
    public User removeUserByID(int id) {
        String sql = "delete from [User] where id=?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            st.executeUpdate();
            System.out.println("xóa user thành công");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("xóa bảng user thất bại");
        }
        return null;
    }

    public User checkEmailUser(String email) {
        String sql = "select * from [User] where email = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, email);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                return new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getInt(6));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e);
        }
        return null;
    }

    public User checkUsername(String username) {
        String sql = "select * from [User] where username = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, username);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                return new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getInt(6));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e);
        }
        return null;
    }



    public boolean addUser(String username, String email, String password) {
        String sql = "insert into [User] values(?, ?, ?, 1, 1)" ;

        try {
            if (checkEmailUser(email) == null && checkUsername(username) == null) {
                PreparedStatement st = connection.prepareStatement(sql);
                st.setString(1, username);
                st.setString(2, email);
                st.setString(3, password);
                st.executeUpdate();
                System.out.println("thêm thành công user:" + username);
                return true;
            }else {
                System.out.println("đã tồn tại user:" + username);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e);
        }
        return false;
    }

    public User getUserByUserPass(String username, String password) {
        String sql = "select * from [User] where username = ? and password = ?" ;

        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, username);
            st.setString(2, password);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                return new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getInt(6));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e);
        }
        return null;
    }

    public int getRoleByUserPass(String username, String password) {
        User user = getUserByUserPass(username, password);
        if (user == null) return 0;
        return user.getRole();
    }

    public static void main(String[] args) {
//        System.out.println(new UserDAO().getUserByUserPass("admin", "admin"));
//        new UserDAO().addUser("user", "username@gmail.com", "123");
//        if (new UserDAO().checkEmailUser("user10@gmail.com") == null)
//            System.out.println("chưa tồn tại");
//        else System.out.println("đã tồn tại");
        for (User user : new UserDAO().getAll()) {
            System.out.println(user);
        }
    }

    public List<User> getAll() {
        String sql = "select * from [User]" ;
        List<User> users = new ArrayList<>();
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                users.add(new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getInt(6)));
            }
            return users;
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e);
        }
        return null;
    }

    public void setUserBTV(Integer id) {
        String sql = "update [User] set role = 2 where id=?" ;

        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e);
        }
    }

    public void setUserPassword(Integer id, String hashPassword) {
        String sql = "update [User] set password = ? where id = ?" ;

        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, hashPassword);
            st.setInt(2, id);
            st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e);
        }
    }

    public int checkFavorite(int user_id, int movie_id) {
        String sql = "select * from Favorite where user_id = ? and movie_id = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, user_id);
            st.setInt(2, movie_id);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                return 1;
            }
        }catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e);
        }
        return 0;
    }


    public void addMovieToFavorite(int user_id, int movie_id) {
        String sql = "insert into [Favorite] values(?, ?)";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, user_id);
            st.setInt(2, movie_id);
            if (checkFavorite(user_id, movie_id) == 0)
                st.executeUpdate();

        }catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e);
        }
    }

    public void removeMovieFromFavorite(int user_id, int movie_id) {
        String sql = "delete from [Favorite] where [user_id] = ? and [movie_id] = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, user_id);
            st.setInt(2, movie_id);
            st.executeUpdate();
        }catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e);
        }
    }

    public List<Movie> getMovieByUser(int user_id) {
        List<Movie> movies = new ArrayList<>();
        String sql = "select m.* from Movie m inner join Favorite f on m.id = f.movie_id where user_id = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, user_id);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                movies.add(new Movie(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11), rs.getString(12), rs.getString(13), rs.getString(14), rs.getInt(15), rs.getString(16), rs.getString(17)));
            }
            return movies;
        }catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e);
        }
        return null;
    }

    public void cancleUserByID(Integer id) {
        String sql = "update [User] set role = 1 where id=?" ;

        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e);
        }
    }
}
