package com.praveen.dsa.arrays;

/*
 * ============================================================================
 * QUESTION
 * ----------------------------------------------------------------------------
 * Given a binary 2D array where each ROW is sorted (all 0s then all 1s),
 * print the INDEX of the row that has the most 1s.
 *
 * Example:
 *      0 1 1 1
 *      0 0 1 0        row 0 has three 1s -> answer is index 0
 *      1 1 1 1
 *      (whichever row has the most 1s)
 *
 * ============================================================================
 * EASY WAY TO THINK ABOUT IT
 * ----------------------------------------------------------------------------
 * In a row-sorted binary matrix, a row with MORE 1s has its FIRST 1 appearing
 * EARLIER (further to the left). So instead of counting 1s in every row, find
 * which row's first 1 is leftmost.
 *
 * approach 2 below uses that: scan column by column from the left; the first
 * row you hit with a 1 in the earliest column is the winner.
 *
 * ============================================================================
 * OPTIMIZATION LEVELS
 * ----------------------------------------------------------------------------
 *  Level 1 - findMaxIndex: sum every row, track the max. Works even if rows are
 *            NOT sorted.
 *            Time  : O(R * C)   Space : O(1)
 *
 *  Level 2 - findMaxIndex1: column-wise scan for the leftmost 1.
 *            Time  : O(R * C) worst case   Space : O(1)
 *
 *  Level 3 - binary search each row for its first 1 (NOT implemented; noted
 *            below). Exploits the per-row sort.
 *            Time  : O(R * log C)   Space : O(1)
 * ============================================================================
 */
public class RowWithMaxOnes {

	public static void main(String[] args) {
		int arr[][] = {
				{ 0, 0, 0, 0 },
				{ 0, 1, 1, 1 },
				{ 0, 1, 0, 0 } };

		findMaxIndex1(arr);
	}

	// Level 1 - sum of each row; works even when rows are not sorted.
	// TC = O(R*C), SC = O(1)
	private static void findMaxIndex(int[][] arr) {

		int temp = 0;
		int result = 0;
		for (int i = 0; i < arr.length; i++) {
			int sum = 0;
			for (int j = 0; j < arr[i].length; j++) {
				sum = sum + arr[i][j];
				if (temp <= sum) {
					temp = sum;
					result = i;
				}
			}
			System.out.println(i + " -> " + sum);
		}
		System.out.println(result);
	}

	// Level 2 - column-wise scan; first row with a 1 in the leftmost column wins.
	// TC = O(R*C) worst case, SC = O(1)
	private static void findMaxIndex1(int[][] arr) {
		for (int i = 0; i < arr[0].length; i++) {       // columns, left to right
			for (int j = 0; j < arr.length; j++) {      // rows
				if (arr[j][i] == 1) {
					System.out.println(j);
					return;
				}
			}
		}
	}

	// Level 3 (NOT implemented): binary-search each row for its first 1,
	// then the row whose first-1 index is smallest has the most 1s. O(R*log C).
}
