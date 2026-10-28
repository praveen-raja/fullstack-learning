package com.praveen.dsa.arrays;

/*
 * ============================================================================
 * QUESTION
 * ----------------------------------------------------------------------------
 * Print the elements of a 2D matrix in SPIRAL order: top row left-to-right,
 * right column top-to-bottom, bottom row right-to-left, left column
 * bottom-to-top, then spiral inward and repeat.
 *
 *   1  2  3  4
 *   5  6  7  8        spiral: 1 2 3 4 8 7 6 5  (for this 2x4 sample)
 *
 * ============================================================================
 * EASY WAY TO THINK ABOUT IT  (four shrinking walls)
 * ----------------------------------------------------------------------------
 * Keep four boundaries: Top, Bottom, Left, Right. Peel one layer at a time:
 *   - walk Left->Right along the Top wall, then push Top down (T++)
 *   - walk Top->Bottom along the Right wall, then pull Right in (R--)
 *   - walk Right->Left along the Bottom wall, then lift Bottom up (B--)
 *   - walk Bottom->Top along the Left wall, then push Left in (L++)
 * Loop while T <= B and L <= R. Each pass peels the outermost ring.
 *
 * ============================================================================
 * OPTIMIZATION
 * ----------------------------------------------------------------------------
 *  Boundary shrinking. Time : O(R * C)   Space : O(1)
 *  Every cell is printed exactly once.
 * ============================================================================
 */
public class SpiralArray {
	public static void main(String[] args) {

		int arr[][] = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 } };// { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };

		printSpiral(arr);
	}

	// Four boundaries (T, B, L, R) shrinking inward. TC = O(R*C), SC = O(1)
	private static void printSpiral(int[][] arr) {

		int T = 0;                  // top boundary
		int B = arr.length - 1;     // bottom boundary
		int L = 0;                  // left boundary
		int R = arr[0].length - 1;  // right boundary

		while (T <= B && L <= R) {

			// top wall: left -> right
			for (int k = L; k <= R; k++) {
				System.out.println(arr[T][k]);
			}
			T++;

			// right wall: top -> bottom
			for (int k = T; k <= B; k++) {
				System.out.println(arr[k][R]);
			}
			R--;

			// bottom wall: right -> left
			for (int k = R; k >= L; k--) {
				System.out.println(arr[B][k]);
			}
			B--;

			// left wall: bottom -> top
			for (int k = B; k >= T; k--) {
				System.out.println(arr[k][L]);
			}
			L++;
		}
	}
}
