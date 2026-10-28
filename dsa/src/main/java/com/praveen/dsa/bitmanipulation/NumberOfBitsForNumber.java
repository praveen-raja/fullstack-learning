package com.praveen.dsa.bitmanipulation;

/*
 * ============================================================================
 * QUESTION
 * ----------------------------------------------------------------------------
 * How many bits are needed to store a given number N?
 *
 * Example:  8 = 1000 needs 4 bits.
 *
 *   Decimal   Binary   bits
 *     0        0000      1
 *     1        0001      1
 *     2        0010      2
 *     3        0011      2
 *     4        0100      3
 *     7        0111      3
 *     8        1000      4
 *    11        1011      4
 *
 * ============================================================================
 * EASY WAY TO THINK ABOUT IT  (the math)
 * ----------------------------------------------------------------------------
 * n bits can store values from 0 up to (2^n - 1). So to store N we need the
 * smallest n with:
 *      N <= 2^n - 1
 *      N + 1 <= 2^n
 *      log2(N + 1) <= n
 *      n = ceil( log2(N + 1) )
 *
 * In code you could compute it as:  (int) Math.ceil(Math.log(N + 1) / Math.log(2))
 * or simply count shifts until the number becomes 0.
 *
 * ============================================================================
 * OPTIMIZATION
 * ----------------------------------------------------------------------------
 *  Counting shifts: O(log N).  Direct log2 formula: O(1).
 *
 * ----------------------------------------------------------------------------
 * STATUS: THEORY ONLY. main() is empty - this file documents the derivation
 * (N <= 2^n - 1  =>  n = ceil(log2(N+1))); no implementation written. Left as-is.
 * ============================================================================
 */
public class NumberOfBitsForNumber {
	public static void main(String[] args) {

	}
}
