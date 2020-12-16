package com.example.plantshopping;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.plantshopping.adapter.FeaturedAdapter;
import com.example.plantshopping.model.Category;
import com.example.plantshopping.model.Product;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements FeaturedAdapter.OnFeaturedListener {

    FeaturedAdapter featuredAdapter;
    RecyclerView featuredView;
    ImageView iv_product_image;
    TextView tv_product_name, tv_product_price;
    CardView cv_shop_all, cv_bonsai, cv_flowers, cv_house_plants, cv_succulents, cv_sale;
    Button btn_show_all;

    List<Product> list_all_products = new ArrayList<>();
    List<Product> list_featured_products = new ArrayList<>();

    Category shop_all, bonsai, flowers, house_plants, succulents, sale;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);

        instantiateComponents();

        setUpListAllProducts(list_all_products);

        setUpCategoryBonsai(list_all_products);
        setUpCategoryFlowers(list_all_products);
        setUpCategoryHousePlants(list_all_products);
        setUpCategorySucculents(list_all_products);
        setUpCategorySale(list_all_products);

        createFeaturedView(list_all_products, layoutManager);
        setOnClickListeners();
    }

    private void instantiateComponents()
    {
        iv_product_image = findViewById(R.id.iv_product_image);
        tv_product_name = findViewById(R.id.tv_product_name);
        tv_product_price = findViewById(R.id.tv_product_price);
        cv_shop_all = findViewById(R.id.cv_shop_all);
        cv_bonsai = findViewById(R.id.cv_bonsai);
        cv_flowers = findViewById(R.id.cv_flowers);
        cv_house_plants = findViewById(R.id.cv_house_plants);
        cv_succulents = findViewById(R.id.cv_succulents);
        cv_sale = findViewById(R.id.cv_sale);
        btn_show_all = findViewById(R.id.btn_show_all);
    }

    private void setUpListAllProducts(List<Product> list_all_products)
    {
        // add all products
        // bonsai
        list_all_products.add(new Product("Golden Gate Ficus",
                "$44.99", R.drawable.bonsai_golden_gate));
        list_all_products.get(0).setProduct_description(
                "They say some plants can be high maintenance. Try telling that to our golden gate" +
                        " ficus bonsai. Its ability to thrive in a variety of light conditions makes" +
                        " it a best seller. Plant Perk: All about artful shaping and training, these" +
                        " trees are great for Zen relaxation."
        );
        list_all_products.add(new Product("Juniper Bonsai",
                "$44.99", R.drawable.bonsai_juniper));
        list_all_products.get(1).setProduct_description(
                "Ever-beautiful and ready for creative shaping, this tiny tree has been cultivated" +
                        " for thousands of years to bring you calmness and serenity. But no pressure!" +
                        " Plant Perk: All about artful shaping and training, these trees are great" +
                        " for Zen relaxation."
        );

        // flowers
        list_all_products.add(new Product("Orange Phalaenopsis",
                "$74.99", R.drawable.flowers_orange_orchid));
        list_all_products.get(2).setProduct_description(
                "Looking for a pop of color to match someone’s unique style? An orchid of peachy" +
                        " orange can help with that. It expresses the same quirky boldness and" +
                        " enthusiasm they do - only with its petals! Plant Perk: Orchids make great" +
                        " bedroom plants. They naturally absorb carbon dioxide and release oxygen into" +
                        " the air for a more restful night’s sleep."
        );
        list_all_products.add(new Product("Yellow Phalaenopsis",
                "$49.99", R.drawable.flowers_yellow_orchid));
        list_all_products.get(3).setProduct_description(
                "Want to send someone a pretty pick-me-up? A willowy orchid in the color of sunny" +
                        " yellow sends a boost of energy & self-confidence...who doesn’t want that?" +
                        " Plant Perk: Orchids make great bedroom plants. They naturally absorb carbon" +
                        " dioxide and release oxygen into the air for a more restful night’s sleep."
        );
        list_all_products.add(new Product("Red Anthurium",
                "$44.99", R.drawable.flowers_red_anthurium));
        list_all_products.get(4).setProduct_description(
                "Who wouldn’t love this showy, exotic plant? With its red, heart-shaped flowers" +
                        " and bright, glossy leaves, it will bloom all year round with the right TLC!" +
                        " Plant Perk: Freshly cut, its flowers can last 14-28 days in a vase, and make" +
                        " a perfect hostess gift!"
        );

        // houseplants
        list_all_products.add(new Product("Birds of Paradise",
                "$99.99", R.drawable.houseplant_bird_of_paradise));
        list_all_products.get(5).setProduct_description(
                "If you like your plants tropical, the Bird of Paradise is absolute perfection." +
                        " With long, glossy, banana-like leaves, they make a statement, with an island" +
                        " vibe that is kind of like being on vacation right at home. It is potted in" +
                        " a neutral-toned planter. Plant Perk: The large green leaves of this tropical" +
                        " beauty are good for air purification due to their size."
        );
        list_all_products.add(new Product("Devil's Ivy",
                "$49.99", R.drawable.houseplant_devils_ivy));
        list_all_products.get(6).setProduct_description(
                "Don’t let the name fool you…this vining favorite gets the nickname Devil’s Ivy" +
                        " because it’s nearly impossible to kill. Potted in our exclusive neutral-toned" +
                        " planter, it’s just the mix of low-maintenance and high-style for your space." +
                        " Plant Perk: Can be trained to grow on a pole or trellis."
        );
        list_all_products.add(new Product("Snake Plant",
                "$49.99", R.drawable.houseplant_snake_plant));
        list_all_products.get(7).setProduct_description(
                "Looking sharp with its blade-like leaves, subtly striped for just the right amount" +
                        " of chic, the Sansevieria is an upstanding plant that will do right by any" +
                        " décor. Plant Perk: So good at improving work space air quality that it can" +
                        " actually cut ventilation needs. Hello energy conservation!"
        );

        // succulents
        list_all_products.add(new Product("Aloe Vera",
                "$39.99", R.drawable.succulent_aloe_vera));
        list_all_products.get(8).setProduct_description(
                "The all-around healer plant, Aloe Vera is not only a go-to for gotta-soothe-my-sunburn-stat" +
                        " moments but is also an aesthetically calming addition to any room. Add our" +
                        " natural Ready.Set.Grow heavy cotton canvas tote bag featuring matching" +
                        " fabric handles. Imported and printed in the USA. Plant Perk: Known to relieve" +
                        " burns and boo-boos as well as improve achy body hinges."
        );
        list_all_products.add(new Product("Black Echeveria",
                "$24.99", R.drawable.succulent_black_echeveria));
        list_all_products.get(9).setProduct_description(
                "The succulent with a dark and mysterious side. Also known as the “Black Prince”" +
                        " because of its color, our echeveria rules the houseplant scene with its" +
                        " uniquely colored rosettes and glowing green center. Designed in a white" +
                        " geometric planter for contrast, the perfect low maintenance plant."
        );
        list_all_products.add(new Product("String of Pearls",
                "$64.99", R.drawable.succulent_string_of_pearls));
        list_all_products.get(10).setProduct_description(
                "An all-time favorite for the way its bead-like leaves can cascade several feet." +
                        " They originate in South Africa where they grow as ground cover in the shade" +
                        " of rocky outcroppings. Partial or filtered sun is ideal, as they are prone" +
                        " to sunburn if exposed to direct sun without a gradual, two week transition."
        );

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
        sale = new Category("Sale", temp);
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

    private void setOnClickListeners()
    {
        btn_show_all.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, CategoryActivity.class);
            intent.putExtra("selected_category", shop_all);
            startActivity(intent);
        });
        cv_shop_all.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, CategoryActivity.class);
            intent.putExtra("selected_category", shop_all);
            startActivity(intent);
        });
        cv_bonsai.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, CategoryActivity.class);
            intent.putExtra("selected_category", bonsai);
            startActivity(intent);
        });
        cv_flowers.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, CategoryActivity.class);
            intent.putExtra("selected_category", flowers);
            startActivity(intent);
        });
        cv_house_plants.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, CategoryActivity.class);
            intent.putExtra("selected_category", house_plants);
            startActivity(intent);
        });
        cv_succulents.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, CategoryActivity.class);
            intent.putExtra("selected_category", succulents);
            startActivity(intent);
        });
        cv_sale.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, CategoryActivity.class);
            intent.putExtra("selected_category", sale);
            startActivity(intent);
        });
    }
}