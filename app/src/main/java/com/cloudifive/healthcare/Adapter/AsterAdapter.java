package com.cloudifive.healthcare.Adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.cloudifive.healthcare.Models.ModelTestimonials;
import com.cloudifive.healthcare.R;

import java.util.List;


/**
 * Created by Abhi on 02 Oct 2017 002.
 */

public class AsterAdapter extends RecyclerView.Adapter<AsterAdapter.CustomViewHolder> {
    private Context mContext;
    private List<ModelTestimonials> modelNews;

    public AsterAdapter(List<ModelTestimonials> modelNews, Context mContext) {
        this.mContext = mContext;
        this.modelNews = modelNews;
    }

    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_testimonials, parent, false);

        return new CustomViewHolder(itemView);
    }

    /**
     *  Populate the views with appropriate Text and Images
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(final CustomViewHolder holder, int position) {
        ModelTestimonials projectsModel = modelNews.get(position);
        holder.name.setText(projectsModel.getTitle());
        holder.price.setText(projectsModel.getDescription());
        holder.state.setText(projectsModel.getDate());
//        holder.image.setImageResource(projectsModel.getImageResource());
//        holder.menu.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                showOptionsMenu(holder.menu);
//            }
//        });
    }

    /**
     * Display options on click of menu icon (3 dots)
     *
     * @param view
     */
    private void showOptionsMenu(View view) {
//        PopupMenu popup = new PopupMenu(mContext, view);
//        MenuInflater inflater = popup.getMenuInflater();
//        inflater.inflate(R.menu.menu_pizza, popup.getMenu());
//        popup.setOnMenuItemClickListener(new PizzaMenuItemClickListener());
//        popup.show();
    }

    @Override
    public int getItemCount() {
        return modelNews.size();
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder {
        public TextView name, price,state;
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
            name = (TextView) itemView.findViewById(R.id.pizzaName);
            price = (TextView) itemView.findViewById(R.id.pizzaPrice);
            state = (TextView) itemView.findViewById(R.id.state);
            image = (ImageView) itemView.findViewById(R.id.pizzaImage);

        }
    }

    private class PizzaMenuItemClickListener implements PopupMenu.OnMenuItemClickListener {
        /**
         * Display Toast message on click of the options in the menu
         *
         * @param item
         * @return
         */
        @Override
        public boolean onMenuItemClick(MenuItem item) {
//            switch (item.getItemId()) {
//                case R.id.action_add_favourite:
//                    Toast.makeText(mContext, "Add to favourite", Toast.LENGTH_SHORT).show();
//                    return true;
//                case R.id.order_now:
//                    Toast.makeText(mContext, "Order Now", Toast.LENGTH_SHORT).show();
//                    return true;
//            }
            return false;
        }
    }
}
