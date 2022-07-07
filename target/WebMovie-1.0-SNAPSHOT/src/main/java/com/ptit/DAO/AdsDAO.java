package com.ptit.DAO;

import com.ptit.dal.DBContext;
import com.ptit.model.Actor;
import com.ptit.model.Ads;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AdsDAO extends DBContext {
    public List<Ads> getAll() {
        List<Ads> ads = new ArrayList<>();
        try {
            String sqlCategory = "select * from Ads";
            PreparedStatement st = connection.prepareStatement(sqlCategory);
            ResultSet rs = st.executeQuery();
            while(rs.next()) {
                ads.add(new Ads(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getInt(6)));
            }
            return ads;
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e);
        }
        return null;
    }

    public Ads getAdsByID(int id_ads) {
        try {
            String sqlCategory = "select * from Ads where id = ?";
            PreparedStatement st = connection.prepareStatement(sqlCategory);
            st.setInt(1, id_ads);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                return new Ads(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getInt(6));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e);
        }
        return null;
    }

    public Ads getAdsActive() {
        try {
            String sqlCategory = "select * from Ads where active = 1";
            PreparedStatement st = connection.prepareStatement(sqlCategory);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                return new Ads(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getInt(6));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e);
        }
        return null;
    }

    public void updateViewAds(int id_ads, int view) {
        try {
            String sqlCategory = "update Ads set [view] = ? where id=?";
            PreparedStatement st = connection.prepareStatement(sqlCategory);
            st.setInt(1, view);
            st.setInt(2, id_ads);
            st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e);
        }
    }

    public void insertAds(Ads ads) {
        try {
            String sqlCategory = "insert into Ads values(?, ?, ?, 0, 0)";
            PreparedStatement st = connection.prepareStatement(sqlCategory);
            st.setString(1, ads.getName());
            st.setString(2, ads.getLink());
            st.setString(3, ads.getImg());
            st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e);
        }
    }

    public void setActiveEqual0() {
        try {
            String sqlCategory = "update Ads set active = 0";
            PreparedStatement st = connection.prepareStatement(sqlCategory);
            st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e);
        }
    }

    public void activeAds(int id_ads) {
        setActiveEqual0();
        try {
            String sqlCategory = "update Ads set active = 1 where id=?";
            PreparedStatement st = connection.prepareStatement(sqlCategory);
            st.setInt(1, id_ads);
            st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        new AdsDAO().updateViewAds(3, 10);
    }
}
