package com.ptit.model;

public class Rating {
    private int user_id;
    private int movie_id;
    private int star;

    public Rating() {
    }

    public Rating(int user_id, int movie_id, int star) {
        this.user_id = user_id;
        this.movie_id = movie_id;
        this.star = star;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getMovie_id() {
        return movie_id;
    }

    public void setMovie_id(int movie_id) {
        this.movie_id = movie_id;
    }

    public int getStar() {
        return star;
    }

    public void setStar(int star) {
        this.star = star;
    }

    @Override
    public String toString() {
        return "Rating{" +
                "user_id=" + user_id +
                ", movie_id=" + movie_id +
                ", star=" + star +
                '}';
    }
}
