package com.example.plantshopping;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.plantshopping.model.Product;


// activity when a product has been clicked
public class ProductDetailsActivity extends AppCompatActivity
{
    // product info components
    ImageView iv_product_image;
    TextView tv_product_name, tv_product_price, tv_product_description;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_details);

        iv_product_image = findViewById(R.id.iv_product_image);
        tv_product_name = findViewById(R.id.tv_product_name);
        tv_product_price = findViewById(R.id.tv_product_price);
        tv_product_description = findViewById(R.id.tv_product_description);

        // if the intent was passed with a product object
        if (getIntent().hasExtra("selected_product"))
        {
            // get the product
            Product product = getIntent().getParcelableExtra("selected_product");

            // display the product info
            iv_product_image.setImageResource(product.getImage_url());
            tv_product_name.setText(product.getProduct_name());
            tv_product_price.setText(product.getProduct_price());
            tv_product_description.setText(product.getProduct_description());
        }
    }
}
