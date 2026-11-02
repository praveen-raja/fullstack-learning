package com.praveen.javacore.streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.OptionalInt;

/*
 * ============================================================================
 * QUESTION
 * ----------------------------------------------------------------------------
 * Given a sentence, find the SECOND LARGEST word length using Java Streams.
 *
 * Example:  "hello I am good"
 *           words   -> hello, I, am, good
 *           lengths -> 5,     1,  2,  4
 *           largest length = 5 ("hello"), second largest length = 4 ("good")
 *           Output: 4
 *
 * ============================================================================
 * EASY WAY TO THINK ABOUT IT
 * ----------------------------------------------------------------------------
 *   split the sentence -> words
 *   map each word to its length -> a stream of numbers
 *   DISTINCT the lengths -> sort DESCENDING -> skip the 1st (largest) -> take next
 *
 * Why distinct() matters: if two words tie for the longest, the "second largest
 * length" should be the next DIFFERENT value, not a repeat of the max.
 *   "hello world ok" -> lengths 5,5,2 -> second largest length = 2 (not 5)
 *
 * ============================================================================
 * OPTIMIZATION LEVELS
 * ----------------------------------------------------------------------------
 *  Level 1 - distinct + sort desc + skip(1) (secondLargestBySort)
 *            Time  : O(N log N)   Space : O(N)   -> clearest
 *  Level 2 - one pass tracking largest + secondLargest (secondLargestOnePass)
 *            Time  : O(N)         Space : O(N) for the split words
 *
 * Both return OptionalInt because a sentence with fewer than 2 DISTINCT lengths
 * has no answer (e.g. "" or "hi" or "aa bb" -> empty).
 * ============================================================================
 */
public class SecondLargestWordLength {

	public static void main(String[] args) {
		
		String sentence = "hello i am good";
		System.out.println(Arrays.stream(sentence.trim().split("\\s+"))
				  .filter(s-> !s.isEmpty())
				  .mapToInt(String::length)
				  .distinct()
				  .boxed()
				  .sorted(Comparator.reverseOrder())
				  .skip(1)
				  .mapToInt(Integer::intValue)
				  .findFirst()
				  .toString());
	}
}
