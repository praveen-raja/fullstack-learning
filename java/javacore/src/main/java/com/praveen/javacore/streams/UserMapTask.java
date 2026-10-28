package com.praveen.javacore.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/*
 * ============================================================================
 * QUESTION: build a Map<id, name> from a list of users. -> {1=Alice, 2=Bob, ...}
 * ----------------------------------------------------------------------------
 * EASY WAY: Collectors.toMap(keyFn, valueFn) with getId as the key and getName
 * as the value. (Heads-up: toMap throws if two elements map to the SAME key -
 * pass a merge function to resolve duplicates when keys can collide.)
 * COMPLEXITY: Time O(N), Space O(N).
 * ============================================================================
 */
class Users {
	int id;
	String name;

	Users(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}
}

public class UserMapTask {
	public static void main(String[] args) {
		List<Users> users = Arrays.asList(new Users(1, "Alice"), new Users(2, "Bob"), new Users(3, "Charlie"));

		// TODO: Create a Map<Integer, String>
		// Expected: {1=Alice, 2=Bob, 3=Charlie}
		
		Map<Integer, String> result = users.stream().collect(Collectors.toMap(Users::getId, Users:: getName));
		System.out.println(result);
	}
}