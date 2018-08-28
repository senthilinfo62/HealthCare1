package com.cloudifive.healthcare.helpers;


import org.json.JSONObject;

import java.util.concurrent.Callable;

import bolts.Task;
import com.cloudifive.healthcare.definitions.IAllMenuCategory;
import com.cloudifive.healthcare.translator.MenuTranslator;
import com.cloudifive.healthcare.utils.AppConstants;
import com.cloudifive.healthcare.utils.LogUtils;

/**
 * Created by karthik.r on 29/05/2018.
 */

public class MenuCategoryHelper extends ClientHelper implements IAllMenuCategory {
    private MenuTranslator menuTranslator = new MenuTranslator();

    @Override
    public Task<JSONObject> getDoctors() {
        // http://137.74.31.149/userpost/individualuserfav_deal/28
        return Task.callInBackground(new Callable<JSONObject>() {
            @Override
            public JSONObject call() throws Exception {

                //System.out.println(AppConstants.BASE_URL + "projects");
                String responseString = get(AppConstants.BASE_URL + "doctor");
                LogUtils.i("Response : " + responseString);
                String replaceString=responseString.replace("null", "");
                //System.out.println("projects "+responseString);
                //System.out.println("projects1 "+replaceString);

                return menuTranslator.translateStringToJSONObj(replaceString);
            }
        });
    }
    @Override
    public Task<JSONObject> getSucessStory() {
        // http://137.74.31.149/userpost/individualuserfav_deal/28
        return Task.callInBackground(new Callable<JSONObject>() {
            @Override
            public JSONObject call() throws Exception {

                //System.out.println(AppConstants.BASE_URL + "projects");
                String responseString = get(AppConstants.BASE_URL + "success_story");
                LogUtils.i("Response : " + responseString);
                String replaceString=responseString.replace("null", "");
                //System.out.println("projects "+responseString);
                //System.out.println("projects1 "+replaceString);

                return menuTranslator.translateStringToJSONObj(replaceString);
            }
        });
    }
   @Override
    public Task<JSONObject> getChairmanMessage() {
        // http://137.74.31.149/userpost/individualuserfav_deal/28
        return Task.callInBackground(new Callable<JSONObject>() {
            @Override
            public JSONObject call() throws Exception {

                //System.out.println(AppConstants.BASE_URL + "projects");
                String responseString = get(AppConstants.BASE_URL + "chairman_message");
                LogUtils.i("Response : " + responseString);
                String replaceString=responseString.replace("null", "");
                //System.out.println("projects "+responseString);
                //System.out.println("projects1 "+replaceString);

                return menuTranslator.translateStringToJSONObj(replaceString);
            }
        });
    }

    @Override
    public Task<JSONObject> getFacilities() {
        return Task.callInBackground(new Callable<JSONObject>() {
            @Override
            public JSONObject call() throws Exception {
                //System.out.println(AppConstants.BASE_URL + "news");
                String responseString = get(AppConstants.BASE_URL + "facility");
                LogUtils.i("Response : " + responseString);
                String replaceString=responseString.replace("null", "");
                //System.out.println("projects "+responseString);
                //System.out.println("projects1 "+replaceString);

                return menuTranslator.translateStringToJSONObj(replaceString);
            }
        });
    }

    @Override
    public Task<JSONObject> getInfra() {
        return Task.callInBackground(new Callable<JSONObject>() {
            @Override
            public JSONObject call() throws Exception {
                //System.out.println(AppConstants.BASE_URL + "events");
                String responseString = get(AppConstants.BASE_URL + "infrastructure");
                LogUtils.i("Response : " + responseString);
                String replaceString=responseString.replace("null", "");
                //System.out.println("projects "+responseString);
                //System.out.println("projects1 "+replaceString);

                return menuTranslator.translateStringToJSONObj(replaceString);
            }
        });
    }    @Override
    public Task<JSONObject> getOffers() {
        return Task.callInBackground(new Callable<JSONObject>() {
            @Override
            public JSONObject call() throws Exception {
                //System.out.println(AppConstants.BASE_URL + "events");
                String responseString = get(AppConstants.BASE_URL + "offer");
                LogUtils.i("Response : " + responseString);
                String replaceString=responseString.replace("null", "");
                //System.out.println("projects "+responseString);
                //System.out.println("projects1 "+replaceString);

                return menuTranslator.translateStringToJSONObj(replaceString);
            }
        });
    }

    @Override
    public Task<JSONObject> getDepartments() {
        return Task.callInBackground(new Callable<JSONObject>() {
            @Override
            public JSONObject call() throws Exception {
                //System.out.println(AppConstants.BASE_URL + "events");
                String responseString = get(AppConstants.BASE_URL + "department");
                System.out.println(AppConstants.BASE_URL + "get_department\n"+"Response : " + responseString);
                String replaceString=responseString.replace("null", "");
                //System.out.println("projects "+responseString);
                //System.out.println("projects1 "+replaceString);

                return menuTranslator.translateStringToJSONObj(replaceString);
            }
        });
    }

    @Override
    public Task<JSONObject> getContactus() {
        return Task.callInBackground(new Callable<JSONObject>() {
            @Override
            public JSONObject call() throws Exception {
                //System.out.println(AppConstants.BASE_URL + "testimonials");
                String responseString = get(AppConstants.BASE_URL + "contact_us");
                LogUtils.i("Response : " + responseString);
                String replaceString=responseString.replace("null", "");
                //System.out.println("projects "+responseString);
                //System.out.println("projects1 "+replaceString);

                return menuTranslator.translateStringToJSONObj(replaceString);
            }
        });
    }

    @Override
    public Task<JSONObject> doFeedback(final String name, final String phone,final String email, final String subject, final String comments) {

            return Task.callInBackground(new Callable<JSONObject>() {
            @Override
            public JSONObject call() throws Exception {
                //JSONObject payload = loginTranslator.constructLogin(userName, password);
                JSONObject jsonObject = new JSONObject();

                jsonObject.put("name", name);
                jsonObject.put("phone", phone);
                jsonObject.put("email", name);
                jsonObject.put("subject", phone);
                jsonObject.put("comments", phone);
                String responseString = post(AppConstants.BASE_URL+"feedback", jsonObject.toString());

                System.out.println("Response : " + responseString);
                return menuTranslator.translateStringToJSONObj(responseString);
            }
        });
    }

    @Override
    public Task<JSONObject> getAboutus() {
        return Task.callInBackground(new Callable<JSONObject>() {
            @Override
            public JSONObject call() throws Exception {
                //System.out.println(AppConstants.BASE_URL + "testimonials");
                String responseString = get(AppConstants.BASE_URL + "about_us");
                LogUtils.i("Response : " + responseString);
                String replaceString=responseString.replace("null", "");
                //System.out.println("projects "+responseString);
                //System.out.println("projects1 "+replaceString);

                return menuTranslator.translateStringToJSONObj(replaceString);
            }
        });
    }

}
