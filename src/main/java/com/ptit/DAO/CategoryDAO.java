package com.ptit.DAO;

import com.ptit.dal.DBContext;
import com.ptit.model.Category;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoryDAO extends DBContext {
    public List<Category> getCategoryByIDMovie(int id_movie) {
        List<Category> categories = new ArrayList<>();
        String sqlCategory = "select c.id, c.name from movie m, CATEGORY c, CATEGORY_MOVIE cm where m.id = cm.movie_id and cm.category_id = c.id and m.id = ";
        sqlCategory += id_movie;
        try {
            PreparedStatement st = connection.prepareStatement(sqlCategory);
            ResultSet rs = st.executeQuery();
            while(rs.next()) {
                categories.add(new Category(rs.getInt(1), rs.getString(2)));
            }
            return categories;
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e);
        }
        return null;
    }

    public Category getCategoryByID(int id) {
        String sqlCategory = "select * from category where id = ";
        sqlCategory += id;
        try {
            PreparedStatement st = connection.prepareStatement(sqlCategory);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                return new Category(rs.getInt(1), rs.getString(2));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e);
        }
        return null;
    }

    public List<Category> getAll() {
        List<Category> categories = new ArrayList<>();
        String sqlCategory = "select * from category";
        try {
            PreparedStatement st = connection.prepareStatement(sqlCategory);
            ResultSet rs = st.executeQuery();
            while(rs.next()) {
                categories.add(new Category(rs.getInt(1), rs.getString(2)));
            }
            return categories;
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e);
        }
        return null;
    }

    public Integer checkCategoryName(String name) {
        Category category = new Category();
        String sqlCategory = "select * from category where name=N'" + name +"'";
        try {
            PreparedStatement st = connection.prepareStatement(sqlCategory);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                category = new Category(rs.getInt(1), rs.getString(2));
            }
            return category.getId();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e);
        }
        return 0;
    }

    public int insertToCategory(Category category) {
        try {
            String sql = "insert into Category values(?)";
            PreparedStatement st = connection.prepareStatement(sql);
            int check = checkCategoryName(category.getName());
            if (check != 0) {
                System.out.println("Đã có danh mục " + category.getName());
                return check; // nếu đã có thì trả về id của cái thể loại có trong bảng rồi
            }
            st.setString(1, category.getName());
            st.executeUpdate();
            System.out.println("Insert to Category Success");
        }catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Insert to Category_Movie Fail");
        }
        return checkCategoryName(category.getName()); // thêm vào và trả về id của thể loại
    }

    public void updateNameCategory(int id, String name) {
        try {
            String sql = "update Category set name = ? where id = ?";
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, name);
            st.setInt(2, id);
            st.executeUpdate();
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
//        for (Category category : new CategoryDAO().getCategoryByIDMovie(2)) {
//            System.out.println(category);
//        }
//
//        for (Category category : new CategoryDAO().getAll()) {
//            System.out.println(category);
//        }
//
//        System.out.println(new CategoryDAO().checkCategoryName("Phim X"));
//        System.out.println(new CategoryDAO().insertToCategory(new Category(0, "Học Đường")));
//        for (Category category : new CategoryDAO().getAll())
//            System.out.println(category);
        new CategoryDAO().updateNameCategory(1, "Phim 18++");
    }

}
