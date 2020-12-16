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

public class CategoryActivity extends AppCompatActivity
{
    RecyclerView categoryView;
    CategoryAdapter categoryAdapter;
    Category category;
    TextView tv_category_name;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);

        categoryView = findViewById(R.id.category_recycler);
        tv_category_name = findViewById(R.id.tv_category_name);

        categoryView.setLayoutManager(layoutManager);

        if (getIntent().hasExtra("selected_category"))
        {
            category = getIntent().getParcelableExtra("selected_category");

            categoryAdapter = new CategoryAdapter(this, category, this::onCategoryClick);
            categoryView.setAdapter(categoryAdapter);
            tv_category_name.setText(category.getCategoryName());
        }
    }

    public void onCategoryClick(int position)
    {
        Intent intent = new Intent(this, ProductDetailsActivity.class);
        intent.putExtra("selected_product", category.getCategory_list().get(position));
        startActivity(intent);
    }

}
