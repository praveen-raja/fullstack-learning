package com.praveen.dsa.bitmanipulation;

/*
 * ============================================================================
 * QUESTION
 * ----------------------------------------------------------------------------
 * Swap two numbers WITHOUT using a temporary variable, using XOR.
 *
 * ============================================================================
 * EASY WAY TO THINK ABOUT IT  (why the XOR dance works)
 * ----------------------------------------------------------------------------
 * XOR has two handy properties: a ^ a = 0, and a ^ 0 = a. Apply three XORs:
 *
 *      a = a ^ b          // a now holds the "mix" of both
 *      b = a ^ b          // = (a^b)^b = a   -> b becomes original a
 *      a = a ^ b          // = (a^b)^a = b   -> a becomes original b
 *
 * No temp variable needed. (A plain temp swap is clearer and just as fast; this
 * is the classic interview trick.)
 *
 * ============================================================================
 * OPTIMIZATION
 * ----------------------------------------------------------------------------
 *  Three XOR operations.  Time : O(1)   Space : O(1)
 *
 * NOTE: the swap happens on local parameter copies, so it only prints the
 * swapped values; it does not affect num1/num2 in main (Java is pass-by-value).
 * ============================================================================
 */
public class SwapTwoNumbersUsingBitwise {

	public static void main(String[] args) {
		int num1 = 20;
		int num2 = 40;

		swap(num1, num2);
	}

	// XOR swap (no temp variable). TC = O(1), SC = O(1)
	private static void swap(int num1, int num2) {

		num1 = num1 ^ num2;
		num2 = num1 ^ num2; // becomes original num1
		num1 = num1 ^ num2; // becomes original num2

		System.out.println(num1 + " " + num2);
	}
}
