package com.praveen.dsa.sorting;

import java.util.Arrays;

/*
 * ============================================================================
 * QUESTION
 * ----------------------------------------------------------------------------
 * A "noble element" is a value X in the array such that the COUNT of elements
 * strictly greater than X equals X itself. Return a noble element if one exists,
 * else -1.
 *
 * Example:  { 1, 2, 4, 4, 6, 6, 6, 6 }
 *           value 4: exactly 4 elements (the four 6s) are greater than 4 -> noble.
 *
 * ============================================================================
 * EASY WAY TO THINK ABOUT IT  (sort, then count-above is just position)
 * ----------------------------------------------------------------------------
 * Sort the array ascending. Now for the element at index i, the number of
 * elements to its RIGHT is (length - i - 1) - and those are all >= arr[i].
 * So "elements strictly greater than arr[i]" = (length - i - 1), provided arr[i]
 * is not equal to its right neighbour (skip duplicates so you count a value once
 * and avoid equal-to cases). If arr[i] == (length - i - 1), it is noble.
 *
 * ============================================================================
 * OPTIMIZATION
 * ----------------------------------------------------------------------------
 *  Sort O(N log N) + single scan O(N) = O(N log N).
 *            Time  : O(N log N)   Space : O(1) extra (in-place sort)
 * ============================================================================
 */
public class PrintNobleElementInArray {
	public static void main(String[] args) {
		int arr[] = { 1, 2, 4, 4, 6, 6, 6, 6 };
		Arrays.sort(arr);
		System.out.println(findNobleElement(arr));
	}

	// After sorting, count-of-greater = (length - i - 1). TC = O(N) over sorted array, SC = O(1)
	private static int findNobleElement(int[] arr) {

		for (int i = 0; i < arr.length; i++) {

			if ((i + 1) < arr.length) {
				if (arr[i] != arr[i + 1]) {                 // skip duplicates
					if (arr[i] == (arr.length - i - 1)) {   // value == count greater than it
						return arr[i];
					}
				}
			}
		}
		return -1;
	}
}
