package com.example.foodapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {
    TextView nametxt;
    ImageView myCartButton ,profilepicimg;
    SharedPreferences pref;
    RecyclerView categoriesRecyclerView,popularRecyclerView;
    ArrayList<categoriesModel> categories;
    ArrayList<cartModel> cartArrayList;
    ArrayList<popularModel> popularItems;

    RecyclerPopularAdapter recyclerPopularAdapter;
    RecyclerCategoriesAdapter recyclerCategoriesAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        categoriesRecyclerView = findViewById(R.id.categoriesRecyclerview);
        categoriesRecyclerView.setLayoutManager(new LinearLayoutManager(HomeActivity.this,LinearLayoutManager.HORIZONTAL,false));

        popularRecyclerView = findViewById(R.id.popularRecyclerView);
        popularRecyclerView.setLayoutManager(new LinearLayoutManager(HomeActivity.this,LinearLayoutManager.VERTICAL,false));

        myCartButton = findViewById(R.id.mycartbutton);

        cartArrayList = (ArrayList<cartModel>) getIntent().getSerializableExtra("cartItemList");


        myCartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, cartActivity.class);
                startActivity(intent);
            }
        });

        pref = getSharedPreferences("login",MODE_PRIVATE);

        profilepicimg = findViewById(R.id.profilpicimage);
        profilepicimg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dialog logoutdialog = new Dialog(HomeActivity.this);
                logoutdialog.setContentView(R.layout.logoutdialoglayout);
                logoutdialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                TextView personEmail = logoutdialog.findViewById(R.id.useremailid);
                Button logoutbtn = logoutdialog.findViewById(R.id.logoutbtn);
                personEmail.setText(pref.getString("EMAIL",""));   // setting the email nam eof logged in usee

                logoutbtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        SharedPreferences.Editor editor = pref.edit();
                        editor.putBoolean("flag",false);
                        editor.apply();
                        Intent intent = new Intent(HomeActivity.this,loginActivity.class);
                        startActivity(intent);
                    }
                });

                logoutdialog.show();
            }
        });


        nametxt = findViewById(R.id.userName);
        nametxt.setText(pref.getString("NAME",""));   //setting name of logged in user

        categories = new ArrayList<>();
        categories.add(new categoriesModel(R.drawable.burger,"Burger"));
        categories.add(new categoriesModel(R.drawable.pizza,"Pizza"));
        categories.add(new categoriesModel(R.drawable.dosa,"Dosa"));
        categories.add(new categoriesModel(R.drawable.chicken,"Chicken"));
        categories.add(new categoriesModel(R.drawable.chinese,"Chinese"));

        recyclerCategoriesAdapter = new RecyclerCategoriesAdapter(HomeActivity.this,categories);
        categoriesRecyclerView.setAdapter(recyclerCategoriesAdapter);

        popularItems = new ArrayList<>();
        popularItems.add(new popularModel("Veg Extravaganza Pizza","Black olives, capsicum, onion, grilled mushroom, corn, tomato, jalapeno and extra cheese.","4.5","259",R.drawable.extravaganza));
        popularItems.add(new popularModel("Double Quarter Pounder","Salt, pepper,topped with slivered onions, tangy pickles, two slices of melty cheese on a sesame seed bun.","4.6","159",R.drawable.popularburger));
        popularItems.add(new popularModel("Masala Dosa","Mix of rice and lentils stuffed with potatoes, mustard seeds, chutneys and sambar.","4.4","129",R.drawable.masala_dosa));
        popularItems.add(new popularModel("Chicken Tikka Masala", "Marinated chicken cooked in a creamy tomato-based sauce with Indian spices. Served with rice or naan bread.","4.3","439",R.drawable.chicken_tikka));


        recyclerPopularAdapter = new RecyclerPopularAdapter(popularItems,HomeActivity.this);
        popularRecyclerView.setAdapter(recyclerPopularAdapter);



    }
}