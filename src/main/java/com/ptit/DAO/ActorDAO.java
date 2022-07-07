package com.ptit.DAO;

import com.ptit.dal.DBContext;
import com.ptit.model.Actor;
import com.ptit.model.Category;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ActorDAO extends DBContext {
    public List<Actor> getActorByIDMovie(int id_movie) {
        List<Actor> actors = new ArrayList<>();
        String sqlActor = "select a.* from ACTOR_MOVIE am inner join ACTOR a on am.actor_id = a.id and am.movie_id = " +id_movie ;
        try {
            PreparedStatement st = connection.prepareStatement(sqlActor);
            ResultSet rs = st.executeQuery();
            while(rs.next()) {
                actors.add(new Actor(rs.getInt(1), rs.getString(2)));
            }
            return actors;
        } catch (
                SQLException e) {
            e.printStackTrace();
            System.out.println(e);
        }
        return null;
    }

    public Actor getActorByID(int id_actor) {
        try {
            String sqlActor = "select * from Actor where id = ?";
            PreparedStatement st = connection.prepareStatement(sqlActor);
            st.setInt(1, id_actor);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                return new Actor(rs.getInt(1), rs.getString(2));
            }
        } catch (
                SQLException e) {
            e.printStackTrace();
            System.out.println(e);
        }
        return null;
    }

    public void updateActorByID(int id_actor, String name_actor) {
        try {
            String sqlActor = "update Actor set name = ? where id = ?";
            PreparedStatement st = connection.prepareStatement(sqlActor);
            st.setString(1, name_actor);
            st.setInt(2, id_actor);
            st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e);
        }
    }

    public Integer checkActorName(String name) {
        Actor actor = new Actor();
        String sql = "select * from actor where name=N'" + name +"'";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                actor = new Actor(rs.getInt(1), rs.getString(2));
            }
            return actor.getId();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e);
        }
        return 0;
    }



    public int insertToActor(Actor actor) {
        try {
            String sql = "insert into actor values(?)";
            PreparedStatement st = connection.prepareStatement(sql);
            int check = checkActorName(actor.getName());
            if (check != 0) {
                System.out.println("Đã có diễn viên " + actor.getName());
                return check; // nếu đã có thì trả về id của cái thể loại có trong bảng rồi
            }
            st.setString(1, actor.getName());
            st.executeUpdate();
            System.out.println("Insert to Actor Success");
        }catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Insert to Actor Fail");
        }
        return checkActorName(actor.getName()); // thêm vào và trả về id của diễn viên
    }

    public List<Actor> getAll() {
        List<Actor> categories = new ArrayList<>();
        String sqlCategory = "select * from actor";
        try {
            PreparedStatement st = connection.prepareStatement(sqlCategory);
            ResultSet rs = st.executeQuery();
            while(rs.next()) {
                categories.add(new Actor(rs.getInt(1), rs.getString(2)));
            }
            return categories;
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e);
        }
        return null;
    }


    public static void main(String[] args) {
//        ActorDAO ad = new ActorDAO();
//        for (Actor actor: new ActorDAO().getAll()) {
//            System.out.println(actor);
//        }
//        System.out.println(new ActorDAO().insertToActor(new Actor(0, "Ellie Kemper")));
        System.out.println();
    }




}
