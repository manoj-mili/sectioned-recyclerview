package com.demo.gitsectionedrecyclerview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.ViewHolder> {

    Context context;

    ArrayList<CategoryModel> categoryModels;

    public CategoryAdapter(Context context, ArrayList<CategoryModel> categoryModel) {
        this.context = context;
        this.categoryModels = categoryModel;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View  view = LayoutInflater.from(context).inflate(R.layout.category_recylerview,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {

        CategoryModel categoryModel = categoryModels.get(i);

        ArrayList<FoodItemModel> foodItemModels = categoryModel.getFoodItemModels();

        ItemAdapter itemAdapter = new ItemAdapter(context,foodItemModels);

        viewHolder.categoryTextView.setText(categoryModel.getCategoryName());
        viewHolder.foodItemsRecyclerView.setLayoutManager(new LinearLayoutManager(context,
                LinearLayoutManager.VERTICAL, false));
        viewHolder.foodItemsRecyclerView.setAdapter(itemAdapter);
        viewHolder.foodItemsRecyclerView.setHasFixedSize(true);
        itemAdapter.notifyDataSetChanged();


    }

    @Override
    public int getItemCount() {
        return categoryModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView categoryTextView;
        RecyclerView foodItemsRecyclerView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            categoryTextView = itemView.findViewById(R.id.restaurant_dish_category);
            foodItemsRecyclerView = itemView.findViewById(R.id.food_item_recycler_view);
        }
    }
}
