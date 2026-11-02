package com.praveen.javacore.streams;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/*
 * ============================================================================
 * QUESTION
 * ----------------------------------------------------------------------------
 * Same task as FindOccurencesInString (char frequency, print repeats), shown
 * TWO ways: a classic HashMap loop and the Streams one-liner.
 *
 * ============================================================================
 * EASY WAY TO THINK ABOUT IT
 * ----------------------------------------------------------------------------
 *   main2(): imperative - loop chars, map.getOrDefault(c,0)+1 to tally, then
 *            loop the entries and print those with count > 1.
 *   main():  functional - chars().mapToObj(...).groupingBy(identity, counting())
 *            builds the same Map, then filter count > 1 and print.
 * Same result, two styles - handy for seeing how a stream collapses a loop.
 *
 * NOTE: the imperative version is named main2() (not a real entry point), so
 * only the Streams main() runs.
 *
 * ============================================================================
 * COMPLEXITY
 * ----------------------------------------------------------------------------
 *  Both : Time O(N), Space O(distinct chars)
 * ============================================================================
 */
public class FindOccurencesInTringUsingHashMap {
	public static void main2(String[] args) {
		String name = "praveenkumar";
		
		Map<Character, Integer> charVsCount = new HashMap<>();
		
		char[] charArray = name.toCharArray();
		
		for(char c: charArray)
		{
			charVsCount.put(c, charVsCount.getOrDefault(c, 0) + 1);
		}
		
		for(Map.Entry<Character, Integer> entry: charVsCount.entrySet()) {
			if(entry.getValue()>1) {
				System.out.println(entry.getKey() + " appears " + entry.getValue() + " times");
			}
		}
 	}
	
	public static void main(String[] args) {
		String name = "praveenkumar";
		
		Map<Character, Long> count = name.chars()
										 .mapToObj(c -> (char)c)
										 .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		
		
		count.entrySet().stream()
						.filter(c -> c.getValue()>1)
						.forEach(c -> System.out.println(c.getKey() +" presents "+ c.getValue() +" times"));
	}
}
