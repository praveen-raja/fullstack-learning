# Java Core

Java language and API practice, organized as a Maven project. Each file is a
self-contained example with its own `main()` method and a documented header
covering the **concept**, an **easy-to-understand intuition**, and (where
relevant) **complexity**.

> Split out from the DSA project so that pure Java-language practice lives with
> the other Java learning material, separate from the algorithm problems in
> [`../../dsa`](../../dsa).

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
mvn compile exec:java -Dexec.mainClass=com.praveen.javacore.streams.FlatMapAnalysis
mvn compile exec:java -Dexec.mainClass=com.praveen.javacore.keywords.VolatileExample
mvn compile exec:java -Dexec.mainClass=com.praveen.javacore.threads.ThreadTypeExample
```

The default `exec.mainClass` (used when you run `mvn exec:java` with no
`-Dexec.mainClass`) is set in `pom.xml` to `FlatMapAnalysis`.

## Project layout

Standard Maven layout; sources live under `src/main/java`.

```
src/main/java/com/praveen/javacore/
├── analyze/          # memory-leak demo + double-checked-locking singletons
├── basics/           # interfaces, inheritance, pass-by-value
├── collections/      # HashSet vs TreeSet
├── concurrency/      # HashMap vs ConcurrentHashMap under threads
├── copy/             # shallow vs deep copy
├── customclass/      # a hand-written String-like class (composition)
├── designpatterns/   # builder / prototype / singleton (5 phases) + adapter / observer / strategy / factory
├── keywords/         # volatile / synchronized / atomic
├── streams/          # Java 8 Streams exercises
└── threads/          # daemon vs user threads, odd/even wait-notify, static vs instance
```

## Notes

- Package names follow the folder path exactly (standard Java convention).
- Some design-pattern "runner" classes use `static void main()` with no
  `String[] args`, so they are not JVM entry points (illustrative snippets).
- A few files are intentionally **incomplete / work-in-progress** and marked
  `STATUS: INCOMPLETE` in their headers.
