package com.praveen.javacore.analyze;

import java.util.ArrayList;
import java.util.List;

/*
 * ============================================================================
 * TOPIC: a deliberate memory leak in Java
 * ----------------------------------------------------------------------------
 * Even with a garbage collector, Java CAN leak memory: objects that are still
 * REACHABLE are never collected. This demo grows forever until OutOfMemoryError.
 *
 * ============================================================================
 * EASY WAY TO THINK ABOUT IT
 * ----------------------------------------------------------------------------
 * The GC only frees objects nothing points to. A `static` list lives for the
 * whole program, so everything added to it stays reachable and can never be
 * collected. Here we keep adding 1 MB byte[] chunks to that static list, so the
 * heap climbs steadily until it runs out -> OutOfMemoryError.
 *
 * The classic real-world version of this bug: caches/collections that you keep
 * adding to but never remove from (especially static ones).
 *
 * ============================================================================
 * WARNING
 * ----------------------------------------------------------------------------
 * This is MEANT to crash with OutOfMemoryError (useful for practising heap-dump
 * analysis). Run with a small heap, e.g. -Xmx64m, to hit it quickly.
 * ============================================================================
 */
public class MemoryLeakDemo {
    // static -> lives for the whole program -> contents can never be GC'd
    private static List<byte[]> leakContainer = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println("Starting memory leak... check your Heap Dump soon!");

        try {
            while (true) {
                // add a 1 MB chunk that stays reachable via the static list
                leakContainer.add(new byte[1024 * 1024]);

                Thread.sleep(5); // slow it down so you can watch it grow
                System.out.println("Current size: " + leakContainer.size() + " MB");
            }
        } catch (OutOfMemoryError e) {
            System.err.println("Reached OutOfMemoryError!");
            // stay alive briefly so a heap dump can complete
            try { Thread.sleep(10000); } catch (InterruptedException ie) {}
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
