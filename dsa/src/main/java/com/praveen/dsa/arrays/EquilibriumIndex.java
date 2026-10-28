package com.praveen.dsa.arrays;

import java.util.Arrays;

/*
 * ============================================================================
 * QUESTION  (asked at DirectI)
 * ----------------------------------------------------------------------------
 * Given an array, return TRUE if an "equilibrium index" exists.
 *
 * An equilibrium index i is an index where:
 *      sum of all elements to the LEFT of i  ==  sum of all elements to the RIGHT of i
 *
 * Example:
 *      array = { 1, 2, 3, 4, 8, 10 }
 *      index =   0  1  2  3  4   5
 *
 *      At index 4:  left  = 1+2+3+4 = 10
 *                   right = 10
 *      left == right  ->  equilibrium exists  ->  return true
 *
 * ============================================================================
 * EASY WAY TO THINK ABOUT IT
 * ----------------------------------------------------------------------------
 * Stand on each index one at a time. Look left, add everything up. Look right,
 * add everything up. If the two sides weigh the same, you found a balance point.
 * That is the "brute force" idea below.
 *
 * (The smarter idea: the whole array has a fixed total. If you keep a running
 *  leftSum as you walk, then rightSum = total - leftSum - array[i], so you can
 *  answer each index in O(1) and never re-add the right side. That turns the
 *  O(N^2) below into O(N).)
 *
 * ============================================================================
 * OPTIMIZATION LEVELS
 * ----------------------------------------------------------------------------
 *  Level 1 - Brute force (implemented below: isEquilibrium1)
 *            Time  : O(N^2)   -> for every index, re-sum left and right
 *            Space : O(1)
 *
 *  Level 2 - Prefix-sum / running-sum (NOT implemented here)
 *            Time  : O(N)     -> one pass, rightSum = total - leftSum - a[i]
 *            Space : O(1)
 * ============================================================================
 */
public class EquilibriumIndex {

	public static void main(String[] args) {

		int[] array = { -7, 1, 5, 2, -4, 3, 0 };
		System.out.println("Initial Array : " + Arrays.toString(array));
		System.out.println(isEquilibrium1(array));
	}

	// Level 1 - Brute force. TC = O(N^2), SC = O(1)
	private static boolean isEquilibrium1(int[] array) {

		int length = array.length;

		for (int i = 0; i < length; i++) {
			int leftSum = 0;
			int rightSum = 0;

			// sum everything to the LEFT of i
			for (int j = 0; j < i; j++) {
				leftSum = leftSum + array[j];
			}

			// sum everything to the RIGHT of i
			for (int j = i + 1; j < length; j++) {
				rightSum = rightSum + array[j];
			}

			// balance point found
			if (leftSum == rightSum) {
				// System.out.println(array[i]); // -> the equilibrium index value
				return true;
			}
		}
		return false;
	}
}
