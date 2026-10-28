package com.praveen.javacore.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/*
 * ============================================================================
 * QUESTION
 * ----------------------------------------------------------------------------
 * From a list of employees, produce the IT employees formatted as
 * "Name [Department]".  Expected: ["Alice [IT]", "Charlie [IT]"].
 *
 * ============================================================================
 * EASY WAY TO THINK ABOUT IT
 * ----------------------------------------------------------------------------
 * Intended pipeline:
 *   filter(e -> e.getDepartment().equals("IT"))
 *   .map(e -> e.getName() + " [" + e.getDepartment() + "]")
 *   .collect(Collectors.toList())
 * (reuses the Employee class defined in StreamPractice.java, same package.)
 *
 * ----------------------------------------------------------------------------
 * STATUS: INCOMPLETE. Only the input list and the expected-output comment
 * exist; the stream pipeline is not written yet. Left as-is (WIP).
 * ============================================================================
 */
public class Stream2 {

	public static void main(String[] args) {

		List<Employee> staff = Arrays.asList(
			    new Employee("Alice", "IT", 60000),
			    new Employee("Bob", "HR", 45000),
			    new Employee("Charlie", "IT", 70000)
			);

		// TODO: Expected Result: ["Alice [IT]", "Charlie [IT]"]
		// filter dept == "IT", map to "Name [Dept]", collect to list.
	}

}
