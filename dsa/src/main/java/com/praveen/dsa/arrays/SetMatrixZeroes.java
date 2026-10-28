package com.praveen.dsa.arrays;

/*
 * ============================================================================
 * QUESTION  (classic: LeetCode 73 - Set Matrix Zeroes; from Striver's SDE sheet)
 * ----------------------------------------------------------------------------
 * Given an m x n matrix, if any element is 0, set its ENTIRE row and column to 0.
 * Do it in place.
 *
 * Example:
 *   Input:  [[1,1,1],[1,0,1],[1,1,1]]
 *   Output: [[1,0,1],[0,0,0],[1,0,1]]   (matrix[1][1] was 0)
 *
 * ============================================================================
 * EASY WAY TO THINK ABOUT IT
 * ----------------------------------------------------------------------------
 * The trap: if you zero a row/column the moment you see a 0, those fresh zeros
 * get mistaken for original zeros and wipe out more than they should. So first
 * RECORD which rows and columns must be zeroed, THEN apply.
 *
 *   Level 1 - use a separate boolean[] rows and boolean[] cols to mark hits,
 *             then zero everything marked.           Time O(m*n), Space O(m+n)
 *   Level 2 - use the matrix's own first row/column as the marker storage
 *             (plus two flags).                      Time O(m*n), Space O(1)
 *
 * ============================================================================
 * STATUS: INCOMPLETE. setMatrixZero() currently only PRINTS the matrix - the
 * marking/zeroing logic is not written yet. Left as-is (WIP); the header
 * describes the intended approaches.
 * ============================================================================
 */
public class SetMatrixZeroes {

	public static void main(String[] args) {
		int arr[][] = { { 1, 1, 1, 5 }, { 1, 0, 1, 5 }, { 1, 1, 1, 5 } };

		setMatrixZero(arr);
	}

	// TODO (INCOMPLETE): currently just prints; should mark zero rows/cols then apply.
	public static void setMatrixZero(int[][] arr) {

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				System.out.print(arr[i][j]);
			}
			System.out.println();
		}

	}
}
