package com.praveen.javacore.basics;

/*
 * ============================================================================
 * TOPIC: interface (the contract)  [renamed from B]
 * ----------------------------------------------------------------------------
 * Part of a small interface + inheritance demo:
 *      Greeting (interface)
 *        ^ implemented by ConsoleGreeting
 *                           ^ extended by GreetingDemo (has main)
 *
 * ============================================================================
 * EASY WAY TO THINK ABOUT IT
 * ----------------------------------------------------------------------------
 * An interface is a promise: "anything that is a Greeting can printHello()".
 * It says WHAT, not HOW. A class that implements it must supply the HOW.
 * ============================================================================
 */
public interface Greeting {

	public void printHello();
}
