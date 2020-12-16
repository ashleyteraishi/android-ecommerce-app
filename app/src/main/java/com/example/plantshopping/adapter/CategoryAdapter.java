package com.example.plantshopping.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.plantshopping.R;
import com.example.plantshopping.model.Category;
import com.example.plantshopping.model.Product;

import java.util.ArrayList;
import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>
{
    Context context;
    Category category;
    List<Product> productList;
    String category_name = "";

    private OnCategoryListener onCategoryListener;

    public CategoryAdapter(Context context, Category category, OnCategoryListener onCategoryListener) {
        this.context = context;
        this.category = category;
        this.onCategoryListener = onCategoryListener;
        productList = category.getCategory_list();
        category_name = category.getCategoryName();
    }

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.category_product_display, parent, false);
        return new CategoryViewHolder(view, onCategoryListener);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder holder, int position) {
        holder.product_image.setImageResource(productList.get(position).getImage_url());
        holder.product_name.setText(productList.get(position).getProduct_name());
        holder.product_price.setText(productList.get(position).getProduct_price());
    }

    @Override
    public int getItemCount()
    {
        return productList.size();
    }

    public static final class CategoryViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
    {
        public ImageView product_image;
        public TextView product_name, product_price;
        OnCategoryListener onCategoryListener;

        public CategoryViewHolder(@NonNull View itemView, OnCategoryListener onCategoryListener) {
            super(itemView);

            product_image = itemView.findViewById(R.id.iv_product_image_cat);
            product_name = itemView.findViewById(R.id.product_name_cat);
            product_price = itemView.findViewById(R.id.tv_product_price_cat);

            this.onCategoryListener = onCategoryListener;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            onCategoryListener.onCategoryClick(getAdapterPosition());
        }
    }

    public interface OnCategoryListener
    {
        void onCategoryClick(int position);
    }
}
