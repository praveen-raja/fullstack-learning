package com.praveen.dsa.arrays.problems;

import java.util.Scanner;

/*
 * ============================================================================
 * QUESTION
 * ----------------------------------------------------------------------------
 * Read a line of text and count how many UPPERCASE letters and how many
 * LOWERCASE letters it contains.
 *
 * ============================================================================
 * EASY WAY TO THINK ABOUT IT
 * ----------------------------------------------------------------------------
 * Walk each character. A char is just a number (its ASCII/Unicode code), so you
 * can range-check it:
 *   'a'..'z' -> lowercase    'A'..'Z' -> uppercase
 * Keep two counters.
 *
 * ============================================================================
 * OPTIMIZATION
 * ----------------------------------------------------------------------------
 *  Single pass.  Time : O(L) for string length L   Space : O(1)
 * ============================================================================
 */
public class CountUpperAndLowerCaseLetters {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		String s = input.nextLine();

		int lower = 0;
		int upper = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) >= 'a' && s.charAt(i) <= 'z') {
				lower++;
			} else if (s.charAt(i) >= 'A' && s.charAt(i) <= 'Z') {
				upper++;
			}
		}

		System.out.println(upper); // uppercase count
		System.out.println(lower); // lowercase count
	}
}
