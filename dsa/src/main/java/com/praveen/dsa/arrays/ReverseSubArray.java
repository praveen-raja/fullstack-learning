package com.praveen.dsa.arrays;

import java.util.Arrays;

/*
 * ============================================================================
 * QUESTION
 * ----------------------------------------------------------------------------
 * Reverse only a PART of the array - the elements between index `start` and
 * index `end` (inclusive). Everything outside that window stays put.
 *
 * Example:  arr = { 1, 2, 3, 4, 5, 6 }, start = 1, end = 5
 *           reverse indices 1..5  ->  { 1, 6, 5, 4, 3, 2 }
 *
 * ============================================================================
 * EASY WAY TO THINK ABOUT IT
 * ----------------------------------------------------------------------------
 * Same "two fingers moving toward each other" idea as reversing a full array,
 * except the fingers start at `start` and `end` instead of 0 and length-1.
 * This sub-array reverse is the key building block used by array rotation.
 *
 * ============================================================================
 * OPTIMIZATION
 * ----------------------------------------------------------------------------
 *  Two-pointer in-place swap (revSubArray)
 *            Time  : O(end - start)   ~ O(N) worst case
 *            Space : O(1)
 * ============================================================================
 */
public class ReverseSubArray {

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 5, 6 };
		int start = 1;
		int end = 5;

		revSubArray(arr, start, end);
	}

	// Two-pointer in-place swap of the window [start, end]. TC = O(N), SC = O(1)
	private static void revSubArray(int[] arr, int start, int end) {

		while (start < end) {

			// XOR swap of arr[start] and arr[end] (no temp variable)
			arr[start] = arr[start] ^ arr[end];
			arr[end]   = arr[start] ^ arr[end];
			arr[start] = arr[start] ^ arr[end];

			start++;
			end--;
		}

		System.out.println(Arrays.toString(arr));
	}

}
