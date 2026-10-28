package com.praveen.javacore.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/*
 * ============================================================================
 * QUESTION: sum of the squares of the EVEN numbers in a list.
 * ----------------------------------------------------------------------------
 * EASY WAY: filter(n % 2 == 0) -> mapToInt(n -> n*n) -> sum(). Switching to an
 * IntStream via mapToInt lets you call sum() directly (no boxing, no reduce).
 * COMPLEXITY: Time O(N), Space O(1).
 * ============================================================================
 */
public class StreamChallengeFour {
	public static void main(String[] args) {
		
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		/*
		 * Write a stream that:
		 * 
		 * Filters for even numbers.
		 * Squares each of those numbers ($x^2$).
		 * Calculates the Sum of those squares.
		 * 
		 * (Hint: Look for mapToInt and sum() for the most efficient way to do math on a stream.)
		 */
		int sum = 0;
		Integer sumOfSquare = numbers.stream().filter( n -> n%2 == 0)
											  .mapToInt(n -> n*n)
											  .sum();
		
		System.out.println(sumOfSquare);
											  
    }
}