package com.lecomptoir;

import java.util.ArrayList;
import java.util.List;

public class Cart {

    List<CartLine> lines = new ArrayList<>();

    void add(CartLine line) {
        lines.add(line);
    }

    double getTotal() {
        double total = 0;
        int drinks = 0;
        double cheapestDrink = 0;

        for (CartLine line : lines) {
            total += line.getTotal();

            if (line.product.category.equals("DRINK")) {
                drinks++;

                if (cheapestDrink == 0 || line.product.price < cheapestDrink) {
                    cheapestDrink = line.product.price;
                }
            }
        }

        if (drinks >= 3) {
            total = total - cheapestDrink;
        }

        return total;
    }

    // Calculate the total VAT for all cart lines
    double getTax() {
        double tax = 0;
        int drinks = 0;
        double cheapestDrink = 0;

        // Add the VAT of each product
        for (CartLine line : lines) {
            tax += line.getTax();

            if (line.product.category.equals("DRINK")) {
                drinks++;

                if (cheapestDrink == 0 || line.product.price < cheapestDrink) {
                    cheapestDrink = line.product.price;
                }
            }
        }

        // Remove the VAT of the free drink
        if (drinks >= 3) {
            tax = tax - (cheapestDrink * 0.20);
        }

        return tax;
    }
}