package com.praveen.javacore.customclass;

import java.io.Serializable;

/*
 * ============================================================================
 * TOPIC: building a String-like class via COMPOSITION (not inheritance)
 * ----------------------------------------------------------------------------
 * java.lang.String is `final`, so you cannot `extends String`. This class shows
 * the standard workaround: wrap a real String inside and DELEGATE to it.
 *
 * ============================================================================
 * EASY WAY TO THINK ABOUT IT  ("has-a" instead of "is-a")
 * ----------------------------------------------------------------------------
 * You cannot inherit String's behaviour, so instead HOLD a private String
 * `value` and forward every method call to it (length(), charAt(), substring(),
 * toUpperCase(), ...). This is the Composition / Wrapper pattern: favour "has-a"
 * when "is-a" is impossible or unwise.
 *
 * It also implements the same key interfaces String does - CharSequence,
 * Comparable, Serializable - so it can stand in for a String in many APIs, and
 * overrides equals()/hashCode()/toString() so it behaves correctly in
 * collections. Being immutable (final `value`) mirrors String's own design.
 *
 * ============================================================================
 * NOTE
 * ----------------------------------------------------------------------------
 * No main() here - it is a library-style class. Only a subset of String's
 * methods are wrapped; the rest follow the identical delegation pattern.
 * ============================================================================
 */
public class PraveenString implements Serializable, Comparable<PraveenString>, CharSequence {
    
    private final String value;

    // ----------------------------------------------------
    // Constructors
    // ----------------------------------------------------
    public PraveenString(String value) {
        this.value = value == null ? "" : value;
    }
    
    public PraveenString(char[] value) {
        this.value = new String(value);
    }
    
    // ----------------------------------------------------
    // Method Delegation (Wrapping String's functionality)
    // ----------------------------------------------------
    
    @Override
    public int length() {
        return value.length();
    }

    @Override
    public char charAt(int index) {
        return value.charAt(index);
    }

    @Override
    public CharSequence subSequence(int start, int end) {
        // CharSequence requirement
        return value.subSequence(start, end);
    }
    
    public PraveenString substring(int beginIndex) {
        return new PraveenString(value.substring(beginIndex));
    }
    
    public PraveenString substring(int beginIndex, int endIndex) {
        return new PraveenString(value.substring(beginIndex, endIndex));
    }

    public boolean contains(CharSequence s) {
        return value.contains(s);
    }
    
    public int indexOf(int ch) {
        return value.indexOf(ch);
    }
    
    public int indexOf(String str) {
        return value.indexOf(str);
    }

    public String[] split(String regex) {
        return value.split(regex);
    }

    public PraveenString toLowerCase() {
        return new PraveenString(value.toLowerCase());
    }

    public PraveenString toUpperCase() {
        return new PraveenString(value.toUpperCase());
    }

    // Support formatting with String
    public PraveenString concat(String str) {
        return new PraveenString(value.concat(str));
    }
    
    // Support formatting with PraveenString
    public PraveenString concat(PraveenString str) {
        return new PraveenString(value.concat(str.toString()));
    }
    
    public PraveenString replace(char oldChar, char newChar) {
        return new PraveenString(value.replace(oldChar, newChar));
    }

    public boolean isEmpty() {
        return value.isEmpty();
    }
    
    public char[] toCharArray() {
        return value.toCharArray();
    }

    // ----------------------------------------------------
    // Core Object Methods
    // ----------------------------------------------------

    @Override
    public int compareTo(PraveenString anotherString) {
        return this.value.compareTo(anotherString.value);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        // Allows equality check with both PraveenString and normal String
        if (obj instanceof PraveenString) {
            PraveenString other = (PraveenString) obj;
            return this.value.equals(other.value);
        }
        if (obj instanceof String) {
            return this.value.equals(obj);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

    @Override
    public String toString() {
        return value;
    }
    
    // Note: You can continue adding absolutely all other standard String methods 
    // (startsWith, endsWith, trim, isBlank, getBytes, etc.) 
    // following the exact same delegation pattern!
}
