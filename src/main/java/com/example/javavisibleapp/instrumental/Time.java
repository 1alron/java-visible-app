package com.example.javavisibleapp.instrumental;

import java.util.Objects;

public class Time {

    private int hours = 0;
    private int minutes = 0;
    private int seconds = 0;

    public Time() {}

    public Time(int hours, int minutes) {
        this(hours, minutes, 0);
    }

    public Time(int hours, int minutes, int seconds) {
        if (hours < 0 || minutes < 0 || seconds < 0) {
            throw new IllegalArgumentException("Invalid time format");
        }
        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;
    }

    public int getHours() {
        return hours;
    }

    public int getMinutes() {
        return minutes;
    }

    public int getSeconds() {
        return seconds;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }

    public void setSeconds(int seconds) {
        this.seconds = seconds;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Time time = (Time) o;
        return hours == time.hours && minutes == time.minutes && seconds == time.seconds;
    }

    @Override
    public int hashCode() {
        return Objects.hash(hours, minutes, seconds);
    }
}
