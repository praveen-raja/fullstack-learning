package com.praveen.javacore.concurrency;

import java.util.*;
import java.util.concurrent.*;

/*
 * ============================================================================
 * TOPIC: HashMap vs ConcurrentHashMap under multiple threads
 * ----------------------------------------------------------------------------
 * Shows two problems with a plain HashMap in concurrent code, and how
 * ConcurrentHashMap avoids them.
 *
 * ============================================================================
 * EASY WAY TO THINK ABOUT IT
 * ----------------------------------------------------------------------------
 * 1) Iteration + modification: modifying a HashMap WHILE iterating it throws
 *    ConcurrentModificationException. ConcurrentHashMap tolerates concurrent
 *    structural changes during iteration (testIteration demonstrates this).
 *
 * 2) Concurrent writes: many threads doing put() on a plain HashMap race on the
 *    internal buckets - entries get lost (final size < expected) or the map can
 *    even corrupt. ConcurrentHashMap uses fine-grained locking/CAS so all writes
 *    land and the final size matches threads * updates.
 *
 * Rule of thumb: never share a plain HashMap across threads that write to it;
 * reach for ConcurrentHashMap.
 *
 * ============================================================================
 * COMPLEXITY
 * ----------------------------------------------------------------------------
 *  put/get average O(1) for both; ConcurrentHashMap adds synchronization cost
 *  but scales across threads. Space O(N).
 * ============================================================================
 */
public class MapComparison {
    public static void main(String[] args) throws InterruptedException {

        MapComparison.testIteration();
        int threads = 10;
        int updatesPerThread = 1000;

        // plain HashMap - size can come out inconsistent under concurrent writes
        Map<String, Integer> unsafeMap = new HashMap<>();
        runMultithreadedUpdate(unsafeMap, "HashMap", threads, updatesPerThread);

        // ConcurrentHashMap - thread-safe writes, size matches expectation
        Map<String, Integer> safeMap = new ConcurrentHashMap<>();
        runMultithreadedUpdate(safeMap, "ConcurrentHashMap", threads, updatesPerThread);
    }

    // Modifying while iterating: fine for ConcurrentHashMap, CME for HashMap.
    public static void testIteration() {
        Map<String, String> map = new HashMap<>();
        map.put("1", "One");
        map.put("2", "Two");

        try {
            for (String key : map.keySet()) {
                System.out.println("Reading: " + key);
                map.put("3", "Three"); // structural change during iteration
            }
            System.out.println("ConcurrentHashMap iteration successful.");
        } catch (ConcurrentModificationException e) {
            System.out.println("HashMap would have crashed here!");
        }
    }

    // Fire `threads` writers, each doing `updates` puts, then compare final size.
    private static void runMultithreadedUpdate(Map<String, Integer> map, String label, int threads, int updates)
            throws InterruptedException {
        ExecutorService service = Executors.newFixedThreadPool(threads);

        for (int i = 0; i < threads; i++) {
            final int threadNum = i;
            service.execute(() -> {
                for (int j = 0; j < updates; j++) {
                    // unique key per update so a smaller size reveals lost writes, not overwrites
                    map.put(threadNum + "_" + j, j);
                }
            });
        }

        service.shutdown();
        service.awaitTermination(1, TimeUnit.MINUTES);

        System.out.println(label + " final size: " + map.size() + " (Expected: " + (threads * updates) + ")");
    }
}
