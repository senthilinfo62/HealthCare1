package com.cloudifive.healthcare.Models;

/**
 * Created by Abhi on 02 Oct 2017 002.
 */

public class ModelProjects {
    private String id;
    private String title;
    private String description;
    private String theme;
    private String icon;
    private String image;
    private String status;

    public ModelProjects(String id, String title, String description, String theme, String icon, String image, String status) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.theme = theme;
        this.icon = icon;
        this.image = image;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
