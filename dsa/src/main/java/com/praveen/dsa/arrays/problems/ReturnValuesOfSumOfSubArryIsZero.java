package com.praveen.dsa.arrays.problems;

import java.util.LinkedHashMap;
import java.util.Map;

/*
 * ============================================================================
 * QUESTION
 * ----------------------------------------------------------------------------
 * Like SumOfSubArryIsZero, but instead of just true/false, RETURN the actual
 * elements of a contiguous subarray whose sum is zero.
 *
 * Example:  array = { 7, 1, 3, -2, 4, 1, 0, -1, 18 }
 *
 * ============================================================================
 * EASY WAY TO THINK ABOUT IT  (prefix sum + remember WHERE you saw it)
 * ----------------------------------------------------------------------------
 * Same insight as the true/false version: if a running total repeats, the slice
 * between the two positions sums to zero. To RETURN the slice (not just detect
 * it), store running total -> index in a map. When a total repeats, the stored
 * index is the start and the current index is the end of the zero-sum window.
 *
 * ============================================================================
 * OPTIMIZATION
 * ----------------------------------------------------------------------------
 *  Prefix sum + hashmap of (sum -> index).
 *            Time  : O(N)   Space : O(N)
 *
 * ----------------------------------------------------------------------------
 * STATUS: INCOMPLETE.
 *   - The zero-element early return is commented out.
 *   - On a repeated sum it returns an empty Integer[] {} instead of slicing out
 *     the actual window between map.get(sum) and the current index.
 *   - map.get(i) uses the loop index i, not the repeated sum - a bug to fix
 *     when completing.
 *   Left as-is intentionally (work in progress).
 * ============================================================================
 */
public class ReturnValuesOfSumOfSubArryIsZero {
	public static void main(String[] args) {
		int[] arr = { -1, -7, 2, 4, -9, -2, 11 };

		System.out.println(returnSumSubarray2(arr));
	}

	// Prefix sum + map of (sum -> index). TC = O(N), SC = O(N).  INCOMPLETE (see header).
	private static Integer[] returnSumSubarray2(int[] arr) {

		// LinkedHashMap keeps insertion order
		Map<Integer, Integer> map = new LinkedHashMap<>();

		// TODO: if any single element is 0, that element alone is the answer.
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == 0) {
//				return true;
			}
		}

		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			System.out.println("Index : " + i);
			sum = sum + arr[i];
			System.out.println(sum);
			if (map.putIfAbsent(sum, i) != null) {
				System.out.println("Index from : " + map.get(i)); // TODO: should be map.get(sum)

				// TODO: build and return the slice arr[map.get(sum)+1 .. i] instead of empty.
				return new Integer[] {};
			}
		}
		return null;
	}
}
