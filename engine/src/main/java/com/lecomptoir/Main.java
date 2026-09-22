package com.lecomptoir;

public class Main {

    public static void main(String[] args) {

        Product pizza = new Product("Pizza", 12.50, "FOOD");

        Product coca = new Product("Coca", 3.00, "DRINK");
        Product eau = new Product("Eau", 1.00, "DRINK");
        Product jus = new Product("Jus", 2.00, "DRINK");

        Cart cart = new Cart();

        cart.add(new CartLine(pizza, 2));

        cart.add(new CartLine(coca, 1));
        cart.add(new CartLine(eau, 1));
        cart.add(new CartLine(jus, 1));

        Checkout checkout = new Checkout();

        Ticket ticket = checkout.checkout(cart);

        ticket.display();
    }
}