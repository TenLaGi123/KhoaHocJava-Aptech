package com.example.androidexample;

import android.app.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class ProductsActivity extends Activity implements IActivity {

    private TextView txtHello;

    private RecyclerView productsRecyclerView;
    private RecyclerView.Adapter productsAdapter;
    private ArrayList<Product> products = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_products);
        productsRecyclerView = (RecyclerView) findViewById(R.id.productsRecyclerView);
        setUpUI();
        setUpAction();

    }

    @Override
    public void setUpUI() {
        products.add(new Product("Iphone XS", 1100.12,125));
        products.add(new Product("Macbook", 2200.12,234));
        products.add(new Product("Dell XPS", 2900.12,134));
        products.add(new Product("Samsung Galaxy S10", 1100.12,127));
        products.add(new Product("Logitech", 500.12,213));
        productsAdapter = new ProductsAdapter(products);
        ((ProductsAdapter) productsAdapter).setProductsActivity(this);
        productsRecyclerView.setAdapter(productsAdapter);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext(),
                RecyclerView.VERTICAL,false);

        productsRecyclerView.setLayoutManager(layoutManager);

    }

    public void navigateToDetail(Integer i){
        Intent intent = new Intent(this, DetailProductActivity.class);
        intent.putExtra("selectedProduct", products.get(i));
        startActivity(intent);
    }
    @Override
    public void setUpAction() {

    }
}
