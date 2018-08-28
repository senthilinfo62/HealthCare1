package com.cloudifive.healthcare.fragment;


import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;
import com.cloudifive.healthcare.R;
import com.cloudifive.healthcare.service.HomeMenuHelper;
import com.cloudifive.healthcare.service.JsonParseClass;
import com.cloudifive.healthcare.utils.NetworkState;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import bolts.Continuation;
import bolts.Task;

public class EnquiryFragment extends Fragment {

    private static final String TAG = AboutusFragment.class.getSimpleName();
    String successTag = null;
    JsonParseClass jsonParse = new JsonParseClass();
    private ProgressDialog pDialog;
    EditText name,email,phone,feedback;
    Button submit;
    private CoordinatorLayout coordinatorLayout;

    private AwesomeValidation awesomeValidation;
    Snackbar snackbar;
    NetworkState mynet;

    public EnquiryFragment() {
        // Required empty public constructor
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {

        ((AppCompatActivity) getActivity()).getSupportActionBar().show();
        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle("Feedback");
        ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        super.onCreate(savedInstanceState);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_feedback, container, false);
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        awesomeValidation = new AwesomeValidation(ValidationStyle.BASIC);
        pDialog = new ProgressDialog(getContext());
        pDialog.setMessage("Please wait...");
        pDialog.setCancelable(false);
        initializeView(view);
        return view;
    }

    private void initializeView(View view) {
        mynet=new NetworkState(getActivity());
        coordinatorLayout = (CoordinatorLayout)view.findViewById(R.id.coordinatorLayout);
        name=(EditText)view.findViewById(R.id.newcus_ID_ET);
        email=(EditText)view.findViewById(R.id.newcus_ID_ET1);
        phone=(EditText)view.findViewById(R.id.newcus_ID_ET2);
        feedback=(EditText)view.findViewById(R.id.newcus_ID_ET3);
        submit=(Button)view.findViewById(R.id.subtmitCS_ID_BT);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                submitData();
            }
        });
    }

    private void submitData()
    {
        if (mynet.isInternetOn()) {
            if (!name.getText().toString().isEmpty()) {
                if (!email.getText().toString().isEmpty() && isEmailValid(email.getText().toString())) {
                    if (!phone.getText().toString().isEmpty()) {
                        if (!feedback.getText().toString().isEmpty()) {
                            submitFeedback submitFeedback = new submitFeedback();
                            submitFeedback.execute();
                        } else {
                            showSnackBar(R.string.feedbackerror);
                        }
                    } else {
                        showSnackBar(R.string.mobileerror);
                    }
                } else {
                    showSnackBar(R.string.emailerror);
                }
            } else {
                showSnackBar(R.string.nameerror);

            }
        }
        else
        {
            Toast.makeText(getContext(),"Please Check your internet connection",Toast.LENGTH_SHORT).show();
        }
    }

    private void showSnackBar(int nameerror) {
        snackbar = Snackbar.make(coordinatorLayout, nameerror, Snackbar.LENGTH_LONG);
        snackbar.show();

    }
    public static boolean isEmailValid(String email) {
        boolean isValid = false;

        String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
        CharSequence inputStr = email;

        Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(inputStr);
        if (matcher.matches()) {
            isValid = true;
        }
        return isValid;
    }

    public void getFavourite1() {

//
//        HomeMenuHelper.INSTANCE.setContext(getActivity());
//        HomeMenuHelper.INSTANCE.

        HomeMenuHelper.INSTANCE.doFeedback("Test","9876543210","test@testmail.com","feedback","improvements").continueWith(new Continuation<JSONObject, Void>() {
            @Override
            public Void then(Task<JSONObject> task) {

                try {
                    System.out.println("HPOO"+task.getResult());
                    JSONObject menuResponse = task.getResult();

                } catch (Exception e) {
                    e.printStackTrace();
                    //  AppDialogs.showAlertDialog(getActivity(), getResources().getString(R.string.app_name), getResources().getString(R.string.failure_api));

                }
                hidepDialog();
                return null;

            }
        }, Task.UI_THREAD_EXECUTOR);


    }

    public class submitFeedback extends AsyncTask<String, String, JSONObject> {

        JSONObject jObject;

        @Override
        protected void onPreExecute() {
            // TODO Auto-generated method stub
            showpDialog();
            super.onPreExecute();
        }

        @Override
        protected JSONObject doInBackground(String... arg0) {
            // TODO Auto-generated method stub

            String name1 = name.getText().toString();
            String email1 =email.getText().toString();
            String mobile1 = phone.getText().toString();
            String subject1 = "Enquiry";
            String feedback1 = feedback.getText().toString();

            List<NameValuePair> validateParams = new ArrayList<NameValuePair>();
            validateParams.add(new BasicNameValuePair("name", name1));
            validateParams.add(new BasicNameValuePair("phone", email1));
            validateParams.add(new BasicNameValuePair("email", mobile1));
            validateParams.add(new BasicNameValuePair("subject", subject1));
            validateParams.add(new BasicNameValuePair("comments", feedback1));
            jObject = jsonParse.makeHttpRequest("https://cloudi5.com/hospital/Api/Api/feedback", "POST",
                    validateParams);
            try {
                successTag = jObject.toString();
                System.out.println("-------------------Json result -----------------------------------------");
                System.out.println("Json result "+ successTag);
                System.out.println("Json result "+ successTag);
                System.out.println("-------------------Json result -----------------------------------------");

            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            return jObject;
        }

        @SuppressLint({"InlinedApi", "LongLogTag"})
        protected void onPostExecute(JSONObject result) {

            // TODO Auto-generated method stub

            super.onPostExecute(result);
            hidepDialog();
//                "response": "Success",
//    "response_code": 1,
//    "message": " Feedback has been added successfully."
            try {
                if (result.get("response_code").equals(1)) {
                    snackbar = Snackbar.make(coordinatorLayout, result.getString("message"), Snackbar.LENGTH_LONG);
                    snackbar.show();

                } else {
                    snackbar = Snackbar.make(coordinatorLayout, result.getString("message"), Snackbar.LENGTH_LONG);
                    snackbar.show();
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }

        }

    }

    private void showpDialog() {
        if (!pDialog.isShowing())
            pDialog.show();
    }

    private void hidepDialog() {
        if (pDialog.isShowing())
            pDialog.dismiss();
    }
    @Override
    public void onResume() {

        try {
            super.onResume();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
