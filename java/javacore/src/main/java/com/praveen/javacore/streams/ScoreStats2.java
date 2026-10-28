package com.praveen.javacore.streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.function.Function;
import java.util.stream.Collectors;

/*
 * ============================================================================
 * TOPIC: a grab-bag of Streams techniques on Employees + numbers + words
 * ----------------------------------------------------------------------------
 * EASY WAY - each block is one idiom worth memorizing:
 *   - filter + map + collect          -> names with salary > 50k
 *   - mapToDouble + max               -> highest salary (OptionalDouble)
 *   - groupingBy + averagingDouble    -> average salary per department
 *   - partitioningBy(predicate)       -> split into two groups (>=70k vs not)
 *   - chars/split + groupingBy+count  -> character frequency map (two ways)
 *   - Collectors.joining(", ")        -> names into one comma-separated string
 *   - sorted(reversed) + limit(3)     -> top 3 earners
 *   - reduce(1, a*b)                  -> product of a number list
 *   - distinct+sorted+skip+limit      -> 2nd smallest
 *   - frequency map -> sort by value  -> most frequent word
 *
 * partitioningBy vs groupingBy: partitioning always yields exactly two buckets
 * (true/false) from a predicate; grouping yields one bucket per distinct key.
 *
 * COMPLEXITY: each block ~O(N) (sorts add O(N log N)).
 * ============================================================================
 */
public class ScoreStats2 {
	public static void main(String[] args) {
		List<Employee> list = Arrays.asList(
			    new Employee("Alice", "IT", 60000),
			    new Employee("Bob", "HR", 45000),
			    new Employee("Charlie", "IT", 80000),
			    new Employee("David", "HR", 55000),
			    new Employee("Eve", "Sales", 90000)
			);
		//Goal: Get a list of names of all employees whose salary is greater than 50,000.
		List<String> names = list.stream()
								.filter(e -> e.getSalary()>50000)
								.map(e -> e.getName())
								.collect(Collectors.toList());
		
		System.out.println(names);
		
		// Goal: Find the highest salary among all employees.
		OptionalDouble highestSalary = list.stream()
									.mapToDouble(Employee::getSalary)
									.max();
		
		//Goal: Group employees by department and calculate the average salary for each.
		Map<String, Double> avgDept = list.stream()
											.collect(Collectors.groupingBy(
													Employee::getDepartment, 
													Collectors.averagingDouble(Employee::getSalary)));
		
		// Goal: Separate the employees into two groups: those earning >= 70,000 and those earning less.
		Map<Boolean, List<Employee>> partitioned = list.stream()
									.collect(Collectors.partitioningBy(e -> e.getSalary() >=70000));
		
		List<Employee> highEarners = partitioned.get(true);
		List<Employee> lowEarners = partitioned.get(false);
		
		System.out.println(highEarners);		
		System.out.println(lowEarners);

									
		
		//Goal: Given a string "streamapi", find the count of each character using Streams.
		String name = "streamapi";
		
		Map<Character, Long> charOccurences = name.chars().mapToObj(c ->(char) c).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		System.out.println(charOccurences);
		
		Map<String, Long> charOccurences2 = Arrays.stream(name.split("")).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		System.out.println(charOccurences2);

		// Goal: Get a single String containing all employee names separated by a comma (e.g., "Alice, Bob, Charlie...").
		String singleString = list.stream().map(e -> e.getName()).collect(Collectors.joining(", "));
		System.out.println(singleString);
		
		// Find the Top 3 highest-paid employees and return their names in descending order of salary.
		List<String> top3 = list.stream()
								.sorted(Comparator.comparing(Employee::getSalary).reversed())
								.limit(3)
								.map(e -> e.getName())
								.collect(Collectors.toList());
		
		System.out.println(top3);
		
		List<Integer> array2 = Arrays.asList(1, 2, 3, 4, 5);
		
		//How would you calculate the "Product" (multiply them all together) using the reduce method?
		
		Integer multiple = array2.stream().reduce(1, (a,b) -> a*b);
		System.out.println(multiple);
		
		List<Integer> array3 = Arrays.asList(5, 2, 8, 2, 9, 1);
		Optional<Integer> secsmall = array3.stream()
								 .distinct()
								 .sorted(Comparator.naturalOrder())
								 .skip(1)
								 .limit(1)
								 .findFirst();
		
		secsmall.ifPresent(System.out::println);
		
		// List<String> words = Arrays.asList("apple", "banana", "apple", "cherry", "banana", "apple");
		List<String> words = Arrays.asList("apple", "banana", "apple", "cherry", "banana", "apple");
		//Final Stream Challenge: The "Frequency Map" to "Top Element"
		Map<String, Long> occurence = words.stream()
										   .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		
		String mostFrequent = occurence.entrySet().stream()
			    .sorted(Map.Entry.<String,Long>comparingByValue().reversed()) // 1. Sort by count DESC
			    .map(Map.Entry::getKey)                                        // 2. Map to the word
			    .findFirst()                                                   // 3. Get the top one
			    .orElse("No words found");                                     // 4. Handle empty case
		
		System.out.println(mostFrequent);
		

	}
}