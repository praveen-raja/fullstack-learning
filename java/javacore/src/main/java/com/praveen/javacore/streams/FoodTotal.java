package com.praveen.javacore.streams;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/*
 * ============================================================================
 * QUESTION: total price of all "Food" items.  -> 8.0
 * ----------------------------------------------------------------------------
 * EASY WAY: filter(category == "Food") -> mapToDouble(price) -> sum().
 * mapToDouble gives a DoubleStream so sum()/average() are available directly.
 * COMPLEXITY: Time O(N), Space O(1).
 *
 * NOTE: the trailing `staff` field + comment below main() is leftover scratch
 * from another exercise; harmless. Left as-is.
 * ============================================================================
 */
class Product3 {
    String name;
    String category;
    double price;

    Product3(String name, String category, double price) {
        this.name = name;
        this.category = category;
        this.price = price;
    }

    public String getCategory() { return category; }
    public double getPrice() { return price; }
}

public class FoodTotal {
    public static void main(String[] args) {
        List<Product3> products = Arrays.asList(
            new Product3("Apple", "Food", 2.50),
            new Product3("Shirt", "Clothing", 20.00),
            new Product3("Bread", "Food", 1.50),
            new Product3("Soap", "Personal Care", 3.00),
            new Product3("Cheese", "Food", 4.00)
        );

        // TODO: Find the total price of all "Food" items
        // Expected result: 8.0
        double total = products.stream()
        	.filter(f -> f.getCategory().equals("Food"))
        	.mapToDouble(Product3::getPrice)
        	.sum();
        
        System.out.println(total);
    }

	List<Employee> staff = Arrays.asList(
	    new Employee("Alice", "IT", 60000),
	    new Employee("Bob", "HR", 45000),
	    new Employee("Charlie", "IT", 70000)
	);
	
	
	
	
	
	// Expected Result: ["Alice [IT]", "Charlie [IT]"]
}