package com.cloudifive.healthcare.Models;

import java.util.ArrayList;

/**
 * Created by gopalakrishnan.s on 08-02-2017.
 */

public class Group {

    private String Name;

    private int Image;

    public int getImage() {
        return Image;
    }

    public void setImage(int image) {
        Image = image;
    }

    private ArrayList<Child> Items;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        this.Name = name;
    }

    public ArrayList<Child> getItems() {
        return Items;
    }

    public void setItems(ArrayList<Child> Items) {
        this.Items = Items;
    }
}
