package com.cloudifive.healthcare.Activity;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.cloudifive.healthcare.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Doctor_Profile extends AppCompatActivity {
     @BindView(R.id.docName)TextView docName;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dactor__profile);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ButterKnife.bind(this);
        Bundle extras = getIntent().getExtras();
        String name=extras.getString("doctor");
        docName.setText(name);



    }

}
