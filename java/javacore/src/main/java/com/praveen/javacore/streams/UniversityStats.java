package com.praveen.javacore.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/*
 * ============================================================================
 * QUESTION: count the UNIQUE, non-empty courses across all students.
 * ----------------------------------------------------------------------------
 * EASY WAY: flatMap each student's course list into one stream, filter out
 * null/empty, distinct(), then count(). flatMap unnests; distinct dedups; count
 * is the terminal. (peek() here just prints each course for debugging.)
 * COMPLEXITY: Time O(total courses), Space O(distinct courses).
 * ============================================================================
 */
class Student {
	List<String> enrolledCourses;

	Student(List<String> courses) {
		this.enrolledCourses = courses;
	}

	public List<String> getEnrolledCourses() {
		return enrolledCourses;
	}
}

public class UniversityStats {
	public static void main(String[] args) {
		List<Student> students = Arrays.asList(new Student(Arrays.asList("Math", "Physics")),
				new Student(Arrays.asList("Biology", "Math")), new Student(Arrays.asList("History", "Physics", "")));

		// TODO: Count unique, non-empty courses
		long sum = students.stream()
				.flatMap(s -> s.getEnrolledCourses().stream())
				.peek(System.out::println)
				.filter(s -> null != s && !s.isEmpty())
				.distinct()
				.count();
		
		System.out.println(sum);
				
	}
}