# DSA

Data-structures & algorithms practice, organized as a Maven project. Each file
is a self-contained example with its own `main()` method, and (for most files) a
documented header covering the **question**, an **easy-to-understand intuition**,
and **optimization levels with time & space complexity**.

> Merged from the former standalone `Scaler_Learning` and `Learn-DSA` repos.
> DSA problem notes (GFG, Striver's SDE, topic write-ups) live under `notes/`.
>
> Java-language practice (`com.praveen.javacore.*`) was split out into a
> separate project: [`../java/javacore`](../java/javacore).

## Requirements

- JDK 8+ (`javac` / `java` on your PATH)
- Apache Maven 3.6+

## Build

```powershell
mvn clean compile      # compile all sources
mvn clean package      # compile + build the jar under target/
```

## Run a specific example

Every class has its own `main()`. Run any one by passing its fully-qualified
class name:

```powershell
mvn compile exec:java -Dexec.mainClass=com.praveen.dsa.arrays.TrappingRainWater
mvn compile exec:java -Dexec.mainClass=com.praveen.dsa.strings.MonotonicStack
mvn compile exec:java -Dexec.mainClass=com.praveen.dsa.bitmanipulation.FindNumberOfSetBits
```

> Some classes read input from the keyboard (`Scanner`). Run those in an
> interactive terminal so you can type the input.

The default `exec.mainClass` (used when you run `mvn exec:java` with no
`-Dexec.mainClass`) is set in `pom.xml` to `TrappingRainWater`.

## Project layout

Standard Maven layout; sources live under `src/main/java`.

```
src/main/java/com/praveen/dsa/
├── arrays/ (+ problems/)   # array traversal, rotation, subarray, binary search, ...
├── bitmanipulation/        # set bits, power of two, XOR tricks, ...
├── hashing/                # HashMap/HashSet intros + problems
├── math/                   # number math helpers
├── matrix/                 # matrix add / transpose
├── numbers/                # prime, Armstrong, narcissistic, sqrt, ...
├── sorting/                # bubble/selection practice, Kth min, noble element
└── strings/                # reverse words, valid parentheses, monotonic stack, ...
```

## Problem notes (non-code)

Reading material merged in from the old `Learn-DSA` repo lives under `notes/`:

```
notes/
├── GFG/docs/DSA_self_paced_GFG.pdf   # GeeksforGeeks self-paced course PDF
├── Strievers-SDE/README.md           # links to Striver's SDE / A2Z sheets
└── Topics/Array/README.md            # array operations + complexity write-up
```

## Notes

- Package names follow the folder path exactly (standard Java convention), so
  the project compiles cleanly as a whole.
- A few files are intentionally left **incomplete / work-in-progress**; their
  headers say `STATUS: INCOMPLETE` and the unfinished logic is marked with
  `TODO`. These compile but do not fully solve the problem yet.
