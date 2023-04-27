package com.example.foodapp;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerCategoriesAdapter extends RecyclerView.Adapter<RecyclerCategoriesAdapter.ViewHolder> {
    ArrayList<categoriesModel> categories;
    Context context;

    RecyclerCategoriesAdapter(Context context, ArrayList<categoriesModel> categories){
        this.context = context;
        this.categories = categories;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.categories_layout,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, @SuppressLint("RecyclerView") int position) {

        categoriesModel temp = categories.get(position);
        holder.categoryImage.setImageResource(categories.get(position).getCategoryImage());
        holder.categoryTitle.setText(categories.get(position).getCategoryTitle());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String categoryName = categories.get(position).getCategoryTitle();
                Intent intent = new Intent(context,foodMenuActivity.class);
                intent.putExtra("category_title",categoryName);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        });



    }

    @Override
    public int getItemCount() {
        return categories.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView categoryImage;
        TextView categoryTitle;
        public ViewHolder(View itemView){
            super(itemView);

            categoryImage = itemView.findViewById(R.id.categoryImage);
            categoryTitle = itemView.findViewById(R.id.categorytitle);
        }
    }
}
