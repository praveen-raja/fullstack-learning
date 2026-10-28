package com.praveen.javacore.designpatterns.creational.prototype;

/*
 * ============================================================================
 * PATTERN: Prototype (creational) - the data class
 * ----------------------------------------------------------------------------
 * The Prototype pattern creates new objects by COPYING an existing instance
 * (the "prototype") instead of building from scratch - handy when construction
 * is expensive or you want an object pre-filled like another.
 *
 * ============================================================================
 * EASY WAY TO THINK ABOUT IT
 * ----------------------------------------------------------------------------
 * A full Prototype Student would offer a clone()/copy() method that returns a
 * NEW Student with the same field values. This class currently only has
 * name/age plus getters/setters - the clone/copy step is not implemented yet
 * (see StudentMain's note). The intent is: given one Student, stamp out copies.
 *
 * STATUS: scaffolding only - no copy()/clone() method present.
 * ============================================================================
 */
public class Student {

    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
