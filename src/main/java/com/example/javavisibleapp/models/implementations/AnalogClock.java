package com.example.javavisibleapp.models.implementations;


import com.example.javavisibleapp.instrumental.Time;
import com.example.javavisibleapp.models.Clock;

public class AnalogClock extends Clock {

    public AnalogClock(String brand, double cost) {
        super(brand, cost);
    }

    public AnalogClock(String brand, double cost, Time time) {
        super(brand, cost, time);
    }

    @Override
    public void moveTimeForward(Time time) {
        if (time.getHours() < 0 || time.getMinutes() < 0) {
            throw new IllegalArgumentException("Invalid time value");
        }
        int tempHours = getTime().getHours() + time.getHours();
        int tempMinutes = getTime().getMinutes() + time.getMinutes();

        // in case of the current value is out of bounds
        while (tempMinutes >= 60) {
            tempHours++;
            tempMinutes -= 60;
        }
        while (tempHours >= 24) {
            tempHours -= 24;
        }
        setTime(new Time(tempHours, tempMinutes));
    }

    @Override
    public void setTime(Time time) {
        if (time.getHours() < 0 || time.getHours() > 23 || time.getMinutes() < 0 || time.getMinutes() > 59) {
            throw new IllegalArgumentException("Invalid time value");
        }
        getTime().setHours(time.getHours());
        getTime().setMinutes(time.getMinutes());
    }

    @Override
    public String toString() {
        String hoursString = String.valueOf(getTime().getHours());
        String minutesString = String.valueOf(getTime().getMinutes());
        if (hoursString.length() < 2) hoursString = '0' + hoursString;
        if (minutesString.length() < 2) minutesString = '0' + minutesString;
        return getBrand() + '{' + hoursString + ':' + minutesString + '}' + ", price = " + getPrice();
    }
}
