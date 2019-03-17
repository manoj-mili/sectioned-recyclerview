package com.demo.gitsectionedrecyclerview;

import java.util.ArrayList;

class CategoryModel {

    String categoryName;
    ArrayList<FoodItemModel> foodItemModels;

    public CategoryModel(String categoryName, ArrayList<FoodItemModel> foodItemModels) {
        this.categoryName = categoryName;
        this.foodItemModels = foodItemModels;
    }

    public CategoryModel() {

    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public ArrayList<FoodItemModel> getFoodItemModels() {
        return foodItemModels;
    }

    public void setFoodItemModels(ArrayList<FoodItemModel> foodItemModels) {
        this.foodItemModels = foodItemModels;
    }
}
