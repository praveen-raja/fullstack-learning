package com.praveen.javacore.designpatterns.creational.builder;

/*
 * ============================================================================
 * RUNNER for the Builder-pattern Student.
 * ----------------------------------------------------------------------------
 * Shows the minimal call: get a builder and build() straight away (all fields
 * left at defaults). In real use you would chain setters in between, e.g.
 *     Student.getBuilder().setName("Asha").setMathsMark(90).build();
 *
 * NOTE: main() is declared `public static void main()` with NO String[] args,
 * so the JVM will NOT treat it as an entry point - this won't run via
 * `java`/exec:java. Kept as-is (it compiles; it's an illustrative snippet).
 * ============================================================================
 */
public class StudentMain {
    public static void main() throws Exception {
        Student student = Student.getBuilder().build();
    }
}
