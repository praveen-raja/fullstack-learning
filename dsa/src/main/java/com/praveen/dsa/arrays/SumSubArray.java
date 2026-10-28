package com.praveen.dsa.arrays;

/*
 * ============================================================================
 * QUESTION
 * ----------------------------------------------------------------------------
 * Given an array and a range [start, end], return the sum of the elements in
 * that range (inclusive).
 *
 * Example:  array = { 1, 2, 3, 4, 5, 6 }, start = 0, end = 3
 *           sum of indices 0..3 = 1+2+3+4 = 10
 *
 * ============================================================================
 * EASY WAY TO THINK ABOUT IT
 * ----------------------------------------------------------------------------
 * Just walk from start to end and keep adding. Simple.
 *
 * This is the "answer one range" version. When you must answer MANY range
 * queries on the same array, re-walking every time is wasteful - see
 * SumSubArrayOptimized, which precomputes a prefix-sum so each query is O(1).
 *
 * ============================================================================
 * OPTIMIZATION LEVELS
 * ----------------------------------------------------------------------------
 *  Level 1 - Loop and add (this file, sumSubArray1)
 *            Time  : O(N) per query
 *            Space : O(1)
 *
 *  Level 2 - Prefix-sum precompute (see SumSubArrayOptimized)
 *            Time  : O(N) once, then O(1) per query
 *            Space : O(N) for the prefix array
 * ============================================================================
 */
public class SumSubArray {
	public static void main(String[] args) {
		int array[] = { 1, 2, 3, 4, 5, 6 };
		int start = 0;
		int end = 3;
		System.out.println(sumSubArray1(array, start, end));
	}

	// Level 1 - add every element in the window. TC = O(N), SC = O(1)
	private static int sumSubArray1(int[] array, int start, int end) {

		int ans = 0;
		for (int i = start; i <= end; i++) {
			ans = ans + array[i];
		}

		return ans;
	}
}
