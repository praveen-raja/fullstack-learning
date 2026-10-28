package com.praveen.dsa.strings;

/*
 * ============================================================================
 * QUESTION
 * ----------------------------------------------------------------------------
 * Reverse the ORDER OF WORDS in a sentence (the words themselves stay intact).
 *
 * Example:  "My name is Utkarsh"  ->  "Utkarsh is name My"
 *
 * ============================================================================
 * EASY WAY TO THINK ABOUT IT
 * ----------------------------------------------------------------------------
 * Split the sentence on spaces into a word array, then stitch the words back
 * together walking from the LAST word to the first. Add a space between words
 * but not after the final one (the i == 0 check).
 *
 * ============================================================================
 * OPTIMIZATION
 * ----------------------------------------------------------------------------
 *  Split + reverse-concat.  Time : O(N) in sentence length   Space : O(N)
 *  NOTE: building the result with String += in a loop is technically O(N^2);
 *  a StringBuilder would make it a clean O(N).
 * ============================================================================
 */
public class ReverseWordsInString {
	public static void main(String[] args) {

		String str = "My name is Utkarsh";
		String temp = "";
		String words[] = str.split("\\s"); // split on whitespace

		for (int i = words.length - 1; i >= 0; i--) { // last word first
			if (i == 0) {
				temp = temp + words[i];         // no trailing space after the last
			} else {
				temp = temp + words[i] + " ";
			}
		}
		System.out.println(temp);
	}
}
