package com.praveen.dsa.strings;

import java.util.Stack;

/*
 * ============================================================================
 * QUESTION  (classic: LeetCode 20 - Valid Parentheses)
 * ----------------------------------------------------------------------------
 * Given a string of brackets ()[]{}, decide whether they are validly matched:
 * every opening bracket is closed by the SAME type, and in the correct order.
 *
 * Example:  "{{[}}"  ->  false      "{[()]}"  ->  true
 *
 * ============================================================================
 * EASY WAY TO THINK ABOUT IT  (a stack of "still-open" brackets)
 * ----------------------------------------------------------------------------
 * Push every OPENING bracket on a stack. On a CLOSING bracket, the thing it must
 * match is the MOST RECENT unclosed opener = the top of the stack. Pop and check
 * the types line up. Two failure cases: a closer with an empty stack (nothing to
 * match), or a type mismatch. At the very end the stack must be EMPTY (no opener
 * left dangling).
 *
 * ============================================================================
 * OPTIMIZATION
 * ----------------------------------------------------------------------------
 *  Single pass with a stack.  Time : O(N)   Space : O(N)
 *
 * ----------------------------------------------------------------------------
 * STATUS: BUGGY / INCOMPLETE (left as-is, not fixed):
 *   1) the opener check tests '{' twice and never tests '(' - '(' is treated as
 *      a closing bracket and wrongly popped.
 *   2) on a mismatch it PRINTS false but keeps looping instead of stopping.
 *   3) it never checks the stack is empty at the end, and unconditionally sets
 *      isValid = true, so it always also prints true.
 *   The header above describes the CORRECT algorithm for when this is finished.
 * ============================================================================
 */
public class ValidParanthesis {
	public static void main(String[] args) {

		String input = "{{[}}";

		if (input == null || input.length() <= 1) {
			System.out.println(false);
		}

		Stack<Character> stack = new Stack<Character>();
		boolean isValid = false;

		for (Character c : input.toCharArray()) {

			if (c.equals('{') || c.equals('{') || c.equals('[')) { // BUG: '{' twice, '(' missing
				stack.push(c);
			} else {
				if (stack.isEmpty()) {
					System.out.println(false); // BUG: should stop/return here
				}

				char current = stack.pop();
				if (c.equals('}') && current != '{') {
					System.out.println(false);
				}
				if (c.equals(']') && current != '[') {
					System.out.println(false);
				}
				if (c.equals(')') && current != '(') {
					System.out.println(false);
				}
			}

		}
		isValid = true; // BUG: unconditional; ignores leftover openers in the stack
		System.out.println(isValid);
	}

}
