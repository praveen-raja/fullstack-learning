package com.praveen.javacore.keywords;

import java.util.concurrent.atomic.AtomicInteger;

/*
 * ============================================================================
 * TOPIC: volatile vs AtomicInteger (visibility vs atomicity)
 * ----------------------------------------------------------------------------
 * Shows that `volatile` is NOT enough for count++ under many threads, while
 * AtomicInteger is.
 *
 * ============================================================================
 * EASY WAY TO THINK ABOUT IT
 * ----------------------------------------------------------------------------
 * `count++` is really THREE steps: read, add one, write back. Two threads can
 * read the same value, both add one, and both write back the same result - one
 * increment is LOST (a race condition). `volatile` makes the value visible but
 * does nothing about this read-modify-write race, so volatileCount ends up less
 * than expected.
 *
 * AtomicInteger.getAndIncrement() does the whole read-add-write as ONE
 * indivisible hardware operation (compare-and-swap under the hood), so no update
 * is ever lost -> atomicCount hits the expected total.
 *
 * ============================================================================
 * NOTE
 * ----------------------------------------------------------------------------
 * The t.join() loop is commented out, so main() may print BEFORE the worker
 * threads finish - results can look even more off. Uncomment the join loop to
 * see the final, settled values. (Left as-is.)
 * ============================================================================
 */
public class AtomicExample {
    // volatile: guarantees visibility, NOT atomicity
    private static volatile int volatileCount = 0;

    // AtomicInteger: guarantees visibility AND atomicity
    private static AtomicInteger atomicCount = new AtomicInteger(0);

    public static void main(String[] args) throws InterruptedException {
        int numThreads = 10;
        int incrementsPerThread = 1000;

        Thread[] threads = new Thread[numThreads];

        for (int i = 0; i < numThreads; i++) {
            threads[i] = new Thread(() -> {
                for (int j = 0; j < incrementsPerThread; j++) {
                    volatileCount++;               // race condition: updates can be lost
                    atomicCount.getAndIncrement();  // atomic: no update lost
                }
            });
            threads[i].start();
        }

        // for (Thread t : threads) t.join(); // NOTE: uncomment to wait for all threads

        System.out.println("Expected Result: " + (numThreads * incrementsPerThread));
        System.out.println("Volatile Result: " + volatileCount);
        System.out.println("Atomic Result:   " + atomicCount.get());
    }
}
