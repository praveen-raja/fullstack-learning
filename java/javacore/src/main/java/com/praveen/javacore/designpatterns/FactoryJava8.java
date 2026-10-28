package com.praveen.javacore.designpatterns;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

/*
 * ============================================================================
 * PATTERN: Factory (creational) - modern Java 8 style
 * ----------------------------------------------------------------------------
 * A factory hands you an object by NAME so callers never use `new` directly and
 * don't depend on concrete classes. This version uses a registry of Suppliers
 * instead of a big switch/if-else.
 *
 * ============================================================================
 * EASY WAY TO THINK ABOUT IT  (a menu of constructors)
 * ----------------------------------------------------------------------------
 * SHAPE_MAP maps "CIRCLE" -> Circle::new (a method reference = a Supplier that
 * builds a Circle). getShape("circle") looks up the supplier and calls .get()
 * to build it. Adding a new shape is one map entry - no touching getShape().
 * This avoids the classic "growing switch statement" of a traditional factory.
 *
 * ============================================================================
 * WHY IT MATTERS
 * ----------------------------------------------------------------------------
 * Callers depend only on the Shape interface; the concrete type is chosen at
 * runtime by a string key. Open/Closed friendly: extend by registering, not editing.
 * ============================================================================
 */

// 1. The Product Interface
interface Shape {
    void draw();
}

// 2. Concrete Products
class Circle implements Shape {
    public void draw() { System.out.println("Drawing a Circle"); }
}

class Square implements Shape {
    public void draw() { System.out.println("Drawing a Square"); }
}

class Rectangle implements Shape {
    public void draw() { System.out.println("Drawing a Rectangle"); }
}

// 3. The Java 8 Factory
class ShapeFactory {
    // A Map of Suppliers acts as our "Registry" of constructors
    private static final Map<String, Supplier<Shape>> SHAPE_MAP = new HashMap<>();

    static {
        SHAPE_MAP.put("CIRCLE", Circle::new);    // Method reference
        SHAPE_MAP.put("SQUARE", Square::new);    // Method reference
        SHAPE_MAP.put("RECTANGLE", Rectangle::new);
    }

    public static Shape getShape(String shapeType) {
        Supplier<Shape> shape = SHAPE_MAP.get(shapeType.toUpperCase());
        if (shape != null) {
            return shape.get();
        }
        throw new IllegalArgumentException("Unknown shape type: " + shapeType);
    }
}

// 4. Usage
public class FactoryJava8 {
    public static void main(String[] args) {
        // No 'new' keywords here!
        Shape s1 = ShapeFactory.getShape("CIRCLE");
        s1.draw();

        Shape s2 = ShapeFactory.getShape("SQUARE");
        s2.draw();
    }
}