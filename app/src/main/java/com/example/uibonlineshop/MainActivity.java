package com.example.uibonlineshop;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.uibonlineshop.adapters.ProductAdapter;
import com.example.uibonlineshop.models.Product;
import com.example.uibonlineshop.repositories.ProductRepository;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity{
    private List<Product> products;

    @Override
    protected void onCreate(Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {
            this.initializeData();
        } catch (JSONException e) {
            Log.i("Error ", e.getMessage());
        }
        RecyclerView rv = (RecyclerView)findViewById(R.id.rv);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        rv.setLayoutManager(llm);

        ProductAdapter adapter = new ProductAdapter(this.products);
        rv.setAdapter(adapter);
    }

    private void initializeData() throws JSONException {
        this.products = new ArrayList<>();
        ProductRepository repository = new ProductRepository(this);
        this.products = repository.getAll();

    }
}