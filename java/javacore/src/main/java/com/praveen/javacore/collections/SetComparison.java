package com.praveen.javacore.collections;

import java.util.*;

/*
 * ============================================================================
 * TOPIC: HashSet vs TreeSet (ordering)
 * ----------------------------------------------------------------------------
 * Both store unique elements; the difference is ORDER.
 *
 * ============================================================================
 * EASY WAY TO THINK ABOUT IT
 * ----------------------------------------------------------------------------
 *   HashSet  -> backed by a hash table. No ordering guarantee; iteration order
 *               looks "random". Fastest: add/contains O(1) average.
 *   TreeSet  -> backed by a red-black tree. Keeps elements SORTED (natural order
 *               or a Comparator). add/contains O(log N).
 *
 * Pick HashSet when you only need uniqueness and speed; pick TreeSet when you
 * need the elements kept in sorted order (or range queries like first/last,
 * ceiling/floor).
 *
 * ============================================================================
 * COMPLEXITY
 * ----------------------------------------------------------------------------
 *  HashSet : add/contains/remove O(1) avg      Space O(N)
 *  TreeSet : add/contains/remove O(log N)      Space O(N)
 * ============================================================================
 */
public class SetComparison {
    public static void main(String[] args) {

        // HashSet: hash table, no guaranteed order
        Set<String> hashSet = new HashSet<>();

        // TreeSet: red-black tree, elements kept sorted
        Set<String> treeSet = new TreeSet<>();

        String[] data = { "Banana", "Apple", "Dragonfruit", "Cherry" };

        for (String fruit : data) {
            hashSet.add(fruit);
            treeSet.add(fruit);
        }

        System.out.println("HashSet (unordered): " + hashSet);
        System.out.println("TreeSet (sorted):    " + treeSet);
    }
}
