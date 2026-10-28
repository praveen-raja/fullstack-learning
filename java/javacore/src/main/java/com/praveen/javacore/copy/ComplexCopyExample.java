package com.praveen.javacore.copy;

import java.util.*;

/*
 * ============================================================================
 * TOPIC: shallow vs deep copy of a NESTED collection
 * ----------------------------------------------------------------------------
 * Extends the copy lesson to a List of HashMaps - the gotcha most people hit
 * with collection "copy constructors".
 *
 * ============================================================================
 * EASY WAY TO THINK ABOUT IT
 * ----------------------------------------------------------------------------
 * `new ArrayList<>(originalList)` makes a NEW list, but it copies the
 * REFERENCES - the new list points at the SAME HashMap objects. So editing a
 * map through the "shallow" list also changes it in the original (the output
 * shows the original's role flips to "Banned").
 *
 * A true DEEP copy must also clone each inner map:
 *      for (HashMap m : original) deepList.add(new HashMap<>(m));
 * Now editing the deep copy's maps leaves the originals untouched.
 *
 * Takeaway: a collection copy-constructor is only ONE level deep; nested mutable
 * elements still need to be copied by hand.
 *
 * ============================================================================
 * COMPLEXITY
 * ----------------------------------------------------------------------------
 *  shallow : O(N) references    |    deep : O(N * M) copying every inner entry
 * ============================================================================
 */
public class ComplexCopyExample {
    public static void main(String[] args) {
        // original: a list holding one user map
        ArrayList<HashMap<String, String>> originalList = new ArrayList<>();

        HashMap<String, String> user1 = new HashMap<>();
        user1.put("name", "Alice");
        user1.put("role", "Admin");
        originalList.add(user1);

        // SHALLOW: new list, but SAME inner HashMaps
        ArrayList<HashMap<String, String>> shallowList = new ArrayList<>(originalList);

        // DEEP: new list AND new inner HashMaps
        ArrayList<HashMap<String, String>> deepList = new ArrayList<>();
        for (HashMap<String, String> map : originalList) {
            deepList.add(new HashMap<>(map)); // copy each map's contents
        }

        // editing via the shallow copy leaks into the original
        System.out.println("Changing Shallow List...");
        shallowList.get(0).put("role", "Banned");
        System.out.println("Original List User Role: " + originalList.get(0).get("role"));
        // Output: Banned  -> shallow copy did NOT protect the data

        // editing via the deep copy does NOT touch the original
        System.out.println("\nChanging Deep List...");
        deepList.get(0).put("role", "SuperUser");
        System.out.println("Original List User Role: " + originalList.get(0).get("role"));
        // Output: Banned  -> original unchanged by the deep copy
    }
}
