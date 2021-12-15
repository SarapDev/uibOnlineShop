package com.example.uibonlineshop.repositories;

import com.example.uibonlineshop.models.Model;

import org.json.JSONException;

import java.util.List;

public interface Repository <T>{
    public List<T> getAll() throws JSONException;
    public T getOne(String id);
}
