package com.praveen.dsa.math;

import java.util.Scanner;

/*
 * ============================================================================
 * QUESTION
 * ----------------------------------------------------------------------------
 * Read a count, then that many integers, and print each with its digits
 * reversed.
 *
 * Example:  1234 -> 4321
 *
 * ============================================================================
 * EASY WAY TO THINK ABOUT IT  (peel digits with %10 and /10)
 * ----------------------------------------------------------------------------
 * n % 10  gives the LAST digit.   n / 10  removes the last digit.
 * Build the reversed number by shifting what you have left by one place and
 * dropping the new last digit on the end:
 *      rev = rev * 10 + (n % 10)
 *
 *   n = 1234:  rev 0->4->43->432->4321 ; n 1234->123->12->1->0
 *
 * ============================================================================
 * OPTIMIZATION
 * ----------------------------------------------------------------------------
 *  One pass over the digits.  Time : O(number of digits) = O(log10 N)   Space : O(1)
 *
 * NOTE: a very large reversed value can overflow int (e.g. reversing 1000000003).
 * ============================================================================
 */
public class ReverseANumber {
	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		int listOfNumber = input.nextInt();
		int arrayOfNumber[] = new int[listOfNumber];

		for (int i = 0; i < listOfNumber; i++) {
			arrayOfNumber[i] = input.nextInt();
		}

		for (int i = 0; i < listOfNumber; i++) {

			int rev = 0;
			while (arrayOfNumber[i] != 0) {
				int rem = arrayOfNumber[i] % 10;     // last digit
				rev = (rev * 10) + rem;              // append it to rev
				arrayOfNumber[i] = arrayOfNumber[i] / 10; // drop last digit
			}
			System.out.println(rev);
		}

		input.close();
	}
}
