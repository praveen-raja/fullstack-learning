package com.praveen.dsa.arrays.problems;

import java.util.Arrays;
import java.util.Scanner;

/*
 * ============================================================================
 * QUESTION
 * ----------------------------------------------------------------------------
 * Read N and then N integers from standard input, and print the SECOND largest
 * value.
 *
 * ============================================================================
 * EASY WAY TO THINK ABOUT IT
 * ----------------------------------------------------------------------------
 * Easiest approach: sort the array ascending, then the second largest sits at
 * index (N - 2) (the largest is at N - 1). Simple, but sorting is the costly
 * part.
 *
 * (Faster idea, not used here: one pass tracking `largest` and `secondLargest`
 *  - whenever you find a new largest, the old largest becomes second. That is
 *  O(N) with no sort. This file uses the sort version for brevity.)
 *
 * ============================================================================
 * OPTIMIZATION LEVELS
 * ----------------------------------------------------------------------------
 *  Level 1 - Sort then index N-2 (this file)
 *            Time  : O(N log N)   Space : O(1) extra (in-place sort)
 *
 *  Level 2 - Single pass tracking top two (NOT implemented)
 *            Time  : O(N)         Space : O(1)
 *
 * NOTE: assumes N >= 2 and no handling for duplicate maxima.
 * ============================================================================
 */
public class SecondLargestInArray {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		int size = input.nextInt();
		int arr[] = new int[size];

		for (int i = 0; i < size; i++) {
			arr[i] = input.nextInt();
		}

		Arrays.sort(arr);                 // ascending sort, O(N log N)
		System.out.println(arr[size - 2]); // second largest = one before the last
	}
}
