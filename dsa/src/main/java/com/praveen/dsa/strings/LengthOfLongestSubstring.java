package com.praveen.dsa.strings;

/*
 * ============================================================================
 * QUESTION  (classic: LeetCode 3)
 * ----------------------------------------------------------------------------
 * Find the length of the longest substring WITHOUT repeating characters.
 *
 * Example:  "abcabcbb" -> 3 ("abc")      "bbbbb" -> 1 ("b")
 *
 * ============================================================================
 * EASY WAY TO THINK ABOUT IT  (sliding window)
 * ----------------------------------------------------------------------------
 * Keep a window [left..current] that contains only unique chars, tracked in a
 * HashSet. Walk `current` forward:
 *   - if the new char is already in the set, shrink the window from the LEFT
 *     (removing chars) until the duplicate is gone,
 *   - then add the new char and update the best length (current - left + 1).
 * Each character is added once and removed at most once -> linear time.
 *
 * ============================================================================
 * OPTIMIZATION
 * ----------------------------------------------------------------------------
 *  Sliding window with a HashSet.
 *            Time  : O(N)   Space : O(min(N, charset size))
 *
 * NOTE: no main() here - it's a method-only class (call
 * lengthOfLongestNonRepeatingSubstring(s)).
 * ============================================================================
 */
public class LengthOfLongestSubstring {
    public int lengthOfLongestNonRepeatingSubstring(String s) {
        // Use a HashSet to track unique characters in our current window
        java.util.HashSet<Character> set = new java.util.HashSet<>();
        int left = 0;
        int maxLength = 0;
        
        for (int current = 0; current < s.length(); current++) {
            char currentChar = s.charAt(current);
            
            // If we find a duplicate, shrink the window from the left
            // until the duplicate is completely removed from the set
            while (set.contains(currentChar)) {
                set.remove(s.charAt(left));
                left++;
            }
            
            // Add the current character to our valid window
            set.add(currentChar);
            
            // Update the maximum length found so far
            maxLength = Math.max(maxLength, current - left + 1);
        }
        
        return maxLength;
    }
}