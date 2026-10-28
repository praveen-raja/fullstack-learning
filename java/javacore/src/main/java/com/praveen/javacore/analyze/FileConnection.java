package com.praveen.javacore.analyze;

/*
 * ============================================================================
 * TOPIC: thread-safe Singleton via double-checked locking (practice copy)
 * ----------------------------------------------------------------------------
 * Same pattern as DatabaseConnection, re-implemented for a "file connection".
 *
 * ============================================================================
 * EASY WAY TO THINK ABOUT IT
 * ----------------------------------------------------------------------------
 * private constructor + private static volatile INSTANCE + getInstance() that
 * checks-locks-checks. See DatabaseConnection for the full explanation of why
 * the double check and `volatile` are both required.
 *
 * NOTE: there is no main() here - it is a reusable singleton class, not a demo.
 * ============================================================================
 */
public class FileConnection {

	private static volatile FileConnection INSTANCE;

	private FileConnection() {}

	public static final FileConnection getInstance() {
		if (INSTANCE == null) {                  // 1st check, no lock
			synchronized (FileConnection.class) {
				if (INSTANCE == null) {          // 2nd check, under lock
					INSTANCE = new FileConnection();
				}
			}
		}
		return INSTANCE;
	}
}
