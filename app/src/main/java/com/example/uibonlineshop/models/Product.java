package com.example.uibonlineshop.models;

public class Product implements Model{
    public int id;
    public String title;
    public String description;
//    public int imageId;

    public Product(int id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
//        this.imageId = imageUrl;
    }

    @Override
    public boolean create() {
        return false;
    }

    @Override
    public boolean update() {
        return false;
    }

    @Override
    public boolean delete() {
        return false;
    }
}
