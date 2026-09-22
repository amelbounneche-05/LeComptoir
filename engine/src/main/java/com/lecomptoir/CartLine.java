package com.lecomptoir;

public class CartLine {

    Product product;
    int quantity;

    public CartLine(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    double getTotal() {
        return product.price * quantity;
    }
}