package com.praveen.dsa.arrays;

import java.util.Arrays;

/*
 * ============================================================================
 * QUESTION
 * ----------------------------------------------------------------------------
 * Reverse an array in place (or produce a reversed copy).
 *
 * Example:  { 1, 2, 3, 4 }  ->  { 4, 3, 2, 1 }
 *
 * ============================================================================
 * EASY WAY TO THINK ABOUT IT
 * ----------------------------------------------------------------------------
 * Put one finger on the first element and one on the last. Swap what they point
 * at, then move both fingers toward the middle. Stop when they meet. Everything
 * is now mirrored.
 *
 * The swaps here use the XOR trick (a^=b; b^=a; a^=b) to swap without a temp
 * variable. A plain temp swap is easier to read and does the same thing.
 *
 * ============================================================================
 * OPTIMIZATION LEVELS
 * ----------------------------------------------------------------------------
 *  Level 1 - Copy backwards into a new array (rev1)
 *            Time  : O(N)
 *            Space : O(N)   -> needs a second array
 *
 *  Level 2 - In-place two-pointer swap (rev2 counts to length/2, rev3 uses
 *            start/end pointers). Same algorithm, two styles.
 *            Time  : O(N)
 *            Space : O(1)   -> best; nothing extra allocated
 * ============================================================================
 */
public class ReverseArray {
	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4 };

		rev3(arr);
	}

	// Level 1 - reversed copy. TC = O(N), SC = O(N)
	private static void rev1(int[] arr) {

		int revArray[] = new int[arr.length];
		int count = 0;
		for (int i = arr.length - 1; i >= 0; i--) {
			revArray[count++] = arr[i];
		}

		System.out.println(Arrays.toString(revArray));
	}

	// Level 2 - in place, loop to the middle. TC = O(N), SC = O(1)
	private static void rev2(int[] arr) {

		int length = arr.length;
		int h = length - 1;

		for (int i = 0; i < (length >> 1); i++, h--) {
			// XOR swap of arr[i] and arr[h] (no temp variable)
			arr[i] = arr[i] ^ arr[h];
			arr[h] = arr[i] ^ arr[h];
			arr[i] = arr[i] ^ arr[h];
		}

		System.out.println(Arrays.toString(arr));
	}

	// Level 2 - in place, two pointers. TC = O(N), SC = O(1)
	private static void rev3(int[] arr) {

		int start = 0;
		int end = arr.length - 1;

		while (start < end) {

			// XOR swap of arr[start] and arr[end]
			arr[start] = arr[start] ^ arr[end];
			arr[end] = arr[start] ^ arr[end];
			arr[start] = arr[start] ^ arr[end];

			start++;
			end--;
		}

		System.out.println(Arrays.toString(arr));
	}
}
