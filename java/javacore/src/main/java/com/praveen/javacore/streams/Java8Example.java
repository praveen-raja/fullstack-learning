package com.praveen.javacore.streams;
import java.util.*;
import java.util.stream.Collectors;

/*
 * ============================================================================
 * TOPIC: map() vs flatMap() on real objects (Orders -> Items)
 * ----------------------------------------------------------------------------
 * Same map-vs-flatMap lesson as FlatMapAnalysis, but with domain objects.
 *
 * ============================================================================
 * EASY WAY TO THINK ABOUT IT
 * ----------------------------------------------------------------------------
 * Each Order has a List<Item>.
 *   map(Order::getItems)       -> Stream<List<Item>> (still nested; you'd loop twice)
 *   flatMap(o -> o.getItems().stream()) -> Stream<Item> (all items in one stream)
 * After flattening you can map(Item::getName).distinct() to get the unique item
 * names across ALL orders in one clean pipeline.
 *
 * ============================================================================
 * COMPLEXITY
 * ----------------------------------------------------------------------------
 *  Time : O(total items)   Space : O(distinct names)
 * ============================================================================
 */
class Item {
    String name;
    Item(String name) { this.name = name; }
    public String getName() { return name; }
    
    @Override
    public String toString() {
		return name;
    }
}

class Order {
    List<Item> items;
    Order(List<Item> items) { this.items = items; }
    public List<Item> getItems() { return items; }
}

public class Java8Example {
    public static void main(String[] args) {
        // Setup data
        Order order1 = new Order(Arrays.asList(new Item("Laptop"), new Item("Mouse")));
        Order order2 = new Order(Arrays.asList(new Item("Monitor"), new Item("Laptop")));
        List<Order> orders = Arrays.asList(order1, order2);

        // 1. Using map() - This would result in a List<List<Item>> (Nested)
        // You'd have to loop twice to get to the items.
        List<List<Item>> mapResult = orders.stream()
            .map(Order::getItems)
            .collect(Collectors.toList());
        
        System.out.println(mapResult); 

        // 2. Using flatMap() - This results in a List<String> (Flattened)
        // It "opens" the internal lists and pours them into one big stream.
        List<String> distinctItems = orders.stream()
            .flatMap(order -> order.getItems().stream()) // Flatten Order -> Stream<Item>
            .map(Item::getName)                          // Transform Item -> String
            .distinct()                                  // Remove duplicates (e.g., Laptop)
            .collect(Collectors.toList());

        System.out.println(distinctItems); 
        // Output: [Laptop, Mouse, Monitor]
    }
}