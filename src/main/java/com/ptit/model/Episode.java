package com.ptit.model;

public class Episode {
    private int id;
    private String name;
    private String slug;
    private String filename;
    private String link_embed;
    private int view;

    public Episode() {
    }

    public Episode(int id, String name, String slug, String filename, String link_embed, int view) {
        this.id = id;
        this.name = name;
        this.slug = slug;
        this.filename = filename;
        this.link_embed = link_embed;
        this.view = view;
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

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getLink_embed() {
        return link_embed;
    }

    public void setLink_embed(String link_embed) {
        this.link_embed = link_embed;
    }

    public int getView() {
        return view;
    }

    public void setView(int view) {
        this.view = view;
    }

    @Override
    public String toString() {
        return "Episode{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", slug='" + slug + '\'' +
                ", filename='" + filename + '\'' +
                ", link_embed='" + link_embed + '\'' +
                ", view=" + view +
                '}';
    }
}
