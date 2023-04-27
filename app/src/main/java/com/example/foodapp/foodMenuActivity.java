package com.example.foodapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class foodMenuActivity extends AppCompatActivity {

    ImageView backButton;
    TextView menuTitle;
    RecyclerView foodMenuRecyclerView;

    ArrayList <foodMenuModel> foodMenuArray;
    RecyclerFoodMenuAdapter foodMenuAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_menu);

        backButton = findViewById(R.id.backtxtbtn);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        menuTitle = findViewById(R.id.foodMenuHeading);
        foodMenuRecyclerView = findViewById(R.id.foodMenuRecyclerView);

        foodMenuRecyclerView.setLayoutManager(new LinearLayoutManager(foodMenuActivity.this,LinearLayoutManager.VERTICAL,false));

        foodMenuArray = new ArrayList<>();

        if(getIntent().getStringExtra("category_title").equals("Burger")) {
            menuTitle.setText("Burger");
            foodMenuArray.add(new foodMenuModel(R.drawable.bkchickendoublepattyburger, "Chicken Double Patty Burger", "179", "4.5", "Chicken double Patty ,garden fresh crispy lettuce, tomato and our signature sauce."));
            foodMenuArray.add(new foodMenuModel(R.drawable.chickenmakhaniburstburger, "Chicken makhani burst Burger", "100", "4.5", "Enjoy rich makhani flavour with crispy chicken patty topped with fresh onion."));
            foodMenuArray.add(new foodMenuModel(R.drawable.whopperjrveg, "Whopper jr Veg", "149", "4.3", "Veg patty, onion, crispy lettuce, juicy tomatoes, tangy gherkins, creamy and smoky sauces."));
            foodMenuArray.add(new foodMenuModel(R.drawable.bkchickendoublepattyburger, "Chicken Burger with Cheese", "164", "4.6", "Chicken patty ,garden fresh crispy lettuce, tomato,cheese slice and our signature sauce."));
            foodMenuArray.add(new foodMenuModel(R.drawable.vegmakhaniburstburger, "Veg Makhani Burst Burger", "80", "4.4", "Enjoy rich makhani flavour with mix veg patty topped with fresh onion."));
            foodMenuAdapter = new RecyclerFoodMenuAdapter(foodMenuArray, foodMenuActivity.this);
            foodMenuRecyclerView.setAdapter(foodMenuAdapter);

        }

        else if(getIntent().getStringExtra("category_title").equals("Pizza")) {
            menuTitle.setText("Pizza");
            foodMenuArray.add(new foodMenuModel(R.drawable.tandooripaneer, "Tandoori Paneer Pizza", "159", "4.3", "Spiced paneer , crunchy onions, Green Capsicum, spicy red paprika with delicious tandoori sauce and cheese."));
            foodMenuArray.add(new foodMenuModel(R.drawable.margherita, "Margherita", "110", "4.2", "Pizza topped with our herb infused signature pan sauce and 100% mozzarella cheese."));
            foodMenuArray.add(new foodMenuModel(R.drawable.veggiesupreme, "Veggie Supreme", "169", "4.4", "Black olives, Green Capsicum, Mushroom, onion, spicey red paprika, juicy sweet corn , flavourful pan sauce and cheese."));
            foodMenuArray.add(new foodMenuModel(R.drawable.vegkebabsurprise, "Veg Kebab Surprise", "189", "4.5", "Flavourful veg kebab, crunchy onion, green capsicum , tomato and juicy sweet corn with delicious tandoori sauce."));
            foodMenuArray.add(new foodMenuModel(R.drawable.triplechickenfeast, "Triple chicken feast", "229", "4.6", "Spicy schewan chicken meatball, flavourful herbed chicken, juicy chicken & sausage, capsicum, onion, paprika, pan sauce and cheese."));
            foodMenuAdapter = new RecyclerFoodMenuAdapter(foodMenuArray, foodMenuActivity.this);
            foodMenuRecyclerView.setAdapter(foodMenuAdapter);

        }

        else if(getIntent().getStringExtra("category_title").equals("Dosa")) {
            menuTitle.setText("Dosa");
            foodMenuArray.add(new foodMenuModel(R.drawable.masaladosa, "Masala Dosa", "79", "4.4", "Turmeric, Mustard seeds, Curry leaves, mashed Potatoes, garnished with fresh Onions, Tomatoes, Capsicum, Coriander & Spring Onion leaves."));
            foodMenuArray.add(new foodMenuModel(R.drawable.roastedoniondosa, "Roasted Onion Dosa", "99", "4.5", "Pan fried caramelized Chopped Onion, with our Signature street kitchen masala makes this dosa is a perfect appetite simulator."));
            foodMenuArray.add(new foodMenuModel(R.drawable.corndosa, "Corn Dosa", "129", "4.3", "Corn, Onions, Capsicum, Tomatoes, Coriander, Spring Onion Leaves & grated Ginger with your favorite Sauce."));
            foodMenuArray.add(new foodMenuModel(R.drawable.vegankeemadosa, "Vegan Keema Dosa", "159", "4.5", "Soya Protein (Vegan Minced Meat), Onion, Garlic, Ginger, Onions, Tomatoes, Capsicum, Coriander, Spring Onion leaves & grated Ginger."));
            foodMenuArray.add(new foodMenuModel(R.drawable.mixvegetabledosa, "Mix Vegetable Dosa", "99", "4.6", "Sweet Corn, green Peas, Carrot, Onions, Capsicum, Tomatoes, Coriander, Spring Onion leaves & grated Ginger."));
            foodMenuAdapter = new RecyclerFoodMenuAdapter(foodMenuArray, foodMenuActivity.this);
            foodMenuRecyclerView.setAdapter(foodMenuAdapter);

        }

        else if(getIntent().getStringExtra("category_title").equals("Chicken")) {
            menuTitle.setText("Chicken");
            foodMenuArray.add(new foodMenuModel(R.drawable.amritsarichickenmasala, "Amritsari Chicken Masala", "379", "4.2", "Boneless chunks of chicken lathered with a rich, buttery gravy of cream, tomatoes and spices."));
            foodMenuArray.add(new foodMenuModel(R.drawable.keralachickenroast, "Kerala Chicken Roast", "319", "4.5", "Marinated chicken pieces cooked with onions, ginger, garlic, curry leaves, turmeric, chili powder, coriander powder, and garam masala."));
            foodMenuArray.add(new foodMenuModel(R.drawable.kadhaichicken, "Kadhai Chicken", "349", "4.6", "Made with boneless chicken cooked in a blend of tomato-based gravy with capsicum, onion, ginger, garlic, and spices."));
            foodMenuArray.add(new foodMenuModel(R.drawable.butterchicken, "Butter Chicken", "299", "4.7", "Marinated chicken cooked in a tomato-based gravy with butter, cream, and a blend of spices including garam masala."));
            foodMenuArray.add(new foodMenuModel(R.drawable.chettinadchicken, "Chicken Chettinad", "380", "4.5", "Cooked in a spicy tomato-based gravy with roasted coconut, curry leaves, spices such as black pepper, cumin, and coriander."));
            foodMenuAdapter = new RecyclerFoodMenuAdapter(foodMenuArray, foodMenuActivity.this);
            foodMenuRecyclerView.setAdapter(foodMenuAdapter);

        }

        else if(getIntent().getStringExtra("category_title").equals("Chinese")) {
            menuTitle.setText("Chinese");
            foodMenuArray.add(new foodMenuModel(R.drawable.springroll, "Crispy veggie Spring Rolls ", "89", "4.5", "Shredded vegetables like cabbage, carrots, and bean sprouts, seasoning, wrapped in a thin flour-based wrapper and fried until crispy."));
            foodMenuArray.add(new foodMenuModel(R.drawable.hakkanoodles, "Hakka Noodles", "79", "4.6", "Made from wheat flour, eggs , onions, cabbage, carrots, and sauces such as soy sauce and chili sauce."));
            foodMenuArray.add(new foodMenuModel(R.drawable.chopsuey, "Chop Suey", "129", "4.4", "Includes a stir-fry of meat or tofu and vegetables such as celery, bean sprouts, cabbage, and onions, served with rice or noodles."));
            foodMenuArray.add(new foodMenuModel(R.drawable.dumplings, "Dumplings", "99", "4.3", "Small pockets of dough filled with meat or vegetable fillings, often steamed or boiled and served with dipping sauce."));
            foodMenuArray.add(new foodMenuModel(R.drawable.chickenwithchillies, "Chicken with chillies", "149", "4.5", "Typically consists of diced chicken stir-fried with green and red chilies, garlic, ginger, soy sauce, and sugar."));
            foodMenuAdapter = new RecyclerFoodMenuAdapter(foodMenuArray, foodMenuActivity.this);
            foodMenuRecyclerView.setAdapter(foodMenuAdapter);
        }


    }
}

