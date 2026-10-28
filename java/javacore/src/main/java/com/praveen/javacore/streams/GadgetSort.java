package com.praveen.javacore.streams;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/*
 * ============================================================================
 * QUESTION: sort gadgets by price DESC, then by name ASC (tie-break).
 * ----------------------------------------------------------------------------
 * EASY WAY: Comparator.comparing(price).reversed().thenComparing(name). The
 * thenComparing kicks in only when prices tie (Tablet vs Watch at 500). Then
 * map to names. This is the idiom for multi-key sorting.
 * COMPLEXITY: Time O(N log N), Space O(N).
 * ============================================================================
 */
class Gadget {
    String name;
    double price;

    Gadget(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() { return name; }
    public double getPrice() { return price; }
    
    @Override
    public String toString() { return name + " ($" + price + ")"; }
}

public class GadgetSort {
    public static void main(String[] args) {
        List<Gadget> inventory = Arrays.asList(
            new Gadget("Phone", 800.0),
            new Gadget("Tablet", 500.0),
            new Gadget("Laptop", 1200.0),
            new Gadget("Watch", 500.0)
        );

        // TODO: Sort by price (desc), then name (asc)
        // Expected order: Laptop, Phone, Tablet, Watch
        List<String> output = inventory.stream()
        						.sorted(Comparator.comparing(Gadget::getPrice).reversed()
        						.thenComparing(Gadget::getName))
        						.map(s -> s.getName())
        						.collect(Collectors.toList());
        
        System.out.println(output);
    }
}