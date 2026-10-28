package com.praveen.javacore.streams;
import java.util.*;
import java.util.stream.*;

/*
 * ============================================================================
 * TOPIC: Streams "all-in-one" tour (filter, map, sort, reduce, min/max,
 *        groupingBy, anyMatch, distinct, limit)
 * ----------------------------------------------------------------------------
 * A single reference exercising the operations you reach for most often, on a
 * list of Products.
 *
 * ============================================================================
 * EASY WAY TO THINK ABOUT IT  (pipeline = source -> steps -> terminal)
 * ----------------------------------------------------------------------------
 * A stream pipeline reads top to bottom:
 *   - INTERMEDIATE ops are lazy and return a stream: filter (keep some), map
 *     (transform), sorted, distinct, limit.
 *   - a TERMINAL op triggers the work and produces a result: collect, reduce,
 *     max/min, anyMatch, forEach.
 * Each numbered block here is one such pipeline; read the comment then the
 * chain. Nothing runs until the terminal op at the end.
 *
 * ============================================================================
 * COMPLEXITY
 * ----------------------------------------------------------------------------
 *  Each pipeline is ~O(N) (sorted adds O(N log N)).  Space : O(result)
 * ============================================================================
 */
class Product {
    String name;
    String category;
    double price;

    Product(String name, String category, double price) {
        this.name = name;
        this.category = category;
        this.price = price;
    }

    @Override
    public String toString() { return name + " ($" + price + ")"; }
}

public class StreamMasterclass {
    public static void main(String[] args) {
        List<Product> products = Arrays.asList(
            new Product("Laptop", "Electronics", 1200.0),
            new Product("Phone", "Electronics", 800.0),
            new Product("Keyboard", "Electronics", 50.0),
            new Product("Apple", "Food", 2.0),
            new Product("Bread", "Food", 3.5),
            new Product("Desk", "Furniture", 200.0)
        );

        // 1. FILTER, MAP, SORT, and COLLECT
        List<String> expensiveElectronics = products.stream()
            .filter(p -> p.category.equals("Electronics")) // Filter: Keep only Electronics
            .filter(p -> p.price > 100)                    // Filter: Price > 100
            .map(p -> p.name.toUpperCase())                 // Map: Transform name to Uppercase
            .sorted()                                      // Sort: Alphabetical order
            .collect(Collectors.toList());                 // Terminal: Collect to List

        System.out.println("Expensive Electronics: " + expensiveElectronics);

        // 2. REDUCE (Calculating Total Price)
        double totalInventoryValue = products.stream()
            .map(p -> p.price)
            .reduce(0.0, Double::sum);                     // Reduce: Sum all prices

        System.out.println("Total Value: $" + totalInventoryValue);

        // 3. MIN / MAX
        products.stream()
            .max(Comparator.comparing(p -> p.price))       // Max: Find the most expensive
            .ifPresent(p -> System.out.println("Max Price Item: " + p));

        // 4. GROUPING BY (Map categorization)
        Map<String, List<Product>> byCategory = products.stream()
            .collect(Collectors.groupingBy(p -> p.category)); // Group by Category

        System.out.println("Products by Category: " + byCategory);

        // 5. ANYMATCH / ALLMATCH / NONEMATCH
        boolean hasCheapItems = products.stream().anyMatch(p -> p.price < 5.0);
        System.out.println("Are there cheap items? " + hasCheapItems);

        // 6. DISTINCT & LIMIT
        List<Integer> numbers = Arrays.asList(1, 2, 2, 3, 4, 4, 5);
        List<Integer> uniqueFirstThree = numbers.stream()
            .distinct()                                    // Remove duplicates
            .limit(3)                                      // Take only first 3
            .collect(Collectors.toList());
        
        System.out.println("Unique Limit 3: " + uniqueFirstThree);
    }
}