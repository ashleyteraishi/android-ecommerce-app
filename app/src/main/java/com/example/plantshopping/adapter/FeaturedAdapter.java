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
import com.example.plantshopping.model.Product;

import java.util.List;

public class FeaturedAdapter extends RecyclerView.Adapter<FeaturedAdapter.FeaturedViewHolder>
{
    Context context;
    List<Product> productList;
    private OnFeaturedListener onFeaturedListener;

    public FeaturedAdapter(Context context, List<Product> productList, OnFeaturedListener onFeaturedListener) {
        this.context = context;
        this.productList = productList;
        this.onFeaturedListener = onFeaturedListener;
    }

    @NonNull
    @Override
    public FeaturedViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.featured_product_display, parent, false);
        return new FeaturedViewHolder(view, onFeaturedListener);
    }

    @Override
    public void onBindViewHolder(@NonNull FeaturedViewHolder holder, int position) {
        holder.product_image.setImageResource(productList.get(position).getImage_url());
        holder.product_name.setText(productList.get(position).getProduct_name());
        holder.product_price.setText(productList.get(position).getProduct_price());
    }

    @Override
    public int getItemCount()
    {
        return productList.size();
    }

    public static final class FeaturedViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
    {
        public ImageView product_image;
        public TextView product_name, product_price;
        OnFeaturedListener onFeaturedListener;

        public FeaturedViewHolder(@NonNull View itemView, OnFeaturedListener onFeaturedListener) {
            super(itemView);

            product_image = itemView.findViewById(R.id.iv_product_image_recyc);
            product_name = itemView.findViewById(R.id.product_name_recyc);
            product_price = itemView.findViewById(R.id.tv_product_price_recyc);

            this.onFeaturedListener = onFeaturedListener;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            onFeaturedListener.onFeaturedClick(getAdapterPosition());
        }
    }

    public interface OnFeaturedListener
    {
        void onFeaturedClick(int position);
    }
}
