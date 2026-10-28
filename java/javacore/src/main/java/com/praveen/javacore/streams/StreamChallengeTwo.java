package com.praveen.javacore.streams;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/*
 * ============================================================================
 * QUESTION: sum transaction amounts per category, counting only amounts > 10.
 * ----------------------------------------------------------------------------
 * EASY WAY: filter(amount > 10), then groupingBy(category,
 * summingDouble(amount)) -> Map<category, totalAmount>. summingDouble is the
 * downstream collector that adds up each group.
 * COMPLEXITY: Time O(N), Space O(distinct categories).
 * ============================================================================
 */
class Transaction {
    String category;
    double amount;

    Transaction(String category, double amount) {
        this.category = category;
        this.amount = amount;
    }

    public String getCategory() { return category; }
    public double getAmount() { return amount; }
    
    @Override
    public String toString() {
    	return category.toString();
    }
}

public class StreamChallengeTwo {
    public static void main(String[] args) {
        List<Transaction> transactions = Arrays.asList(
            new Transaction("Grocery", 5.0),
            new Transaction("Grocery", 25.0),
            new Transaction("Electronics", 500.0),
            new Transaction("Utility", 100.0),
            new Transaction("Grocery", 15.0),
            new Transaction("Utility", 50.0)
        );

        // TODO: Map the sums by category for transactions > 10
        Map<String, Double> output = transactions.stream()
        										 .filter(t -> t.getAmount() > 10)
        										 .collect(Collectors.groupingBy(Transaction::getCategory, Collectors.summingDouble(Transaction::getAmount)));
        
        System.out.println(output);

        										
    }
}