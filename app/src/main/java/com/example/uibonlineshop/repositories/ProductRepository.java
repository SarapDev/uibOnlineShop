package com.example.uibonlineshop.repositories;

import android.view.Display;

import com.example.uibonlineshop.ApiService;
import com.example.uibonlineshop.models.Model;
import com.example.uibonlineshop.models.Product;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductRepository implements Repository {

    @Override
    public List<Model> getAll() {
        ApiService as = new ApiService();
        Map<String, String> requestParams = new HashMap<String, String>();
        ArrayList<Model> products = new ArrayList<>();
        List<JSONObject> res = as.sendRequest(requestParams);

        return products;
    }

    @Override
    public Model getOne(int id) {
        return null;
    }
}
