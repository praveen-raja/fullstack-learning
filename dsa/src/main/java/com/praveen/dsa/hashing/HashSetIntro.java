package com.praveen.dsa.hashing;

import java.util.HashSet;
import java.util.Set;

/*
 * ============================================================================
 * TOPIC: HashSet API tour
 * ----------------------------------------------------------------------------
 * Not a problem - a hands-on reference for the common HashSet methods: isEmpty,
 * add, toString, (and in general: contains, remove, size, clear).
 *
 * ============================================================================
 * WHY A HASHSET (the mental model)
 * ----------------------------------------------------------------------------
 * A HashSet stores UNIQUE values with O(1) average add/contains. It is the go-to
 * for "have I already seen this value?" problems - e.g. detecting duplicates, or
 * the prefix-sum "seen totals" trick for zero-sum subarrays.
 *
 * Handy detail: add(x) RETURNS a boolean - true if x was new, false if x was
 * already present. That true/false is often the whole answer to a dedup check.
 *
 * ============================================================================
 * COMPLEXITY (average case)
 * ----------------------------------------------------------------------------
 *  add / contains / remove : O(1) average  (O(N) worst if many hash collisions)
 *  Space                   : O(N)
 *
 * ----------------------------------------------------------------------------
 * NOTE: the large commented-out block below is leftover HashMap-style code
 * (containsKey/values/entrySet/getOrDefault) that does NOT apply to a Set.
 * Left as-is; only the active add/isEmpty demo runs.
 * ============================================================================
 */
public class HashSetIntro {
	public static void main(String[] args) {
		hashsetMethods();
	}

	private static void hashsetMethods() {

		Set set = new HashSet<>();

		// isEmpty()
		System.out.println("Is Set Empty : " + set.isEmpty());

		// add()
		set.add(1);
		set.add(2);
		// add() returns true when the value is newly added
		System.out.println(set.add(3));
		// add() returns false when the value already exists
		System.out.println(set.add(3));

		System.out.println(set.toString());

//		// NOTE: the following are HashMap methods, not valid on a Set - left for reference.
//		// containsKey()
//		System.out.println("Map contain key 1 : " + set.containsKey(1));
//
//		// containsValue()
//		System.out.println("Map contain value ONE : " + set.containsValue("ONE"));
//		System.out.println();
//
//		// keySet()
//		set.keySet().forEach(t -> System.out.println(t));
//		System.out.println();
//
//		// values()
//		set.values().forEach(t -> System.out.println(t));
//		System.out.println();
//
//		// entrySet()
//		set.entrySet().forEach(t -> System.out.println(t));
//		System.out.println();
//
//		// putIfAbsent()
//		set.putIfAbsent(3, "THREE");
//		System.out.println(set.toString());
//		System.out.println();
//
//		// getOrDefault()
//		System.out.println(set.getOrDefault(3, "NO VALUE"));
//		System.out.println();
//
//		// remove(key, value)
//		System.out.println(set.remove(3, "THREE"));
//
//		// remove(key)
//		System.out.println(set.remove(2));
//		System.out.println(set.toString());
//		System.out.println();
//
//		// size()
//		System.out.println(set.size());
//		System.out.println();
//
//		// clear()
//		set.clear();
//
//		System.out.println(set.toString());

	}
}
