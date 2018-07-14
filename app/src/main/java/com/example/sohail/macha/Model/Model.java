package com.example.sohail.macha.Model;

public class Model {

    private String title;
    private int id;
    private String path;

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Model() {

    }

    public Model(String title, int id, String path) {
        this.title = title;
        this.id = id;
        this.path = path;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
