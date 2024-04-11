package com.example.javavisibleapp.models;


import com.example.javavisibleapp.instrumental.Time;
import com.example.javavisibleapp.interfaces.ClockActions;

import java.util.Objects;

public abstract class Clock implements ClockActions {

    private final String brand;
    private double price;
    private Time time = new Time();

    public Clock(String brand, double cost) {
        this.brand = brand;
        this.price = cost;

        time = new Time();
    }

    public Clock(String brand, double cost, Time time) {
        this.brand = brand;
        this.price = cost;

        setTime(time);
    }

    public void setTime(Time time) {
        if (time.getHours() < 0 || time.getHours() > 23 || time.getMinutes() < 0 || time.getMinutes() > 59 ||
            time.getSeconds() < 0 || time.getSeconds() > 59) {
            throw new IllegalArgumentException("Invalid time value");
        }
        this.time = time;
    }

    public Time getTime() {
        return time;
    }

    public String getBrand() {
        return brand;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public abstract void moveTimeForward(Time time);

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Clock clock = (Clock) o;
        return Double.compare(price, clock.price) == 0 && Objects.equals(brand, clock.brand) &&
                Objects.equals(time, clock.time) && o.hashCode() == this.hashCode();
    }

    @Override
    public int hashCode() {
        return Objects.hash(brand, price, time);
    }
}
