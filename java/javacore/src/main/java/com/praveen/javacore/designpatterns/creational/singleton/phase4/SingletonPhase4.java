package com.praveen.javacore.designpatterns.creational.singleton.phase4;

/*
 * ============================================================================
 * PATTERN: Singleton - PHASE 4 of 5: synchronized BLOCK (still locks every call)
 * ----------------------------------------------------------------------------
 * Move the lock from the whole method to a synchronized BLOCK inside it. The
 * null-check here sits INSIDE the lock, so every caller still has to acquire
 * the monitor before reaching it - effectively the same cost as phase 3.
 *
 * TRADE-OFF: no real improvement over phase 3; it is the stepping stone to the
 * fix. Phase 5 adds a check BEFORE the lock so the lock is taken only once.
 * ============================================================================
 */
public class SingletonPhase4 {
    private static SingletonPhase4 instance = null;

    private SingletonPhase4(){}

    public static SingletonPhase4 getInstance(){
        synchronized(SingletonPhase4.class) {
            if(instance == null){
                instance = new SingletonPhase4();
            }
        }
        return instance;
    }
}
