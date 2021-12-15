package com.example.uibonlineshop;

import org.json.JSONArray;
import org.json.JSONException;

public interface ServerCallback {
    void onSuccess(JSONArray result) throws JSONException;
}
