package com.praveen.javacore.copy;

/*
 * ============================================================================
 * TOPIC: shallow copy vs deep copy (object graphs)
 * ----------------------------------------------------------------------------
 * Runner for the Student/Address classes (see Address.java). Shows the
 * practical difference between copying references and copying the actual nested
 * objects.
 *
 * ============================================================================
 * EASY WAY TO THINK ABOUT IT
 * ----------------------------------------------------------------------------
 * A Student holds an Address.
 *   - SHALLOW copy duplicates the Student but both Students point at the SAME
 *     Address. Change the copy's city and the original's city changes too -
 *     they share one Address object.
 *   - DEEP copy duplicates the Student AND builds a NEW Address with the same
 *     data. Now the two are fully independent; changing one leaves the other
 *     untouched.
 *
 * Rule: shallow copy shares nested mutable objects; deep copy clones them so
 * nothing is shared.
 * ============================================================================
 */
public class ShallowVsDeepCopyDemo {
    public static void main(String[] args) {
        Address commonAddress = new Address("New York");
        Student student1 = new Student("Alice", commonAddress);

        // --- SHALLOW COPY: both students share the SAME Address ---
        Student shallowStudent = student1.shallowCopy();
        shallowStudent.address.city = "London";

        System.out.println("Original City after Shallow change: " + student1.address.city);
        // Output: London  -> original WAS affected (shared Address)

        // --- DEEP COPY: copy gets its OWN Address ---
        student1.address.city = "New York"; // reset
        Student deepStudent = student1.deepCopy();
        deepStudent.address.city = "Paris";

        System.out.println("Original City after Deep change: " + student1.address.city);
        // Output: New York -> original safe (independent Address)
    }
}
