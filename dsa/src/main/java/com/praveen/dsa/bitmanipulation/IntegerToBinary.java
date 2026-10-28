package com.praveen.dsa.bitmanipulation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 * ============================================================================
 * QUESTION
 * ----------------------------------------------------------------------------
 * Convert a positive integer into its binary representation and print it.
 *
 * Example:  16 -> 10000
 *
 * ============================================================================
 * EASY WAY TO THINK ABOUT IT  (peel off the last bit, repeatedly)
 * ----------------------------------------------------------------------------
 * The last binary digit of a number is (num & 1). After reading it, shift the
 * number right by one (num >> 1) to expose the next digit. Repeat until the
 * number is 0. You read the bits LEAST-significant first, so collect them and
 * REVERSE at the end to print most-significant first.
 *
 *   16 = 10000
 *   &1, >>1  ->  0,0,0,0,1  (read order)  ->  reverse ->  1,0,0,0,0
 *
 * ============================================================================
 * OPTIMIZATION
 * ----------------------------------------------------------------------------
 *  Extract one bit per shift.  Time : O(log N)   Space : O(log N) for the list
 * ============================================================================
 */
public class IntegerToBinary {
	public static void main(String[] args) {

		int num = 16;
		findBinary1(num);
	}

	// Peel last bit (num & 1), shift right, repeat; reverse to print. TC = O(log N), SC = O(log N)
	private static void findBinary1(int num) {

		List<Integer> list = new ArrayList<>();

		while (num > 0) {
			list.add(num & 1); // read the last bit
			num = num >> 1;    // expose the next bit
		}
		Collections.reverse(list); // bits were collected LSB-first
		list.forEach(bit -> System.out.print(bit));
	}
}
