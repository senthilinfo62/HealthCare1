package com.cloudifive.healthcare.Models;

import java.util.ArrayList;

/**
 * Created by gopalakrishnan.s on 09-02-2017.
 */

public class UserInfo {

    private String userID = "";
    private String userName = "";
    private String emailID = "";
    private String mobileNumber = "";
    private String userCategory = "";

    public String getProfileIm() {
        return profileIm;
    }

    public void setProfileIm(String profileIm) {
        this.profileIm = profileIm;
    }

    private String profileIm = "";

    public Boolean getChecked() {
        return checked;
    }

    public void setChecked(Boolean checked) {
        this.checked = checked;
    }

    private Boolean checked = false;

    public Boolean getCheckedTemp() {
        return checkedTemp;
    }

    public void setCheckedTemp(Boolean checkedTemp) {
        this.checkedTemp = checkedTemp;
    }

    private Boolean checkedTemp = false;


    public String getUserLanSymbol() {
        return userLanSymbol;
    }

    public void setUserLanSymbol(String userLanSymbol) {
        this.userLanSymbol = userLanSymbol;
    }

    private String userLanSymbol = "";


    public ArrayList<UserInfo> getUserLangList() {
        return UserLangList;
    }

    public void setUserLangList(ArrayList<UserInfo> userLangList) {
        UserLangList = userLangList;
    }

    private ArrayList<UserInfo> UserLangList;

    public String getUserLan() {
        return userLan;
    }

    public void setUserLan(String userLan) {
        this.userLan = userLan;
    }

    public String getUserLanID() {
        return userLanID;
    }

    public void setUserLanID(String userLanID) {
        this.userLanID = userLanID;
    }

    private String userLan = "";
    private String userLanID = "";


    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmailID() {
        return emailID;
    }

    public void setEmailID(String emailID) {
        this.emailID = emailID;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getUserCategory() {
        return userCategory;
    }

    public void setUserCategory(String userCategory) {
        this.userCategory = userCategory;
    }
}
