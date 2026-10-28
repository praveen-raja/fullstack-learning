package com.praveen.dsa.arrays;

import java.util.Arrays;

/*
 * ============================================================================
 * QUESTION  (asked at DirectI)
 * ----------------------------------------------------------------------------
 * Same as EquilibriumIndex, but solve it in a single pass.
 * Return TRUE if an index i exists where leftSum == rightSum.
 *
 * Example:
 *      array = { 1, 2, 3, 4, 8, 10 }
 *      At index 4: left = 1+2+3+4 = 10, right = 10  ->  equilibrium exists
 *
 * ============================================================================
 * EASY WAY TO THINK ABOUT IT
 * ----------------------------------------------------------------------------
 * The whole array has one fixed total. Walk left to right keeping a running
 * leftSum. At index i, the right side must be:
 *      rightSum = total - leftSum - array[i]
 * so you never re-add the right side. One pass instead of nested loops.
 *
 * A prefix-sum array (built by sumArray() below) is the stepping stone to this
 * idea: prefix[i] already holds the sum of everything up to i.
 *
 * ============================================================================
 * OPTIMIZATION LEVELS
 * ----------------------------------------------------------------------------
 *  Level 1 - Brute force  -> see EquilibriumIndex (O(N^2), O(1))
 *
 *  Level 2 - Prefix-sum / running-sum single pass
 *            Time  : O(N)
 *            Space : O(1)   (or O(N) if you materialize the prefix array)
 *
 * ----------------------------------------------------------------------------
 * STATUS: INCOMPLETE.
 *   - isEquilibrium1() is commented out / not finished.
 *   - Only the prefix-sum helper sumArray() is implemented so far.
 *   Left as-is intentionally (work in progress).
 * ============================================================================
 */
public class EquilibriumIndexOptimized {

	public static void main(String[] args) {

		int[] array = { -7, 1, 5, 2, -4, 3, 0 };
		System.out.println("Initial Array : " + Arrays.toString(array));
//		System.out.println(isEquilibrium1(array));
	}

	// TODO (INCOMPLETE): Level 2 single-pass solution not yet written.
	// Intended approach: keep a running leftSum; rightSum = total - leftSum - array[i].
//	private static boolean isEquilibrium1(int[] array) {
//
//		int length = array.length;
//
//		for (int i = 0; i < array.length; i++) {
//			int leftSum = 0;
//			int rightSum = 0;
//
//
//		}
//
//	}
//
	// Helper: builds a prefix-sum array. prefix[i] = array[0] + ... + array[i].
	// TC = O(N), SC = O(N)
	private static int[] sumArray(int[] array) {

		int ans = 0;
		int length = array.length;
		int tempArr[] = new int[length];

		tempArr[0] = array[0];

		for (int i = 1; i < length; i++) {
			tempArr[i] = array[i] + tempArr[i - 1];
		}
		System.out.println(Arrays.toString(tempArr));
		return tempArr;
	}
}
