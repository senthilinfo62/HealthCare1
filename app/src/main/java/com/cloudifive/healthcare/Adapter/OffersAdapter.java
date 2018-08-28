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

import com.cloudifive.healthcare.Models.Departments;
import com.cloudifive.healthcare.Models.Offers;
import com.cloudifive.healthcare.R;

import java.util.List;


/**
 * Created by Abhi on 02 Oct 2017 002.
 */

public class OffersAdapter extends RecyclerView.Adapter<OffersAdapter.CustomViewHolder> {
    private Context mContext;
    private List<Offers> modelNews;
    int myPosition;

    public OffersAdapter(List<Offers> modelNews, Context mContext) {
        this.mContext = mContext;
        this.modelNews = modelNews;
    }

    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_offers, parent, false);

        return new CustomViewHolder(itemView);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(final CustomViewHolder holder, int position) {
        Offers projectsModel = modelNews.get(position);

        try {
            holder.name.setText(projectsModel.getTitle());
            holder.desc.setText(projectsModel.getDescription());
            holder.price.setText(projectsModel.getPrice());
            holder.date.setText(projectsModel.getStart_date()+" - "+projectsModel.getEnd_date());


            } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Override
    public int getItemCount() {
        return modelNews.size();
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView name, desc,price,date;
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
            name = (TextView) itemView.findViewById(R.id.title);
            desc = (TextView) itemView.findViewById(R.id.price);
            price = (TextView) itemView.findViewById(R.id.description);
            date = (TextView) itemView.findViewById(R.id.valid);


        }

        @Override
        public void onClick(View v) {
            int position = (Integer) v.getTag();
            Offers aItem = modelNews.get(position);
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
