package com.praveen.dsa.numbers;

import java.util.Scanner;

/*
 * ============================================================================
 * QUESTION
 * ----------------------------------------------------------------------------
 * Given a range [num1, num2], count how many prime numbers lie within it
 * (inclusive).
 *
 * ============================================================================
 * EASY WAY TO THINK ABOUT IT
 * ----------------------------------------------------------------------------
 * Walk every number in the range and test primality. For the primality test use
 * the sqrt(N) trick (loop while j*j <= i): if nothing divides i up to its square
 * root, i is prime. Skip 0 and 1 (not prime). Count the primes.
 *
 * ============================================================================
 * OPTIMIZATION LEVELS
 * ----------------------------------------------------------------------------
 *  Level 1 - test each number with sqrt(N) primality (this file)
 *            Time  : O((num2 - num1) * sqrt(num2))   Space : O(1)
 *
 *  Level 2 - Sieve of Eratosthenes (NOT implemented): precompute all primes up
 *            to num2 by crossing out multiples.
 *            Time  : O(N log log N)   Space : O(N)
 * ============================================================================
 */
public class CountPrimesInRange {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		int num1 = input.nextInt();
		int num2 = input.nextInt();
		int count = 0;

		for (int i = num1; i <= num2; i++) {

			if (i == 1 || i == 0) {   // 0 and 1 are not prime
				continue;
			}

			int flag = 1; // assume prime until a divisor is found
			for (int j = 2; j * j <= i; j++) { // sqrt(i) primality test
				if ((i % j) == 0) {
					flag = 0;
					break;
				}
			}

			if (flag == 1) {
				count++;
			}
		}

		System.out.println(count);
	}
}
