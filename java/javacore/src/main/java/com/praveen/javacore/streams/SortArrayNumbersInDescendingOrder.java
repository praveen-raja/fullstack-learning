package com.praveen.javacore.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SortArrayNumbersInDescendingOrder {
	
	public static void main(String[] args) {
		
		int[] num = {1,32,3,555,-9,100};
		
		sortOldWay(num);
		sortStreamWay(num);
	}

	private static void sortStreamWay(int[] num) {
		
		int[] sorted = Arrays.stream(num)
									.boxed()
									.distinct()
									.sorted(Comparator.reverseOrder())
									.mapToInt(Integer::intValue)
									.toArray();
						 
			
		
	}

	private static void sortOldWay(int[] num) {
		
		List<Integer> sorted = new ArrayList<>();
		
		for(int n: num) {
			if(!sorted.contains(n)) {
				sorted.add(n);
			}
		}
		
		Collections.sort(sorted, new Comparator<Integer>() {

			@Override
			public int compare(Integer i1, Integer i2) {
				return i2.compareTo(i1);
			}
		});		
		
		System.out.println(sorted);
	}

}
