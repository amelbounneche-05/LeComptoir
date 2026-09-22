package com.lecomptoir;

public class Checkout {

    int loyaltyPoints = 0;

    void setLoyaltyPoints(int points) {
        loyaltyPoints = points;
    }

    double getLoyaltyDiscount() {
        if (loyaltyPoints >= 100) {
            return 5;
        }

        return 0;
    }

    int getEarnedPoints(Cart cart) {
        return (int) cart.getTotal();
    }

    Ticket checkout(Cart cart) {
        double discount = Math.max(
            getLoyaltyDiscount(),
            cart.getDiscount10Percent()
        );

        if (loyaltyPoints >= 100 && discount == 5) {
            loyaltyPoints -= 100;
        }

        if (discount > 0) {
            System.out.println("Discount : " + discount + " EUR");
        }

        loyaltyPoints += getEarnedPoints(cart);

        return new Ticket(cart, discount);
    }
}