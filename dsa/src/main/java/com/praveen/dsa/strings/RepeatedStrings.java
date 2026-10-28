package com.praveen.dsa.strings;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/*
 * ============================================================================
 * QUESTION
 * ----------------------------------------------------------------------------
 * Given a sentence, (1) count how many times each word appears, and (2) list
 * the words that appear more than once.
 *
 * ============================================================================
 * EASY WAY TO THINK ABOUT IT  (group + count with streams)
 * ----------------------------------------------------------------------------
 * Lowercase the sentence and split on spaces into words. Then:
 *   groupingBy(identity, counting())  builds a Map<word, count> in one shot.
 * To find repeats, stream the map entries, keep those with count > 1, and
 * collect their keys.
 *
 * (Function.identity() just means "group each word by itself".)
 *
 * ============================================================================
 * OPTIMIZATION
 * ----------------------------------------------------------------------------
 *  Single grouping pass.  Time : O(W) for W words   Space : O(distinct words)
 * ============================================================================
 */
public class RepeatedStrings {
	public static void main(String[] args) {
		String input = "Java is great and Java is fast, but Java can be complex may be";

		// (1) word -> count
		Map<String, Long> countofwords = Arrays.stream(input.toLowerCase().split(" "))
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

		System.out.println(countofwords);

		// (2) keep only words whose count > 1
		List<String> output = Arrays.stream(input.toLowerCase().split(" "))
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
				.entrySet()
				.stream()
				.filter(entry -> entry.getValue() > 1)
				.map(Map.Entry::getKey)
				.collect(Collectors.toList());

		System.out.println("Repeated words: " + output);
	}
}
