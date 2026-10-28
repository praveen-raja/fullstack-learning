package com.praveen.dsa.arrays.problems;

/*
 * ============================================================================
 * QUESTION
 * ----------------------------------------------------------------------------
 * Practice re-implementation of binary search on a sorted array: return the
 * index of `target`, or -1 if absent. (Same problem as BinarySearchExample -
 * kept as a from-memory practice copy.)
 *
 * ============================================================================
 * EASY WAY TO THINK ABOUT IT
 * ----------------------------------------------------------------------------
 * Check the middle. If it is the target, done. If the target is bigger, throw
 * away the left half; if smaller, throw away the right half. Each step halves
 * the search space -> log(N) steps.
 *
 * ============================================================================
 * OPTIMIZATION
 * ----------------------------------------------------------------------------
 *  Binary search (iterative).  Time : O(log N)   Space : O(1)
 * ============================================================================
 */
public class BinarySearchPractice {
	public static void main(String[] args) {
		int[] arr = { 10, 20, 30, 40, 50, 60 };
		int find = 50;

		int result = binarySearch(arr, find);
		System.out.println(result);
	}

	// Iterative binary search. TC = O(log N), SC = O(1)
	private static int binarySearch(int[] arr, int target) {

		int low = 0;
		int high = arr.length - 1;
		while (low <= high) {
			int mid = low + (high - low) / 2; // overflow-safe midpoint

			if (arr[mid] == target) {
				return mid;
			}

			if (arr[mid] < target) {
				low = mid + 1;  // search right half
			} else {
				high = mid - 1; // search left half
			}
		}

		return -1;
	}
}
