package com.example.foodapp;

public class popularModel {

    String title, description, rating, rupee;
    int image;

    popularModel(String title, String description, String rating, String rupee, int image){
        this.title = title;
        this.description = description;
        this.rating = rating;
        this.rupee = rupee;
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getRupee() {
        return rupee;
    }

    public void setRupee(String rupee) {
        this.rupee = rupee;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
