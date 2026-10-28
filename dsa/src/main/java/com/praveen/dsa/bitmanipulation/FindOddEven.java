package com.praveen.dsa.bitmanipulation;

/*
 * ============================================================================
 * QUESTION
 * ----------------------------------------------------------------------------
 * Decide whether a number is odd or even.
 *
 * ============================================================================
 * EASY WAY TO THINK ABOUT IT
 * ----------------------------------------------------------------------------
 * A number is even when its LAST binary bit is 0, and odd when it is 1.
 * ANDing with 1 keeps only that last bit:
 *      num  = 0101 (5)
 *      1    = 0001
 *      &    = 0001  -> last bit 1 -> odd
 * (num & 1) == 0 means even; otherwise odd.
 *
 * The bitwise test is preferred over `% 2` because a single AND is cheaper for
 * the CPU than a division/modulo (and it is correct for negatives too, which
 * `% 2` can return -1 for).
 *
 * ============================================================================
 * OPTIMIZATION LEVELS
 * ----------------------------------------------------------------------------
 *  Level 1 - modulo: num % 2 == 0 (isEven1)      O(1) time, O(1) space
 *  Level 2 - bitwise: (num & 1) == 0 (isEven2)   O(1) time, O(1) space; cheaper op
 * ============================================================================
 */
public class FindOddEven {
	public static void main(String[] args) {

		int num = 24;

		System.out.println(isEven2(num));
	}

	// Level 1 - modulo. TC = O(1), SC = O(1)
	private static String isEven1(int num) {
		if (num % 2 == 0) {
			return "Even number";
		} else {
			return "Odd number";
		}
	}

	// Level 2 - bitwise AND with 1 (checks the last bit). TC = O(1), SC = O(1)
	private static String isEven2(int num) {
		// last bit 0 -> even, last bit 1 -> odd
		if ((num & 1) == 0) {
			return "Even number";
		} else {
			return "Odd number";
		}
	}
}
