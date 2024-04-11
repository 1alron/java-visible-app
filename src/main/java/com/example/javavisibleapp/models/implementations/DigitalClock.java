package com.example.javavisibleapp.models.implementations;


import com.example.javavisibleapp.instrumental.Time;
import com.example.javavisibleapp.models.Clock;

public class DigitalClock extends Clock {

    public DigitalClock(String brand, double cost) {
        super(brand, cost);
    }

    public DigitalClock(String brand, double cost, Time time) {
        super(brand, cost, time);
    }

    @Override
    public void moveTimeForward(Time time) {
        if (getTime().getHours() < 0 || getTime().getMinutes() < 0 || getTime().getSeconds() < 0) {
            throw new IllegalArgumentException("Invalid time value");
        }
        int tempHours = getTime().getHours() + time.getHours();
        int tempMinutes = getTime().getMinutes() + time.getMinutes();
        int tempSeconds = getTime().getSeconds() + time.getSeconds();

        // in case of the current value is out of bounds
        while (tempSeconds >= 60) {
            tempMinutes++;
            tempSeconds -= 60;
        }
        while (tempMinutes >= 60) {
            tempHours++;
            tempMinutes -= 60;
        }
        while (tempHours >= 24) {
            tempHours -= 24;
        }
        setTime(new Time(tempHours, tempMinutes, tempSeconds));
    }

    @Override
    public void setTime(Time time) {
        if (time.getHours() < 0 || time.getHours() > 23 || time.getMinutes() < 0 || time.getMinutes() > 59 ||
                time.getSeconds() < 0 || time.getSeconds() > 59) {
            throw new IllegalArgumentException("Invalid time value");
        }
        getTime().setHours(time.getHours());
        getTime().setMinutes(time.getMinutes());
        getTime().setSeconds(time.getSeconds());
    }

    @Override
    public String toString() {
        String hoursString = String.valueOf(getTime().getHours());
        String minutesString = String.valueOf(getTime().getMinutes());
        String secondsString = String.valueOf(getTime().getSeconds());
        if (hoursString.length() < 2) hoursString = '0' + hoursString;
        if (minutesString.length() < 2) minutesString = '0' + minutesString;
        if (secondsString.length() < 2) secondsString = '0' + secondsString;
        return getBrand() + '{' + hoursString + ':' + minutesString + ':' + secondsString + '}' +
                ", price = " + getPrice();
    }
}
