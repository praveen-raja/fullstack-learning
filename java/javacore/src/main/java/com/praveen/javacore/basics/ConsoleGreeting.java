package com.praveen.javacore.basics;

/*
 * ============================================================================
 * TOPIC: implementing an interface  [renamed from C]
 * ----------------------------------------------------------------------------
 * ConsoleGreeting fulfills the Greeting contract by providing a concrete
 * printHello(). This is the "HOW" for the interface's "WHAT".
 *
 * ============================================================================
 * EASY WAY TO THINK ABOUT IT
 * ----------------------------------------------------------------------------
 * `implements Greeting` forces this class to define printHello(). Once it does,
 * a ConsoleGreeting can be used anywhere a Greeting is expected (polymorphism).
 * ============================================================================
 */
public class ConsoleGreeting implements Greeting {

	@Override
	public void printHello() {
		System.out.println("Hello");
	}

}
