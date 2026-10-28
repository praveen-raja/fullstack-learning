package com.praveen.dsa.strings;

/*
 * ============================================================================
 * TOPIC: Reference equality (==) with StringBuilder
 * ----------------------------------------------------------------------------
 * Shows that `==` compares REFERENCES (are these the same object?), not contents.
 *
 * ============================================================================
 * EASY WAY TO THINK ABOUT IT
 * ----------------------------------------------------------------------------
 * `str2 = str` does NOT copy anything - it just makes str2 point at the SAME
 * object str points to. So `str == str2` is true (same object). To compare
 * CONTENTS you would convert to String and use .equals(), because StringBuilder
 * does not override equals() for content comparison.
 *
 * ----------------------------------------------------------------------------
 * NOTE: the code prints "Equal" inside the if, but "Not Equal" is OUTSIDE the
 * if/else, so it always prints too. The output is both lines - a reminder to
 * guard the "Not Equal" branch with an else. Left as-is.
 * ============================================================================
 */
public class StringBuilderExample {
	public static void main(String[] args) {

		StringBuilder str = new StringBuilder("Praveen");
		StringBuilder str2 = str; // str2 points at the SAME object as str

		if (str == str2) { // true: same reference
			System.out.println("Equal");
		}
		System.out.println("Not Equal"); // NOTE: not in an else, always prints

	}
}
