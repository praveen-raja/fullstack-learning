package com.praveen.javacore.designpatterns;

import java.util.ArrayList;
import java.util.List;

/*
 * ============================================================================
 * PATTERN: Observer (behavioural)
 * ----------------------------------------------------------------------------
 * One Subject (publisher) keeps a list of Observers (subscribers) and notifies
 * ALL of them automatically whenever its state changes. The subject does not
 * care who the observers are - it just calls update() on each.
 *
 * ============================================================================
 * EASY WAY TO THINK ABOUT IT  (a newsletter)
 * ----------------------------------------------------------------------------
 * WeatherStation = publisher. PhoneDisplay / TVDisplay = subscribers. Call
 * setTemperature() once and every subscribed display refreshes itself - you
 * never call each display by hand. Add a new display type without touching the
 * station: it just implements Observer and subscribes.
 *
 * Roles here:
 *   Observer (interface)      -> the subscriber contract: update(temp)
 *   WeatherStation (subject)  -> holds observers, notifies them on change
 *   PhoneDisplay / TVDisplay  -> concrete observers reacting to updates
 * ============================================================================
 */

// 1. The Observer interface (the subscribers)
interface Observer {
    void update(float temp);
}

// 2. The Subject (the publisher)
class WeatherStation {
    private List<Observer> observers = new ArrayList<>();
    private float temp;

    public void addObserver(Observer o) { observers.add(o); }

    public void setTemperature(float newTemp) {
        this.temp = newTemp;
        notifyObservers(); // push the change to every subscriber
    }

    private void notifyObservers() {
        for (Observer o : observers) {
            o.update(temp);
        }
    }
}

// 3. Concrete observers
class PhoneDisplay implements Observer {
    public void update(float temp) {
        System.out.println("Phone Display: Temp updated to " + temp + " C");
    }
}

class TVDisplay implements Observer {
    public void update(float temp) {
        System.out.println("TV Display: Breaking News! It is now " + temp + " C");
    }
}

// Usage
public class ObserverExample {
    public static void main(String[] args) {
        WeatherStation station = new WeatherStation();

        station.addObserver(new PhoneDisplay());
        station.addObserver(new TVDisplay());

        // Both displays update automatically on this single call
        station.setTemperature(25.5f);
    }
}
