package com.example.uibonlineshop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.uibonlineshop.repositories.ProductRepository;

public class ProductActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent i = getIntent();
        String productId = i.getStringExtra("product_id");
//        ProductRepository repository = new ProductRepository();
//        repository.getOne(productId);

        setContentView(R.layout.activity_product);
    }
}