package com.praveen.javacore.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/*
 * ============================================================================
 * QUESTION: convert a list of scores into "PASS"/"FAIL" (>= 70 is PASS).
 * ----------------------------------------------------------------------------
 * EASY WAY: map each score through a ternary (s >= 70 ? "PASS" : "FAIL") and
 * collect to a list. Pure one-to-one transform.
 * COMPLEXITY: Time O(N), Space O(N).
 * ============================================================================
 */
public class GradeConverter {
	public static void main(String[] args) {
		List<Integer> scores = Arrays.asList(90, 45, 82, 70, 55, 99);

		// TODO: Transform to ["PASS", "FAIL"]
		
		List<String> result = scores.stream()
								.map(s -> s >= 70 ? "PASS":"FAIL")
								.collect(Collectors.toList());
		
		System.out.println(result);
	}
}