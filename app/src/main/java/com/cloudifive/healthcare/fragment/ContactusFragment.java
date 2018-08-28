package com.cloudifive.healthcare.fragment;


import android.Manifest;
import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.cloudifive.healthcare.Models.Chairman;
import com.cloudifive.healthcare.R;
import com.cloudifive.healthcare.service.HomeMenuHelper;
import com.cloudifive.healthcare.utils.NetworkState;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.Map;

import am.appwise.components.ni.NoInternetDialog;
import bolts.Continuation;
import bolts.Task;


public class ContactusFragment extends Fragment implements OnMapReadyCallback {

    private static final String TAG = ContactusFragment.class.getSimpleName();

    private MapView mapView;
    private GoogleMap googleMap;
    private ProgressDialog pDialog;
    NetworkState myNet;
    NoInternetDialog noInternetDialog;
    static LatLng Your_Location = new LatLng(23.81, 90.41); //Your LatLong
    TextView address,phone,alternate_phone,mail;

    public ContactusFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        try {
            ((AppCompatActivity) getActivity()).getSupportActionBar().show();
            ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle("Contact us");
            ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);

            super.onCreate(savedInstanceState);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    @Nullable
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_contactus, container, false);


        try {
            mapView = (MapView) view.findViewById(R.id.map);
            mapView.onCreate(savedInstanceState);
            mapView.onResume();
            mapView.getMapAsync(this);
            pDialog = new ProgressDialog(getContext());
            noInternetDialog = new NoInternetDialog.Builder(getActivity()).build();
            myNet = new NetworkState(getActivity());
            address=(TextView)view.findViewById(R.id.address);
            phone=(TextView)view.findViewById(R.id.phone);
            alternate_phone=(TextView)view.findViewById(R.id.alternate_phone);
            mail=(TextView)view.findViewById(R.id.mail);

            createList();


        } catch (Exception e) {
            e.printStackTrace();
        }
        return view;
    }

    @Override
    public void onMapReady(GoogleMap map) {
        try {
            googleMap = map;

            //googleMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
            //googleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
            googleMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
            //googleMap.setMapType(GoogleMap.MAP_TYPE_TERRAIN);
            googleMap.setBuildingsEnabled(true);
            googleMap.setIndoorEnabled(true);
            if (ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                // TODO: Consider calling
                //    ActivityCompat#requestPermissions
                // here to request the missing permissions, and then overriding
                //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                //                                          int[] grantResults)
                // to handle the case where the user grants the permission. See the documentation
                // for ActivityCompat#requestPermissions for more details.
                return;
            }
            googleMap.setMyLocationEnabled(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Load new jobs lists in Lisview **
     */
    private void createList() {
        try {

            if (myNet.isInternetOn()) {

                pDialog.setMessage("Please wait...");
                pDialog.setCancelable(false);

                showpDialog();
                HomeMenuHelper.INSTANCE.getContactus().continueWith(new Continuation<JSONObject, Void>() {
                    @Override
                    public Void then(Task<JSONObject> task) {

                        try {
                            System.out.println("HPOO" + task.getResult());
                            JSONObject menuResponse = task.getResult();
                            if (menuResponse != null) {
                                JSONArray jsonArray = new JSONArray(menuResponse.getJSONArray("get_Contact_us").toString());


                                for (int i = 0; i < jsonArray.length(); i++) {
                                    JSONObject jsonObject = jsonArray.getJSONObject(i);
                                    address.setText(jsonObject.getString("address"));
                                    phone.setText(jsonObject.getString("mobile"));
                                    alternate_phone.setText(jsonObject.getString("alternate_number"));
                                    mail.setText(jsonObject.getString("email"));

                                    Your_Location=new LatLng(Double.parseDouble(jsonObject.getString("lat")), Double.parseDouble(jsonObject.getString("lng")));
                                    googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(Your_Location, 15));
                                    {
                                        googleMap.addMarker(new MarkerOptions()
                                                .title(jsonObject.getString("address"))
                                                .position(new LatLng(
                                                        Double.parseDouble(jsonObject.getString("lat")),
                                                        Double.parseDouble(jsonObject.getString("lng"))
                                                ))
                                                .snippet("snippet")
                                        );
                                    }
                                }
                            }
                            hidepDialog();

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
    @Override
    public void onResume() {
        try {
            mapView.getMapAsync(this);
            createList();
            super.onResume();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}