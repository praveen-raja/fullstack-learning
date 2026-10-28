package com.praveen.dsa.hashing;

import java.util.HashMap;
import java.util.Map;

/*
 * ============================================================================
 * TOPIC: HashMap API tour
 * ----------------------------------------------------------------------------
 * Not a problem - a hands-on reference for the common HashMap methods you reach
 * for in DSA: put, get, containsKey/Value, keySet/values/entrySet, putIfAbsent,
 * getOrDefault, remove, size, clear.
 *
 * ============================================================================
 * WHY A HASHMAP (the mental model)
 * ----------------------------------------------------------------------------
 * A HashMap stores key -> value pairs and finds a key in O(1) AVERAGE time by
 * hashing the key to a bucket. This is the workhorse for "have I seen this
 * before?", frequency counting, and prefix-sum lookups in array problems.
 *
 * ============================================================================
 * COMPLEXITY (average case)
 * ----------------------------------------------------------------------------
 *  put / get / containsKey / remove : O(1) average  (O(N) worst if many collide)
 *  containsValue                    : O(N)          (scans all values)
 *  Space                            : O(N)
 *
 *  Method notes used below:
 *   - putIfAbsent(k,v): returns null if it added; else the EXISTING value.
 *   - getOrDefault(k,d): value for k, or d if k absent (no NPE, no insert).
 *   - remove(k,v): removes only if k currently maps to v; returns boolean.
 * ============================================================================
 */
public class HashMapIntro {
	public static void main(String[] args) {
		hashmapMethods();
	}

	private static void hashmapMethods() {
		Map<Integer, String> map = new HashMap<>();

		// isEmpty()
		System.out.println("Is Map Empty : " + map.isEmpty());

		// put()
		map.put(1, "ONE");

		// containsKey()
		System.out.println("Map contain key 1 : " + map.containsKey(1));

		// containsValue()  (O(N) - scans values)
		System.out.println("Map contain value ONE : " + map.containsValue("ONE"));
		System.out.println();

		// keySet()
		map.keySet().forEach(t -> System.out.println(t));
		System.out.println();

		// values()
		map.values().forEach(t -> System.out.println(t));
		System.out.println();

		// entrySet()
		map.entrySet().forEach(t -> System.out.println(t));
		System.out.println();

		// putIfAbsent() -> null if it added a new value; otherwise the existing value
		System.out.println(map.putIfAbsent(7, "SEVEN"));
		System.out.println(map.toString());
		System.out.println();

		// getOrDefault()
		System.out.println(map.getOrDefault(3, "NO VALUE"));
		System.out.println();

		// remove(key, value) -> true only if key currently maps to that value
		System.out.println(map.remove(3, "THREE"));

		// remove(key) -> removes the mapping if present
		System.out.println(map.remove(2));
		System.out.println(map.toString());
		System.out.println();

		// size()
		System.out.println(map.size());
		System.out.println();

		// clear()
		map.clear();

		System.out.println(map.toString());
	}
}
