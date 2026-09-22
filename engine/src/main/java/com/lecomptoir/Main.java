package com.lecomptoir;

public class Main {

    public static void main(String[] args) {

        Product pizza = new Product("Pizza", 80.00, "FOOD");

        Cart cart = new Cart();

        cart.add(new CartLine(pizza, 2));

        Checkout checkout = new Checkout();

        Ticket ticket = checkout.checkout(cart);

        ticket.display();
    }
}