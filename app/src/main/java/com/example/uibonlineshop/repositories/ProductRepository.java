package com.example.uibonlineshop.repositories;

import android.content.Context;
import android.util.Log;

import com.example.uibonlineshop.ApiService;
import com.example.uibonlineshop.ServerCallback;
import com.example.uibonlineshop.models.Model;
import com.example.uibonlineshop.models.Product;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductRepository implements Repository {
    public Context ctx;

    public ProductRepository(Context ctx) {
        this.ctx = ctx;
    }

    @Override
    public List<Product> getAll() throws JSONException {
        ApiService as = new ApiService(this.ctx);

        Map<String, String> requestParams = new HashMap<>();
        requestParams.put("url", "/products");

        ArrayList<Product> products = new ArrayList<>();
        final List<JSONObject> res = new ArrayList<>();

        as.sendRequest(requestParams, result -> {
            for (int i = 0; i < result.length(); ++i) {
                res.add(result.getJSONObject(i));
                Log.i("JSON", result.getJSONObject(i).toString());
            }
        });

        for (JSONObject jsonObject : res) {
            Log.i("API", jsonObject.toString());
            products.add(new Product(
                    Integer.parseInt(jsonObject.get("id").toString()),
                    jsonObject.get("name").toString(),
                    jsonObject.get("description").toString()
            ));
        }
        return products;
    }

    @Override
    public Product getOne(String id) {
        return null;
    }

}
