package com.praveen.dsa.strings;

/*
 * ============================================================================
 * QUESTION  (classic: LeetCode 5)
 * ----------------------------------------------------------------------------
 * Find the longest substring of s that reads the same forwards and backwards
 * (a palindrome).
 *
 * Example:  "madam" -> "madam"      "babad" -> "bab" (or "aba")
 *
 * ============================================================================
 * EASY WAY TO THINK ABOUT IT
 * ----------------------------------------------------------------------------
 * This file uses the straightforward approach: try EVERY substring (all i..j
 * pairs), check if it's a palindrome with a two-pointer test, and remember the
 * longest one that passes.
 *
 * ============================================================================
 * OPTIMIZATION LEVELS
 * ----------------------------------------------------------------------------
 *  Level 1 - Check all substrings (this file)
 *            Time  : O(N^3)  (N^2 substrings x O(N) palindrome check)   Space : O(1)
 *  Level 2 - "Expand around center" (not here): try each of the 2N-1 centers and
 *            grow outward.            Time : O(N^2)   Space : O(1)
 *  Level 3 - Manacher's algorithm (not here).   Time : O(N)
 * ============================================================================
 */
public class LongestPalindromeSubstring {
	
	public static void main(String[] args) {
		LongestPalindromeSubstring longestPalindromeSubstring = new LongestPalindromeSubstring();
		System.out.println(longestPalindromeSubstring.longestPalindrome("madam"));
	}
	
    public String longestPalindrome(String s) {
        // Base case for empty string or single character
        if (s == null || s.length() < 2) {
            return s;
        }

        String longest = "";

        // Generate all possible substrings
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                
                // Check if the current substring is a palindrome
                if (isPalindrome(s, i, j)) {
                    // If it is, and it's longer than our current best, update it
                    if (j - i + 1 > longest.length()) {
                        longest = s.substring(i, j + 1);
                    }
                }
            }
        }
        return longest;
    }

    // Helper method to check if a substring is a palindrome
    private boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
