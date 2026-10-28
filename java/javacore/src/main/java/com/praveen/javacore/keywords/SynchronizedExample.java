package com.praveen.javacore.keywords;

/*
 * ============================================================================
 * TOPIC: the `synchronized` keyword (mutual exclusion)
 * ----------------------------------------------------------------------------
 * Shows how a synchronized block makes count++ thread-safe by letting only one
 * thread into the critical section at a time.
 *
 * ============================================================================
 * EASY WAY TO THINK ABOUT IT  (one key to one room)
 * ----------------------------------------------------------------------------
 * `synchronized (lock)` means a thread must hold the `lock` object's monitor to
 * enter the block. Only one thread can hold it at a time, so count++ (the
 * unsafe read-add-write) runs without interference. Here join() waits for all
 * threads, so the final count reliably equals numThreads * incrementsPerThread.
 *
 * Any object can serve as a lock; a dedicated `private final Object lock` is a
 * common, clean choice.
 *
 * ============================================================================
 * TRADE-OFF
 * ----------------------------------------------------------------------------
 * Correct but slower than AtomicInteger here, because every increment acquires
 * and releases the monitor. For a single counter, AtomicInteger is lighter;
 * synchronized shines when you must guard SEVERAL operations as one unit.
 * ============================================================================
 */
public class SynchronizedExample {
    private static int count = 0;

    // the lock object - any object can act as a monitor
    private static final Object lock = new Object();

    public static void main(String[] args) throws InterruptedException {
        int numThreads = 10;
        int incrementsPerThread = 1000000;

        Thread[] threads = new Thread[numThreads];

        for (int i = 0; i < numThreads; i++) {
            threads[i] = new Thread(() -> {
                for (int j = 0; j < incrementsPerThread; j++) {
                    // only one thread at a time may run this block
                    synchronized (lock) {
                        count++;
                    }
                }
            });
            threads[i].start();
        }

        for (Thread t : threads) t.join(); // wait for all threads to finish

        System.out.println("Expected Result: " + (numThreads * incrementsPerThread));
        System.out.println("Actual Result:   " + count);
    }
}
