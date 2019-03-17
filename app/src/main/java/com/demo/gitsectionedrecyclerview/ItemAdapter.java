package com.demo.gitsectionedrecyclerview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ViewHolder> {

    Context context;
    ArrayList<FoodItemModel> foodItemModels;


    public ItemAdapter(Context context, ArrayList<FoodItemModel> foodItemModel) {
        this.context = context;
        this.foodItemModels = foodItemModel;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).
                inflate(R.layout.recylerview_item, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        FoodItemModel foodItemModel = foodItemModels.get(i);
        viewHolder.foodNameTextView.setText(foodItemModel.getFoodName());
        viewHolder.descriptionTextView.setText(foodItemModel.getFoodDescription());
        viewHolder.priceTextView.setText(foodItemModel.getFoodPrice());
        Picasso.with(context).load(foodItemModel.getFoodImage()).into(viewHolder.foodImageView);

    }

    @Override
    public int getItemCount() {
        return foodItemModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView descriptionTextView;
        TextView foodNameTextView;
        ImageView foodImageView;
        TextView priceTextView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            priceTextView = itemView.findViewById(R.id.menu_item_price);
            descriptionTextView = itemView.findViewById(R.id.menu_item_description);
            foodImageView = itemView.findViewById(R.id.food_image);
            foodNameTextView = itemView.findViewById(R.id.food_name);
        }
    }
}
