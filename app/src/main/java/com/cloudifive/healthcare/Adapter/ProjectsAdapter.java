package com.cloudifive.healthcare.Adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.CardView;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import com.bumptech.glide.Glide;
import com.cloudifive.healthcare.Models.ModelProjects;
import com.cloudifive.healthcare.R;


/**
 * Created by Abhi on 02 Oct 2017 002.
 */

public class ProjectsAdapter extends RecyclerView.Adapter<ProjectsAdapter.CustomViewHolder> {
    private Context mContext;
    private List<ModelProjects> modelProjects;

    public ProjectsAdapter(List<ModelProjects> modelProjects, Context mContext) {
        this.mContext = mContext;
        this.modelProjects = modelProjects;
    }

    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_projects, parent, false);

        return new CustomViewHolder(itemView);
    }

    /**
     *  Populate the views with appropriate Text and Images
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(final CustomViewHolder holder, int position) {
        ModelProjects modelProjects = this.modelProjects.get(position);
        holder.mycard.setCardBackgroundColor(Color.parseColor(modelProjects.getTheme()));
        //System.out.println("COLORS "+ modelProjects.getColor());
        holder.name.setText(modelProjects.getTitle());
        holder.desc.setText(Html.fromHtml(modelProjects.getDescription()));

        try {

            Glide.with(mContext)
                    .load(modelProjects.getImage())
                    .into(holder.image);
        } catch (Exception e) {
            e.printStackTrace();
        }
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
        return modelProjects.size();
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder {
        public TextView name, desc;
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
            name = (TextView) itemView.findViewById(R.id.projectName);
            desc = (TextView) itemView.findViewById(R.id.projectDescription);
            image = (ImageView) itemView.findViewById(R.id.projectImage);

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
