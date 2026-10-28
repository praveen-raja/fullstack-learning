package com.praveen.dsa.math;

/*
 * ============================================================================
 * QUESTION
 * ----------------------------------------------------------------------------
 * Find the absolute difference between two numbers (the distance between them
 * on the number line, always non-negative).
 *
 * Example:  a = 8, b = 15  ->  |8 - 15| = 7
 *
 * ============================================================================
 * EASY WAY TO THINK ABOUT IT
 * ----------------------------------------------------------------------------
 * Subtract one from the other, then drop the sign. Math.abs does the sign-drop.
 * (Manually: if (a - b) < 0, negate it.)
 *
 * ============================================================================
 * OPTIMIZATION
 * ----------------------------------------------------------------------------
 *  One subtraction + abs.  Time : O(1)   Space : O(1)
 * ============================================================================
 */
public class FindAbsoluteDifferenceBetweenTwoNumbers {
	public static void main(String[] args) {

		int a = 8;
		int b = 15;
		int absDiff = Math.abs(a - b); // |a - b|

		System.out.println(absDiff);
	}
}
