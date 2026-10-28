package com.praveen.dsa.arrays;

import java.util.ArrayList;

/*
 * ============================================================================
 * QUESTION  (asked at Google)
 * ----------------------------------------------------------------------------
 * Design/identify a data structure that gives both:
 *   a) flexible size (grows as you add items)
 *   b) O(1) random access (jump straight to index i)
 *
 * In Java that structure is ArrayList (backed by a resizable array).
 *
 * ============================================================================
 * EASY WAY TO THINK ABOUT IT
 * ----------------------------------------------------------------------------
 * A plain array gives O(1) access but a FIXED size. A linked list grows freely
 * but access is O(N). A dynamic array (ArrayList) gets the best of both: it
 * stores items in a backing array for O(1) indexing, and when it runs out of
 * room it allocates a bigger array (usually ~1.5x) and copies everything over.
 *
 * That occasional copy is O(N), but it happens rarely, so the AVERAGE cost of
 * an add stays O(1) - this is called "amortized O(1)".
 *
 * ============================================================================
 * COMPLEXITY (ArrayList)
 * ----------------------------------------------------------------------------
 *  get(i)      : O(1)
 *  add(x)      : O(1) amortized   (O(N) on the resize that copies)
 *  add(i, x)   : O(N)             (shift elements to make room)
 *  remove(i)   : O(N)             (shift elements to close the gap)
 *  Space       : O(N)
 *
 * ----------------------------------------------------------------------------
 * STATUS: STUB. main() only creates an empty ArrayList to point at the answer;
 * no custom implementation is written. Left as-is.
 * ============================================================================
 */
public class DynamicArray {
	public static void main(String[] args) {
		ArrayList list = new ArrayList();
	}
}
