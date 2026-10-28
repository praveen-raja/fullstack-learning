package com.praveen.javacore.streams;
import java.util.*;
import java.util.stream.*;

/*
 * ============================================================================
 * TOPIC: Streams practice #2 (filter/map/sort, reduce, min/max, groupingBy,
 *        noneMatch) - a re-do of StreamMasterclass from memory.
 * ----------------------------------------------------------------------------
 * EASY WAY - same pipeline ideas:
 *   - filter price > 100 -> map name uppercase -> sorted -> collect
 *   - reduce(0.0, Double::sum)       -> total price
 *   - max(Comparator.comparing(name))-> (note: this finds max by NAME, so the
 *                                        "Minimum price item" label is a misnomer)
 *   - groupingBy(category)           -> products per category
 *   - noneMatch(price > 1200)        -> true if NOTHING exceeds 1200
 *
 * NOTE: a `Products` class is declared here but main() actually uses `Product`
 * (defined in StreamMasterclass.java, same package). The `Products` class is
 * unused - leftover. Left as-is.
 *
 * COMPLEXITY: each pipeline ~O(N) (sort O(N log N)).
 * ============================================================================
 */
class Products {
    String name;
    String category;
    double price;

    Products(String name, String category, double price) {
        this.name = name;
        this.category = category;
        this.price = price;
    }

    @Override
    public String toString() { return name + " ($" + price + ")"; }
}

public class StreamMasterclass2 {
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
        List<String> stringList = products.stream().filter(p-> p.price > 100)
        				 .map(p -> p.name.toUpperCase())
        				 .sorted()
        				 .collect(Collectors.toList());
        
        System.out.println(stringList);

        // 2. REDUCE (Calculating Total Price)
        double sum = 0;
        double totalPrice = products.stream()
        							.map(p -> p.price)
        							.reduce(0.0, Double::sum);
        
        System.out.println(totalPrice);
        
        // 3. MIN / MAX
        products.stream().max(Comparator.comparing(p -> p.name))
        				 .ifPresent(p -> System.out.println("Minimum price item : "+p));
        
        // 4. GROUPING BY (Map categorization)
       Map<String, List<Product>> prodMap = products.stream().collect(Collectors.groupingBy( p -> p.category));
       System.out.println("Products by Category: " + prodMap);
       
        // 5. ANYMATCH / ALLMATCH / NONEMATCH
        boolean hasCheapItems = products.stream().noneMatch(p -> p.price > 1200);
        System.out.println(hasCheapItems);
    }
}