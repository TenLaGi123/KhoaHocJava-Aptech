package com.example.androidexample;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class ProductItemView extends RecyclerView.ViewHolder {
    public TextView txtProductName;
    public TextView txtProductPrice;
    public TextView txtProductModel;
    private ProductsActivity productsActivity;

    public ProductItemView(View view){
        super(view);
        txtProductName = (TextView) view.findViewById(R.id.txtProductName);
        txtProductModel = (TextView) view.findViewById(R.id.txtProductModel);
        txtProductPrice = (TextView) view.findViewById(R.id.txtProductPrice);

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int position = getLayoutPosition();
                productsActivity.navigateToDetail(position);
            }
        });

    }
    public ProductsActivity getProductsActivity() {
        return productsActivity;
    }

    public void setProductsActivity(ProductsActivity productsActivity) {
        this.productsActivity = productsActivity;
    }

}
