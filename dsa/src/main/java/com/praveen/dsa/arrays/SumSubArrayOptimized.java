package com.praveen.dsa.arrays;

import java.util.Arrays;
import java.util.Scanner;

/*
 * ============================================================================
 * QUESTION  (asked at Amazon)
 * ----------------------------------------------------------------------------
 * Answer MANY "sum of range [X, Y]" queries on a fixed array efficiently.
 * Re-adding the window for every query is too slow when queries are frequent.
 *
 * ============================================================================
 * EASY WAY TO THINK ABOUT IT
 * ----------------------------------------------------------------------------
 * Build a "running total" array (prefix sum). prefix[i] = sum of array[0..i].
 *
 *   array  = {  1,  2,  3,  4,  5,  6 }
 *   prefix = {  1,  3,  6, 10, 15, 21 }
 *
 * Then the sum of any range [X, Y] is just:
 *      prefix[Y] - prefix[X-1]      (and if X == 0, just prefix[Y])
 *
 * You paid O(N) once to build prefix; after that every range answer is one
 * subtraction = O(1).
 *
 * ============================================================================
 * OPTIMIZATION LEVELS
 * ----------------------------------------------------------------------------
 *  Level 1 - Loop and add per query (see SumSubArray)
 *            Time  : O(N) per query
 *            Space : O(1)
 *
 *  Level 2 - Prefix sum (this file: sumSubArray2 builds it, calculate queries it)
 *            Time  : O(N) to build, then O(1) per query
 *            Space : O(N) for the prefix array
 * ============================================================================
 *
 * NOTE: main() reads 3 query pairs (X and Y) from standard input via Scanner.
 */
public class SumSubArrayOptimized {
	public static void main(String[] args) {
		int array[] = { 1, 2, 3, 4, 5, 6 };
		int start = 0;
		int end = 3;

		System.out.println(Arrays.toString(array));
		calculate(array);
	}

	// Reads query pairs and answers each in O(1) using the prefix array.
	private static void calculate(int[] array) {
		int[] arrays = sumSubArray2(array); // prefix array
		int ans;

		Scanner input = new Scanner(System.in);

		for (int i = 0; i < 3; i++) {

			int[] inputs = new int[2];

			System.out.println("Please enter your inputs : X and Y");
			inputs[0] = input.nextInt();
			inputs[1] = input.nextInt();

			if (inputs[0] <= 0) {
				// range starts at 0 -> answer is just prefix[Y]
				ans = arrays[inputs[1]];
			} else {
				// range [X, Y] -> prefix[Y] - prefix[X-1]
				ans = arrays[inputs[1]] - arrays[inputs[0] - 1];
			}
			System.out.println(ans);

		}
	}

	// Build prefix-sum array. prefix[i] = array[0] + ... + array[i]. TC = O(N), SC = O(N)
	private static int[] sumSubArray2(int[] array) {

		int ans = 0;
		int length = array.length;
		int tempArr[] = new int[length];

		tempArr[0] = array[0];

		for (int i = 1; i < length; i++) {
			tempArr[i] = array[i] + tempArr[i - 1];
		}
		System.out.println(Arrays.toString(tempArr));
		return tempArr;
	}
}
