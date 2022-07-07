package com.ptit.model;


import java.util.ArrayList;
import java.util.List;

public class Movie {
    private int id;
    private String name;
    private String orinal_name;
    private String content;
    private String type;
    private String status;
    private String thuml_url;
    private String trailer_url;
    private String time;
    private String episode_current;
    private String episode_total;
    private String quality;
    private String lang;
    private String slug;
    private int year;
    private String director;
    private String country;
    private List<Actor> actors = new ArrayList<>();
    private List<Category> categorys = new ArrayList<>();
    private List<Episode> episodes = new ArrayList<>();

    public Movie() {
    }

    public Movie(int id, String name, String orinal_name, String content, String type, String status, String thuml_url, String trailer_url, String time, String episode_current, String episode_total, String quality, String lang, String slug, int year, String director, String country) {
        this.id = id;
        this.name = name;
        this.orinal_name = orinal_name;
        this.content = content;
        this.type = type;
        this.status = status;
        this.thuml_url = thuml_url;
        this.trailer_url = trailer_url;
        this.time = time;
        this.episode_current = episode_current;
        this.episode_total = episode_total;
        this.quality = quality;
        this.lang = lang;
        this.slug = slug;
        this.year = year;
        this.director = director;
        this.country = country;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOrinal_name() {
        return orinal_name;
    }

    public void setOrinal_name(String orinal_name) {
        this.orinal_name = orinal_name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getThuml_url() {
        return thuml_url;
    }

    public void setThuml_url(String thuml_url) {
        this.thuml_url = thuml_url;
    }

    public String getTrailer_url() {
        return trailer_url;
    }

    public void setTrailer_url(String trailer_url) {
        this.trailer_url = trailer_url;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getEpisode_current() {
        return episode_current;
    }

    public void setEpisode_current(String episode_current) {
        this.episode_current = episode_current;
    }

    public String getEpisode_total() {
        return episode_total;
    }

    public void setEpisode_total(String episode_total) {
        this.episode_total = episode_total;
    }

    public String getQuality() {
        return quality;
    }

    public void setQuality(String quality) {
        this.quality = quality;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public List<Actor> getActors() {
        return actors;
    }

    public void setActors(List<Actor> actors) {
        this.actors = actors;
    }

    public List<Category> getCategorys() {
        return categorys;
    }

    public void setCategorys(List<Category> categorys) {
        this.categorys = categorys;
    }

    public List<Episode> getEpisodes() {
        return episodes;
    }

    public void setEpisodes(List<Episode> episodes) {
        this.episodes = episodes;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", orinal_name='" + orinal_name + '\'' +
                ", content='" + content + '\'' +
                ", status='" + status + '\'' +
                ", thuml_url='" + thuml_url + '\'' +
                ", trailer_url='" + trailer_url + '\'' +
                ", time='" + time + '\'' +
                ", episode_current='" + episode_current + '\'' +
                ", episode_total='" + episode_total + '\'' +
                ", quality='" + quality + '\'' +
                ", lang='" + lang + '\'' +
                ", slug='" + slug + '\'' +
                ", year=" + year +
                ", director='" + director + '\'' +
                ", country='" + country + '\'' +
                '}';
    }

    public String showNameCategorys() {
        String res = "";
        for (Category category : categorys) {
            res += category.getName() + ", ";
        }
        if (res.length() > 2) {
            res = res.substring(0, res.length() - 2);
            res += '.';
        }
        return res;
    }

    public String showNameActors() {
        String res = "";
        for (Actor actor : actors) {
            res += actor.getName() + ", ";
        }
        if (res.length() > 2) {
            res = res.substring(0, res.length() - 2);
            res += '.';
        }
        return res;
    }
}
