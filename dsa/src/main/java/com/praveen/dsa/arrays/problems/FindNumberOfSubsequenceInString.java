package com.praveen.dsa.arrays.problems;

/*
 * ============================================================================
 * QUESTION
 * ----------------------------------------------------------------------------
 * Count how many times a short pattern appears as a SUBSEQUENCE in a string.
 * (A subsequence keeps order but the characters need not be adjacent.)
 *
 * This file specializes the pattern to "ag": count how many ways you can pick
 * an 'a' and a later 'g' from the string.
 *
 * Example:  s = "adgagagfg", pattern = "ag"
 *
 * ============================================================================
 * EASY WAY TO THINK ABOUT IT  (count a's, then pair each g with them)
 * ----------------------------------------------------------------------------
 * Walk left to right. Keep a running count of how many 'a's you've seen so far.
 * Each time you hit a 'g', every earlier 'a' can pair with it, so add the
 * current a-count to the answer. One pass, no nested loop.
 *
 *   s = a d g a g a g f g
 *   a-count: 1 1 1 2 2 3 3 3 3
 *   on g:         +1  +2  +3    ...accumulate
 *
 * ============================================================================
 * OPTIMIZATION LEVELS
 * ----------------------------------------------------------------------------
 *  Level 1 - Brute force (findCountOfSubstring1): for each 'a', scan forward
 *            counting 'g's.
 *            Time  : O(N^2)   Space : O(1)
 *
 *  Level 2 - Running a-count, add on each 'g' (findCountOfSubstring2)
 *            Time  : O(N)     Space : O(1)   -> best
 *
 * NOTE: both methods are hard-coded to the characters 'a' and 'g' (they ignore
 * the generic `sub` argument). Generalizing to any 2-char pattern is a TODO.
 * ============================================================================
 */
public class FindNumberOfSubsequenceInString {

	public static void main(String[] args) {

		String s = "adgagagfg";// "abcgageafgd2agefaagg"; // original string

		String sub = "ag"; // pattern (currently hard-coded as 'a' then 'g')

		System.out.println(findCountOfSubstring2(s, sub));
	}

	// Level 2 - running count of 'a'; on each 'g' add how many 'a's came before.
	// TC = O(N), SC = O(1)
	private static int findCountOfSubstring2(String s, String sub) {

		int countOfA = 0; // number of 'a's seen so far
		int sum = 0;      // total "ag" subsequences

		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == 'a') {
				countOfA++;
			}
			if (s.charAt(i) == 'g') {
				sum = sum + countOfA; // pair this g with every earlier a
			}
		}

		return sum;
	}

	// Level 1 - brute force: for each 'a', count every later 'g'. TC = O(N^2), SC = O(1)
	private static int findCountOfSubstring1(String s, String sub) {

		int countOfSubstring = 0;

		char[] originalArray = s.toCharArray();
		char[] subArray = sub.toCharArray();

		for (int i = 0; i < originalArray.length - 1; i++) {
			if (originalArray[i] == 'a') {
				for (int j = i + 1; j < originalArray.length; j++) {
					if (originalArray[j] == 'g') {
						countOfSubstring++;
					}
				}
			}
		}

		return countOfSubstring;
	}

}
