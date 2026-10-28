package com.praveen.javacore.designpatterns.creational.singleton.phase3;

/*
 * RUNNER for SingletonPhase3 (synchronized method). Both getInstance() calls
 * return the SAME object. NOTE: `static void main()` (no args) is not a JVM
 * entry point. As-is.
 */
public class Main {
    static void main() {
        SingletonPhase3 instance = SingletonPhase3.getInstance();
        SingletonPhase3 instance2 = SingletonPhase3.getInstance();
    }
}
