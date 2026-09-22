package com.lecomptoir;

public class Ticket {

    Cart cart;

    public Ticket(Cart cart) {
        this.cart = cart;
    }

    void display() {
        for (CartLine line : cart.lines) {
            System.out.println(line.product.name + " x " + line.quantity);
        }

        System.out.println("Total : " + cart.getTotal() + " EUR");
    }
}