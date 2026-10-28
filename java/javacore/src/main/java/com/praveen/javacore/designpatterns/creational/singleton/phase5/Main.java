package com.praveen.javacore.designpatterns.creational.singleton.phase5;

/*
 * RUNNER for SingletonPhase5 (double-checked locking). Both getInstance() calls
 * return the SAME object; the lock is paid only on the first call. NOTE:
 * `static void main()` (no args) is not a JVM entry point. As-is.
 */
public class Main {
    static void main() {
        SingletonPhase5 instance = SingletonPhase5.getInstance();
        SingletonPhase5 instance2 = SingletonPhase5.getInstance();
    }
}
