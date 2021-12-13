package com.example.uibonlineshop;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.uibonlineshop.adapters.ProductAdapter;
import com.example.uibonlineshop.models.Product;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity{
    private List<Product> products;

    @Override
    protected void onCreate(Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.initializeData();

        RecyclerView rv = (RecyclerView)findViewById(R.id.rv);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        rv.setLayoutManager(llm);

        ProductAdapter adapter = new ProductAdapter(this.products);
        rv.setAdapter(adapter);
    }

    private void initializeData(){
        products = new ArrayList<>();
        products.add(new Product(1,"Title", "Some Desc"));
        products.add(new Product(2, "Title1", "Some Desc"));
        products.add(new Product(3, "Title2", "Some Desc"));
    }
}