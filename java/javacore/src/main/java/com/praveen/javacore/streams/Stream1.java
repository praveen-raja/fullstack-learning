package com.praveen.javacore.streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/*
 * ============================================================================
 * QUESTION
 * ----------------------------------------------------------------------------
 * From a list of employees, get the names (uppercase) of the TOP 3 highest-paid
 * employees in the "Engineering" department.
 *
 * ============================================================================
 * EASY WAY TO THINK ABOUT IT  (filter -> sort desc -> limit -> map)
 * ----------------------------------------------------------------------------
 *   filter(dept == Engineering)
 *   sorted(by salary, reversed)        -> highest first
 *   limit(3)                           -> keep top 3
 *   map(name -> UPPERCASE)             -> project to names
 *   collect(toList)
 * Order matters: limit AFTER sorting so you keep the top earners, not any 3.
 *
 * ============================================================================
 * COMPLEXITY
 * ----------------------------------------------------------------------------
 *  Time : O(N log N) (the sort dominates)   Space : O(N)
 * ============================================================================
 */
class EmployeeStream{
	String name;
	String department;
	double salary;
	
	public EmployeeStream(String name, String departent, Double salary){
		this.name = name;
		this.department = departent;
		this.salary = salary;
	}
	
	public String getName() { return name; }
    public String getDepartment() { return department; }
    public double getSalary() { return salary; }
}

public class Stream1 {
	
	public static void main(String[] args) {
		
		List<EmployeeStream> empList = Arrays.asList(
				new EmployeeStream("praveen", "dev", (double) 103400),
				new EmployeeStream("Bob", "Marketing", (double) 60000),
	            new EmployeeStream("Charlie", "Engineering", (double) 120000),
	            new EmployeeStream("David", "Engineering", (double) 110000),
	            new EmployeeStream("Eve", "HR", (double) 70000),
	            new EmployeeStream("Frank", "Engineering", (double) 95000)
		);
		
		List<String> topThreeEmpWithHighPaidSalary = empList.stream()
															.filter(e -> e.getDepartment().equals("Engineering"))
															.sorted(Comparator.comparingDouble(EmployeeStream::getSalary).reversed())
															.limit(3)
															.map(e -> e.getName().toUpperCase())
															.collect(Collectors.toList());
															
															System.out.println(topThreeEmpWithHighPaidSalary);
															
															
															
														
															
															
				

	}

}
