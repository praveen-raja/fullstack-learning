package com.praveen.javacore.copy;

/*
 * ============================================================================
 * TOPIC: supporting classes for the shallow-vs-deep copy demo
 * ----------------------------------------------------------------------------
 * Address is a small mutable object. Student HAS-A Address, and offers two copy
 * methods so the demo (ShallowVsDeepCopyDemo) can contrast them.
 *
 * ============================================================================
 * EASY WAY TO THINK ABOUT IT
 * ----------------------------------------------------------------------------
 *   shallowCopy(): new Student but REUSES the same Address reference
 *                  -> copies share one Address (changes bleed across).
 *   deepCopy():    new Student AND a brand-new Address with the same city
 *                  -> copies are fully independent.
 *
 * The whole lesson lives in that one line of difference inside deepCopy():
 * building a `new Address(...)` instead of passing the existing one along.
 * ============================================================================
 */
class Address {
    String city;
    Address(String city) { this.city = city; }
}

class Student implements Cloneable {
    String name;
    Address address;

    Student(String name, Address address) {
        this.name = name;
        this.address = address;
    }

    // Shallow copy: reuses the SAME Address reference (shared)
    public Student shallowCopy() {
        return new Student(this.name, this.address);
    }

    // Deep copy: creates a NEW Address so nothing is shared
    public Student deepCopy() {
        Address newAddr = new Address(this.address.city);
        return new Student(this.name, newAddr);
    }
}
