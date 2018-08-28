package com.cloudifive.healthcare.Models;

/**
 * Created by Karthikr on 30/05/2018
 */

public class Offers {
    String title;
    String price;
    String start_date;
    String end_date;
    String description;

    public Offers(String title, String price, String start_date, String end_date, String description) {
        this.title = title;
        this.price = price;
        this.start_date = start_date;
        this.end_date = end_date;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getStart_date() {
        return start_date;
    }

    public void setStart_date(String start_date) {
        this.start_date = start_date;
    }

    public String getEnd_date() {
        return end_date;
    }

    public void setEnd_date(String end_date) {
        this.end_date = end_date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
