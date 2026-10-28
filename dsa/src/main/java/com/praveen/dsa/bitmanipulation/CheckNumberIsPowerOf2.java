package com.praveen.dsa.bitmanipulation;

/*
 * ============================================================================
 * QUESTION
 * ----------------------------------------------------------------------------
 * Check whether a number is a power of two (2, 4, 8, 16, 32, ...).
 *
 * ============================================================================
 * EASY WAY TO THINK ABOUT IT
 * ----------------------------------------------------------------------------
 * In binary, a power of two has EXACTLY ONE set bit:
 *      2 = 0010, 4 = 0100, 8 = 1000, 16 = 1_0000 ...
 * So the question reduces to "does this number have exactly one 1-bit?"
 *
 * The O(1) trick: for any power of two n, (n - 1) flips that single 1 to 0 and
 * turns all lower 0s into 1s:
 *      n   = 1000
 *      n-1 = 0111
 *      n & (n-1) = 0000   -> if the AND is 0, it was a power of two.
 *
 * ============================================================================
 * OPTIMIZATION LEVELS
 * ----------------------------------------------------------------------------
 *  Level 1 - Count set bits by shifting (isPowerOfTwo1): true if exactly one.
 *            Time  : O(log N)   Space : O(1)
 *
 *  Level 2 - n & (n-1) == 0 (isPowerOfTwo2)
 *            Time  : O(1)       Space : O(1)   -> best
 *            (Caveat: 0 and negatives need a guard; 0 & -1 == 0 falsely passes.)
 * ============================================================================
 */
public class CheckNumberIsPowerOf2 {
	public static void main(String[] args) {
		int num = 64;

		System.out.println(isPowerOfTwo2(num));
	}

/*
 * value   power of 2   binary
 *   2       2^1         0000 0010
 *   4       2^2         0000 0100
 *   8       2^3         0000 1000
 *  16       2^4         0001 0000
 *  32       2^5         0010 0000
 *  64       2^6         0100 0000
 * 128       2^7         1000 0000
 *
 * A power of two always has exactly one set bit.
 */

	// Level 1 - count the set bits; power of two iff exactly one. TC = O(log N), SC = O(1)
	private static boolean isPowerOfTwo1(int num) {

		int set_bit = 0;

		while (num > 0) {
			if ((num & 1) == 1) {
				set_bit++;
			}
			if (set_bit > 1) {
				return false; // more than one set bit -> not a power of two
			}
			num = num >> 1;
		}
		return set_bit == 1;
	}

	// Level 2 - n & (n-1) clears the lowest set bit; zero means only one bit was set.
	// TC = O(1), SC = O(1)
	private static boolean isPowerOfTwo2(int num) {
		return (num & (num - 1)) == 0;
	}
}
