package com.lecomptoir;

public class Ticket {

    // Cart and discount used for the ticket
    Cart cart;
    double discount;

    // Customer's loyalty points
    int loyaltyPoints;

    // Create a ticket with a cart, a discount and loyalty points
    public Ticket(Cart cart, double discount, int loyaltyPoints) {
        this.cart = cart;
        this.discount = discount;
        this.loyaltyPoints = loyaltyPoints;
    }

    // Display the cart details and the final total
    void display() {

        for (CartLine line : cart.lines) {
            System.out.printf("%s x %d%n", line.product.name, line.quantity);
        }

        // Calculate the total including VAT
        double totalTTC = cart.getTotal();

        // Calculate the total VAT
        double tax = cart.getTax();
        double taxFood = 0;
        double taxDrink = 0;

        // Separate VAT for food and drinks
        for (CartLine line : cart.lines) {
            if (line.product.category.equals("FOOD")) {
                taxFood += line.getTax();
            } else {
                taxDrink += line.getTax();
            }
        }

        // Calculate the total before VAT
        double totalHT = totalTTC - tax;

        // Display the VAT details
        System.out.printf("Total HT : %.2f EUR%n", totalHT);
        System.out.printf("TVA 5.5%% : %.2f EUR%n", taxFood);
        System.out.printf("TVA 20%% : %.2f EUR%n", taxDrink);

        // Display the total after discount
        System.out.printf("Total : %.2f EUR%n", cart.getTotal() - discount);

        // Display the customer's loyalty points
        System.out.println("Loyalty points : " + loyaltyPoints);
    }
}