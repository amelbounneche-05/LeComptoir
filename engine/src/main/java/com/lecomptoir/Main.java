package com.lecomptoir;

public class Main {

    public static void main(String[] args) {

        Product pizza = new Product("Pizza", 12.50, "FOOD");
        Product burger = new Product("Burger", 10.00, "FOOD");
        Product sandwich = new Product("Sandwich", 6.00, "FOOD");
        Product salade = new Product("Salade", 5.00, "FOOD");
        Product frites = new Product("Frites", 4.00, "FOOD");
        Product dessert = new Product("Dessert", 3.50, "FOOD");

        Product coca = new Product("Coca", 3.00, "DRINK");
        Product eau = new Product("Eau", 1.00, "DRINK");

        Cart cart = new Cart();

        cart.add(new CartLine(pizza, 2));
        cart.add(new CartLine(burger, 2));
        cart.add(new CartLine(sandwich, 2));
        cart.add(new CartLine(salade, 1));
        cart.add(new CartLine(frites, 2));
        cart.add(new CartLine(dessert, 1));

        cart.add(new CartLine(coca, 1));
        cart.add(new CartLine(eau, 1));

        Checkout checkout = new Checkout();

        Ticket ticket = checkout.checkout(cart);

        ticket.display();
    }
}