package com.demo.gitsectionedrecyclerview;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.LinearLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;
    RecyclerView categoryRecyclerView;
    CategoryAdapter categoryAdapter;
    ArrayList<CategoryModel> categoryModels = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = findViewById(R.id.toolbar);
        categoryRecyclerView = findViewById(R.id.category_recyler_view);
        setSupportActionBar(toolbar);
        toolbar.setTitle(R.string.section_recycler_view);

        categoryRecyclerView.setHasFixedSize(true);
        categoryRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayout.VERTICAL, false));
        setUpAdapter();

    }

    private void setUpAdapter() {

        ArrayList<FoodItemModel> foodItemModels;

        for (int j = 0; j < 3; j++) {
            foodItemModels = new ArrayList<>();
            CategoryModel categoryModel = new CategoryModel();
            for (int i = 0; i < 2; i++) {
                FoodItemModel foodItemModel = new FoodItemModel("Butter Chicken",
                        "Butter chicken or murgh makhani is a dish, originating in India, of chicken in a mildly spiced tomato sauce.",
                        "₹ 240", "https://www.wellplated.com/wp-content/uploads/2018/07/Healthy-Instant-Pot-Butter-Chicken-500x673@2x.jpg");
                foodItemModels.add(foodItemModel);
            }
            categoryModel.setCategoryName("Chicken Dishes");
            categoryModel.setFoodItemModels(foodItemModels);
            categoryModels.add(categoryModel);
        }

        categoryAdapter = new CategoryAdapter(this,categoryModels);
        categoryRecyclerView.setAdapter(categoryAdapter);
        categoryAdapter.notifyDataSetChanged();
    }
}
