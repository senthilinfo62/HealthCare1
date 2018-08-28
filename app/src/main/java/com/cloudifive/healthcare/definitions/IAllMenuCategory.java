package com.cloudifive.healthcare.definitions;

import org.json.JSONObject;

import bolts.Task;

/**
 * Created by Gnanaprakash. S on 10/17/2016.
 */

public interface IAllMenuCategory
{
    Task<JSONObject> doFeedback(String name, String phone, String email, String subject, String comments);
    Task<JSONObject> getAboutus();
    Task<JSONObject> getInfra();
    Task<JSONObject> getDoctors();
    Task<JSONObject> getFacilities();
    Task<JSONObject> getOffers();
    Task<JSONObject> getDepartments();
    Task<JSONObject> getContactus();
    Task<JSONObject> getSucessStory();
    Task<JSONObject> getChairmanMessage();



}
