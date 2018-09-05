package com.cloudifive.healthcare.fragment;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cloudifive.healthcare.Adapter.DoctorsAdapter;
import com.cloudifive.healthcare.Models.Doctors;
import com.cloudifive.healthcare.R;
import com.cloudifive.healthcare.service.HomeMenuHelper;
import com.cloudifive.healthcare.utils.NetworkState;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import am.appwise.components.ni.NoInternetDialog;
import bolts.Continuation;
import bolts.Task;

public class DoctorsFragment extends Fragment implements  View.OnClickListener {
    RecyclerView myRecyclerView;
    DoctorsAdapter myHisJbAdaptr;
    CoordinatorLayout myHisCL;
    private ArrayList <Doctors> myHisJbLst = new ArrayList <Doctors> ();
    private ProgressDialog pDialog;
    NetworkState myNet;
    NoInternetDialog noInternetDialog;

    public DoctorsFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ((AppCompatActivity) getActivity()).getSupportActionBar().show();
        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle("Doctors");
        ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_doctors, container, false);
        pDialog = new ProgressDialog(getContext());
        noInternetDialog = new NoInternetDialog.Builder(getActivity()).build();
        myNet=new NetworkState(getActivity());
        myRecyclerView = (RecyclerView) rootView.findViewById(R.id.hisJobList);
        myHisCL = (CoordinatorLayout) rootView.findViewById(R.id.aHis_CL_ID);
        createList();
        myRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        return rootView;
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }


    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }
    //

    /**
     * Show history filter dialog box *
     */

    @Override
    public void onResume() {
        try {
            myHisJbLst.clear();
//            myHisJbAdaptr.notifyDataSetChanged();
            createList();
            super.onResume();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

   
    @Override
    public void onClick(View arg0) {
        Calendar now = Calendar.getInstance();
        Date aFromDate, aToDate;
        switch (arg0.getId()) {
                 default:
                break;
        }
    }

    private void updateJobHistory() {
        try {
            myRecyclerView.setVisibility(View.VISIBLE);
            myHisJbAdaptr = new DoctorsAdapter(getActivity(), myHisJbLst);
            myHisJbAdaptr.notifyDataSetChanged();
            myRecyclerView.setAdapter(myHisJbAdaptr);
            hidepDialog();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    private void createList() {
        try {

            if (myNet.isInternetOn()) {

                myHisJbLst.clear();
                pDialog.setMessage("Please wait...");
                pDialog.setCancelable(false);

                showpDialog();
                HomeMenuHelper.INSTANCE.getDoctors().continueWith(new Continuation<JSONObject, Void>() {
                    @Override
                    public Void then(Task<JSONObject> task) {

                        try {
                            myHisJbLst.clear();
                            System.out.println("HPOO" + task.getResult());
                            JSONObject menuResponse = task.getResult();
                            if (menuResponse != null) {
                                JSONArray jsonArray = new JSONArray(menuResponse.getJSONArray("get_Doctor").toString());


                                for (int i = 0; i < jsonArray.length(); i++) {
                                    JSONObject jsonObject = jsonArray.getJSONObject(i);
                                    String name = jsonObject.getString("name");
                                    String description = jsonObject.getString("unique_id");
                                    String image = jsonObject.getString("image");


                                    Doctors aItem = new Doctors();
                                    aItem.setName(name);
                                    aItem.setAddress1(description);
                                    aItem.setImage(image);
                                    aItem.setDescription(jsonObject.getString("description"));
                                    aItem.setGrade(jsonObject.getString("grade"));
                                    aItem.setGender(jsonObject.getString("gender"));
                                    aItem.setAddress(jsonObject.getString("address"));
                                    aItem.setPhone(jsonObject.getString("phone"));
                                    aItem.setEmail(jsonObject.getString("email"));
                                    aItem.setType(jsonObject.getString("type"));
                                    aItem.setExperience(jsonObject.getString("experience"));
                                    aItem.setStatus(jsonObject.getString("status"));
                                    myHisJbLst.add(aItem);

                                }
                                updateJobHistory();
                            }

                        } catch (Exception e) {
                            hidepDialog();
                            e.printStackTrace();
                            //  AppDialogs.showAlertDialog(getActivity(), getResources().getString(R.string.app_name), getResources().getString(R.string.failure_api));

                        }
                        return null;
                    }
                }, Task.UI_THREAD_EXECUTOR);
            }
            else
            {
                noInternetDialog.showDialog();
            }
        } catch (Exception e) {
            e.printStackTrace();
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