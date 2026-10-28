package com.praveen.javacore.streams;
import java.util.*;
import java.util.stream.*;

/*
 * ============================================================================
 * TOPIC: map() vs flatMap()
 * ----------------------------------------------------------------------------
 * The single most confusing Streams method, made concrete with nested lists.
 *
 * ============================================================================
 * EASY WAY TO THINK ABOUT IT  (unnesting boxes)
 * ----------------------------------------------------------------------------
 * Data is List<List<String>> - lists inside a list.
 *   map()     transforms each element but keeps the nesting -> you still have
 *             Stream<List<String>> (a box inside a box).
 *   flatMap() takes each inner list, OPENS it (list.stream()), and merges all
 *             items into ONE flat stream -> Stream<String>.
 * Use flatMap whenever each element itself expands into multiple elements and
 * you want them all in a single flat stream.
 *
 * ============================================================================
 * COMPLEXITY
 * ----------------------------------------------------------------------------
 *  Time : O(total items across all inner lists)   Space : O(result)
 * ============================================================================
 */
public class FlatMapAnalysis {
    public static void main(String[] args) {

        // Scenario: A list of students, where each student has a list of registered courses.
        List<List<String>> studentCourses = Arrays.asList(
            Arrays.asList("Java", "Spring"),
            Arrays.asList("Python", "Django"),
            Arrays.asList("Java", "AWS")
        );

        System.out.println("Original Nested Structure: " + studentCourses);
        System.out.println("--------------------------------------------------");

        // --- 1. USING map() ---
        // map() transforms each inner list into... another list.
        // Result: Stream<List<String>> (Box inside a Box)
        List<List<String>> mappedResult = studentCourses.stream()
            .distinct()
            .collect(Collectors.toList());

        System.out.println("Result of map(): " + mappedResult); 
        // Notice: This looks like a list of Stream objects. Not very useful!


        // --- 2. USING flatMap() ---
        // flatMap() takes each inner list, opens it, and merges the items into the main stream.
        // Result: Stream<String> (One single flat list)
        List<String> flatMappedResult = studentCourses.stream()
            .flatMap(list -> list.stream()) // Flattens the nested lists
            .distinct()                    // Bonus: Remove duplicate "Java"
            .collect(Collectors.toList());

        System.out.println("Result of flatMap(): " + flatMappedResult);
        // Output: [Java, Spring, Python, Django, AWS]
    }
}