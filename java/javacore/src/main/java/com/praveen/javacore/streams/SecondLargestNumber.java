package com.praveen.javacore.streams;

import java.util.Arrays;
import java.util.Comparator;

public class SecondLargestNumber {
	
	public static void main(String[] args) {
		int [] numbers = {1,3,44,57,89,100};
		
		int secondLargest = Arrays.stream(numbers)
									.boxed()
									.sorted(Comparator.reverseOrder())
									.skip(1)
									.findFirst()
									.orElseThrow(() -> new IllegalArgumentException("Array does not have enough elements"));
		
		System.out.println(secondLargest);
	}

}
