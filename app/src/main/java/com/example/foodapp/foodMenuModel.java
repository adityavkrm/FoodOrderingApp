package com.example.foodapp;

import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class foodMenuModel {
    int foodMenuImage;
    String foodMenuTitle, foodMenuCost, foodMenuRating,foodMenuDescription;

    public foodMenuModel(int foodMenuImage, String foodMenuTitle, String foodMenuCost, String foodMenuRating, String foodMenuDescription) {
        this.foodMenuImage = foodMenuImage;
        this.foodMenuTitle = foodMenuTitle;
        this.foodMenuCost = foodMenuCost;
        this.foodMenuRating = foodMenuRating;
        this.foodMenuDescription = foodMenuDescription;
    }

    public int getFoodMenuImage() {
        return foodMenuImage;
    }

    public void setFoodMenuImage(int foodMenuImage) {
        this.foodMenuImage = foodMenuImage;
    }

    public String getFoodMenuTitle() {
        return foodMenuTitle;
    }

    public void setFoodMenuTitle(String foodMenuTitle) {
        this.foodMenuTitle = foodMenuTitle;
    }

    public String getFoodMenuCost() {
        return foodMenuCost;
    }

    public void setFoodMenuCost(String foodMenuCost) {
        this.foodMenuCost = foodMenuCost;
    }

    public String getFoodMenuRating() {
        return foodMenuRating;
    }

    public void setFoodMenuRating(String foodMenuRating) {
        this.foodMenuRating = foodMenuRating;
    }

    public String getFoodMenuDescription() {
        return foodMenuDescription;
    }

    public void setFoodMenuDescription(String foodMenuDescription) {
        this.foodMenuDescription = foodMenuDescription;
    }
}
