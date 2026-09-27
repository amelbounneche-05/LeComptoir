package com.lecomptoir;

public class CartLine {

    // Product and quantity in the cart
    Product product;
    int quantity;

    // Create a cart line with a product and its quantity
    public CartLine(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    // Calculate the total price for this cart line
    double getTotal() {
        return product.price * quantity;
    }

    // Calculate the VAT for this cart line
    double getTax() {
        return getTotal() * product.taxRate;
    }
}