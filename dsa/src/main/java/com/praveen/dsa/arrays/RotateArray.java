package com.praveen.dsa.arrays;

import java.util.Arrays;

/*
 * ============================================================================
 * QUESTION
 * ----------------------------------------------------------------------------
 * Rotate an array to the RIGHT by N steps. One right-rotation takes the last
 * element and puts it at the front.
 *
 * Example 1:  { 1, 2, 3, 4, 5 }  after 1 rotation  ->  { 5, 1, 2, 3, 4 }
 * Example 2:  { 3, 2, 9, 6, 5, 8 } after 3 rotations -> { 6, 5, 8, 3, 2, 9 }
 *
 * ============================================================================
 * EASY WAY TO THINK ABOUT IT  (the "triple reverse" trick)
 * ----------------------------------------------------------------------------
 * Rotating right by k is the same as:
 *   1) reverse the WHOLE array
 *   2) reverse the FIRST k elements
 *   3) reverse the REMAINING elements
 *
 *   { 1,2,3,4,5 }, k=2
 *   reverse all      -> { 5,4,3,2,1 }
 *   reverse first 2  -> { 4,5,3,2,1 }
 *   reverse rest     -> { 4,5,1,2,3 }   (rotated right by 2)
 *
 * Two guard rails:
 *   - if k > length, use k % length (rotating by length does nothing)
 *   - handle tiny / already-handled arrays before touching them
 *
 * ============================================================================
 * OPTIMIZATION LEVELS
 * ----------------------------------------------------------------------------
 *  Level 1 - Extra array, place each element at (i+k) % n (see the commented
 *            "Easy solution" at the bottom).
 *            Time  : O(N)   Space : O(N)
 *
 *  Level 2 - Triple reverse, in place (this file, rotate1)
 *            Time  : O(N)   Space : O(1)   -> best
 * ============================================================================
 */
public class RotateArray {

	public static void main(String[] args) {

//		int array[] = { 3, 2, 9, 6, 5, 8 };
		int array[] = { 1, 2, 3 };
		int rotate = 4;

		System.out.println("Initial Array : " + Arrays.toString(array));

		if (rotate == 0) {
			System.out.println("Result Array  : " + Arrays.toString(array));
		} else {
			rotate1(array, rotate);
		}
	}

	// Level 2 - triple reverse in place. TC = O(N), SC = O(1)
	private static void rotate1(int[] array, int rotate) {
		int length = array.length - 1;

		// single element (or empty) - nothing to rotate
		if (length < 1) {
			System.out.println(Arrays.toString(array));
			return;
		}

		// rotating by more than the length just wraps around
		if (rotate > array.length) {
			rotate = rotate % array.length;
		}

		// step 1: reverse whole array
		reverseArray(array, length);
		System.out.println("Reverse Array : " + Arrays.toString(array));

		// step 2 + 3: reverse the two halves
		reverseSubArray(array, 0, rotate - 1);
		reverseSubArray(array, rotate, length);
		System.out.println("Result Array  : " + Arrays.toString(array));
	}

	private static int[] reverseArray(int[] array, int length) {
		swap(array, 0, length);
		return array;
	}

	private static int[] reverseSubArray(int[] array, int start, int end) {
		swap(array, start, end);
		return array;
	}

	// two-pointer XOR swap over window [start, end]
	private static void swap(int[] array, int start, int end) {
		while (start < end) {
			array[start] = array[start] ^ array[end];
			array[end] = array[start] ^ array[end];
			array[start] = array[start] ^ array[end];

			start++;
			end--;
		}
	}

/*
 * Level 1 - easy extra-array solution (for reference):
 *
 * class Solution {
 *     public void rotate(int[] nums, int k) {
 *         int[] ans = new int[nums.length];
 *         for (int i = 0; i < nums.length; i++) {
 *             ans[(i + k) % nums.length] = nums[i];
 *         }
 *         for (int i = 0; i < ans.length; i++) {
 *             nums[i] = ans[i];
 *         }
 *         System.out.println(Arrays.toString(ans));
 *     }
 * }
 */

}
