package com.cloudifive.healthcare.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cloudifive.healthcare.DashboardActivity;
import com.cloudifive.healthcare.R;


public class AboutusFragment extends Fragment implements View.OnClickListener {

    private static final String TAG = AboutusFragment.class.getSimpleName();
    private CardView chairmen,aster,sucessstory;
    // url to fetch shopping items


    public AboutusFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        ((AppCompatActivity) getActivity()).getSupportActionBar().show();
        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle("About us");
        ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_aboutus, container, false);
        chairmen =(CardView)view.findViewById(R.id.chairmen);
        aster =(CardView)view.findViewById(R.id.aster);
        sucessstory =(CardView)view.findViewById(R.id.successstory);
        chairmen.setOnClickListener(this);
        aster.setOnClickListener(this);
        sucessstory.setOnClickListener(this);

        return view;
    }


    @Override
    public void onClick(View v)
    {
        try {
            Fragment fragment=null;
            switch(v.getId()) {
                case R.id.chairmen:
                    fragment=new ChairmensFragment();
                    callFrage(fragment,"chairman");
                    break;
                case R.id.successstory:
                    fragment=new SuccessStoryFragment();
                    callFrage(fragment,"sucess");
                    break;
                case R.id.aster:
                    fragment=new AsterFragment();
                    callFrage(fragment,"aster");
                    break;

            }
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    private void callFrage(Fragment fragment,String aBackStackName) {
        try
        {
            ((DashboardActivity)getActivity()).loadFragment(fragment,aBackStackName);
        } catch (Exception e) {
            e.printStackTrace();
        }
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