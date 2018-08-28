package com.cloudifive.healthcare.Models;

/**
 * Created by Karthikr on 30/05/2018
 */

public class Infrastructure {
    private String id;
    private String title;
    private String status;
    private String image;
    private String image_count;

    public Infrastructure(String id, String title, String status, String image, String image_count) {
        this.id = id;
        this.title = title;
        this.status = status;
        this.image = image;
        this.image_count = image_count;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getImage_count() {
        return image_count;
    }

    public void setImage_count(String image_count) {
        this.image_count = image_count;
    }
}
