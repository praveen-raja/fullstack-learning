package com.praveen.javacore.designpatterns.creational.singleton.phase1;

/*
 * RUNNER for SingletonPhase1. Calls getInstance() twice - both references point
 * at the SAME single object (that is the whole point of a singleton).
 * NOTE: `static void main()` has no String[] args, so it is NOT a JVM entry
 * point (won't run via java/exec:java); it is an illustrative snippet. As-is.
 */
public class Main {
    static void main() {
        SingletonPhase1 instance = SingletonPhase1.getInstance();
        SingletonPhase1 instance2 = SingletonPhase1.getInstance();
    }
}
