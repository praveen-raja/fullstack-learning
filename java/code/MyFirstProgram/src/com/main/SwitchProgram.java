package com.main;

import java.util.Scanner;

public class SwitchProgram {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		
		System.out.println("Enter the day number");
		int dayNumber = input.nextInt();
		
		switch(dayNumber)
		{
		case 1:
			System.out.println("SUNDAY");
			break;
		case 2:
			System.out.println("MONDAY");
			break;
		case 3:
			System.out.println("TUESDAY");
			break;
		case 4:
			System.out.println("WEDNESDAY");
			break;
		case 5:
			System.out.println("THURSDAY");
			break;
		case 6:
			System.out.println("FRIDAY");
			break;
		case 7:
			System.out.println("SATURDAY");
			break;
		default:
			System.out.println("Entered number is Invalid");
		}
		
	input.close();
	}	
}
