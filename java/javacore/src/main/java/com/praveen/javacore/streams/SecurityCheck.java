package com.praveen.javacore.streams;
import java.util.Arrays;
import java.util.List;

/*
 * ============================================================================
 * QUESTION: (1) are ALL users verified?  (2) is NO user an "Admin"?
 * ----------------------------------------------------------------------------
 * EASY WAY: allMatch(predicate) is true only if every element passes;
 * noneMatch(predicate) is true only if none pass. Both are short-circuiting
 * terminal ops - they stop early as soon as the answer is known.
 * COMPLEXITY: Time O(N) worst case, O(1) when it short-circuits. Space O(1).
 * ============================================================================
 */
class User {
    String name;
    String role;
    boolean isVerified;

    User(String name, String role, boolean isVerified) {
        this.name = name;
        this.role = role;
        this.isVerified = isVerified;
    }

    public String getRole() { return role; }
    public boolean isVerified() { return isVerified; }
}

public class SecurityCheck {
    public static void main(String[] args) {
        List<User> users = Arrays.asList(
            new User("Alice", "Guest", true),
            new User("Bob", "Customer", true),
            new User("Charlie", "Guest", false)
        );

        // TODO 1: Check if ALL are verified (Expected: false)
        
        boolean allverified = users.stream().allMatch(user -> user.isVerified);
        System.out.println(allverified);
        // TODO 2: Check if NONE are "Admin" (Expected: true)
        boolean noneAreAdmin = users.stream().noneMatch(user -> "Admin".equals(user.getRole()));
        System.out.println(noneAreAdmin);

    }
}