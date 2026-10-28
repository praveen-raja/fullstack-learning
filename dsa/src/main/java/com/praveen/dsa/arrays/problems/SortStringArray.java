package com.praveen.dsa.arrays.problems;

import java.util.Arrays;
import java.util.Scanner;

/*
 * ============================================================================
 * QUESTION
 * ----------------------------------------------------------------------------
 * Read N strings from standard input, sort them, and print them in order.
 *
 * ============================================================================
 * EASY WAY TO THINK ABOUT IT
 * ----------------------------------------------------------------------------
 * Strings compare lexicographically (dictionary order) by default, so
 * Arrays.sort on a String[] already does exactly what we want - just read them
 * into an array, sort, and print.
 *
 * ============================================================================
 * OPTIMIZATION
 * ----------------------------------------------------------------------------
 *  Arrays.sort (dual-pivot / TimSort under the hood).
 *            Time  : O(N log N) comparisons, each comparison up to O(L) for
 *                    string length L
 *            Space : O(1) extra for primitives, but String[] uses TimSort = O(N)
 * ============================================================================
 */
public class SortStringArray {
	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		int num = input.nextInt();
		String name[] = new String[num];

		for (int i = 0; i < num; i++) {
			name[i] = input.next();
		}

		Arrays.sort(name); // lexicographic sort

		for (int i = 0; i < num; i++) {
			System.out.println(name[i]);
		}
	}
}
