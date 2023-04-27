package com.example.foodapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.ArrayList;

public class cartActivity extends AppCompatActivity {
    RecyclerView cartRecyclerView;
    MyDBHelper dbHelper;
    TextView totalamounttxt;
    Button proceedbtn;

    ArrayList<cartModel> cartArrayList;
    RecyclerCartAdapter recyclerCartAdapter;
    ImageView backbtncart;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        proceedbtn = findViewById(R.id.ProceedButton);
        totalamounttxt = findViewById(R.id.totalamounttxt);
        dbHelper = new MyDBHelper(cartActivity.this);

        backbtncart = findViewById(R.id.backtxtbtncart);
        backbtncart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        dbHelper = new MyDBHelper(this);

        cartRecyclerView = findViewById(R.id.cartRecyclerView);
        cartRecyclerView.setLayoutManager(new LinearLayoutManager(cartActivity.this,LinearLayoutManager.VERTICAL,false));

        cartArrayList = new ArrayList<>();

        cartArrayList = dbHelper.fetchCart();
        recyclerCartAdapter = new RecyclerCartAdapter(cartArrayList,cartActivity.this, totalamounttxt);
        cartRecyclerView.setAdapter(recyclerCartAdapter);
        recyclerCartAdapter.notifyItemInserted(cartArrayList.size()-1);

        proceedbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dialog dialog = new Dialog(cartActivity.this);
                dialog.setContentView(R.layout.order_confirmed);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dbHelper.deleteall();
                cartArrayList = dbHelper.fetchCart();
                recyclerCartAdapter = new RecyclerCartAdapter(cartArrayList,cartActivity.this, totalamounttxt);
                cartRecyclerView.setAdapter(recyclerCartAdapter);
                dialog.show();


            }
        });

    }


}


