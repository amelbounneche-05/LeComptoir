package com.lecomptoir;

public class Product {

    String name;
    double price;
    String category;
    double taxRate;

    public Product(String name, double price, String category) {
        this.name = name;
        this.price = price;
        this.category = category;
        this.taxRate = category.equals("FOOD") ? 0.055 : 0.20;
    }
}