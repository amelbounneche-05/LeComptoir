package com.lecomptoir;

public class Checkout {

    // Store the customer's loyalty points
    int loyaltyPoints = 0;

    // Set the customer's loyalty points
    void setLoyaltyPoints(int points) {
        loyaltyPoints = points;
    }

    // Calculate the loyalty discount
    double getLoyaltyDiscount() {
        
        // Give a 5€ discount if the customer has at least 100 points
        if (loyaltyPoints >= 100) {
            return 5;
        }

        // No loyalty discount
        return 0;
    }

    // Calculate the loyalty points earned from the cart
    int getEarnedPoints(Cart cart) {
        return (int) cart.getTotal();
    }

    // Process the checkout and create the ticket
    Ticket checkout(Cart cart) {

        // Keep the biggest discount available
        double discount = Math.max(
                getLoyaltyDiscount(),
                Math.max(
                        cart.getDiscount10Percent(),
                        cart.getDiscount20Percent()));

        // Use 100 loyalty points when the 5€ discount is used
        if (loyaltyPoints >= 100 && discount == 5) {
            loyaltyPoints -= 100;
        }

        // Display the discount if there is one
        if (discount > 0) {
            System.out.printf("Discount : %.2f EUR%n", discount);
        }

        // Add the points earned from the cart
        loyaltyPoints += getEarnedPoints(cart);

        // Create and return the ticket
        return new Ticket(cart, discount);
    }
}