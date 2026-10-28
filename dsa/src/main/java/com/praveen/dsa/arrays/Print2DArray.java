package com.praveen.dsa.arrays;

/*
 * ============================================================================
 * QUESTION
 * ----------------------------------------------------------------------------
 * Print a 2D array (matrix) row by row.
 *
 * ============================================================================
 * EASY WAY TO THINK ABOUT IT
 * ----------------------------------------------------------------------------
 * Outer loop walks the rows (i). Inner loop walks the columns of that row (j).
 * Print each value with a tab, then a newline at the end of every row.
 *
 * NOTE: this sample array is "jagged" - the first row has 5 columns while the
 * other two have 4. Using arr[i].length (the length of THIS row) in the inner
 * loop is what makes jagged arrays safe; a hard-coded width would crash.
 *
 * ============================================================================
 * OPTIMIZATION
 * ----------------------------------------------------------------------------
 *  Nested traversal. Time : O(R * C)   Space : O(1)
 *  You must touch every cell to print it, so this is optimal.
 * ============================================================================
 */
public class Print2DArray {

	public static void main(String[] args) {

		int arr[][] = {
				{ 0, 0, 0, 0, 1 },
				{ 0, 0, 0, 0 },
				{ 0, 0, 0, 0 } };

		print2DArray(arr);
	}

	// Walk rows (i), then columns of each row (j). TC = O(R*C), SC = O(1)
	private static void print2DArray(int[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j] + "\t");
			}
			System.out.println();
		}
	}
}
