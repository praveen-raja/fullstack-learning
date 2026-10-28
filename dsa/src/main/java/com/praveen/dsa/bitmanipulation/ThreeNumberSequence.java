package com.praveen.dsa.bitmanipulation;

/*
 * ============================================================================
 * QUESTION
 * ----------------------------------------------------------------------------
 * Every number in the array appears THREE times except one, which appears once.
 * Find that single unique number.
 *
 * Example:  { 22,22,22, 444,444,444, 6,6,6, 8, 77,77,77 }  -> 8
 *
 * ============================================================================
 * EASY WAY TO THINK ABOUT IT  (count each bit position mod 3)
 * ----------------------------------------------------------------------------
 * The XOR trick from TwoNumberSequence cancels PAIRS, so it doesn't work when
 * numbers repeat three times. Instead, look at each of the 32 bit positions
 * independently:
 *
 *   For bit position i, add up how many numbers have that bit set. Every number
 *   that appears 3 times contributes 0 or 3 to that count. So count % 3 removes
 *   all the triples - whatever is left (1 if the unique number has that bit)
 *   belongs to the unique number. Rebuild the answer bit by bit.
 *
 * ============================================================================
 * OPTIMIZATION
 * ----------------------------------------------------------------------------
 *  Bit-counting over 32 positions.
 *            Time  : O(32 * N) = O(N)
 *            Space : O(1)
 * ============================================================================
 */
public class ThreeNumberSequence {

	public static void main(String[] args) {
		int array[] = { 22, 22, 22, 444, 444, 444, 6, 6, 6, 8, 77, 77, 77 };

		System.out.println("Approach 1 (Bit Counting - O(32n)): " + approach1(array));
	}

	// For each bit position, (count of set bits) % 3 reveals the unique number's bit.
	// TC = O(32*N) = O(N), SC = O(1)
	public static int approach1(int[] array) {
		int ans = 0;
		for (int i = 0; i < 32; i++) {
			int setBit = 0; // how many numbers have bit i set
			for (int j = 0; j < array.length; j++) {
				if ((array[j] & (1 << i)) != 0) {
					setBit++;
				}
			}
			if (setBit % 3 != 0) {   // triples cancel; leftover belongs to the unique number
				ans = ans | (1 << i);
			}
		}
		return ans;
	}
}
