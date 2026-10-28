package com.praveen.dsa.arrays.problems;

/*
 * ============================================================================
 * QUESTION
 * ----------------------------------------------------------------------------
 * Search for a target value in a SORTED array and return its index, or -1 if
 * it is not present.
 *
 * ============================================================================
 * EASY WAY TO THINK ABOUT IT  (the dictionary / guessing game)
 * ----------------------------------------------------------------------------
 * The array is sorted, so look at the MIDDLE element and compare:
 *   - middle == target  -> found it
 *   - middle <  target  -> the answer must be in the RIGHT half, ignore left
 *   - middle >  target  -> the answer must be in the LEFT half, ignore right
 * Every comparison throws away HALF of what's left. That's why it is log(N).
 *
 * Overflow note: mid = low + (high - low) / 2 instead of (low + high) / 2,
 * because (low + high) can overflow int for very large indices.
 *
 * ============================================================================
 * OPTIMIZATION
 * ----------------------------------------------------------------------------
 *  Binary search (iterative).
 *            Time  : O(log N)
 *            Space : O(1)
 *  (A linear scan would be O(N); binary search needs the array sorted first.)
 * ============================================================================
 */
public class BinarySearchExample {

    // Iterative binary search. TC = O(log N), SC = O(1)
    public static int binarySearch(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            // Using (low + high) / 2 can overflow for large indices; this form is safe.
            int mid = low + (high - low) / 2;

            if (arr[mid] == target) {
                return mid; // target found
            }

            if (arr[mid] < target) {
                low = mid + 1; // discard left half, search right
            } else {
                high = mid - 1; // discard right half, search left
            }
        }

        return -1; // target not found
    }

    public static void main(String[] args) {
        int[] sortedArray = { 10, 20, 30, 40, 50, 60, 70 };
        int target = 40;

        int result = binarySearch(sortedArray, target);

        if (result != -1) {
            System.out.println("Element found at index: " + result);
        } else {
            System.out.println("Element not found.");
        }
    }
}
