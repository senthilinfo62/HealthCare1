package com.cloudifive.healthcare.fragment;


import android.app.ProgressDialog;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cloudifive.healthcare.Adapter.InfrastrutureAdapter;
import com.cloudifive.healthcare.Models.Infrastructure;
import com.cloudifive.healthcare.R;
import com.cloudifive.healthcare.service.HomeMenuHelper;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import bolts.Continuation;
import bolts.Task;

public class InfrastructureFragment extends Fragment {

    private static final String TAG = AboutusFragment.class.getSimpleName();

    // url to fetch shopping items
    private static final String URL = "https://api.androidhive.info/json/movies_2017.json";

    private RecyclerView recyclerView;
    List<Infrastructure> modelsModelNews = new ArrayList<>();
    private InfrastrutureAdapter nAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private ProgressDialog pDialog;


    public InfrastructureFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        ((AppCompatActivity) getActivity()).getSupportActionBar().show();
        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle("infrastructure");
        ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_infrastructures, container, false);

        recyclerView = view.findViewById(R.id.recycler_view);
        pDialog = new ProgressDialog(getContext());
        pDialog.setMessage("Please wait...");
        pDialog.setCancelable(false);

        nAdapter = new InfrastrutureAdapter(modelsModelNews,getActivity());
        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(getContext(), 3);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(nAdapter);
        recyclerView.setNestedScrollingEnabled(false);

//        fetchStoreItems();
        getFavourite();
        nAdapter.notifyDataSetChanged();

        return view;
    }

    private int dpToPx(int dp) {
        Resources r = getResources();
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, r.getDisplayMetrics()));
    }

    private void showpDialog() {
        if (!pDialog.isShowing())
            pDialog.show();
    }

    private void hidepDialog() {
        if (pDialog.isShowing())
            pDialog.dismiss();
    }

    public void getFavourite() {
        showpDialog();
//         HomeMenuHelper.INSTANCE.setContext(getActivity());
//        HomeMenuHelper.INSTANCE.
        HomeMenuHelper.INSTANCE.getInfra().continueWith(new Continuation<JSONObject, Void>() {
            @Override
            public Void then(Task<JSONObject> task) {

                try {
                    modelsModelNews.clear();
                    System.out.println("HPOO"+task.getResult());
                    JSONObject menuResponse = task.getResult();
                    JSONArray jsonArray = new JSONArray(menuResponse.getJSONArray("get_Infrastructure").toString());
                    for (int i=0;i<jsonArray.length();i++)
                    {
                        JSONObject jsonObject=jsonArray.getJSONObject(i);
                        String name=jsonObject.getString("title");
                        String description=jsonObject.getString("description");
                        String image=jsonObject.getString("image");
                        Infrastructure modelNews = new Infrastructure("",name,description,image,"");
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
//            modelsModelNews.clear();
//       //     nAdapter.notifyDataSetChanged();
//            getFavourite();
            super.onResume();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
