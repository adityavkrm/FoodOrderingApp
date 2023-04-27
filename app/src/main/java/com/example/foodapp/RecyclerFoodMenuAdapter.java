package com.example.foodapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerFoodMenuAdapter extends RecyclerView.Adapter<RecyclerFoodMenuAdapter.MyViewHolder> {

    ArrayList<foodMenuModel> foodMenuArray;
    Context context;

    public RecyclerFoodMenuAdapter(ArrayList<foodMenuModel> foodMenuArray, Context context) {
        this.foodMenuArray = foodMenuArray;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerFoodMenuAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.food_menu_item_layout,parent,false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        foodMenuModel temp = foodMenuArray.get(position);
        holder.itemImage.setImageResource(foodMenuArray.get(position).getFoodMenuImage());
        holder.itemTitle.setText(foodMenuArray.get(position).getFoodMenuTitle());
        holder.itemDescription.setText(foodMenuArray.get(position).getFoodMenuDescription());
        holder.itemCost.setText(foodMenuArray.get(position).getFoodMenuCost());
        holder.itemRatings.setText(foodMenuArray.get(position).getFoodMenuRating());


        holder.itemaddToCartBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyDBHelper dbHelper = new MyDBHelper(context);
                dbHelper.addDatatoCart(temp.getFoodMenuTitle(),temp.getFoodMenuCost(),1,temp.getFoodMenuImage());
                displayCustomToast("Item added to cart");
            }
        });



    }

    @Override
    public int getItemCount() {
        return foodMenuArray.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView itemImage;
        TextView itemTitle, itemCost,itemDescription, itemRatings;
        Button itemaddToCartBtn;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            itemImage = itemView.findViewById(R.id.foodMenuImage);
            itemCost = itemView.findViewById(R.id.foodMenuCost);
            itemDescription = itemView.findViewById(R.id.foodMenuDescription);
            itemTitle = itemView.findViewById(R.id.foodMenuTitle);
            itemaddToCartBtn = itemView.findViewById(R.id.foodMenuAddToCartButton);
            itemRatings = itemView.findViewById(R.id.foodMenuRating);
        }
    }
    public void displayCustomToast(String message){
        LayoutInflater inflater = LayoutInflater.from(context);
        View layout = inflater.inflate(R.layout.custom_toast,null);

        TextView txt = layout.findViewById(R.id.toasttext);
        txt.setText(message);

        Toast toast = new Toast(context);
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.setView(layout);
        toast.show();
    }

}
