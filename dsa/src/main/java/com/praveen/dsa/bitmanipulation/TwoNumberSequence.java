package com.praveen.dsa.bitmanipulation;

/*
 * ============================================================================
 * QUESTION
 * ----------------------------------------------------------------------------
 * Every number in the array appears TWICE except one, which appears once.
 * Find that single unique number.
 *
 * Example:  { 22, 22, 444, 444, 6, 6, 8, 77, 77 }  -> 8
 *
 * ============================================================================
 * EASY WAY TO THINK ABOUT IT  (XOR cancels pairs)
 * ----------------------------------------------------------------------------
 * XOR-ing a number with itself gives 0 (a ^ a = 0), and XOR-ing with 0 leaves
 * the number unchanged (a ^ 0 = a). So if you XOR EVERY element together, each
 * duplicate pair cancels to 0, and only the lonely number survives.
 *
 *      22^22 ^ 444^444 ^ 6^6 ^ 8 ^ 77^77
 *    =  0    ^   0     ^  0  ^ 8 ^  0    = 8
 *
 * ============================================================================
 * OPTIMIZATION
 * ----------------------------------------------------------------------------
 *  XOR all elements.  Time : O(N)   Space : O(1)
 *  Beats a hashmap-counting approach (O(N) space) and a sort approach (O(N log N)).
 * ============================================================================
 */
public class TwoNumberSequence {

	public static void main(String[] args) {
		int array[] = { 22, 22, 444, 444, 6, 6, 8, 77, 77 };
		int ans = 0;
		for (int i : array) {
			ans = ans ^ i; // pairs cancel, the unique one remains
		}
		System.out.println(ans);
	}
}
