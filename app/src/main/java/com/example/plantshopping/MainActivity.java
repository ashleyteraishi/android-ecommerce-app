package com.example.plantshopping;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.plantshopping.adapter.FeaturedAdapter;
import com.example.plantshopping.model.Category;
import com.example.plantshopping.model.Product;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements FeaturedAdapter.OnFeaturedListener {

    FeaturedAdapter featuredAdapter;
    //BestsellingAdapter bestsellingAdapter;
    //SaleAdapter saleAdapter;
    //RecyclerView featuredView, bestsellingView, saleView;
    RecyclerView featuredView;
    ImageView iv_product_image;
    TextView tv_product_name, tv_product_price;
    CardView cv_shop_all, cv_bonsai, cv_flowers, cv_house_plants, cv_succulents, cv_sale;

    List<Product> list_all_products = new ArrayList<Product>();
    List<Product> list_featured_products = new ArrayList<>();

    Category shop_all, bonsai, flowers, house_plants, succulents, sale;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iv_product_image = findViewById(R.id.iv_product_image);
        tv_product_name = findViewById(R.id.tv_product_name);
        tv_product_price = findViewById(R.id.tv_product_price);
        cv_shop_all = findViewById(R.id.cv_shop_all);
        cv_bonsai = findViewById(R.id.cv_bonsai);
        cv_flowers = findViewById(R.id.cv_flowers);
        cv_house_plants = findViewById(R.id.cv_house_plants);
        cv_succulents = findViewById(R.id.cv_succulents);
        cv_sale = findViewById(R.id.cv_sale);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);

        if(list_all_products == null)
        {
            setUpListAllProducts(list_all_products);
        }

        setUpCategoryBonsai(list_all_products);
        setUpCategoryFlowers(list_all_products);
        setUpCategoryHousePlants(list_all_products);
        setUpCategorySucculents(list_all_products);
        setUpCategorySale(list_all_products);

        createFeaturedView(list_all_products, layoutManager);

        // best sellers
        // aloe vera
        //list_bestselling_products.add(list_all_products.get(8));
        // black echeveria
        //list_bestselling_products.add(list_all_products.get(9));
        // birds of paradise
        //list_bestselling_products.add(list_all_products.get(5));
        //bestsellingView = findViewById(R.id.best_sellers_recycler);
        //bestsellingView.setLayoutManager(layoutManager);
        //bestsellingAdapter = new BestsellingAdapter(this, list_bestselling_products);
        //bestsellingView.setAdapter(bestsellingAdapter);

        // sale products
        // red anthurium
        //list_sale_products.add(list_all_products.get(4));
        // snake plant
        //list_sale_products.add(list_all_products.get(7));
        // devils ivy
        //list_sale_products.add(list_all_products.get(6));
        //saleView = findViewById(R.id.sale_recycler);
        //saleView.setLayoutManager(layoutManager);
        //saleAdapter = new SaleAdapter(this, list_sale_products);
        //saleView.setAdapter(saleAdapter);

    }

    private void setUpListAllProducts(List<Product> list_all_products)
    {
        // add all products
        // bonsai
        list_all_products.add(new Product("Golden Gate Ficus",
                "$44.99", R.drawable.bonsai_golden_gate));
        list_all_products.add(new Product("Juniper Bonsai",
                "$44.99", R.drawable.bonsai_juniper));

        // flowers
        list_all_products.add(new Product("Orange Phalaenopsis",
                "$74.99", R.drawable.flowers_orange_orchid));
        list_all_products.add(new Product("Yellow Phalaenopsis",
                "$49.99", R.drawable.flowers_yellow_orchid));
        list_all_products.add(new Product("Red Anthurium",
                "$44.99", R.drawable.flowers_red_anthurium));

        // houseplants
        list_all_products.add(new Product("Birds of Paradise",
                "$99.99", R.drawable.houseplant_bird_of_paradise));
        list_all_products.add(new Product("Devil's Ivy",
                "$49.99", R.drawable.houseplant_devils_ivy));
        list_all_products.add(new Product("Snake Plant",
                "$49.99", R.drawable.houseplant_snake_plant));

        // succulents
        list_all_products.add(new Product("Aloe Vera",
                "$39.99", R.drawable.succulent_aloe_vera));
        list_all_products.add(new Product("Black Echeveria",
                "$24.99", R.drawable.succulent_black_echeveria));
        list_all_products.add(new Product("String of Pearls",
                "$64.99", R.drawable.succulent_string_of_pearls));

        // add all of the products to the "shop all" category
        shop_all = new Category("Shop All", list_all_products);
    }

    private void setUpCategoryBonsai(List<Product> list_all_products)
    {
        List<Product> temp = new ArrayList<>();

        // the two bonsai plants are at indexes 0 and 1 in all products
        temp.add(list_all_products.get(0));
        temp.add(list_all_products.get(1));

        // add the two bonsai plants to the bonsai category
        bonsai = new Category("Bonsai", temp);
    }

    private void setUpCategoryFlowers(List<Product> list_all_products)
    {
        List<Product> temp = new ArrayList<>();

        // the three flowers are at indexes 2, 3, and 4 in all products
        temp.add(list_all_products.get(2));
        temp.add(list_all_products.get(3));
        temp.add(list_all_products.get(4));

        // add the two bonsai plants to the bonsai category
        flowers = new Category("Flowers", temp);
    }

    private void setUpCategoryHousePlants(List<Product> list_all_products)
    {
        List<Product> temp = new ArrayList<>();

        // the three house plants are at indexes 5, 6, and 7 in all products
        temp.add(list_all_products.get(5));
        temp.add(list_all_products.get(6));
        temp.add(list_all_products.get(7));

        // add the two bonsai plants to the bonsai category
        house_plants = new Category("House Plants", temp);
    }

    private void setUpCategorySucculents(List<Product> list_all_products)
    {
        List<Product> temp = new ArrayList<>();

        // the three succulents are at indexes 8, 9, and 10 in all products
        temp.add(list_all_products.get(8));
        temp.add(list_all_products.get(9));
        temp.add(list_all_products.get(10));

        // add the two bonsai plants to the bonsai category
        succulents = new Category("Succulents", temp);
    }

    private void setUpCategorySale(List<Product> list_all_products)
    {
        List<Product> temp = new ArrayList<>();

        // the three sale items are at indexes 1, 3, and 9
        temp.add(list_all_products.get(1));
        temp.add(list_all_products.get(3));
        temp.add(list_all_products.get(9));

        // add the two bonsai plants to the bonsai category
        succulents = new Category("Succulents", temp);
    }

    private void createFeaturedView(List<Product> list_all_products, RecyclerView.LayoutManager layoutManager)
    {
        // birds of paradise
        list_featured_products.add(list_all_products.get(5));
        // phalaenopsis orchid: orange
        list_featured_products.add(list_all_products.get(2));
        // string of pearls
        list_featured_products.add(list_all_products.get(10));
        featuredView = findViewById(R.id.featured_recycler);
        featuredView.setLayoutManager(layoutManager);
        featuredAdapter = new FeaturedAdapter(this, list_featured_products, this);
        featuredView.setAdapter(featuredAdapter);
    }

    @Override
    public void onFeaturedClick(int position) {
        Intent intent = new Intent(this, ProductDetailsActivity.class);
        intent.putExtra("selected_product", list_featured_products.get(position));
        startActivity(intent);
    }
}