package com.praveen.dsa.arrays;

/*
 * ============================================================================
 * QUESTION  (classic: LeetCode 1920 - Build Array from Permutation)
 * ----------------------------------------------------------------------------
 * Given a zero-based permutation `nums`, build an array `ans` where
 *      ans[i] = nums[nums[i]]
 * for every i, and return it.
 *
 * Example:  nums = [0,2,1,5,3,4]  ->  ans = [0,1,2,4,5,3]
 *
 * ============================================================================
 * EASY WAY TO THINK ABOUT IT
 * ----------------------------------------------------------------------------
 * For each index i, look up nums[i], then use THAT as an index into nums again:
 * ans[i] = nums[nums[i]]. Straightforward double-indexing.
 *
 *   Level 1 - extra output array.                    Time O(N), Space O(N)
 *   Level 2 - in-place trick encoding two values per slot with modular math
 *             (ans without extra array).              Time O(N), Space O(1)
 *
 * ============================================================================
 * STATUS: EMPTY STUB. No implementation yet - placeholder class only. Left as-is.
 * ============================================================================
 */
public class BuildArrayFromPermutation {

}
