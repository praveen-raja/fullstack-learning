package com.praveen.dsa.arrays.problems;

/*
 * ============================================================================
 * QUESTION
 * ----------------------------------------------------------------------------
 * Given an integer N, print an N x N grid where each row counts down from the
 * right, forming a lower-triangular staircase.
 *
 * For N = 4:
 *      0  0  0  1
 *      0  0  2  1
 *      0  3  2  1
 *      4  3  2  1
 *
 * ============================================================================
 * EASY WAY TO THINK ABOUT IT
 * ----------------------------------------------------------------------------
 * Row i (0-based) fills (i+1) cells, starting from the RIGHTMOST column and
 * walking left, writing 1, 2, 3, ... as it goes. Cells not written stay 0.
 * So row 0 writes just "1" in the last column; row 3 writes "1 2 3 4" filling
 * the whole row from the right.
 *
 * ============================================================================
 * OPTIMIZATION
 * ----------------------------------------------------------------------------
 *  Fill the triangle, then print the grid.
 *            Time  : O(N^2)   Space : O(N^2) for the matrix
 * ============================================================================
 */
public class StaircaseNumberPattern {
	public static void main(String[] args) {
		int N = 4;

		pattern1(N);
	}

	// Fill each row from the right with 1..(i+1), then print. TC = O(N^2), SC = O(N^2)
	private static void pattern1(int num) {

		int[][] matrix = new int[num][num]; // starts all zeros

		int j = 0;
		for (int i = 0; i < num; i++) {
			j = num - 1;                 // rightmost column
			for (int k = 1; k <= i + 1; k++) {
				matrix[i][j] = k;        // write 1, 2, 3, ... walking left
				j--;
			}
		}

		for (int i = 0; i < num; i++) {
			for (int z = 0; z < num; z++) {
				System.out.print(matrix[i][z] + "\t");
			}
			System.out.println();
		}
	}
}
