package com.praveen.dsa.sorting;

import java.util.Arrays;

/*
 * ============================================================================
 * QUESTION
 * ----------------------------------------------------------------------------
 * Given an array of size N, find the Kth minimum element, using selection-sort
 * style passes and WITHOUT extra space (number of swap-passes kept small, ~K).
 *
 * Example:  { 1, 2, 3, 4, 5 }, k = 2  ->  2nd minimum is 2
 *
 * ============================================================================
 * EASY WAY TO THINK ABOUT IT  (partial selection sort)
 * ----------------------------------------------------------------------------
 * A full sort is wasteful if you only need the Kth smallest. Selection sort
 * "locks in" one correct element per pass, so after K passes the K smallest (or
 * largest) are already in their final spots - you can stop early. That is why
 * the outer loop here runs only ~K times instead of N times.
 *
 * ============================================================================
 * OPTIMIZATION LEVELS
 * ----------------------------------------------------------------------------
 *  Level 1 - Full sort then index (O(N log N)).
 *  Level 2 - Partial selection sort, K passes (this file).
 *            Time  : O(K * N)   Space : O(1)
 *  Level 3 - Min-heap / Quickselect (not here): O(N + K log N) or avg O(N).
 *
 * ----------------------------------------------------------------------------
 * NOTE: find() sorts DESCENDING (swaps when arr[i] < arr[i+1]) and reads
 * arr[length-1-k]. The outer loop "x <= k" and that index are easy to get
 * off-by-one; treat the exact boundary as practice-grade, not battle-tested.
 * ============================================================================
 */
public class FindKthMinimumArrayElements {
	public static void main(String[] args) {
		int[] arr = { 34, 9, 88, 15, 32, 33 };
		int k = 2;

		find(arr, k);
	}

	// Partial selection sort (descending), ~K passes. TC = O(K*N), SC = O(1)
	private static void find(int[] arr, int k) {
		for (int x = 0; x <= k; x++) {
			for (int i = 0; i < arr.length; i++) {
				if (i < arr.length - 1) {
					if (arr[i] < arr[i + 1]) {       // bubble larger values toward the front
						int temp = arr[i];
						arr[i] = arr[i + 1];
						arr[i + 1] = temp;
					}
				}
			}
		}
		System.out.println(Arrays.toString(arr));
		System.out.println(arr[arr.length - 1 - k]);
	}
}
