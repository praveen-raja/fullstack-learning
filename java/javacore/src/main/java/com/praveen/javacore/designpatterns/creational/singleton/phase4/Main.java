package com.praveen.javacore.designpatterns.creational.singleton.phase4;

/*
 * RUNNER for SingletonPhase4 (synchronized block). Both getInstance() calls
 * return the SAME object. NOTE: `static void main()` (no args) is not a JVM
 * entry point. As-is.
 */
public class Main {
    static void main() {
        SingletonPhase4 instance = SingletonPhase4.getInstance();
        SingletonPhase4 instance2 = SingletonPhase4.getInstance();
    }
}
