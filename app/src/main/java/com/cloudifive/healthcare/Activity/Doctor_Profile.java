package com.cloudifive.healthcare.Activity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.BitmapImageViewTarget;
import com.cloudifive.healthcare.Adapter.DoctorsAdapter;
import com.cloudifive.healthcare.Models.Doctors;
import com.cloudifive.healthcare.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Doctor_Profile extends AppCompatActivity {
     @BindView(R.id.docName)TextView docName;
     @BindView(R.id.doctor_img)ImageView docImage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dactor__profile);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ButterKnife.bind(this);
        Bundle extras = getIntent().getExtras();
        String name=extras.getString("doctor");
        String img=extras.getString("img");
        Doctors doctors=new Doctors();
        doctors.setExperience(extras.getString("exp"));
        docName.setText(name);

        Glide.with(Doctor_Profile.this).load("https://cloudi5.com/hospital/"+img).asBitmap().centerCrop().into(new BitmapImageViewTarget(((Doctor_Profile.this)).docImage) {
            @Override
            protected void setResource(Bitmap resource) {
                RoundedBitmapDrawable circularBitmapDrawable =
                        RoundedBitmapDrawableFactory.create(Doctor_Profile.this.getResources(), resource);
                circularBitmapDrawable.setCircular(true);
               docImage.setImageDrawable(circularBitmapDrawable);
            }
        });


    }

}
