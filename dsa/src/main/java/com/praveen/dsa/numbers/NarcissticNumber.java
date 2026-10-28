package com.praveen.dsa.numbers;

import java.util.Scanner;

/*
 * ============================================================================
 * QUESTION
 * ----------------------------------------------------------------------------
 * Check whether a number is a narcissistic (Armstrong) number: an n-digit number
 * equal to the sum of the nth powers of its digits (n = the digit count).
 *
 * Example:  1634 = 1^4 + 6^4 + 3^4 + 4^4  ->  True
 *
 * ============================================================================
 * EASY WAY TO THINK ABOUT IT  (two passes)
 * ----------------------------------------------------------------------------
 * Pass 1: count how many digits the number has -> that is the power `n`.
 * Pass 2: peel each digit, raise it to the nth power, and add them up.
 * If the total equals the original number, it is narcissistic.
 * (Keep copies of the original - the digit-peeling destroys the working value.)
 *
 * ============================================================================
 * OPTIMIZATION
 * ----------------------------------------------------------------------------
 *  Two passes over the digits.  Time : O(digits)   Space : O(1)
 * ============================================================================
 */
public class NarcissticNumber {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		int num = input.nextInt();
		int temp = num;   // copy for pass 2
		int temp2 = num;  // copy for the final compare
		int power = 0;

		// pass 1: count digits -> power
		while (num != 0) {
			int rem = num % 10;
			num = num / 10;
			power++;
		}

		// pass 2: sum of (each digit ^ power)
		int ans = 0;
		while (temp != 0) {
			int rem = temp % 10;
			temp = temp / 10;
			ans = (int) (ans + Math.pow(rem, power));
		}

		if (temp2 == ans) {
			System.out.println("True");
		} else {
			System.out.println("False");
		}
	}

}
