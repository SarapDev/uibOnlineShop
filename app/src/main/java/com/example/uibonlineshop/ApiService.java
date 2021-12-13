package com.example.uibonlineshop;

import android.util.Log;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ApiService {
    private final String apiRoute = "https://f218-95-57-109-201.ngrok.io/api";

    public List<JSONObject> sendRequest(Map<String, String> data) {
        String fullRoute = apiRoute + data.get("url");
        List<JSONObject> res = new ArrayList<JSONObject>();
        new JsonObjectRequest
                (Request.Method.GET, fullRoute, null, new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONArray data = response.getJSONArray("data");
                            for (int i = 0; i <= data.length(); ++i) {
                                res.add(data.getJSONObject(i));
                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.i("VolleyErr", error.toString());
                    }
                });
        return res;
    }
}
