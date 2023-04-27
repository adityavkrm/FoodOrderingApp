package com.example.foodapp;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomsheet.BottomSheetDialog;

import org.w3c.dom.Text;

import java.util.ArrayList;
public class RecyclerCartAdapter extends RecyclerView.Adapter<RecyclerCartAdapter.MyViewHolder> {
    ArrayList<cartModel> cartArraylist;

    TextView totalamount;
    Context context;

    public RecyclerCartAdapter(ArrayList<cartModel> cartArraylist, Context context, TextView totalamount) {
        this.cartArraylist = cartArraylist;
        this.context = context;
        this.totalamount = totalamount;
        updateamount();

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.my_cart_recycler_layout,parent,false);
        MyViewHolder viewHolder = new MyViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, @SuppressLint("RecyclerView") int position) {

        cartModel temp = cartArraylist.get(position);
        holder.cartImage.setImageResource(cartArraylist.get(position).getMyCartImage());
        holder.cartItemTitle.setText(cartArraylist.get(position).getMyCartTitle());
        holder.cartItemCost.setText(cartArraylist.get(position).getMyCartCost());
        holder.cartItemCount.setText(String.valueOf(cartArraylist.get(position).getMyCartCount()));




        holder.removeFromCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyDBHelper dbHelper = new MyDBHelper(context);
                dbHelper.removeFromCart(temp.myCartTitle);
                cartArraylist = dbHelper.fetchCart();
                notifyItemRemoved(position);
                updateamount();

            }
        });

        holder.plusbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               int count = cartArraylist.get(position).getMyCartCount();
               count++;
               cartArraylist.get(position).setMyCartCount(count);
               notifyDataSetChanged();
                updateamount();

            }
        });

        holder.minusbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int count = cartArraylist.get(position).getMyCartCount();
                if(count>1){
                count--;}
                cartArraylist.get(position).setMyCartCount(count);
                notifyDataSetChanged();
                updateamount();

            }
        });


    }

    @Override
    public int getItemCount() {
       return cartArraylist.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView cartImage , plusbtn, minusbtn;
        ImageButton removeFromCart;
        TextView cartItemTitle, cartItemCount,cartItemCost;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            cartImage = itemView.findViewById(R.id.cartItemImage);
            cartItemTitle = itemView.findViewById(R.id.cartItemTitle);
            cartItemCost = itemView.findViewById(R.id.cartItemCost);
            cartItemCount = itemView.findViewById(R.id.counttext);
            removeFromCart = itemView.findViewById(R.id.deleteButton);
            plusbtn = itemView.findViewById(R.id.plusicon);
            minusbtn = itemView.findViewById(R.id.minusicon);

        }
    }

    public void updateamount(){
        int sum = 0, i;
        for(i=0; i<cartArraylist.size();i++){
            sum = sum + Integer.parseInt(cartArraylist.get(i).getMyCartCost()) * cartArraylist.get(i).getMyCartCount();
        }

        totalamount.setText("₹ "+sum);
    }


}
