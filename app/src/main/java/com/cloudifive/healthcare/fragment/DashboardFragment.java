package com.cloudifive.healthcare.fragment;



import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.cloudifive.healthcare.DashboardActivity;
import com.cloudifive.healthcare.R;

import am.appwise.components.ni.NoInternetDialog;

public class DashboardFragment extends Fragment implements View.OnClickListener {

    CardView aboutus, doctors, infrastructures, facilities, offers, departments, complaints, feedback, contactus, enquiry;
    LinearLayout ll1;

    private static final String TAG = DashboardFragment.class.getSimpleName();
    NoInternetDialog noInternetDialog;
    // url to fetch shopping items


    public DashboardFragment() {
        // Required empty public constructor
    }

    public static DashboardFragment newInstance(String param1, String param2) {
        DashboardFragment fragment = new DashboardFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        ((AppCompatActivity) getActivity()).getSupportActionBar().hide();
        ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle("HealthCare");
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_dashboard, container, false);
        intializeView(view);


        return view;
    }

    private void intializeView(View view) {
     noInternetDialog = new NoInternetDialog.Builder(getActivity()).build();

        aboutus =(CardView)view.findViewById(R.id.aboutus);
    doctors =(CardView)view.findViewById(R.id.doctors);
    infrastructures =(CardView)view.findViewById(R.id.infrastuctures);
    facilities =(CardView)view.findViewById(R.id.facilities);
    offers =(CardView)view.findViewById(R.id.offers);
    departments =(CardView)view.findViewById(R.id.departments);
    complaints =(CardView)view.findViewById(R.id.complaints);
    feedback =(CardView)view.findViewById(R.id.feedback);
    contactus =(CardView)view.findViewById(R.id.contactus);
    enquiry =(CardView)view.findViewById(R.id.enquiry);
    aboutus.setOnClickListener(this);
    doctors.setOnClickListener(this);
    infrastructures.setOnClickListener(this);
    facilities.setOnClickListener(this);
    offers.setOnClickListener(this);
    departments.setOnClickListener(this);
    complaints.setOnClickListener(this);
    feedback.setOnClickListener(this);
    contactus.setOnClickListener(this);
    enquiry.setOnClickListener(this);



    }


    @Override
    public void onClick(View v)
    {
        try {
            Fragment fragment=null;
            switch(v.getId()) {
                 case R.id.aboutus:
                    fragment=new AboutusFragment();
                    callFrage(fragment,"aboutus");
                    break;
                case R.id.doctors:
                    fragment=new DoctorsFragment();
                    callFrage(fragment,"history");
                    break;
                case R.id.infrastuctures:
                    fragment=new InfrastructureFragment();
                    callFrage(fragment,"infrastructure");
                    break;
                case R.id.facilities:
                    fragment=new FacilitiesFragment();
                    callFrage(fragment,"facilities");
                    break;
                case R.id.offers:
                    fragment=new OffersFragment();
                    callFrage(fragment,"offers");
                    break;
                case R.id.departments:
                    fragment=new DepartmentsFragment();
                    callFrage(fragment,"departments");
                    break;
                case R.id.complaints:
                    fragment=new ComplaintsFragment();
                    callFrage(fragment,"complaints");
                    break;
                case R.id.feedback:
                    fragment=new FeedbackFragment();
                    callFrage(fragment,"feedback");
                    break;
                case R.id.contactus:
                    fragment=new ContactusFragment();
                    callFrage(fragment,"contactus");

                    break;
                case R.id.enquiry:
                    fragment=new EnquiryFragment();
                    callFrage(fragment,"enquiry");
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
