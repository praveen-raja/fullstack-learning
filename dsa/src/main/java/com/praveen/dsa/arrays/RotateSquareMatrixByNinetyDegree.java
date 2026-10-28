package com.praveen.dsa.arrays;

/*
 * ============================================================================
 * QUESTION
 * ----------------------------------------------------------------------------
 * Rotate a square matrix 90 degrees clockwise, in place.
 *
 *   Before:        After 90 deg clockwise:
 *     1 2 3            7 4 1
 *     4 5 6     ->     8 5 2
 *     7 8 9            9 6 3
 *
 * ============================================================================
 * EASY WAY TO THINK ABOUT IT
 * ----------------------------------------------------------------------------
 * Two simple steps you already know:
 *   Step 1: TRANSPOSE (flip across the main diagonal).
 *   Step 2: REVERSE EACH ROW (mirror every row left-to-right).
 *
 *   1 2 3   transpose   1 4 7   reverse rows   7 4 1
 *   4 5 6   -------->   2 5 8   ----------->   8 5 2
 *   7 8 9               3 6 9                   9 6 3
 *
 * (For counter-clockwise: transpose, then reverse each COLUMN instead.)
 *
 * ============================================================================
 * OPTIMIZATION
 * ----------------------------------------------------------------------------
 *  Transpose O(N^2) + reverse rows O(N^2) = O(N^2) total.
 *            Time  : O(N^2)
 *            Space : O(1)   -> fully in place
 * ============================================================================
 */
public class RotateSquareMatrixByNinetyDegree {
	public static void main(String[] args) {

		int arr[][] = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };

		System.out.println("Initial array :");
		print(arr);

		transpose(arr);
	}

	// STEP 1: transpose (swap upper triangle), then kick off STEP 2.
	// TC = O(N^2), SC = O(1)
	private static void transpose(int[][] arr) {

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				if (i < j) {
					swap(arr, i, j);
				}
			}
		}

		System.out.println("After Transpose:");
		print(arr);

		reverseRow(arr);
	}

	// STEP 2: reverse every row left-to-right. TC = O(N^2), SC = O(1)
	private static void reverseRow(int[][] arr) {

		int length = arr.length;
		for (int i = 0; i < length; i++) {
			for (int j = 0; j < arr[i].length / 2; j++) {
				// swap arr[i][j] with its mirror on the same row
				int temp = arr[i][j];
				arr[i][j] = arr[i][arr[i].length - j - 1];
				arr[i][arr[i].length - j - 1] = temp;
			}
		}

		System.out.println("After Reverse:");
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
