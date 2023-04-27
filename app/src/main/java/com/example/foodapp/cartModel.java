package com.example.foodapp;

public class cartModel {
    String myCartTitle, myCartCost;
    int myCartImage,myCartCount;

    public cartModel(String myCartTitle, String myCartCost, int myCartCount,  int myCartImage) {
        this.myCartTitle = myCartTitle;
        this.myCartCount = myCartCount;
        this.myCartCost = myCartCost;
        this.myCartImage = myCartImage;
    }

    public String getMyCartTitle() {
        return myCartTitle;
    }

    public void setMyCartTitle(String myCartTitle) {
        this.myCartTitle = myCartTitle;
    }

    public int getMyCartCount() {
        return myCartCount;
    }

    public void setMyCartCount(int myCartCount) {
        this.myCartCount = myCartCount;
    }

    public String getMyCartCost() {
        return myCartCost;
    }

    public void setMyCartCost(String myCartCost) {
        this.myCartCost = myCartCost;
    }

    public int getMyCartImage() {
        return myCartImage;
    }

    public void setMyCartImage(int myCartImage) {
        this.myCartImage = myCartImage;
    }
}
