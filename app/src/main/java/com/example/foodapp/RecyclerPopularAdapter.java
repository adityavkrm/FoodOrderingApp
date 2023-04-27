package com.example.foodapp;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.zip.Inflater;

public class RecyclerPopularAdapter extends RecyclerView.Adapter<RecyclerPopularAdapter.ViewHolder> {

    ArrayList<popularModel> popularItems ;
    ArrayList<cartModel> cartArrayList;
    Context context;

    RecyclerPopularAdapter(ArrayList<popularModel> popularItems,Context context){
        this.popularItems = popularItems;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.popular_layout,parent,false);
        ViewHolder v = new ViewHolder(view);
        return v;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        popularModel temp = popularItems.get(position);
        holder.itemImage.setImageResource(popularItems.get(position).getImage());
        holder.itemTitle.setText(popularItems.get(position).getTitle());
        holder.itemDescription.setText(popularItems.get(position).getDescription());
        holder.itemRating.setText(popularItems.get(position).getRating());
        holder.itemCost.setText(popularItems.get(position).getRupee());

        holder.addToCartbtnpopular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyDBHelper dbHelper = new MyDBHelper(context);
                dbHelper.addDatatoCart(temp.getTitle(),temp.getRupee(),1,temp.getImage());
                displayCustomToast("Item added to cart");

            }
        });
    }


    @Override
    public int getItemCount() {
        return popularItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        ImageView itemImage;
        Button addToCartbtnpopular;
        TextView itemTitle, itemDescription, itemRating, itemCost;
        public ViewHolder(View itemView) {
            super(itemView);
            itemImage = itemView.findViewById(R.id.popular_image);
            itemTitle = itemView.findViewById(R.id.popular_title);
            itemDescription = itemView.findViewById(R.id.popular_description);
            itemRating = itemView.findViewById(R.id.rating_count);
            itemCost = itemView.findViewById(R.id.rupee_count);
            addToCartbtnpopular = itemView.findViewById(R.id.addToCartPopularButton);
        }
    }

    public void displayCustomToast(String message){
        LayoutInflater inflater = LayoutInflater.from(context);
        View layout = inflater.inflate(R.layout.custom_toast,null);

        TextView txt = layout.findViewById(R.id.toasttext);
        txt.setText(message);

        Toast toast = new Toast(context);
        toast.setDuration(100);
        toast.setView(layout);
        toast.show();
    }
}
