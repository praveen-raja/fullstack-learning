package com.praveen.javacore.basics;

import java.util.HashMap;

/*
 * ============================================================================
 * TOPIC: inheritance + running the interface demo  [renamed from A]
 * ----------------------------------------------------------------------------
 * GreetingDemo EXTENDS ConsoleGreeting, so it inherits printHello(). main()
 * creates a ConsoleGreeting and calls the inherited behaviour.
 *
 * ============================================================================
 * EASY WAY TO THINK ABOUT IT
 * ----------------------------------------------------------------------------
 * Chain of relationships:
 *   Greeting (interface)  ->  ConsoleGreeting (implements it)  ->  GreetingDemo
 *   (extends ConsoleGreeting). By extending, GreetingDemo gets printHello() for
 *   free. The code here news up a ConsoleGreeting and invokes printHello().
 *
 * (The empty HashMap is leftover scratch from the original demo - harmless.)
 * ============================================================================
 */
public class GreetingDemo extends ConsoleGreeting {
	public static void main(String[] args) {
		ConsoleGreeting b = new ConsoleGreeting();

		HashMap<Integer, Integer> hmap = new HashMap<>();

		b.printHello();
	}
}
