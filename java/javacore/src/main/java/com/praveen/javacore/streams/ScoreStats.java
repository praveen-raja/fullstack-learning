package com.praveen.javacore.streams;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

/*
 * ============================================================================
 * QUESTION: get sum, average, count, min, max of valid scores in ONE pass.
 * ----------------------------------------------------------------------------
 * EASY WAY: filter out negatives, then summarizingInt collects all five stats
 * at once into an IntSummaryStatistics - no need for five separate passes.
 * COMPLEXITY: Time O(N), Space O(1).
 * ============================================================================
 */
public class ScoreStats {
	public static void main(String[] args) {
		List<Integer> scores = Arrays.asList(85, 92, 78, -5, 100, 88);

		// TODO: Get stats (sum, average, count, min, max) in one go
		IntSummaryStatistics stats = scores.stream()
					.filter (s -> s>=0)
					.collect(Collectors.summarizingInt(Integer::intValue));
		
		
		System.out.println("Full stats: "+stats);
	}
}