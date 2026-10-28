package com.praveen.javacore.streams;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/*
 * ============================================================================
 * QUESTION: from race times, get the 2nd and 3rd FASTEST.  -> [51, 53]
 * ----------------------------------------------------------------------------
 * EASY WAY: sort ascending, limit(3) keeps the three fastest, then skip(1)
 * drops the fastest, leaving 2nd and 3rd. (Order of limit/skip matters.)
 * COMPLEXITY: Time O(N log N), Space O(N).
 * ============================================================================
 */
public class RaceResults {
    public static void main(String[] args) {
        // Race times in seconds
        List<Integer> times = Arrays.asList(55, 48, 62, 51, 53, 59);

        // TODO: Get only the 2nd and 3rd fastest times
        // Expected Output: [51, 53]
        
        List<Integer> output = times.stream()
        							.sorted(Comparator.naturalOrder())
        							.limit(3)
        							.skip(1)
        							.collect(Collectors.toList());
        
        System.out.println(output);
    }
}