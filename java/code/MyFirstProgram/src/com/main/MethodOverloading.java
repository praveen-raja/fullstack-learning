package com.main;

public class MethodOverloading {

	public static void main(String[] args) {

		String name = "Praveen";
		int age = 23;

		hello(name, age);
		hello(name);
	}

	static void hello(String name) {
		System.out.println("Hello " + name);
	}

	static void hello(String name, int age) {
		System.out.println("Hello "+ name);
		System.out.println("You are "+ age +" years old");
	}

}
