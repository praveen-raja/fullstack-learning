package com.praveen.javacore.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/*
 * ============================================================================
 * QUESTION: get the UNIQUE list of all skills across the whole team.
 * ----------------------------------------------------------------------------
 * EASY WAY: flatMap each developer's skill list into one stream, distinct() to
 * dedup, collect to a list. Textbook flatMap-then-distinct.
 * COMPLEXITY: Time O(total skills), Space O(distinct skills).
 * ============================================================================
 */
class Developer {
	String name;
	List<String> skills;

	Developer(String name, List<String> skills) {
		this.name = name;
		this.skills = skills;
	}

	public List<String> getSkills() {
		return skills;
	}
}

public class SkillFinder {
	public static void main(String[] args) {
		List<Developer> team = Arrays.asList(new Developer("Alice", Arrays.asList("Java", "Spring")),
				new Developer("Bob", Arrays.asList("Java", "SQL")),
				new Developer("Charlie", Arrays.asList("Python", "AWS")));

		// TODO: Get a unique list of all skills [Java, Spring, SQL, Python, AWS]
		
		List<String> skills = team.stream()
								.flatMap(s -> s.getSkills().stream())
								.distinct()
								.collect(Collectors.toList());
		
		System.out.println(skills);
	}
}