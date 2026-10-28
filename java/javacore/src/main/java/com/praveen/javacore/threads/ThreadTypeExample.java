package com.praveen.javacore.threads;

/*
 * ============================================================================
 * TOPIC: daemon vs user (non-daemon) threads
 * ----------------------------------------------------------------------------
 * Shows that the JVM exits as soon as all USER threads finish, killing any
 * daemon threads instantly - even mid-loop.
 *
 * ============================================================================
 * EASY WAY TO THINK ABOUT IT
 * ----------------------------------------------------------------------------
 * A DAEMON thread is a background helper (think: GC, housekeeping). The JVM
 * stays alive only while at least one USER thread is running; daemons do not
 * count. Here the daemon loops forever, but once main (a user thread) finishes
 * its 2 seconds, the JVM shuts down and the daemon is terminated abruptly.
 *
 * Consequence: the daemon's `finally` cleanup likely NEVER runs - the JVM does
 * not wait for daemons to tidy up. So don't rely on daemon threads for work
 * that must complete (flushing, closing files, etc.).
 *
 * setDaemon(true) must be called BEFORE start().
 *
 * ============================================================================
 * COMPLEXITY
 * ----------------------------------------------------------------------------
 *  O(1) - a timing/lifecycle demonstration.
 * ============================================================================
 */
public class ThreadTypeExample {
    public static void main(String[] args) throws InterruptedException {

        Thread daemonThread = new Thread(() -> {
            try {
                while (true) {
                    System.out.println("Daemon thread is running in the background...");
                    Thread.sleep(150);
                }
            } catch (InterruptedException e) {
                System.out.println("Daemon thread interrupted.");
            } finally {
                // likely NEVER prints: the JVM kills the daemon on exit
                System.out.println("Daemon thread cleaning up...");
            }
        });

        daemonThread.setDaemon(true); // must be set before start()
        daemonThread.start();

        // main is a USER thread; the JVM lives only as long as it runs
        System.out.println("Main thread starting work...");
        Thread.sleep(2000);
        System.out.println("Main thread is finished. JVM will now exit.");

        // the infinite daemon loop is terminated immediately here
    }
}
