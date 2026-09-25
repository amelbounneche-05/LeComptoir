package com.lecomptoir;

public class Ticket {
    Cart cart;
    double discount;

    public Ticket(Cart cart, double discount) {
        this.cart = cart;
        this.discount = discount;
    }

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
        System.out.printf("Total : %.2f EUR%n", cart.getTotal() - discount);
    }
}