package com.praveen.dsa.hashing;

/*
 * ============================================================================
 * QUESTION
 * ----------------------------------------------------------------------------
 * Given an array, decide whether there exist four elements A, B, C, D (at
 * distinct indices) such that A + B == C + D.
 *
 * Example:  { 1, 3, 2, 2 }  ->  1 + 3 == 2 + 2  (4 == 4)  ->  true
 *
 * ============================================================================
 * EASY WAY TO THINK ABOUT IT  (store each pair's sum in a hashmap)
 * ----------------------------------------------------------------------------
 * There are only O(N^2) pairs. Compute the sum of every pair (i, j) and store it
 * in a map: pairSum -> the pair of indices that produced it. The FIRST time you
 * compute a sum that already exists in the map - with four DISTINCT indices -
 * you've found A+B == C+D. This turns the naive O(N^4) (four nested loops) into
 * O(N^2).
 *
 * ============================================================================
 * OPTIMIZATION LEVELS
 * ----------------------------------------------------------------------------
 *  Level 1 - Brute force (find1): four nested loops.
 *            Time  : O(N^4)   Space : O(1)
 *
 *  Level 2 - Hashmap of pair-sums (find2, intended optimal)
 *            Time  : O(N^2)   Space : O(N^2)
 *
 * ----------------------------------------------------------------------------
 * STATUS: INCOMPLETE. find2 (the O(N^2) hashmap approach) is commented out /
 * unfinished - the distinct-index check and the sum-key lookup are not done.
 * Only the O(N^4) brute force find1 actually runs. Left as-is (WIP).
 * ============================================================================
 */
public class FourNumbersPairSumEqual {
	public static void main(String[] args) {

		int arr[] = { 3, 7, 71, 7, 3 };

		System.out.println(find1(arr));
	}

	// Level 2 (INCOMPLETE) - intended O(N^2) hashmap of pair-sums -> index pair.
	private static void find2(int[] arr) {
//		Map<Integer, Integer[]> hm = new HashMap<>();
//
//		for (int i = 0; i < arr.length; i++) {
//			for (int j = i+1; j < arr.length; j++) {
//				if (hm.containsKey(arr[i]+arr[j])) {
//					int sum = arr[i] + arr[j];
//					// TODO: verify the stored pair uses indices distinct from i and j
//				}
//			}
//		}
//		hm.forEach((key, values) -> System.out.println(key + " -> " + Arrays.toString(values)));
	}

	// Level 1 - brute force, four nested loops. TC = O(N^4), SC = O(1)
	private static boolean find1(int[] arr) {

		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				for (int k = j + 1; k < arr.length; k++) {
					for (int l = k + 1; l < arr.length; l++) {
						if (arr[i] + arr[j] == arr[k] + arr[l]) {
							System.out.println(arr[i] + "+" + arr[j] + " == " + arr[k] + "+" + arr[l]);
							return true;
						}
					}
				}
			}
		}
		return false;
	}
}
