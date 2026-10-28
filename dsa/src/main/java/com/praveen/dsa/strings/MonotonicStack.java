package com.praveen.dsa.strings;

/*
 * ============================================================================
 * QUESTION  (classic: LeetCode 402 - Remove K Digits)
 * ----------------------------------------------------------------------------
 * Given a number as a string `num` and an integer k, remove exactly k digits so
 * the resulting number is the SMALLEST possible. Return it as a string (no
 * leading zeros, "0" if empty).
 *
 * Example:  num = "10200", k = 1  ->  "200"
 *
 * ============================================================================
 * EASY WAY TO THINK ABOUT IT  (monotonic increasing stack)
 * ----------------------------------------------------------------------------
 * To make a number small, you want smaller digits as far LEFT as possible. Walk
 * the digits pushing them on a stack; before pushing a digit, if the digit on
 * top is BIGGER than the current one and you still have removals left, pop it
 * (removing a big high-place digit shrinks the number most). This keeps the
 * stack non-decreasing - a "monotonic stack".
 *
 * Clean-up after the pass:
 *   - if removals remain (digits were already increasing, e.g. "1234"), drop
 *     them from the END.
 *   - strip leading zeros.
 *   - empty result -> "0".
 *
 * ============================================================================
 * OPTIMIZATION
 * ----------------------------------------------------------------------------
 *  Each digit is pushed and popped at most once.
 *            Time  : O(N)   Space : O(N) for the stack
 * ============================================================================
 */
public class MonotonicStack {

	public static void main(String[] args) {
		MonotonicStack stack = new MonotonicStack();
		System.out.println(stack.removeKdigits("10200", 1));
	}

	// Monotonic (non-decreasing) stack. TC = O(N), SC = O(N)
	public String removeKdigits(String num, int k) {
		// if we must remove everything
		if (num.length() == k)
			return "0";

		StringBuilder stack = new StringBuilder();

		for (char digit : num.toCharArray()) {
			// while removals remain and the top digit is bigger than current,
			// pop it - dropping a larger high-place digit shrinks the number most
			while (k > 0 && stack.length() > 0 && stack.charAt(stack.length() - 1) > digit) {
				stack.deleteCharAt(stack.length() - 1);
				k--;
			}
			stack.append(digit);
		}

		// digits were non-decreasing; remove any leftover k from the end
		while (k > 0) {
			stack.deleteCharAt(stack.length() - 1);
			k--;
		}

		// strip leading zeros
		int start = 0;
		while (start < stack.length() && stack.charAt(start) == '0') {
			start++;
		}

		String result = stack.substring(start);

		return result.isEmpty() ? "0" : result;
	}
}
