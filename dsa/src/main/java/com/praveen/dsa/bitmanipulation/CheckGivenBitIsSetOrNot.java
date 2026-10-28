package com.praveen.dsa.bitmanipulation;

/*
 * ============================================================================
 * QUESTION
 * ----------------------------------------------------------------------------
 * Given a number and a bit position (0-indexed from the right), check whether
 * that bit is set (1) or not (0).
 *
 * Example:  num = 20 = 10100 (binary)
 *           index:      43210
 *           bit 2 is 1  -> return true
 *
 * ============================================================================
 * EASY WAY TO THINK ABOUT IT  (line up a single 1 and AND them)
 * ----------------------------------------------------------------------------
 * Two equivalent tricks using a "mask" that has a single 1-bit:
 *   A) Shift the mask LEFT to the position you care about: (1 << bit).
 *      AND it with num. Non-zero result means that bit was set.
 *   B) Shift NUM RIGHT by `bit` so the target bit lands in position 0, then
 *      AND with 1. Result 1 means it was set.
 *
 * ============================================================================
 * OPTIMIZATION
 * ----------------------------------------------------------------------------
 *  Both approaches are O(1) time, O(1) space - a single shift and a single AND.
 * ============================================================================
 */
public class CheckGivenBitIsSetOrNot {
	public static void main(String[] args) {
		int num = 20;
		int bit = 2;

		System.out.println(checkBit1(num, bit));
	}

	// Approach A - move a 1 to position `bit` and AND. TC = O(1), SC = O(1)
	private static boolean checkBit1(int num, int bit) {
		// num = 20 = 10100, bit 2 is set -> true
		return ((1 << bit) & num) != 0;
	}

	// Approach B - move the target bit down to position 0 and AND with 1. TC = O(1), SC = O(1)
	private static boolean checkBit2(int num, int bit) {
		return ((num >> bit) & 1) == 1;
	}
}
