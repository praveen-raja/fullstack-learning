package com.praveen.javacore.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/*
 * ============================================================================
 * QUESTION: group staff by role; the shown code lists the NAMES per role.
 * ----------------------------------------------------------------------------
 * EASY WAY: groupingBy(role, mapping(name, toList())) -> {Developer=[...],
 * Manager=[...]}. To get COUNTS instead ({Developer=3, Manager=2}), swap the
 * downstream collector to Collectors.counting().
 * COMPLEXITY: Time O(N), Space O(distinct roles).
 * ============================================================================
 */
class Employeee {
	String name;
	String role;

	Employeee(String name, String role) {
		this.name = name;
		this.role = role;
	}

	public String getName() {
		return name;
	}

	public String getRole() {
		return role;
	}
}

public class RoleCounter {
	public static void main(String[] args) {
		List<Employeee> staff = Arrays.asList(new Employeee("Alice", "Developer"), new Employeee("Bob", "Developer"),
				new Employeee("Charlie", "Manager"), new Employeee("David", "Developer"),
				new Employeee("Eve", "Manager"));

		// TODO: Map the roles to the number of people in that role
		// Expected Output: {Developer=3, Manager=2}

		
		 Map<String, List<String>> output = staff.stream()
		 .collect(Collectors.groupingBy(Employeee::getRole,
		 Collectors.mapping(Employeee::getName, Collectors.toList())));
		 
		  System.out.println(output);
	}
}