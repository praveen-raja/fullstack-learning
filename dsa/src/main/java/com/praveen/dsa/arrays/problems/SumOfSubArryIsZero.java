package com.praveen.dsa.arrays.problems;

import java.util.LinkedHashSet;
import java.util.Set;

/*
 * ============================================================================
 * QUESTION
 * ----------------------------------------------------------------------------
 * Given an array, check whether ANY contiguous subarray sums to zero.
 *
 * Example:  { 7, 1, 3, -2, 4, 1, 0, -1, 18 }  -> true (several zero-sum windows)
 *
 * ============================================================================
 * EASY WAY TO THINK ABOUT IT  (prefix sums + "have I seen this total before?")
 * ----------------------------------------------------------------------------
 * Keep a running total (prefix sum) as you walk. Store every running total in a
 * set. Two facts give the answer:
 *   1) If any element itself is 0, that's a zero-sum subarray -> true.
 *   2) If the running total REPEATS a value you've seen before, then the chunk
 *      of elements between those two points must add up to 0 (same total before
 *      and after means the middle added nothing). -> true.
 *
 * So: the moment set.add(sum) fails (value already present), you've found one.
 *
 * ============================================================================
 * OPTIMIZATION LEVELS
 * ----------------------------------------------------------------------------
 *  Level 1 - Brute force (isSumSubarray1): try every window, sum it.
 *            Time  : O(N^2)   Space : O(1)
 *
 *  Level 2 - Prefix sum + set of seen totals (isSumSubarray2)
 *            Time  : O(N)     Space : O(N)   -> the set
 * ============================================================================
 */
public class SumOfSubArryIsZero {
	public static void main(String[] args) {
		int[] arr = { -1, -7, 2, 4, -9, -2, 11 };

		System.out.println(isSumSubarray2(arr));
	}

	// Level 2 - prefix sum; a repeated running total means a zero-sum window.
	// TC = O(N), SC = O(N)
	private static boolean isSumSubarray2(int[] arr) {

		// LinkedHashSet keeps insertion order (not required, just tidy for debugging)
		Set<Integer> set = new LinkedHashSet<>();

		// a lone 0 is already a zero-sum subarray
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == 0) {
				return true;
			}
		}

		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum = sum + arr[i];
			if (!set.add(sum)) {     // running total repeated -> zero-sum window between
				return true;
			}
		}

		return false;
	}

	// Level 1 - brute force: sum of every window. TC = O(N^2), SC = O(1)
	private static boolean isSumSubarray1(int[] arr) {

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == 0) {
				return true;
			}
		}

		for (int i = 0; i < arr.length; i++) {
			int sum = 0;
			for (int j = i; j < arr.length; j++) {
				sum = sum + arr[j];
				if (sum == 0) {
					return true;
				}
			}
		}

		return false;
	}
}
