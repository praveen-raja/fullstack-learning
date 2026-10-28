package com.praveen.javacore.basics;

/*
 * ============================================================================
 * TOPIC: Java is ALWAYS pass-by-value
 * ----------------------------------------------------------------------------
 * Shows that reassigning a parameter inside a method never affects the caller's
 * variable - for both primitives and references.
 *
 * ============================================================================
 * EASY WAY TO THINK ABOUT IT
 * ----------------------------------------------------------------------------
 * When you call test(x, name), Java copies the VALUES into the parameters. For
 * the int, the value is the number 10. For the String, the value is a COPY of
 * the reference (an arrow pointing at the "praveen" object). Inside test(),
 * reassigning x or name just repoints the LOCAL copies; the caller's x and name
 * are untouched. So main still prints 10 and "praveen".
 *
 * Key nuance: "pass-by-value of a reference" means you CAN mutate the object a
 * reference points to (e.g. list.add(...)) and the caller sees it - but
 * REASSIGNING the parameter to a new object never affects the caller. (Strings
 * are immutable anyway, so you can only reassign them.)
 *
 * ============================================================================
 * COMPLEXITY
 * ----------------------------------------------------------------------------
 *  O(1) - just demonstrates parameter semantics.
 * ============================================================================
 */
public class PassByValue {
	public static void main(String[] args) {
		int x = 10;
		String name = "praveen";

		test(x, name);

		// unchanged: the method only edited its own local copies
		System.out.println("x main value:" + x);
		System.out.println("name main value:" + name);
	}

	private static void test(int x, String name) {
		System.out.println("x from pass by value:" + x);
		System.out.println("name from pass by value:" + name);

		x = 1000;      // reassigns the local copy only
		name = "arun"; // reassigns the local copy only

		System.out.println("x after changes pass by value:" + x);
		System.out.println("name after changes pass by value:" + name);
	}
}
