package com.example.uibonlineshop;

import android.content.Context;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ApiService {

    private final Context ctx;

    public ApiService(Context ctx) {
        this.ctx = ctx;
    }

    public void sendRequest(Map<String, String> data, final ServerCallback callback) {
        String apiRoute = "https://eshop-api-uib.herokuapp.com/api";
        String fullRoute = apiRoute + data.get("url");

        JsonObjectRequest request = new JsonObjectRequest
                (Request.Method.GET, fullRoute, null, response -> {
                    try {
                        JSONArray data1 = response.getJSONArray("data");
                        callback.onSuccess(data1);

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }, error -> Log.i("VolleyErr", error.toString()));

        RequestQueue mRequestQueue = Volley.newRequestQueue(ctx);
        mRequestQueue.add(request);
    }
}
