package com.lecomptoir;

public class Ticket {

    Cart cart;

    public Ticket(Cart cart) {
        this.cart = cart;
    }

    void display() {
        for (CartLine line : cart.lines) {
            System.out.println(line.product.name + " x " + line.quantity);
        }

        // Keep the original total
        System.out.println("Total : " + cart.getTotal() + " EUR");

         // Calculate the total including VAT
        double totalTTC = cart.getTotal();

        // Calculate the total VAT
        double tax = cart.getTax();

        // Calculate the total before VAT
        double totalHT = totalTTC - tax;

        // Display the VAT details
        System.out.println("Total HT : " + totalHT + " EUR");
        System.out.println("TVA : " + tax + " EUR");
        System.out.println("Total TTC : " + totalTTC + " EUR");
    }
}