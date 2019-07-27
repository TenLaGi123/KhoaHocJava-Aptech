package com.example.androidexample;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ProductsAdapter extends RecyclerView.Adapter<ProductItemView> {
    private ArrayList<Product> productsData;
    private ProductsActivity productsActivity;

    ProductsAdapter(ArrayList<Product> productsData){
        this.productsData = productsData;
    }

    public ProductsActivity getProductsActivity() {
        return productsActivity;
    }

    public void setProductsActivity(ProductsActivity productsActivity) {
        this.productsActivity = productsActivity;
    }

    @NonNull
    @Override
    public ProductItemView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.product_item_view,parent,false);
        ProductItemView productItemView = new ProductItemView(view);
        productItemView.setProductsActivity(productsActivity);
        return productItemView;
    }

    @Override
    public void onBindViewHolder(@NonNull ProductItemView holder, int position) {
        Product selectedProduct = productsData.get(position);
        String productName = selectedProduct.getName();
        String productPrice = selectedProduct.getPrice().toString();
        String productModel = selectedProduct.getModel().toString();
        holder.txtProductName.setText(productName);
        holder.txtProductPrice.setText(productPrice);
        holder.txtProductModel.setText(productModel);
    }

    @Override
    public int getItemCount() {
         return productsData.size();
    }
}
