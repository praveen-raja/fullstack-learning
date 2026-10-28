package com.praveen.javacore.analyze;

/*
 * ============================================================================
 * TOPIC: thread-safe Singleton via double-checked locking
 * ----------------------------------------------------------------------------
 * One shared instance of a heavy resource (a DB connection), created lazily and
 * safely even when many threads call getInstance() at once.
 *
 * ============================================================================
 * EASY WAY TO THINK ABOUT IT  (check, lock, check again)
 * ----------------------------------------------------------------------------
 * Creating the instance is expensive, so we only want to do it ONCE. Naive lazy
 * init (if null -> create) is racy: two threads could both see null and create
 * two instances. Double-checked locking fixes it:
 *   1) first check without locking (fast path once it already exists),
 *   2) if null, grab the class lock,
 *   3) check AGAIN inside the lock (another thread may have created it while we
 *      waited), then create.
 *
 * `volatile` on INSTANCE is essential: it prevents other threads from seeing a
 * half-constructed object due to instruction reordering.
 *
 * ============================================================================
 * COMPLEXITY
 * ----------------------------------------------------------------------------
 *  getInstance : O(1); the lock is taken only on the very first creation.
 * ============================================================================
 */
public class DatabaseConnection {
    // the single instance; volatile so a half-built object is never published
    private static volatile DatabaseConnection INSTANCE;

    // private constructor -> no one else can `new` it
    private DatabaseConnection() {
        System.out.println("New Database Connection Created.");
    }

    // global access point
    public static DatabaseConnection getInstance() {
        if (INSTANCE == null) {                 // 1st check, no lock (fast path)
            synchronized (DatabaseConnection.class) {
                if (INSTANCE == null) {         // 2nd check, holding the lock
                    INSTANCE = new DatabaseConnection();
                }
            }
        }
        return INSTANCE;
    }
}
