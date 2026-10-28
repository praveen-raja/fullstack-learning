package com.praveen.javacore.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/*
 * ============================================================================
 * QUESTION: take names starting with "a", sort them, join as "[a, b, c]".
 * ----------------------------------------------------------------------------
 * EASY WAY: filter(startsWith "a") -> sorted() -> joining(", ", "[", "]").
 * The 3-arg joining adds a delimiter plus a prefix and suffix in one step.
 * COMPLEXITY: Time O(N log N), Space O(N).
 * ============================================================================
 */
public class StreamChallengeFive {
	public static void main(String[] args) {
		
		List<String> nameList = Arrays.asList("anna", "bob", "alex", "brian", "charles", "amanda");
		
		String output = nameList.stream()
		//Filter for names starting with "a".
			.filter(n -> n.startsWith("a"))
			.sorted()
			.collect(Collectors.joining(", ","[", "]"));
		
		System.out.println(output);
			
    }
}