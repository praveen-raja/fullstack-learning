package com.praveen.dsa.arrays.problems;

import java.util.Arrays;

/*
 * ============================================================================
 * QUESTION
 * ----------------------------------------------------------------------------
 * Count the number of contiguous subarrays that contain EXACTLY K odd numbers.
 *
 * Example:  array = { 2, 4, 1, 3, 8 }, k = 1
 *           subarrays with exactly 1 odd element:
 *              {2,4,1}, {4,1}, {1}, {3}, {3,8}   -> count = 5
 *
 * ============================================================================
 * EASY WAY TO THINK ABOUT IT
 * ----------------------------------------------------------------------------
 * Turn each number into 1 if odd, 0 if even. Now "exactly K odd elements" is
 * the same as "subarray sum exactly K" on this 0/1 array - the classic
 * "count subarrays with sum K" problem (prefix sum + hashmap), or a sliding
 * window of odd-counts.
 *
 * ============================================================================
 * OPTIMIZATION LEVELS
 * ----------------------------------------------------------------------------
 *  Level 1 - Brute force: every window, count odds.          O(N^2), O(1)
 *  Level 2 - Map it to "count subarrays with sum K" on 0/1.  O(N),  O(N)
 *
 * ----------------------------------------------------------------------------
 * STATUS: INCOMPLETE / BUGGY.
 *   find() overwrites the array with prefix sums and then uses (arr[i] & 1) on
 *   those prefixes, plus an ad-hoc count formula. It does NOT correctly solve
 *   "exactly K odds" (the sample uses k=2 on a different array). The prefix/odd
 *   logic is mixed up. Left as-is intentionally (work in progress) - the header
 *   describes the correct approach for when it is finished.
 * ============================================================================
 */
public class CountSubarrayWithExactlyKOddElements {

	public static void main(String[] args) {
		int[] arr = { 7, 1, 3, -2, 4, -1, 0, -1, 18 };
		int k = 2;

		find(arr, k);
	}

	// INCOMPLETE / BUGGY - see header. Does not correctly count "exactly K odds".
	private static void find(int[] arr, int k) {

		int sum = 0;

		// NOTE: this overwrites arr with prefix sums...
		for (int i = 0; i < arr.length; i++) {
			sum = sum + arr[i];
			arr[i] = sum;
		}

		int count = 0;
		int k_count = 0;
		for (int i = 0; i < arr.length; i++) {
			if ((arr[i] & 1) == 1) { // ...then tests parity of a PREFIX, not the original element
				k_count++;
				if (k_count == k) {
					count = count + (i + 1) + ((arr.length - 1) - i);
				}
			}
		}

		System.out.println(Arrays.toString(arr));
		System.out.println(count);
	}

}
