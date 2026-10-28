package com.praveen.dsa.hashing;

/*
 * ============================================================================
 * QUESTION
 * ----------------------------------------------------------------------------
 * Given an array of integers, determine the number of occurrences of each
 * repeated value (frequency count).
 *
 * Example:  { 2, 2, 3, 4, 5, 5 }  ->  2:2, 3:1, 4:1, 5:2
 *
 * ============================================================================
 * EASY WAY TO THINK ABOUT IT  (a tally with a hashmap)
 * ----------------------------------------------------------------------------
 * Walk the array once. For each value, bump its counter in a HashMap<value, count>:
 *      map.put(x, map.getOrDefault(x, 0) + 1);
 * At the end the map holds how many times each value appeared. This is the
 * canonical use of a hash map for frequency counting.
 *
 * ============================================================================
 * OPTIMIZATION
 * ----------------------------------------------------------------------------
 *  HashMap tally in one pass.  Time : O(N) average   Space : O(N)
 *
 * ----------------------------------------------------------------------------
 * STATUS: INCOMPLETE ("not yet solved"). findOccurrence() has an empty loop and
 * no map. Left as-is intentionally - the header describes the intended approach.
 * ============================================================================
 */
public class Hashfunction {

	public static void main(String[] args) {

		int arr[] = { 2, 2, 3, 4, 5, 5, };

		findOccurrence(arr);
	}

	// TODO (INCOMPLETE): tally counts with a HashMap<value, count> in one pass.
	private static void findOccurrence(int[] arr) {

		int length = arr.length;

		for (int i = 0; i < length; i++) {
			// if (arr[i]) ...
		}
	}
}
