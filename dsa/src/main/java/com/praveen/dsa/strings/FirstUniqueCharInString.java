package com.praveen.dsa.strings;

import java.util.HashMap;
import java.util.Map;

/*
 * ============================================================================
 * QUESTION  (classic: LeetCode 387)
 * ----------------------------------------------------------------------------
 * Find the FIRST non-repeating character in a string and print it (print its
 * index, or here the character). If none exists, nothing is printed.
 *
 * Example:  "loveleetcode"  ->  'v'  (first char that appears exactly once)
 *
 * ============================================================================
 * EASY WAY TO THINK ABOUT IT  (count, then re-scan in order)
 * ----------------------------------------------------------------------------
 * Pass 1: tally each character's frequency in a HashMap<char, count>.
 * Pass 2: walk the string again LEFT to RIGHT; the first character whose count
 *         is 1 is the answer. Re-scanning in original order is what makes it
 *         the FIRST unique one.
 *
 * ============================================================================
 * OPTIMIZATION
 * ----------------------------------------------------------------------------
 *  Two passes over the string.  Time : O(N)   Space : O(1) (at most 26/128 keys)
 * ============================================================================
 */
public class FirstUniqueCharInString {

	public static void main(String[] args) {
		String s = "loveleetcode";

		Map<Character, Integer> countMap = new HashMap<>();

		// pass 1: frequency tally
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			countMap.put(c, countMap.getOrDefault(c, 0) + 1);
		}

		// pass 2: first char with count 1 (in original order)
		for (int i = 0; i < s.length(); i++) {
			if (countMap.containsKey(s.charAt(i)) && countMap.get(s.charAt(i)) == 1) {
				System.out.println(s.charAt(i));
				break;
			}
		}
	}

}
