package com.praveen.javacore.designpatterns;

/*
 * ============================================================================
 * PATTERN: Strategy (behavioural)
 * ----------------------------------------------------------------------------
 * Define a family of interchangeable algorithms, and let the client swap which
 * one is used at runtime.
 *
 * ============================================================================
 * EASY WAY TO THINK ABOUT IT  (pick a payment method at checkout)
 * ----------------------------------------------------------------------------
 * ShoppingCart (the context) does not hard-code HOW to pay. It holds a
 * PaymentStrategy and calls it. The customer plugs in CreditCardPayment or
 * PayPalPayment, and checkout() behaves differently without the cart changing.
 * Swap the strategy object -> swap the behaviour.
 *
 * Roles:
 *   PaymentStrategy  -> the interchangeable-algorithm interface
 *   CreditCard/PayPal-> concrete strategies
 *   ShoppingCart     -> context that delegates to the chosen strategy
 *
 * This is the OO version of "pass in a function to change behaviour".
 * ============================================================================
 */

// 1. The Strategy Interface
interface PaymentStrategy {
    void collectDetails();
    void pay(int amount);
}

// 2. Concrete Strategy: Credit Card
class CreditCardPayment implements PaymentStrategy {
    public void collectDetails() { System.out.println("Collecting Card Details..."); }
    public void pay(int amount) { System.out.println("Paying " + amount + " via Card."); }
}

// 3. Concrete Strategy: PayPal
class PayPalPayment implements PaymentStrategy {
    public void collectDetails() { System.out.println("Logging into PayPal..."); }
    public void pay(int amount) { System.out.println("Paying " + amount + " via PayPal."); }
}

// 4. The Context (The Shopping Cart)
class ShoppingCart {
    private PaymentStrategy strategy;

    public void setPaymentStrategy(PaymentStrategy strategy) {
        this.strategy = strategy;
    }

    public void checkout(int amount) {
        strategy.collectDetails();
        strategy.pay(amount);
    }
}

// Usage
public class StrategyExample {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();

        // Customer chooses PayPal
        cart.setPaymentStrategy(new PayPalPayment());
        cart.checkout(500);

        // Customer changes mind to Credit Card
        cart.setPaymentStrategy(new CreditCardPayment());
        cart.checkout(500);
    }
}