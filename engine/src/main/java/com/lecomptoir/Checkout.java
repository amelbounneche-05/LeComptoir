package com.lecomptoir;

public class Checkout {

    Ticket checkout(Cart cart) {
        return new Ticket(cart);
    }
}