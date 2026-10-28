package com.praveen.javacore.designpatterns.creational.singleton.phase2;

/*
 * ============================================================================
 * PATTERN: Singleton - PHASE 2 of 5: EAGER initialization
 * ----------------------------------------------------------------------------
 * Build the single instance immediately at class-load time:
 *      private static SingletonPhase2 instance = new SingletonPhase2();
 * The JVM guarantees class initialization is thread-safe, so this is
 * automatically safe across threads with no locking.
 *
 * TRADE-OFF: the instance is created even if you never call getInstance() - no
 * lazy loading. Perfect when the object is cheap and always needed.
 * ============================================================================
 */
public class SingletonPhase2 {
    private static SingletonPhase2 instance = new SingletonPhase2();

    private SingletonPhase2(){}

    public static SingletonPhase2 getInstance(){
        return instance;
    }
}
