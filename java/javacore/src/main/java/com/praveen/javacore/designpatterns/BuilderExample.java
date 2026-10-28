package com.praveen.javacore.designpatterns;

/*
 * ============================================================================
 * PATTERN: Builder (creational)
 * ----------------------------------------------------------------------------
 * Construct a complex object step by step with a readable, fluent API - great
 * when there are many optional fields and you want to avoid "telescoping"
 * constructors (Burger(size), Burger(size, cheese), Burger(size, cheese, ...)).
 *
 * ============================================================================
 * EASY WAY TO THINK ABOUT IT  (order a burger your way)
 * ----------------------------------------------------------------------------
 * The Burger constructor is PRIVATE; you build one through a static inner
 * Builder: start with the required `size`, then chain optional extras
 * (.addCheese().addLettuce()), and finish with .build(). Each add-method returns
 * `this`, which is what enables the fluent chain. The result is immutable
 * (all fields final).
 *
 * Roles:
 *   Burger          -> the immutable product
 *   Burger.Builder  -> collects fields, then build() creates the product
 *
 * Readable, order-independent, and no huge constructor overloads.
 * ============================================================================
 */
class Burger {
    private final String size; // Required
    private final boolean cheese; // Optional
    private final boolean pepperoni; // Optional
    private final boolean lettuce; // Optional

    // Private constructor: Only the Builder can use this
    private Burger(Builder builder) {
        this.size = builder.size;
        this.cheese = builder.cheese;
        this.pepperoni = builder.pepperoni;
        this.lettuce = builder.lettuce;
    }

    // Static Inner Builder Class
    public static class Builder {
        private final String size; 
        private boolean cheese = false;
        private boolean pepperoni = false;
        private boolean lettuce = false;

        public Builder(String size) { this.size = size; }

        public Builder addCheese() { this.cheese = true; return this; }
        public Builder addPepperoni() { this.pepperoni = true; return this; }
        public Builder addLettuce() { this.lettuce = true; return this; }

        public Burger build() { return new Burger(this); }
    }

    @Override
    public String toString() {
        return "Burger [Size=" + size + ", Cheese=" + cheese + 
               ", Pepperoni=" + pepperoni + ", Lettuce=" + lettuce + "]";
    }
}

// Usage
public class BuilderExample {
    public static void main(String[] args) {
        // Fluent API: Much easier to read!
        Burger myBurger = new Burger.Builder("Large")
                                    .addCheese()
                                    .addLettuce()
                                    .build();
        
        System.out.println(myBurger);
    }
}