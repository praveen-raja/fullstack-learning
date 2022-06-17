package com.main;

import java.util.Scanner;

public class ArrayProgram {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		System.out.print("Enter size of names : ");
		int size = input.nextInt();

		String[] name = new String[size];

		System.out.println("Enter " + size + " names");

		for (int i = 0; i < size; i++) {
			name[i] = input.nextLine();
		}

		System.out.println("List of names :");

		for (int i = 0; i < size; i++) {
			System.out.println(name[i]);
		}

		input.close();
	}

}
