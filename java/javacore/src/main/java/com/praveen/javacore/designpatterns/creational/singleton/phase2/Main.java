package com.praveen.javacore.designpatterns.creational.singleton.phase2;

/*
 * RUNNER for SingletonPhase2 (eager). getInstance() twice returns the SAME
 * pre-built instance. NOTE: `static void main()` (no args) is not a JVM entry
 * point. As-is.
 */
public class Main {
    static void main() {
        SingletonPhase2 instance = SingletonPhase2.getInstance();
        SingletonPhase2 instance2 = SingletonPhase2.getInstance();
    }
}
