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
                Math.max(
                        cart.getDiscount10Percent(),
                        cart.getDiscount20Percent()));

        if (loyaltyPoints >= 100 && discount == 5) {
            loyaltyPoints -= 100;
        }

        if (discount > 0) {
            System.out.printf("Discount : %.2f EUR%n", discount);
        }

        loyaltyPoints += getEarnedPoints(cart);

        return new Ticket(cart, discount);
    }
}