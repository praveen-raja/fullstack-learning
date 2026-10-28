package com.praveen.dsa.arrays;

/*
 * ============================================================================
 * QUESTION
 * ----------------------------------------------------------------------------
 * Print a 2D array COLUMN by column instead of row by row.
 *
 * Example:  { { 1, 2, 3, 4 },
 *             { 5, 6, 7, 8 } }
 *
 *   Row-wise  prints: 1 2 3 4 / 5 6 7 8
 *   Col-wise  prints: 1 5 / 2 6 / 3 7 / 4 8
 *
 * ============================================================================
 * EASY WAY TO THINK ABOUT IT
 * ----------------------------------------------------------------------------
 * Flip which loop is on the outside. The OUTER loop now walks columns (i), and
 * the INNER loop walks down the rows (j). The access is arr[j][i] - row index
 * second-level, column index first-level - because we fixed the column and move
 * the row.
 *
 * ============================================================================
 * OPTIMIZATION
 * ----------------------------------------------------------------------------
 *  Nested traversal. Time : O(R * C)   Space : O(1)
 * ============================================================================
 */
public class Print2DArrayColumnWise {

	public static void main(String[] args) {

		int arr[][] = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 } };

		print2DArrayInColumnWise(arr);
	}

	// Outer loop = columns, inner loop = rows. TC = O(R*C), SC = O(1)
	private static void print2DArrayInColumnWise(int[][] arr) {

		// arr[0].length = number of columns; arr.length = number of rows
		for (int i = 0; i < arr[0].length; i++) {
			for (int j = 0; j < arr.length; j++) {
				System.out.print(arr[j][i] + "\t");
			}
			System.out.println();
		}
	}
}
