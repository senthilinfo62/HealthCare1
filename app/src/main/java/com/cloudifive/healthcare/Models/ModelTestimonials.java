package com.cloudifive.healthcare.Models;

/**
 * Created by Abhi on 02 Oct 2017 002.
 */

public class ModelTestimonials {
    String id;
    String title;
    String description;
    String image;
    String date;


    public ModelTestimonials(String id, String title, String description, String image, String date) {
    this.id=id;
    this.title=title;
    this.description=description;
    this.image=image;
    this.date=date;
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
