package com.cloudifive.healthcare.Adapter;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.BitmapImageViewTarget;
import com.cloudifive.healthcare.Activity.Doctor_Profile;
import com.cloudifive.healthcare.Models.Doctors;
import com.cloudifive.healthcare.R;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.HashMap;

public class DoctorsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>  {
    ArrayList<Doctors> myHisJbItem;
    Dialog myPreviewDialog;
    private LayoutInflater inflater;
    private Context myCtx;

    public DoctorsAdapter(Context context, ArrayList<Doctors> items) {
        myCtx = context;
        inflater = LayoutInflater.from(context);
        myHisJbItem = items;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.disp_hisjob_row1, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, int position) {
        try {
            Doctors aItem = myHisJbItem.get(position);
            HashMap<String,Object> myAllData=aItem.getMyAMapData();
            System.out.println("myHashMap"+myAllData.get(""));
            ((MyViewHolder) holder).aNameTV.setText(aItem.getName());
            ((MyViewHolder) holder).aAddrTV.setText(aItem.getAddress1());

            Glide.with(myCtx).load("https://cloudi5.com/hospital/"+aItem.getImage()).asBitmap().centerCrop().into(new BitmapImageViewTarget(((MyViewHolder) holder).image) {
                @Override
                protected void setResource(Bitmap resource) {
                    RoundedBitmapDrawable circularBitmapDrawable =
                            RoundedBitmapDrawableFactory.create(myCtx.getResources(), resource);
                    circularBitmapDrawable.setCircular(true);
                    ((MyViewHolder)holder).image.setImageDrawable(circularBitmapDrawable);
                }
            });
                    //.into(((MyViewHolder) holder).image);


            ((MyViewHolder) holder).image_next.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                  Intent intent=new Intent(myCtx,Doctor_Profile.class);
                  intent.putExtra("doctor",((MyViewHolder) holder).aNameTV.getText().toString());
                  myCtx.startActivity(intent);


                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getItemCount() {
        return myHisJbItem.size();
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView aNameTV, aAddrTV;
        public ImageView image,image_next;

        public MyViewHolder(View itemView) {
            super(itemView);
            try {
                aNameTV = (TextView) itemView.findViewById(R.id.list_title);
                aAddrTV = (TextView) itemView.findViewById(R.id.list_desc);
                image = (ImageView) itemView.findViewById(R.id.image);
                image_next=(ImageView)itemView.findViewById(R.id.icon_next);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }


        @Override
        public void onClick(View v) {
            try {
                int aPosition = 0;
                Doctors aItem;
                switch (v.getId()) {
                    default:
                        break;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        private void showCustomDialog(Doctors aItem, int aFlag) {
//            myPreviewDialog = new Dialog(myCtx);
//            myPreviewDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
//            myPreviewDialog.setContentView(R.layout.disp_jobpreview_dialog);
//            myPreviewDialog.setCancelable(false);
//            myPreviewDialog.show();
        }
    }
}