package com.praveen.javacore.designpatterns.creational.singleton.phase1;

/*
 * ============================================================================
 * PATTERN: Singleton (creational) - PHASE 1 of 5: lazy, NOT thread-safe
 * ----------------------------------------------------------------------------
 * Singleton = exactly ONE instance of a class, reached through getInstance().
 * Recipe: private static field + private constructor + public getInstance().
 *
 * This phase creates the instance lazily (on first call). PROBLEM: with multiple
 * threads, two can both see `instance == null` at the same time and each create
 * an instance -> you get TWO. Fine for single-threaded code only.
 *
 * Progression:  phase1 lazy/unsafe -> phase2 eager -> phase3 synchronized method
 *               -> phase4 synchronized block -> phase5 double-checked locking (best).
 * ============================================================================
 */
public class SingletonPhase1 {
    private static SingletonPhase1 instance = null;

    private SingletonPhase1(){}

    public static SingletonPhase1 getInstance(){
        if(instance == null){
            instance = new SingletonPhase1();
        }
        return instance;
    }
}
