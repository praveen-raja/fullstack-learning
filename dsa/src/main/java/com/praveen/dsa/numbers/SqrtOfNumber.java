package com.praveen.dsa.numbers;

/*
 * ============================================================================
 * QUESTION
 * ----------------------------------------------------------------------------
 * Find the (integer) square root of a number without using a library call -
 * ideally via binary search on the answer.
 *
 * Example:  400 -> 20
 *
 * ============================================================================
 * EASY WAY TO THINK ABOUT IT  (binary search on the answer)
 * ----------------------------------------------------------------------------
 * The square root of N lies between 0 and N. Binary-search that range: pick the
 * middle `mid`, compare mid*mid with N:
 *   - mid*mid == N -> exact root, return mid
 *   - mid*mid <  N -> root is bigger, move low up (low = mid + 1)
 *   - mid*mid >  N -> root is smaller, move high down (high = mid - 1)
 * Each step halves the range -> O(log N). (Use long for mid*mid to avoid
 * overflow on large N.)
 *
 * ============================================================================
 * OPTIMIZATION LEVELS
 * ----------------------------------------------------------------------------
 *  Level 1 - linear scan i=1.. until i*i > N.    O(sqrt N)
 *  Level 2 - binary search on the answer.        O(log N)   -> best
 *  Space : O(1)
 *
 * ----------------------------------------------------------------------------
 * STATUS: INCOMPLETE / BUGGY. sqrt() mixes a for-loop with binary-search style
 * updates to `start`/`end`/`mid`: `mid` is computed once and never updated
 * inside the loop, the branch conditions overlap, and it never returns a value.
 * Left as-is intentionally (WIP) - the header describes the correct approach.
 * ============================================================================
 */
public class SqrtOfNumber {
	public static void main(String[] args) {

		int num = 400;

		Math.sqrt(num); // reference call (result unused)
		sqrt(num);
		System.out.println();
	}

	// INCOMPLETE / BUGGY - see header. Not a working binary search yet.
	private static void sqrt(int num) {

		int end = num;
		int mid = num / 2;

		for (int start = 0; start <= mid; start++) {

			if (mid * mid >= num) {
				end = mid - 1;
			} else if (mid * mid <= num) {
				start = mid + 1;
			} else {
				if (mid * mid == num) {
					// return mid;
					System.out.println(mid);
				}
			}
		}
	}
}
