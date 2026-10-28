package com.praveen.javacore.streams;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/*
 * ============================================================================
 * TOPIC: Streams practice over a list of Employees (5 common tasks)
 * ----------------------------------------------------------------------------
 * EASY WAY TO THINK ABOUT IT - each task is one pipeline:
 *   1) map names of IT employees to uppercase            -> map + collect
 *   2) average salary                                    -> mapToDouble + average
 *   3) group employees by department                     -> groupingBy
 *   4) highest-paid employee                             -> max(Comparator)
 *   5) does anyone earn > 100k?                          -> anyMatch
 *
 * Note the Optional returned by average()/max(): use orElse / ifPresent to
 * handle the "empty" case safely instead of risking a null.
 *
 * ============================================================================
 * COMPLEXITY
 * ----------------------------------------------------------------------------
 *  Each task ~O(N) (grouping/averaging a single pass).   Space : O(result)
 * ============================================================================
 */
public class StreamPractice {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
            new Employee("Alice", "IT", 75000),
            new Employee("Bob", "HR", 50000),
            new Employee("Charlie", "IT", 90000),
            new Employee("David", "Sales", 60000),
            new Employee("Eve", "HR", 55000)
        );

        // TASK 1: Get a list of names of employees in the "IT" department (Uppercase)
        List<String> itNames = employees.stream()
        								.map(e -> e.getName().toUpperCase())
        						        .collect(Collectors.toList());
        System.out.println("IT Employees: " + itNames);

        // TASK 2: Find the average salary of all employees
        double avgSalary = employees.stream()
        							.mapToDouble(Employee:: getSalary)        
        							.average()
        							.orElse(0.0);
        							
        									
        System.out.println("Average Salary: " + avgSalary);

        // TASK 3: Group employees by their department
        Map<String, List<Employee>> byDept = employees.stream()
        											  .collect(Collectors.groupingBy(e -> e.getDepartment()));
        		
        System.out.println("Departments: " + byDept);

        // TASK 4: Find the employee with the highest salary
        Optional<Employee> richest = employees.stream().max(Comparator.comparing(e -> e.getSalary()));
        richest.ifPresent(e -> System.out.println("Highest Paid: " + e.getName()));

        // TASK 5: Check if any employee earns more than 100,000
        boolean highlyPaid = employees.stream().anyMatch(e -> e.getSalary() > 100000);
        System.out.println("Anyone > 100k? " + highlyPaid);
    }
}

class Employee {
    private String name;
    private String department;
    private double salary;

    public Employee(String n, String d, double s) { name = n; department = d; salary = s; }
    public String getName() { return name; }
    public String getDepartment() { return department; }
    public double getSalary() { return salary; }
    @Override
    public String toString() { return name; }
}