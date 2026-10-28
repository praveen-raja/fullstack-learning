package com.praveen.javacore.designpatterns.creational.prototype;

/*
 * ============================================================================
 * RUNNER for the Prototype-pattern Student.
 * ----------------------------------------------------------------------------
 * EASY WAY TO THINK ABOUT IT
 *   The goal of Prototype is: copy student1 into a brand-new student2 that has
 *   the same values but is an INDEPENDENT object.
 *
 * STATUS: INCOMPLETE / BUGGY (left as-is):
 *   - `Student student2 = student1;` does NOT clone - it just makes student2
 *     point at the SAME object (so later edits hit the same instance).
 *   - `new Student();` creates an object and immediately throws it away.
 *   - The intended version would be: student2 = student1.copy(); where copy()
 *     returns a new Student carrying student1's field values.
 *   - Also `static void main()` (no String[] args) is not a JVM entry point.
 * ============================================================================
 */
public class StudentMain {
    static void main() {
        Student student1 = new Student();
        student1.setAge(21);
        student1.setName("Karthika");

        Student student2 = student1; // BUG: alias, not a copy (should be a clone)
        new Student();               // created and discarded
        student2.setAge(student1.getAge());
        student2.setName(student1.getName());
    }
}
