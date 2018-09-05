package com.cloudifive.healthcare.Models;

import java.util.HashMap;

public class Doctors {

    private String myName, myAddr1,image,uniqueID,email,phone,address,type,experience,grade,gender,description,status;

    HashMap<String,Object> myAMapData=new HashMap<>();


    public Doctors() {
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


    public String getUniqueID() {
        return uniqueID;
    }

    public void setUniqueID(String uniqueID) {
        this.uniqueID = uniqueID;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
