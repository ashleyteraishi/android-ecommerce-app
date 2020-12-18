package com.example.plantshopping;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.plantshopping.adapter.CategoryAdapter;
import com.example.plantshopping.model.Category;

// category activity starts when the user selects a category to view
public class CategoryActivity extends AppCompatActivity
{
    // all of the products in the category are displayed in this RecyclerView
    RecyclerView categoryView;
    // adapter for the category RecyclerView
    CategoryAdapter categoryAdapter;
    // the category that will be displayed
    Category category;
    TextView tv_category_name;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        // vertical RecyclerView so that the user can scroll vertically
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);

        categoryView = findViewById(R.id.category_recycler);
        tv_category_name = findViewById(R.id.tv_category_name);

        categoryView.setLayoutManager(layoutManager);

        // if a "selected_category" was passed with the intent
        if (getIntent().hasExtra("selected_category"))
        {
            // get the category
            category = getIntent().getParcelableExtra("selected_category");

            // set the category adapter and the page text
            categoryAdapter = new CategoryAdapter(this, category, this::onCategoryClick);
            categoryView.setAdapter(categoryAdapter);
            tv_category_name.setText(category.getCategoryName());
        }
    }

    // when a product object in the category RecyclerView has been clicked
    public void onCategoryClick(int position)
    {
        // start the ProductDetailsActivity, pass the product that was clicked
        Intent intent = new Intent(this, ProductDetailsActivity.class);
        intent.putExtra("selected_product", category.getCategory_list().get(position));
        startActivity(intent);
    }

}
