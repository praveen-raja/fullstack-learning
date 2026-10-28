package com.praveen.javacore.designpatterns.creational.singleton.phase5;

/*
 * ============================================================================
 * PATTERN: Singleton - PHASE 5 of 5: DOUBLE-CHECKED LOCKING (best of the five)
 * ----------------------------------------------------------------------------
 * Combines lazy loading with cheap thread-safety:
 *   1) check instance == null WITHOUT locking (fast path once it exists),
 *   2) only if null, take the lock,
 *   3) check null AGAIN inside the lock (another thread may have built it),
 *      then create.
 * The lock is paid ONCE (at first creation); afterwards every call hits the
 * fast lock-free path and just returns the instance.
 *
 * `volatile` on `instance` is REQUIRED - it stops a thread from seeing a
 * half-constructed object due to instruction reordering.
 *
 * This is the same technique used by DatabaseConnection / FileConnection in the
 * analyze package.
 * ============================================================================
 */
public class SingletonPhase5 {
    private static volatile SingletonPhase5 instance = null;

    private SingletonPhase5(){}

    public static SingletonPhase5 getInstance(){
        if(instance == null){
            synchronized(SingletonPhase5.class) {
                if (instance == null) {
                    instance = new SingletonPhase5();
                }
            }
        }
        return instance;
    }
}
