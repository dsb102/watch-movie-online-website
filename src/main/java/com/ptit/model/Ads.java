package com.ptit.model;

public class Ads {
    private int id;
    private String name;
    private String link;
    private String img;
    private int view;
    private int active;

    public Ads() {
    }


    public Ads(int id, String name, String link, String img, int view, int active) {
        this.id = id;
        this.name = name;
        this.link = link;
        this.img = img;
        this.view = view;
        this.active = active;
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

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public int getView() {
        return view;
    }

    public void setView(int view) {
        this.view = view;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "Ads{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", link='" + link + '\'' +
                ", img='" + img + '\'' +
                ", view=" + view +
                ", active=" + active +
                '}';
    }
}
