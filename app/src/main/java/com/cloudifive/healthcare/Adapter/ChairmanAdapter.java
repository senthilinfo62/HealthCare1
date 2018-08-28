package com.cloudifive.healthcare.Adapter;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Bitmap;
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
import com.cloudifive.healthcare.Models.Chairman;
import com.cloudifive.healthcare.Models.Doctors;
import com.cloudifive.healthcare.R;

import java.util.ArrayList;
import java.util.HashMap;

public class ChairmanAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>  {
    ArrayList<Chairman> myHisJbItem;
    Dialog myPreviewDialog;
    private LayoutInflater inflater;
    private Context myCtx;

    public ChairmanAdapter(Context context, ArrayList<Chairman> items) {
        myCtx = context;
        inflater = LayoutInflater.from(context);
        myHisJbItem = items;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.card_chairman, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, int position) {
        try {
            Chairman aItem = myHisJbItem.get(position);
            HashMap<String,Object> myAllData=aItem.getMyAMapData();
            System.out.println("myHashMap"+myAllData.get(""));
            ((MyViewHolder) holder).aNameTV.setText(aItem.getName());
            ((MyViewHolder) holder).aAddrTV.setText(aItem.getAddress1());

//            Glide.with(myCtx).load("https://cloudi5.com/hospital/"+aItem.getImage()).asBitmap().centerCrop().into(new BitmapImageViewTarget(((MyViewHolder) holder).image) {
//                @Override
//                protected void setResource(Bitmap resource) {
//                    RoundedBitmapDrawable circularBitmapDrawable =
//                            RoundedBitmapDrawableFactory.create(myCtx.getResources(), resource);
//                    circularBitmapDrawable.setCircular(true);
//                    ((MyViewHolder)holder).image.setImageDrawable(circularBitmapDrawable);
//                }
//            });
                    //.into(((MyViewHolder) holder).image);
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

        public MyViewHolder(View itemView) {
            super(itemView);
            try {
                aNameTV = (TextView) itemView.findViewById(R.id.list_title);
                aAddrTV = (TextView) itemView.findViewById(R.id.list_desc);
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