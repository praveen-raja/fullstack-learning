package com.praveen.dsa.arrays;

/*
 * ============================================================================
 * QUESTION
 * ----------------------------------------------------------------------------
 * Transpose a square matrix in place. Transpose = flip across the main
 * diagonal, so rows become columns.
 *
 *   Before:        After transpose:
 *     1 2 3            1 4 7
 *     4 5 6     ->     2 5 8
 *     7 8 9            3 6 9
 *
 * ============================================================================
 * EASY WAY TO THINK ABOUT IT
 * ----------------------------------------------------------------------------
 * For every cell above the diagonal, swap arr[i][j] with its mirror arr[j][i].
 * The trick is to only swap the UPPER triangle (where i < j). If you swap the
 * lower triangle too you undo your own work and get the original matrix back.
 *
 * ============================================================================
 * OPTIMIZATION LEVELS
 * ----------------------------------------------------------------------------
 *  Level 1 - transpose1: inner loop starts at j = i+1 (upper triangle only)
 *  Level 2 - transpose2: inner loop from 0 but guarded by "if (i < j)"
 *            Both are the same algorithm.
 *            Time  : O(N^2)   -> must visit each cell
 *            Space : O(1)     -> in place, swaps use XOR (no temp)
 * ============================================================================
 */
public class ArrayTranspose {
	public static void main(String[] args) {

		int arr[][] = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };

		System.out.println("Initial array :");
		print(arr);

		transpose2(arr);
	}

	// Level 1 - swap only the upper triangle (j starts at i+1). TC = O(N^2), SC = O(1)
	private static void transpose1(int[][] arr) {

		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr[i].length; j++) {
				swap(arr, i, j);
			}
		}

		System.out.println("After Transpose:");
		print(arr);
	}

	// Level 2 - full loop but only swap when i < j. TC = O(N^2), SC = O(1)
	private static void transpose2(int[][] arr) {

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				if (i < j) {
					swap(arr, i, j);
				}
			}
		}

		System.out.println("After Transpose:");
		print(arr);
	}

	// XOR swap of arr[i][j] and arr[j][i] (no temp variable)
	private static void swap(int[][] arr, int i, int j) {
		arr[i][j] = arr[i][j] ^ arr[j][i];
		arr[j][i] = arr[i][j] ^ arr[j][i];
		arr[i][j] = arr[i][j] ^ arr[j][i];
	}

	private static void print(int[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j] + "\t");
			}
			System.out.println();
		}
	}
}
