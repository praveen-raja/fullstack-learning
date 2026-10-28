package com.praveen.dsa.arrays.problems;

import java.util.ArrayList;
import java.util.List;

/*
 * ============================================================================
 * QUESTION
 * ----------------------------------------------------------------------------
 * Count how many contiguous subarrays have a sum exactly equal to K.
 *
 * Example:  arr = { 10, 2, -2, -20, 10 }, k = -10
 *
 * ============================================================================
 * EASY WAY TO THINK ABOUT IT  (prefix sum + hashmap)
 * ----------------------------------------------------------------------------
 * Build running totals (prefix sums). The sum of window (i..j] equals
 * prefix[j] - prefix[i]. So a window sums to K whenever:
 *      prefix[j] - prefix[i] == K   ->   prefix[i] == prefix[j] - K
 * Walk left to right, and for each prefix[j] ask "how many earlier prefixes
 * equal prefix[j] - K?" using a hashmap of (prefixValue -> count). Add that to
 * the answer. (Seed the map with {0 : 1} to count windows starting at index 0.)
 *
 * ============================================================================
 * OPTIMIZATION LEVELS
 * ----------------------------------------------------------------------------
 *  Level 1 - Brute force (find1): sum of every window.
 *            Time  : O(N^2)   Space : O(1)
 *
 *  Level 2 - Prefix sum + hashmap of counts (the intended optimal)
 *            Time  : O(N)     Space : O(N)
 *
 * ----------------------------------------------------------------------------
 * STATUS: INCOMPLETE.
 *   find2 builds the prefix list but only counts prefixes literally equal to K
 *   and has an empty trailing loop. It does NOT yet implement the
 *   "prefix[j] - K" hashmap counting described above. Left as-is (WIP).
 * ============================================================================
 */
public class CountNumberOfSubarrayWithSumK {
	public static void main(String[] args) {
		int[] arr = { 10, 2, -2, -20, 10 };
		int k = -10;

		find2(arr, k);
	}

	// Level 1 - brute force over every window. TC = O(N^2), SC = O(1)
	private static void find1(int[] arr, int k) {
		int count = 0;
		for (int i = 0; i < arr.length; i++) {
			int sum = 0;
			for (int j = i; j < arr.length; j++) {
				sum = sum + arr[j];
				if (sum == k) {
					count++;
				}
			}
		}

		System.out.println(count);
	}

	// Level 2 (INCOMPLETE) - prefix sums built, but hashmap counting not done yet.
	private static void find2(int[] arr, int k) {

		List<Integer> list = new ArrayList<>();

		int sum = 0;
		int count = 0;

		// build the prefix-sum list
		for (int i = 0; i < arr.length; i++) {
			sum = sum + arr[i];
			list.add(sum);
		}

		// TODO: this only counts prefixes exactly equal to K; the correct logic is
		// to count earlier prefixes equal to (currentPrefix - K) via a hashmap.
		for (Integer l : list) {
			if (l == k) {
				count++;
			}
		}

		// TODO: empty placeholder loop - intended for the hashmap pass.
		for (int i = 0; i < arr.length; i++) {

		}

		System.out.println(list.toString());
		System.out.println(count);
	}
}
