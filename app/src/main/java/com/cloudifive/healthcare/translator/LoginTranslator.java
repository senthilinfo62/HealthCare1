package com.cloudifive.healthcare.translator;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Gnanaprakash. S on 10/11/2016.
 */

public class LoginTranslator extends Translator
{
    public JSONObject constructLogin(String userName, String password) throws JSONException {
        JSONObject jsonObject = new JSONObject();
    
            jsonObject.put("email", userName);
            jsonObject.put("password", password);
        
        return  jsonObject;
    }

}
