package com.cloudifive.healthcare.Adapter;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.cloudifive.healthcare.Models.Facilities;
import com.cloudifive.healthcare.Models.Infrastructure;
import com.cloudifive.healthcare.R;

import java.util.List;


/**
 * Created by Abhi on 02 Oct 2017 002.
 */

public class FacilitiesAdapter extends RecyclerView.Adapter<FacilitiesAdapter.CustomViewHolder> {
    private Context mContext;
    private List<Facilities> modelNews;
    int myPosition;

    public FacilitiesAdapter(List<Facilities> modelNews, Context mContext) {
        this.mContext = mContext;
        this.modelNews = modelNews;
    }

    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_infrastructure, parent, false);

        return new CustomViewHolder(itemView);
    }

    /**
     *  Populate the views with appropriate Text and Images
     * @param holder
     * @param position
     */
    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(final CustomViewHolder holder, int position) {
        Facilities projectsModel = modelNews.get(position);

        try {
            holder.name.setText(projectsModel.getTitle());
            holder.desc.setText(projectsModel.getImage_count() + " Listings");

            Glide.with(mContext)
                    .load("https://cloudi5.com/hospital/"+projectsModel.getImage())
                    .placeholder(R.drawable.splash_bg)
                    .error(R.drawable.splash_bg)
                    .into(holder.image);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Override
    public int getItemCount() {
        return modelNews.size();
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView name, desc,venue,date;
        public ImageView image;
        public CardView mycard;

        /**
         * Constructor to initialize the Views
         *
         * @param itemView
         */
        public CustomViewHolder(View itemView) {
            super(itemView);
            mycard = (CardView) itemView.findViewById(R.id.mycard);
            name = (TextView) itemView.findViewById(R.id.galleryName);
            desc = (TextView) itemView.findViewById(R.id.galleryDescription);
            image = (ImageView) itemView.findViewById(R.id.galleryImage);
            mycard.setOnClickListener(this);


        }

        @Override
        public void onClick(View v) {
            int position = (Integer) v.getTag();
            Facilities aItem = modelNews.get(position);
            myPosition = position;
            switch (v.getId()) {
                case R.id.mycard:
                    showDialog();
            }
        }
    }

    private void showDialog() {
        final Dialog dialog = new Dialog(mContext);
        dialog.setContentView(R.layout.dialog); //layout for dialog
        dialog.setCancelable(true); //none-dismiss when touching outside Dialog
        dialog.show();
    }

}
