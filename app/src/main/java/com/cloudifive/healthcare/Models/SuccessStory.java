package com.cloudifive.healthcare.Models;

import java.util.HashMap;

public class SuccessStory {

    private String myName, myAddr1,image;
    HashMap<String,Object> myAMapData=new HashMap<>();


    public SuccessStory() {
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    /**
     * Getter and setter for Customer name

     ****/
    public String getName() {
        return myName;
    }

    public void setName(String name) {
        this.myName = name;
    }

    /*** Getter and setter for address 1***/
    public String getAddress1() {
        return myAddr1;
    }

    public void setAddress1(String addr1) {
        this.myAddr1 = addr1;
    }


    @Override
    public String toString() {
        return super.toString();
    }

    public HashMap<String, Object> getMyAMapData() {
        return myAMapData;
    }

    public void setMyAMapData(HashMap<String, Object> myAMapData) {
        this.myAMapData = myAMapData;
    }
    /**** SNT Ends here ***/
}
