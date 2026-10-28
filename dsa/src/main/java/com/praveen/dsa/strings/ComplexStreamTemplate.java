package com.praveen.dsa.strings;
import java.util.*;
import java.util.stream.*;

/*
 * ============================================================================
 * TOPIC: A "kitchen sink" Streams template (flatMap + filter + groupingBy +
 *        summary statistics)
 * ----------------------------------------------------------------------------
 * A reference showing how several stream operations chain together on nested
 * data (Departments -> Employees).
 *
 * ============================================================================
 * EASY WAY TO THINK ABOUT IT  (read the pipeline top to bottom)
 * ----------------------------------------------------------------------------
 * Task 1 - "high-earning top performers, grouped by city":
 *   flatMap    : flatten List<Department> into one stream of all Employees
 *   filter     : keep score >= 8 AND salary > 50000
 *   peek       : debug-print each survivor (does not change the stream)
 *   groupingBy : bucket by city, and mapping(...toList) keeps only the names
 *
 * Task 2 - "whole-company salary stats":
 *   flatMap + summarizingDouble(salary) -> count, sum, min, max, average in one
 *   pass via DoubleSummaryStatistics.
 *
 * Key ideas: flatMap = "unnest a collection of collections"; groupingBy +
 * downstream collector = "group, then transform each group".
 *
 * ============================================================================
 * COMPLEXITY
 * ----------------------------------------------------------------------------
 *  One linear pass per pipeline.  Time : O(total employees)   Space : O(result)
 * ============================================================================
 */
public class ComplexStreamTemplate {
    public static void main(String[] args) {
        List<Department> company = getCompanyData();

        // --- TASK 1: high-earning top performers, grouped by city ---
        Map<Object, List<Object>> result = company.stream()
            // 1. flatMap: List<Department> -> Stream<Employee>
            .flatMap(dept -> dept.employees.stream())

            // 2. filter: score >= 8 AND salary > 50k
            .filter(e -> e.performanceScore >= 8 && e.salary > 50000)

            // 3. peek: debug print mid-stream (no effect on data)
            .peek(e -> System.out.println("Processing: " + e.name))

            // 4. collect: group by city, keep only the names in each group
            .collect(Collectors.groupingBy(
                e -> e.city != null ? e.city : "Unknown",
                Collectors.mapping(e -> e.name, Collectors.toList())));

        System.out.println("\nTop Performers by City: " + result);

        // --- TASK 2: full salary statistics for the whole company ---
        DoubleSummaryStatistics stats = company.stream()
            .flatMap(d -> d.employees.stream())
            .collect(Collectors.summarizingDouble(e -> e.salary));

        System.out.println("\nSalary Stats: " + stats);
        System.out.println("Max: " + stats.getMax() + ", Avg: " + stats.getAverage());
    }

    private static List<Department> getCompanyData() {
        return Arrays.asList(
            new Department("IT", Arrays.asList(
                new Employee("Alice", "New York", 90000, 9),
                new Employee("Bob", "London", 40000, 8))),
            new Department("HR", Arrays.asList(
                new Employee("Charlie", "New York", 60000, 10),
                new Employee("David", "London", 75000, 5)))
        );
    }
}

class Employee {
    String name;
    String city;
    double salary;
    int performanceScore; // 1 to 10

    Employee(String name, String city, double salary, int score) {
        this.name = name;
        this.city = city;
        this.salary = salary;
        this.performanceScore = score;
    }
}

class Department {
    String deptName;
    List<Employee> employees;

    Department(String name, List<Employee> employees) {
        this.deptName = name;
        this.employees = employees;
    }
}
