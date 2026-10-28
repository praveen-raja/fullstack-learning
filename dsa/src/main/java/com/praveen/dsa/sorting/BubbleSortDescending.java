package com.praveen.dsa.sorting;

import java.util.Arrays;

/*
 * ============================================================================
 * QUESTION
 * ----------------------------------------------------------------------------
 * Sort an array in DESCENDING order using a simple bubble/selection style of
 * repeated adjacent swaps.
 *
 * Example:  { 9, 5, 2, 6, 3, 1, 3 }  ->  { 9, 6, 5, 3, 3, 2, 1 }
 *
 * ============================================================================
 * EASY WAY TO THINK ABOUT IT  (bubble the biggest forward)
 * ----------------------------------------------------------------------------
 * Compare each adjacent pair; if the left one is SMALLER, swap so the bigger
 * value moves toward the front. After each outer pass, one more element is in
 * its correct (descending) place. Repeat for every position.
 *
 * ============================================================================
 * OPTIMIZATION
 * ----------------------------------------------------------------------------
 *  Bubble sort.  Time : O(N^2)   Space : O(1)
 *  (Fine for learning / tiny arrays; real code would use Arrays.sort = O(N log N).)
 *
 * NOTE: main() has the sort() call commented out, so running it prints nothing.
 * The sort() method itself is complete. Left as-is.
 * ============================================================================
 */
public class BubbleSortDescending {
	public static void main(String[] args) {

		int[] arr = { 9, 5, 2, 6, 3, 1, 3 };

//		sort(arr);
	}

	// Bubble sort, descending (swap when left < right). TC = O(N^2), SC = O(1)
	private static void sort(int[] arr) {

		for (int x = 0; x < arr.length; x++) {

			for (int i = x; i < arr.length; i++) {
				if (i < arr.length - 1) {
					if (arr[i] < arr[i + 1]) {
						int temp = arr[i];
						arr[i] = arr[i + 1];
						arr[i + 1] = temp;
					}
				}
			}
		}

		System.out.println(Arrays.toString(arr));
	}
}
