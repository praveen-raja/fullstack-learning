package com.praveen.javacore.keywords;

/*
 * ============================================================================
 * TOPIC: the `volatile` keyword (visibility between threads)
 * ----------------------------------------------------------------------------
 * Demonstrates WHY volatile matters: without it, one thread may never see a
 * change another thread made to a shared flag.
 *
 * ============================================================================
 * EASY WAY TO THINK ABOUT IT
 * ----------------------------------------------------------------------------
 * Each thread can keep its OWN cached copy of a variable for speed. The worker
 * thread loops on `keepRunning`; if that field is NOT volatile, the worker may
 * read a stale cached `true` forever and never notice main() set it to false ->
 * infinite loop. Marking it `volatile` forces every read/write to go to main
 * memory, so the worker sees the update and stops.
 *
 * volatile guarantees VISIBILITY (everyone sees the latest value). It does NOT
 * guarantee ATOMICITY of compound operations like count++ (see AtomicExample).
 *
 * ============================================================================
 * TRY IT
 * ----------------------------------------------------------------------------
 * Remove `volatile` and the worker may hang forever on some JVMs/hardware.
 * ============================================================================
 */
public class VolatileExample {
    // Try removing 'volatile' to see the potential infinite loop
    private static volatile boolean keepRunning = true;

    public static void main(String[] args) throws InterruptedException {
        Thread workerThread = new Thread(() -> {
            System.out.println("Worker thread started...");
            long count = 0;

            while (keepRunning) {
                // Without volatile, the worker may read a cached 'true' forever
                // and never see the update made by main().
                count++;
            }

            System.out.println("Worker thread stopped. Count: " + count);
        });

        workerThread.start();

        // let the worker spin for a second
        Thread.sleep(1000);

        System.out.println("Main thread is setting keepRunning to false...");
        keepRunning = false;

        workerThread.join();
        System.out.println("Main thread finished.");
    }
}
