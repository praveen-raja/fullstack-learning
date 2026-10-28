package com.praveen.dsa.arrays.problems;

import java.util.Arrays;
import java.util.Collections;

/*
 * ============================================================================
 * QUESTION
 * ----------------------------------------------------------------------------
 * Find the length of the SMALLEST subarray (contiguous window) that contains
 * BOTH the array's minimum value and its maximum value.
 *
 * Example:  { 1, 6, 4, 6, 5, 1, 5, 2, 6, 4, 4, 2, 1 }
 *           min = 1, max = 6. Find the shortest window holding at least one 1
 *           and one 6, return its length.
 *
 * ============================================================================
 * EASY WAY TO THINK ABOUT IT  (track the last seen position)
 * ----------------------------------------------------------------------------
 * First find the global min and max values. Now walk the array keeping the most
 * recent index where you saw a min and the most recent index where you saw a
 * max. Every time you see one of them, the distance to the LAST time you saw
 * the OTHER is a candidate window - keep the smallest such distance.
 *
 * If min == max (all elements equal), any single element works -> answer is 1.
 *
 * ============================================================================
 * OPTIMIZATION LEVELS
 * ----------------------------------------------------------------------------
 *  Level 1 - Brute force (find1): from each min/max, scan forward for its pair.
 *            Time  : O(N^2)   Space : O(1)
 *
 *  Level 2 - Single pass tracking last-seen positions (find2)
 *            Time  : O(N)     Space : O(1)
 *            (Collections.min/max add two O(N) scans up front - still O(N).)
 * ============================================================================
 */
public class SmallestSubArrayHavingMinAndMaxValue {
	public static void main(String[] args) {
		Integer[] num = { 1, 6, 4, 6, 5, 1, 5, 2, 6, 4, 4, 2, 1 };

		System.out.println(find2(num));
	}

	// Level 2 - track last-seen min/max indices in one pass. TC = O(N), SC = O(1)
	private static int find2(Integer[] num) {

		int array_min = Collections.min(Arrays.asList(num));
		int array_max = Collections.max(Arrays.asList(num));

		if (array_max == array_min) {
			return 1; // every single element already holds both
		}

		int ans = num.length;
		Integer mini = null; // last index where min was seen
		Integer maxi = null; // last index where max was seen

		for (int i = num.length - 1; i >= 0; i--) {

			if (num[i] == array_min) {
				mini = i;
				if (maxi != null) {
					ans = Math.min(ans, (maxi - mini + 1));
				}
			} else if (num[i] == array_max) {
				maxi = i;
				if (mini != null) {
					ans = Math.min(ans, (mini - maxi + 1));
				}
			}
		}
		return ans;
	}

	// Level 1 - brute force: from each min/max, scan forward for its pair.
	// TC = O(N^2), SC = O(1)
	private static int find1(Integer[] num) {

		int array_min = Collections.min(Arrays.asList(num));
		int array_max = Collections.max(Arrays.asList(num));

		if (array_max == array_min) {
			return 1;
		}

		int ans = num.length;

		for (int i = 0; i < num.length; i++) {

			if (num[i] == array_max) {
				for (int j = i + 1; j < num.length; j++) {
					if (num[j] == array_min) {
						ans = Math.min(ans, j - i + 1);
						break;
					}
				}
			} else if (num[i] == array_min) {
				for (int j = i + 1; j < num.length; j++) {
					if (num[j] == array_max) {
						ans = Math.min(ans, j - i + 1);
						break;
					}
				}
			}
		}

		return ans;
	}
}
