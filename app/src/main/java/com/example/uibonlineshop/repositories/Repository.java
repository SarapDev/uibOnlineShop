package com.example.uibonlineshop.repositories;

import com.example.uibonlineshop.models.Model;

import java.util.List;

public interface Repository {
    public List<Model> getAll();
    public Model getOne(int id);
}
