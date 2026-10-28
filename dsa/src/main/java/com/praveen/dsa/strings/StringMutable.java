package com.praveen.dsa.strings;

/*
 * ============================================================================
 * TOPIC: String is immutable; use StringBuffer/StringBuilder to mutate
 * ----------------------------------------------------------------------------
 * Same lesson as MutabilityExample, shown with StringBuffer.
 *
 * ============================================================================
 * EASY WAY TO THINK ABOUT IT
 * ----------------------------------------------------------------------------
 *   s.concat("world")  -> returns a new String; discarded if not reassigned,
 *                         so `s` still prints "hello".
 *   sb.append("world") -> mutates the StringBuffer in place, so it prints
 *                         "helloworld".
 *
 * StringBuffer vs StringBuilder: both are mutable; StringBuffer is synchronized
 * (thread-safe, slightly slower), StringBuilder is not (faster, single-thread).
 * Prefer StringBuilder unless you truly share it across threads.
 *
 * ============================================================================
 * COMPLEXITY
 * ----------------------------------------------------------------------------
 *  append : amortized O(1)   |  repeated String concat in a loop : O(N^2)
 * ============================================================================
 */
public class StringMutable {

	public static void main(String[] args) {
		String s = "hello";
		String s2 = "hello";

		s.concat("world");       // result discarded -> s stays "hello"
		System.out.println(s);

		// to actually mutate, use a StringBuffer (or StringBuilder)
		StringBuffer sb = new StringBuffer("hello");
		sb.append("world");      // mutates in place
		System.out.println(sb);
	}

}
