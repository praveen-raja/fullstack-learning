package com.praveen.dsa.strings;

import java.util.StringJoiner;

/*
 * ============================================================================
 * TOPIC: StringJoiner - joining strings with a delimiter
 * ----------------------------------------------------------------------------
 * StringJoiner builds a single string from parts, inserting a delimiter between
 * them (and optionally a prefix/suffix).
 *
 * ============================================================================
 * EASY WAY TO THINK ABOUT IT
 * ----------------------------------------------------------------------------
 * new StringJoiner(", ") then add("Praveen").add("Kumar") produces
 * "Praveen, Kumar" - the delimiter goes BETWEEN items only, not at the ends.
 * add() returns the same joiner, so calls can be chained. length() is the
 * length of the string built so far.
 *
 * ============================================================================
 * COMPLEXITY
 * ----------------------------------------------------------------------------
 *  add : O(length of the piece)   |   building N pieces : O(total chars)
 * ============================================================================
 */
public class JoinStringElementsUsingStringJoiner {
	public static void main(String[] args) {
		StringJoiner sj = new StringJoiner(", "); // delimiter between items

		StringJoiner praveen = sj.add("Praveen").add("Kumar"); // "Praveen, Kumar"
		int length = praveen.length();

		System.out.println(praveen + "\n" + length);
	}
}
