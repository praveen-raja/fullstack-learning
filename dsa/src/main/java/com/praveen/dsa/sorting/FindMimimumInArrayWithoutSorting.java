package com.praveen.dsa.sorting;

/*
 * ============================================================================
 * QUESTION
 * ----------------------------------------------------------------------------
 * Find the smallest (and second-smallest) element in an array WITHOUT sorting
 * it, in a single pass. (This file then prints secondMin - firstMin.)
 *
 * ============================================================================
 * EASY WAY TO THINK ABOUT IT  (keep the top two "smallest so far")
 * ----------------------------------------------------------------------------
 * Hold two running values: firstMin (smallest so far) and secondMin (runner-up).
 * For each element:
 *   - if it beats firstMin, the old firstMin slides down to secondMin, and the
 *     new element becomes firstMin.
 *   - else if it beats secondMin, it becomes the new secondMin.
 * One pass, no sort needed.
 *
 * ============================================================================
 * OPTIMIZATION
 * ----------------------------------------------------------------------------
 *  Single pass tracking top two.  Time : O(N)   Space : O(1)
 *  (Sorting first would be O(N log N) - this is strictly better.)
 *
 * NOTE: with an array of 3 elements like {3,5,7}, firstMin=3, secondMin=5, and
 * it prints secondMin - firstMin = 2. Edge cases (array length < 2, duplicate
 * minima) are not specially handled.
 * ============================================================================
 */
public class FindMimimumInArrayWithoutSorting {
	public static void main(String[] args) {
		int arr[] = { 3, 5, 7 };

		findMimimum(arr);
	}

	// Track smallest and second-smallest in one pass. TC = O(N), SC = O(1)
	private static void findMimimum(int[] arr) {

		int firstMin = Integer.MAX_VALUE;  // smallest so far
		int secondMin = Integer.MAX_VALUE; // runner-up

		System.out.println(firstMin + "\n" + secondMin);

		for (int i = 0; i < arr.length; i++) {

			if (arr[i] < firstMin) {
				secondMin = firstMin;  // old smallest becomes runner-up
				firstMin = arr[i];
			}

			if (arr[i] < secondMin) {
				secondMin = arr[i];
			}
		}

		System.out.println(secondMin - firstMin);
	}
}
