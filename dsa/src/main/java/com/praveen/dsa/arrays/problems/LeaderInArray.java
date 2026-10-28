package com.praveen.dsa.arrays.problems;

/*
 * ============================================================================
 * QUESTION
 * ----------------------------------------------------------------------------
 * Count the number of "leaders" in an array. An element is a leader if it is
 * strictly greater than EVERY element to its right. (The rightmost element is
 * always a leader - nothing is to its right.)
 *
 * Example:
 *      array    = { 15, -1, 7, 2, 5, 4, 2, 3 }
 *      leaders  = { 15, 7, 5, 4, 3 }
 *      count    = 5
 *
 * ============================================================================
 * EASY WAY TO THINK ABOUT IT  (walk from the right)
 * ----------------------------------------------------------------------------
 * Scan RIGHT to LEFT keeping the biggest value seen so far ("max from the
 * right"). An element is a leader exactly when it beats that running max.
 * Walking from the right means you already know everything on the right, so
 * one pass is enough - no need to re-scan the right side for each element.
 *
 * ============================================================================
 * OPTIMIZATION LEVELS
 * ----------------------------------------------------------------------------
 *  Level 1 - Brute force: for each element, scan everything to its right.
 *            Time  : O(N^2)   Space : O(1)
 *
 *  Level 2 - Right-to-left single pass (this file: countLeader)
 *            Time  : O(N)     Space : O(1)   -> best
 * ============================================================================
 */
public class LeaderInArray {

	public static void main(String[] args) {

		int[] arr = { 15, -1, 7, 2, 5, 4, 2, 3 };

		System.out.println(countLeader(arr));
	}

	// Level 2 - right-to-left, track running max. TC = O(N), SC = O(1)
	private static int countLeader(int[] arr) {

		if ((arr != null) && (arr.length != 0)) {

			int ans = 1;                      // last element is always a leader
			int max = arr[arr.length - 1];    // running max from the right

			for (int i = arr.length - 2; i >= 0; i--) {
				if (arr[i] > max) {           // beats everything to its right
					ans++;
					max = arr[i];
				}
			}
			return ans;
		} else {
			return 0;
		}
	}

}
