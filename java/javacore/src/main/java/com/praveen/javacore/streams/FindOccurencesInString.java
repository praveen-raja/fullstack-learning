package com.praveen.javacore.streams;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/*
 * ============================================================================
 * QUESTION
 * ----------------------------------------------------------------------------
 * Count how many times each character appears in a string, then print the ones
 * that repeat (count > 1). Streams version.
 *
 * ============================================================================
 * EASY WAY TO THINK ABOUT IT
 * ----------------------------------------------------------------------------
 *   name.chars()                 -> an IntStream of char codes
 *   .mapToObj(c -> (char)c)      -> turn each code back into a Character
 *   groupingBy(identity, counting()) -> Map<Character, Long> of frequencies
 * Then stream the map entries, keep count > 1, and print. The groupingBy +
 * counting combo is the idiomatic "frequency map" in one line.
 *
 * ============================================================================
 * COMPLEXITY
 * ----------------------------------------------------------------------------
 *  Time : O(N)   Space : O(distinct chars)
 * ============================================================================
 */
public class FindOccurencesInString {
	public static void main(String[] args) {
		String name = "praveenkumar";
		
		Map<Character, Long> counts = name
										.chars()
										.mapToObj(c -> (char)c)
										.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		
		System.out.println(counts);
		
		counts.entrySet().stream()
						 .filter(c -> c.getValue() > 1)
						 .forEach(c -> System.out.println(c.getKey() + ":"+c.getValue()));
	}
}
