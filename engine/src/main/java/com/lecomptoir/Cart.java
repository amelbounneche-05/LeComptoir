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

        for (CartLine line : lines) {
            total += line.getTotal();
        }

        if (total>50) {
            total = total * 0.90;
        }
        return total;
    }
}