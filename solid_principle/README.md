# Solid Design Principle

What is solid design principle?
```dtd
Quality that a great software design should have.
```
### Problems of not using SOLID Principles
1. Bad for readability.
2. Testing is difficult.
3. Re-usability of code is difficult.
4. Difficult for multiple developers to work in parallel.

### General Practices

**Note:** There is no single correct answer in software design.
Every action has a trade-off.

- Following any design principle in software design is not possible at all.
- Avoid using the package like util/common/helper

### 5 Principle's of SOLID
1. S - ```Single Responsibility Principle```
2. O - ```Open/Closed Principle```
3. L - ```Liskov's Substitution Principle```
4. I - ```Interface Segregation Principle```
5. D - ```Dependency Inversion Principle```

### 1. Single Responsibility Principle (SRP)

- Every code unit(method/class/package) should EXACTLY have one well-defined responsibility.
- Should have exactly one reason to make a change.

```dtd
Monster Method

Methods that are doing lot more work than what their
name is suggesting to do so.
```
- SRP violations occurs in
  1. multiple if-else in the code.
  2. monster method.
  3. common/helper packages or classes.
- SRP is subjective(two peoples thoughts are not same.)

### 2. Open/Closed Principle (OCP)

- OCP means, codebase should be open for extension and closed for modification.
- Extensibility - ```adding new feature```
- Maintainability - ```ensuring system working well when no new requirements```
- My codebase should make it very easy to add new feature but  adding new feature should require very less/ ideally no change in my already written code base. 
- Adding new feature should mostly be adding new classes or methods.
- No regression, something that used to work earlier should work the same way.

### 3. Liskov's Substitution Principle (LSP)

- Objects of any child classes should be able to substituted/stored in a variable of a parent class without requiring a change in further code.
- No child class should deserve any special treatments.
```java
Bird bird = new Pigeon();
Bird bird = new Crow();
Bird bird = new Penquin();
Bird bird = new Sparrow();
```

### 4. Interface Segregation Principle (ISP)

- Interface should be as light as possible.
- Don't have a generalized interface.
- Make interface as specific as possible.
- Have very less number of methods(ideally 1 methods in interface).
- Interface having 1 method is called as ```Functional Interface```

### 5. Dependency Inversion Principle (DIP)

- No 2 concrete classes should be directly depend on each other.
- They should depend on each via an interface in between.