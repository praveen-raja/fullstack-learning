package com.praveen.dsa.bitmanipulation;

/*
 * ============================================================================
 * QUESTION
 * ----------------------------------------------------------------------------
 * Count the number of set bits (1s) in the binary representation of a number.
 * Also called the "population count" or Hamming weight.
 *
 * Example:  15 = 1111 -> 4 set bits
 *
 * ============================================================================
 * EASY WAY TO THINK ABOUT IT  (Brian Kernighan's algorithm)
 * ----------------------------------------------------------------------------
 * The trick: n & (n - 1) removes the LOWEST set bit from n.
 *
 *      n   = 1010 (10)
 *      n-1 = 1001 (9)
 *      n & (n-1) = 1000  -> the lowest 1 got cleared
 *
 * So repeatedly do n = n & (n-1) and count how many times you can before n
 * hits 0. That count IS the number of set bits. The loop runs once per set bit,
 * not once per bit, so it is faster than shifting through all 32 positions.
 *
 * ============================================================================
 * OPTIMIZATION LEVELS
 * ----------------------------------------------------------------------------
 *  Level 1 - Shift and test each bit (not here): O(total bits) = O(32).
 *  Level 2 - Brian Kernighan (this file): loops once per SET bit.
 *            Time  : O(number of set bits)   Space : O(1)   -> best
 * ============================================================================
 */
public class FindNumberOfSetBits {
	public static void main(String[] args) {
		int num = 15;

		findNumOfSet(num);
	}

/*
 * Why n & (n-1) clears the lowest set bit:
 *   10 = 0000 1010   (lowest set bit is at position 1)
 *    9 = 0000 1001   (n-1 flips that bit and everything below it)
 *   10 & 9 = 0000 1000  -> lowest set bit removed
 * This is Brian Kernighan's algorithm.
 */

	// Clear the lowest set bit each loop; count how many loops. TC = O(set bits), SC = O(1)
	private static void findNumOfSet(int num) {
		int set_bit_count = 0;

		while (num > 0) {
			set_bit_count++;
			num = num & (num - 1); // drop the lowest set bit
		}
		System.out.println(set_bit_count);
	}
}
