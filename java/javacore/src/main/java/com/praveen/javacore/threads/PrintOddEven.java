package com.praveen.javacore.threads;

/*
 * ============================================================================
 * QUESTION  (classic concurrency exercise)
 * ----------------------------------------------------------------------------
 * Use two threads to print numbers 1..MAX in order: one thread prints only ODD
 * numbers, the other only EVEN, and they must alternate (1, 2, 3, 4, ...).
 *
 * ============================================================================
 * EASY WAY TO THINK ABOUT IT  (wait / notify hand-off)
 * ----------------------------------------------------------------------------
 * Both threads share one Printer object and one `count`. They take turns using
 * wait()/notifyAll() on that shared lock:
 *   - the odd thread, if count is currently even, calls wait() (sleeps and
 *     releases the lock); when it's odd it prints, increments, then notifyAll()
 *     to wake the even thread.
 *   - the even thread does the mirror image.
 * Because the methods are `synchronized`, only one runs the critical section at
 * a time, and the wait/notify dance enforces strict alternation.
 *
 * Key points:
 *   - wait() must be called inside synchronized and inside a WHILE loop (guards
 *     against spurious wakeups), which this code does correctly.
 *   - notifyAll() wakes the other waiting thread to take its turn.
 *
 * ============================================================================
 * COMPLEXITY
 * ----------------------------------------------------------------------------
 *  Each number handled once.  Time : O(MAX)   Space : O(1)
 * ============================================================================
 */
public class PrintOddEven {

	public static void main(String[] args) {

		Printer printer = new Printer(20);

		Thread oddThread = new Thread(() -> {
			printer.printOdd();
		});

		Thread evenThread = new Thread(() -> {
			printer.printEven();
		});

		oddThread.start();
		evenThread.start();
	}
}

// Shared object holding the lock and the running counter.
class Printer {

	private int MAX;
	private int count = 1;

	public Printer(int max) {
		this.MAX = max;
	}

	// Prints odd numbers; waits while it is the even thread's turn.
	public synchronized void printOdd() {
		while (count <= MAX) {
			while (count % 2 == 0) {        // not my turn -> release lock and sleep
				try {
					wait();
				} catch (InterruptedException e) {
					Thread.currentThread().interrupt();
				}
			}

			if (count <= MAX) {
				System.out.println("Odd Thread:" + Thread.currentThread().getName() + ", " + count);
				count++;
			}

			notifyAll();                    // wake the even thread
		}
	}

	// Prints even numbers; waits while it is the odd thread's turn.
	public synchronized void printEven() {
		while (count <= MAX) {
			while (count % 2 != 0) {        // not my turn -> release lock and sleep
				try {
					wait();
				} catch (InterruptedException e) {
					Thread.currentThread().interrupt();
				}
			}

			if (count <= MAX) {
				System.out.println("Even Thread:" + Thread.currentThread().getName() + ", " + count);
				count++;
			}

			notifyAll();                    // wake the odd thread
		}
	}
}
