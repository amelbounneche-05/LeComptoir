package com.lecomptoir;

import java.util.ArrayList;
import java.util.List;

public class Cart {

    // List of cart lines
    List<CartLine> lines = new ArrayList<>();

    // Add a line to the cart
    void add(CartLine line) {
        lines.add(line);
    }

    // Calculate the cart total
    double getTotal() {
        double total = 0;
        int drinks = 0;
        double cheapestDrink = 0;

        // Go through each cart line
        for (CartLine line : lines) {
            total += line.getTotal();

            // Check if the product is a drink
            if (line.product.category.equals("DRINK")) {
                drinks++;

                // Find the cheapest drink
                if (cheapestDrink == 0 || line.product.price < cheapestDrink) {
                    cheapestDrink = line.product.price;
                }
            }
        }

        // With 3 or more drinks, the cheapest one is free
        if (drinks >= 3) {
            total = total - cheapestDrink;
        }

        return total;
    }

    // Calculate the total VAT
    double getTax() {
        double tax = 0;
        int drinks = 0;
        double cheapestDrink = 0;

        // Go through each cart line
        for (CartLine line : lines) {
            tax += line.getTax();

            if (line.product.category.equals("DRINK")) {
                drinks++;

                // Find the cheapest drink
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

    // Calculate a 10% discount
    double getDiscount10Percent() {
        double total = getTotal();

        // Discount if the total is more than 50€
        if (total > 50) {
            return total * 0.10;
        }

        return 0;
    }

    // Calculate a 20% discount on food products
    double getDiscount20Percent() {
        int foodProducts = 0;

        // Count the quantity of food products
        for (CartLine line : lines) {
            if (line.product.category.equals("FOOD")) {
                foodProducts += line.quantity;
            }
        }

        // Discount if there are at least 10 food products
        if (foodProducts >= 10) {
            return getTotal() * 0.20;
        }

        return 0;
    }
}