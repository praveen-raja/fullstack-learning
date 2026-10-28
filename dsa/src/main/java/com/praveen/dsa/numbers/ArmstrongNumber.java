package com.praveen.dsa.numbers;

import java.util.Scanner;

/*
 * ============================================================================
 * QUESTION
 * ----------------------------------------------------------------------------
 * Check whether a number is an Armstrong number (this 3-digit version): the sum
 * of the CUBES of its digits equals the number itself.
 *
 * Example:  370 = 3^3 + 7^3 + 0^3 = 27 + 343 + 0 = 370  ->  Armstrong
 *
 * ============================================================================
 * EASY WAY TO THINK ABOUT IT  (peel digits, cube, add)
 * ----------------------------------------------------------------------------
 * Pull digits off one at a time with %10 and /10, cube each, and accumulate.
 * Compare the sum to the original number.
 *
 * ============================================================================
 * OPTIMIZATION
 * ----------------------------------------------------------------------------
 *  One pass over the digits.  Time : O(number of digits)   Space : O(1)
 *
 * NOTE: this version hard-codes the power as 3 (cubes). A true Armstrong /
 * narcissistic check raises each digit to the power = digit count (see
 * NarcissticNumber). Also, it only prints the digit-cube sum, not a True/False.
 * ============================================================================
 */
public class ArmstrongNumber {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		int num = input.nextInt();

		int sum = 0;
		while (num != 0) {
			int rem = num % 10;        // last digit
			num = num / 10;            // drop it
			sum = sum + (rem * rem * rem); // add its cube
		}

		System.out.println(sum);
	}
}
