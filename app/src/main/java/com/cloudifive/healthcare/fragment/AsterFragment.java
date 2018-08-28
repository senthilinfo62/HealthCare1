package com.cloudifive.healthcare.fragment;


import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import bolts.Continuation;
import bolts.Task;

import com.cloudifive.healthcare.Adapter.AsterAdapter;


import org.json.JSONArray;
import org.json.JSONObject;

import com.cloudifive.healthcare.Models.ModelTestimonials;
import com.cloudifive.healthcare.R;
import com.cloudifive.healthcare.service.HomeMenuHelper;

public class AsterFragment extends Fragment {

    private static final String TAG = AboutusFragment.class.getSimpleName();

    // url to fetch shopping items
    private RecyclerView recyclerView;
    List<ModelTestimonials> modelsModelNews = new ArrayList<>();
    private AsterAdapter nAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private ProgressDialog pDialog;


    public AsterFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        ((AppCompatActivity) getActivity()).getSupportActionBar().show();
        ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle("About Us");

        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_aster, container, false);

        recyclerView = view.findViewById(R.id.recycler_view);
        pDialog = new ProgressDialog(getContext());
        pDialog.setMessage("Please wait...");
        pDialog.setCancelable(false);
        nAdapter = new AsterAdapter(modelsModelNews, getActivity());
        recyclerView.setHasFixedSize(true);
        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(nAdapter);
        recyclerView.setNestedScrollingEnabled(false);
        getFavourite();
        nAdapter.notifyDataSetChanged();

        return view;
    }

    public void getFavourite() {
        showpDialog();
//         HomeMenuHelper.INSTANCE.setContext(getActivity());
//        HomeMenuHelper.INSTANCE.
        HomeMenuHelper.INSTANCE.getAboutus().continueWith(new Continuation<JSONObject, Void>() {
            @Override
            public Void then(Task<JSONObject> task) {

                try {
                    modelsModelNews.clear();
                    System.out.println("HPOO" + task.getResult());
                    JSONObject menuResponse = task.getResult();
                    System.out.println("HIIHHIIIHIHIHIHIHIIHIIHIHIHIHI" + menuResponse);


                    JSONArray jsonArray = new JSONArray(menuResponse.getJSONArray("getabout_us").toString());
                    System.out.println("HIIHHIIIHIHIHIHIHIIHIIHIHIHIHI" + jsonArray);
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject jsonObject = jsonArray.getJSONObject(i);

                        String title = jsonObject.getString("title");
                        String description = jsonObject.getString("description");

                        ModelTestimonials modelNews = new ModelTestimonials("", title, description, "", "");
                        modelsModelNews.add(modelNews);
                        nAdapter.notifyDataSetChanged();
                    }

                    hidepDialog();
                } catch (Exception e) {
                    e.printStackTrace();
                    //  AppDialogs.showAlertDialog(getActivity(), getResources().getString(R.string.app_name), getResources().getString(R.string.failure_api));

                }
                return null;
            }
        }, Task.UI_THREAD_EXECUTOR);


    }

    @Override
    public void onResume() {
        try {
            modelsModelNews.clear();
            //nAdapter.notifyDataSetChanged();
            getFavourite();
            super.onResume();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public class MngrExeListJobs extends AsyncTask<Void, Void, Boolean> {

        public MngrExeListJobs(FragmentActivity activity) {

        }

        // declare other objects as per your need
        @Override
        protected void onPreExecute() {
            // ---Executing progress dialog while configuring---
        }


        @Override
        protected Boolean doInBackground(Void... params) {
            try {
                getFavourite();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return true;
        }

        protected void onPostExecute(Boolean result) {
            super.onPostExecute(result);

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




}
