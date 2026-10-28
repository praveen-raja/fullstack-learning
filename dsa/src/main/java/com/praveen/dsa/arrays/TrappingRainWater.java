package com.praveen.dsa.arrays;

/*
 * ============================================================================
 * QUESTION  (classic: LeetCode 42)
 * ----------------------------------------------------------------------------
 * Given N non-negative bar heights (an elevation map where each bar has width 1),
 * compute how much rain water is trapped between the bars after it rains.
 *
 * Example:  { 0,1,0,2,1,0,1,3,2,1,2,1 }  ->  6 units of water
 *
 * ============================================================================
 * EASY WAY TO THINK ABOUT IT  (water over one bar)
 * ----------------------------------------------------------------------------
 * Water sitting ON TOP of bar i is bounded by the TALLEST wall to its left and
 * the TALLEST wall to its right. The level it can hold is the SHORTER of those
 * two walls (water spills over the lower side), minus the bar's own height:
 *
 *      water[i] = min(leftMax[i], rightMax[i]) - height[i]
 *
 * Precompute leftMax[] (tallest bar from the left up to i) and rightMax[]
 * (tallest from the right), then sum water[i] over all bars.
 *
 * ============================================================================
 * OPTIMIZATION LEVELS
 * ----------------------------------------------------------------------------
 *  Level 1 - Brute force: for each bar scan left and right for its maxes. O(N^2), O(1)
 *  Level 2 - Precomputed leftMax/rightMax arrays (this file)
 *            Time  : O(N)   Space : O(N)
 *  Level 3 - Two pointers converging from both ends (not here)
 *            Time  : O(N)   Space : O(1)   -> best space
 * ============================================================================
 */
public class TrappingRainWater {

	public static void main(String[] args) {
		TrappingRainWater trappingRainWater = new TrappingRainWater();

		int rain[] = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
		System.out.println(trappingRainWater.trap(rain));
	}

	// Level 2 - leftMax/rightMax prefix arrays. TC = O(N), SC = O(N)
	public int trap(int[] rain) {
		if (rain == null || rain.length == 0)
			return 0;

		int n = rain.length;

		int[] leftMax = new int[n];
		int[] rightMax = new int[n];

		// tallest bar from the left up to i
		leftMax[0] = rain[0];
		for (int i = 1; i < n; i++) {
			leftMax[i] = Math.max(leftMax[i - 1], rain[i]);
		}

		// tallest bar from the right up to i
		rightMax[n - 1] = rain[n - 1];
		for (int i = n - 2; i >= 0; i--) {
			rightMax[i] = Math.max(rightMax[i + 1], rain[i]);
		}

		// water over each bar = min(left wall, right wall) - bar height
		int totalWater = 0;
		for (int i = 0; i < n; i++) {
			totalWater += Math.min(leftMax[i], rightMax[i]) - rain[i];
		}

		return totalWater;
	}
}
