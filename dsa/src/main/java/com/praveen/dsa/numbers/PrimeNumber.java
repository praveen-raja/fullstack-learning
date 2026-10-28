package com.praveen.dsa.numbers;

/*
 * ============================================================================
 * QUESTION
 * ----------------------------------------------------------------------------
 * Check whether a number is prime (divisible only by 1 and itself).
 *
 * ============================================================================
 * EASY WAY TO THINK ABOUT IT  (why sqrt(N) is enough)
 * ----------------------------------------------------------------------------
 * A number N is NOT prime if it has any divisor between 2 and N-1. But divisors
 * come in pairs: if d divides N, so does N/d. One of each pair is always <=
 * sqrt(N). So if no divisor exists up to sqrt(N), none exists at all - you can
 * stop checking at sqrt(N) instead of N. That is the big speedup.
 *
 * ============================================================================
 * OPTIMIZATION LEVELS
 * ----------------------------------------------------------------------------
 *  Level 1 - test divisors 2..N-1 (checkPrimeNumber1)       O(N)
 *  Level 2 - test divisors 2..N/2 (checkPrimeNumber2)       O(N/2) = O(N)
 *  Level 3 - test divisors 2..sqrt(N) (checkPrimeNumber3)   O(sqrt N)
 *  Level 4 - loop while i*i <= N (checkPrimeNumber4)         O(sqrt N), no Math.sqrt
 *            -> best; avoids the floating-point sqrt call.
 *  Space (all): O(1)
 * ============================================================================
 */
public class PrimeNumber {

	public static void main(String[] args) {

		int num = 7449447;

		if (checkPrimeNumber1(num)) {
			System.out.println("PrimeNumber");
		} else {
			System.out.println("Not a PrimeNumber");
		}

	}

	// Level 1 - divisors 2..N-1. TC = O(N), SC = O(1)
	private static boolean checkPrimeNumber1(int num) {
		if (num <= 1) {
			return false;
		} else {
			for (int i = 2; i <= num - 1; i++) { // N-2 comparisons
				if (num % i == 0) {
					return false;
				}
			}
			return true;
		}
	}

	// Level 2 - divisors 2..N/2. TC = O(N), SC = O(1)
	private static boolean checkPrimeNumber2(int num) {
		if (num <= 1) {
			return false;
		} else {
			for (int i = 2; i <= num / 2; i++) { // N/2 comparisons
				if (num % i == 0) {
					return false;
				}
			}
			return true;
		}
	}

	// Level 3 - divisors 2..sqrt(N). TC = O(sqrt N), SC = O(1)
	private static boolean checkPrimeNumber3(int num) {
		if (num <= 1) {
			return false;
		} else {
			int root = (int) Math.sqrt(num);
			for (int i = 2; i <= root; i++) { // sqrt(N) comparisons
				if (num % i == 0) {
					return false;
				}
			}
			return true;
		}
	}

	// Level 4 - loop while i*i <= N (same bound, no Math.sqrt). TC = O(sqrt N), SC = O(1)
	private static boolean checkPrimeNumber4(int num) {
		if (num <= 1) {
			return false;
		} else {
			// i <= sqrt(num)  <==>  i*i <= num
			for (int i = 2; i * i <= num; i++) {
				if (num % i == 0) {
					return false;
				}
			}
			return true;
		}
	}

}
