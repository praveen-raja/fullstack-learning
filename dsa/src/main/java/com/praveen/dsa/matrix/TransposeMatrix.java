package com.praveen.dsa.matrix;

import java.util.Scanner;

/*
 * ============================================================================
 * QUESTION
 * ----------------------------------------------------------------------------
 * Read a matrix (with its dimensions) from standard input and print its
 * transpose. Transpose turns rows into columns: element [i][j] moves to [j][i].
 *
 *   Input:        Transpose:
 *     1 2 3          1 4
 *     4 5 6          2 5
 *                    3 6
 *
 * ============================================================================
 * EASY WAY TO THINK ABOUT IT
 * ----------------------------------------------------------------------------
 * To PRINT the transpose you don't even need a second matrix - just change the
 * loop order. The outer loop walks the original COLUMNS, the inner loop walks
 * the original ROWS, and you print mat1[row][col] = mat1[j][i]. That reads the
 * matrix column-by-column, which is exactly the transpose row-by-row.
 *
 * (This works for any R x C matrix, not just square ones.)
 *
 * ============================================================================
 * OPTIMIZATION
 * ----------------------------------------------------------------------------
 *  Visit each cell once.  Time : O(R * C)   Space : O(1) extra (prints directly)
 * ============================================================================
 */
public class TransposeMatrix {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		int mat1_row = input.nextInt();
		int mat1_col = input.nextInt();

		int mat1[][] = new int[mat1_row][mat1_col];

		for (int i = 0; i < mat1_row; i++) {
			for (int j = 0; j < mat1_col; j++) {
				mat1[i][j] = input.nextInt();
			}
		}

		// Print column-by-column => that is the transpose printed row-by-row.
		for (int i = 0; i < mat1_col; i++) {
			for (int j = 0; j < mat1_row; j++) {
				if (j == mat1_row - 1) {
					System.out.print(mat1[j][i]);
				} else {
					System.out.print(mat1[j][i] + " ");
				}
			}
			System.out.println();
		}
	}
}
