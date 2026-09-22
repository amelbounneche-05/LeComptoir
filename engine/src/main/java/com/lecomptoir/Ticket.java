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
            System.out.println(line.product.name + " x " + line.quantity);
        }

        // Calculate the total including VAT
        double totalTTC = cart.getTotal();

        // Calculate the total VAT
        double tax = cart.getTax();

        // Calculate the total before VAT
        double totalHT = totalTTC - tax;

        // Display the VAT details
        System.out.println("Total HT : " + totalHT + " EUR");
        System.out.println("TVA : " + tax + " EUR");
        System.out.println("Total : " + (cart.getTotal() - discount) + " EUR");
    }
}