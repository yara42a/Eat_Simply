package com.example.wireleseproject;

public class Profile{
   private final String Month,height,weight,calories;

    public Profile(String month, String height, String weight, String calories) {
        Month = month;
        this.height = height;
        this.weight = weight;
        this.calories = calories;
    }

    public String getMonth() {
        return Month;
    }

    public String getHeight() {
        return height;
    }


    public String getWeight() {
        return weight;
    }


    public String getCalories() {
        return calories;
    }
}
