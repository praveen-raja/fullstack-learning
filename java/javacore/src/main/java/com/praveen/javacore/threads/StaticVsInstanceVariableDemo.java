package com.praveen.javacore.threads;

/*
 * ============================================================================
 * TOPIC: static vs instance variables
 * ----------------------------------------------------------------------------
 * (Despite living in the threads package, this is really about field sharing,
 * not concurrency.)
 *
 * ============================================================================
 * EASY WAY TO THINK ABOUT IT
 * ----------------------------------------------------------------------------
 * An INSTANCE variable (name) belongs to each object - every Student has its
 * own name. A STATIC variable (studentCount) belongs to the CLASS - there is
 * exactly one copy shared by all objects. The constructor bumps studentCount on
 * every `new`, so after creating two Students it reads 2, visible through the
 * class itself (Student.studentCount).
 *
 * Mental model: instance field = "one per object", static field = "one per
 * class, shared by all".
 *
 * ============================================================================
 * COMPLEXITY
 * ----------------------------------------------------------------------------
 *  O(1) - a language-semantics demonstration.
 * ============================================================================
 */

class Student {
    String name;              // instance variable - unique to each Student
    static int studentCount;  // static variable - shared by ALL Students

    Student(String name) {
        this.name = name;
        studentCount++;       // every new Student bumps the shared counter
    }
}

public class StaticVsInstanceVariableDemo {
    public static void main(String[] args) {
        Student s1 = new Student("Alice");
        Student s2 = new Student("Bob");

        System.out.println(s1.name); // Alice (own copy)
        System.out.println(s2.name); // Bob   (own copy)

        // both share the SAME studentCount
        System.out.println(Student.studentCount); // 2
    }
}
