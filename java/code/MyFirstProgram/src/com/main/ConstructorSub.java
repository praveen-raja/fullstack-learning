package com.main;

public class ConstructorSub {

	String name;
	int age;
	String email;
	String phone;
	
	ConstructorSub(String name, int age, String email, String phone) {
		this.name = name;
		this.age = age;
		this.email = email;
		this.phone = phone;
	}
	
	void hello() {
		System.out.printf("Hello %s\n", this.name);
	}
}
