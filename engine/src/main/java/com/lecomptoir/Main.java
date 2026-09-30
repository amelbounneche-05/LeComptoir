package com.lecomptoir;

public class Main {

    public static void main(String[] args) {

        // Create the food products
        Product pizza = new Product("Pizza", 12.50, "FOOD");
        Product burger = new Product("Burger", 10.00, "FOOD");
        Product sandwich = new Product("Sandwich", 12.00, "FOOD");
        Product salade = new Product("Salade", 5.00, "FOOD");
        Product frites = new Product("Frites", 8.00, "FOOD");
        Product dessert = new Product("Dessert", 3.50, "FOOD");

        // Create the drink products
        Product coca = new Product("Coca", 3.00, "DRINK");
        Product eau = new Product("Eau", 1.00, "DRINK");
        Product jus = new Product("Jus", 2.00, "DRINK");

        // Create an empty cart
        Cart cart = new Cart();

        // Add products and their quantities to the cart
        cart.add(new CartLine(pizza, 1));
        cart.add(new CartLine(burger, 1));
        cart.add(new CartLine(sandwich, 1));
        cart.add(new CartLine(salade, 1));
        cart.add(new CartLine(frites, 2));
        cart.add(new CartLine(dessert, 1));
        cart.add(new CartLine(jus, 1));
        cart.add(new CartLine(coca, 1));
        cart.add(new CartLine(eau, 1));

        // Create the checkout
        Checkout checkout = new Checkout();

        // Set the customer's loyalty points
        checkout.setLoyaltyPoints(100);

        // Process the checkout and create the ticket
        Ticket ticket = checkout.checkout(cart);

        // Display the ticket
        ticket.display();
    }
}