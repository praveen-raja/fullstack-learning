package com.praveen.dsa.arrays.problems;

/*
 * ============================================================================
 * QUESTION
 * ----------------------------------------------------------------------------
 * In one pass over an array, find:
 *   - the MINIMUM odd number
 *   - the MAXIMUM even number
 *
 * ============================================================================
 * EASY WAY TO THINK ABOUT IT
 * ----------------------------------------------------------------------------
 * Keep two running answers. For each element:
 *   - is it odd?  compare against the smallest odd seen so far, keep smaller.
 *   - is it even? compare against the biggest even seen so far, keep bigger.
 *
 * Odd/even test uses a bit trick: (x & 1) == 1 means the last bit is set, i.e.
 * the number is odd. Seed `odd` with Integer.MAX_VALUE so the first odd always
 * wins the "smaller" comparison.
 *
 * NOTE: `even` is seeded with 0, which is fine for arrays containing a positive
 * even number, but for an all-negative-even array the true max would be below 0
 * and this seed would report 0 incorrectly. (Left as-is - noting the edge case.)
 *
 * ============================================================================
 * OPTIMIZATION
 * ----------------------------------------------------------------------------
 *  Single pass.  Time : O(N)   Space : O(1)
 * ============================================================================
 */
public class MinOddAndMaxEvenInArray {
	public static void main(String[] args) {
		int[] arr = { -98, 54, -52, 15, 23, -97, 12, -64, 52, 85 };

		find(arr);
	}

	// One pass tracking min-odd and max-even. TC = O(N), SC = O(1)
	private static void find(int[] arr) {

		int odd = Integer.MAX_VALUE; // smallest odd so far
		int even = 0;                // biggest even so far (see edge-case note)

		for (int i = 0; i < arr.length; i++) {

			if ((arr[i] & 1) == 1) {       // odd
				if (arr[i] < odd) {
					odd = arr[i];
				}
			} else {                       // even
				if (arr[i] > even) {
					even = arr[i];
				}
			}
		}

		System.out.println("Even : " + even + "\nOdd : " + odd);
	}
}
