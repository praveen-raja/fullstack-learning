package com.main;

public class ConstructorMain {

	public static void main(String[] args) {

		ConstructorSub obj1 = new ConstructorSub("Praveen", 23, "pk@mail.com", "9999998888");
		obj1.hello();
		System.out.println(obj1.phone);
		
	}

}
