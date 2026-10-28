package com.praveen.javacore.designpatterns.creational.singleton.phase3;

/*
 * ============================================================================
 * PATTERN: Singleton - PHASE 3 of 5: lazy + synchronized METHOD
 * ----------------------------------------------------------------------------
 * Make getInstance() `synchronized` so only one thread runs it at a time. This
 * fixes phase 1's race and keeps lazy loading.
 *
 * TRADE-OFF: EVERY call now acquires the lock - even after the instance already
 * exists and all we do is return it. That locking on every read is wasteful and
 * slow under heavy use. Phase 5 removes this cost.
 * ============================================================================
 */
public class SingletonPhase3 {
    private static SingletonPhase3 instance = null;

    private SingletonPhase3(){}

    public synchronized static SingletonPhase3 getInstance(){
        if(instance == null){
            instance = new SingletonPhase3();
        }
        return instance;
    }
}
