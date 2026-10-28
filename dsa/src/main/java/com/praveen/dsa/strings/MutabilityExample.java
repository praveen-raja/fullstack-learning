package com.praveen.dsa.strings;

/*
 * ============================================================================
 * TOPIC: String immutability vs StringBuilder mutability
 * ----------------------------------------------------------------------------
 * Demonstrates WHY String is immutable and StringBuilder is mutable - a classic
 * interview gotcha.
 *
 * ============================================================================
 * EASY WAY TO THINK ABOUT IT
 * ----------------------------------------------------------------------------
 * A String can NEVER change once created. Methods like concat() don't modify
 * the original - they build and RETURN a brand-new String. If you don't capture
 * that return value, the result is thrown away and the original looks unchanged.
 *
 *      s.concat(" World");   // returns a new String, immediately lost
 *      s = s.concat(" World"); // THIS is how you'd keep it
 *
 * A StringBuilder is mutable: append() edits the SAME object in place, so no
 * reassignment is needed and no extra objects are created per edit.
 *
 * ============================================================================
 * WHY IT MATTERS (complexity)
 * ----------------------------------------------------------------------------
 * Building a string by repeated String + concat in a loop is O(N^2) (each
 * concat copies the whole string so far). StringBuilder.append is amortized
 * O(1), making loop building O(N). Prefer StringBuilder for heavy concatenation.
 * ============================================================================
 */
public class MutabilityExample {
    public static void main(String[] args) {

        // --- IMMUTABLE (String) ---
        String s = "Hello";
        s.concat(" World"); // returns a NEW string that is discarded (not reassigned)

        System.out.println("String Result: " + s);
        // Output: Hello  -> original unchanged because concat's result was lost

        // --- MUTABLE (StringBuilder) ---
        StringBuilder sb = new StringBuilder("Hello");
        sb.append(" World"); // edits the same object in place

        System.out.println("StringBuilder Result: " + sb);
        // Output: Hello World
    }
}
