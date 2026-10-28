package com.praveen.dsa.matrix;

import java.util.Scanner;

/*
 * ============================================================================
 * QUESTION
 * ----------------------------------------------------------------------------
 * Read two matrices (with their dimensions) from standard input, add them
 * element by element, and print the resulting sum matrix.
 *
 * ============================================================================
 * EASY WAY TO THINK ABOUT IT
 * ----------------------------------------------------------------------------
 * Matrix addition is purely positional: result[i][j] = A[i][j] + B[i][j].
 * Just walk every cell once and add the two values at the same coordinates.
 * (This assumes both matrices share the same dimensions.)
 *
 * ============================================================================
 * OPTIMIZATION
 * ----------------------------------------------------------------------------
 *  Visit each cell once.  Time : O(R * C)   Space : O(R * C) for the result
 * ============================================================================
 */
public class AddTwoMatrices {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		// FIRST MATRIX
		int mat1_row = input.nextInt();
		int mat1_col = input.nextInt();

		int mat1[][] = new int[mat1_row][mat1_col];

		for (int i = 0; i < mat1_row; i++) {
			for (int j = 0; j < mat1_col; j++) {
				mat1[i][j] = input.nextInt();
			}
		}

		// SECOND MATRIX
		int mat2_row = input.nextInt();
		int mat2_col = input.nextInt();

		int mat2[][] = new int[mat2_row][mat2_col];

		for (int i = 0; i < mat2_row; i++) {
			for (int j = 0; j < mat2_col; j++) {
				mat2[i][j] = input.nextInt();
			}
		}

		// SUM: result[i][j] = mat1[i][j] + mat2[i][j]
		int row = mat2_row;
		int col = mat2_col;
		int mat_sum[][] = new int[row][col];

		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				mat_sum[i][j] = mat1[i][j] + mat2[i][j];
			}
		}

		// DISPLAY (space-separated, no trailing space per row)
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (j == col - 1) {
					System.out.print(mat_sum[i][j]);
				} else {
					System.out.print(mat_sum[i][j] + " ");
				}
			}
			System.out.println();
		}
	}
}
