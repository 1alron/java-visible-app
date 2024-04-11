package com.example.javavisibleapp.stores;

import com.example.javavisibleapp.instrumental.Time;
import com.example.javavisibleapp.models.Clock;

import java.util.*;

public class ClockStore implements Iterable<Clock> {

    private TreeMap<Clock, Integer> clocks;

    public TreeMap<Clock, Integer> getClocks() {
        return clocks;
    }

    public ClockStore() {
        // sorting by cost
        clocks = new TreeMap<>( (a, b) -> (int) (a.getPrice() - b.getPrice()) );
    }

    public ClockStore(TreeMap<Clock, Integer> clocks) {
        this.clocks = clocks;
    }

    public void addClock(Clock clock) {
        clocks.put(clock, 0);
        for (Map.Entry<Clock, Integer> entry : clocks.entrySet()) {
            if (Objects.equals(entry.getKey().getBrand(), clock.getBrand())) {
                clocks.put(clock, 1 + clocks.getOrDefault(clock, 0));
            }
        }
    }

    public void deleteClock(Clock clock) {
        TreeMap<Clock, Integer> clocksCopy = new TreeMap<>((a, b) -> (int) (a.getPrice() - b.getPrice()));
        clocksCopy.putAll(clocks);
        boolean flag = false;
        // Iterator<Clock> iterator = iterator();
        for (Map.Entry<Clock, Integer> entry : clocks.entrySet()) {
            if (Objects.equals(entry.getKey().getBrand(), clock.getBrand()) &&
                    Objects.equals(entry.getKey().getPrice(), clock.getPrice()) &&
                    Objects.equals(entry.getKey().getTime(), clock.getTime())) {
                clocksCopy.remove(entry.getKey());
                flag = true;
                break;
            }
        }
        if (flag) {
            for (Map.Entry<Clock, Integer> entry : clocks.entrySet()) {
                if (Objects.equals(entry.getKey().getBrand(), clock.getBrand())) {
                    clocksCopy.put(clock, -1 + clocksCopy.getOrDefault(clock, 1));
                }
            }
        }
        clocks = clocksCopy;
    }

    public Clock mostExpensiveClockDescription() {
        return clocks.lastKey();
    }

    public void setTimeOnAllClocks(Time time) {
        for (Map.Entry<Clock, Integer> entry : clocks.entrySet()) {
            Clock clock = entry.getKey();
            clock.setTime(time);
        }
    }

    public ArrayList<Clock> mostCommonClockBrand() {
        ArrayList<Clock> mostCommonClocks = new ArrayList<>();
        int maxCount = 0;
        for (int i : clocks.values()) {
            maxCount = Math.max(i, maxCount);
        }
        if (maxCount == 0) {
            return mostCommonClocks;
        }
        for (Map.Entry<Clock, Integer> entry : clocks.entrySet()) {
            if (entry.getValue() == maxCount) {
                mostCommonClocks.add(entry.getKey());
            }
        }
        return mostCommonClocks;
    }

    public ArrayList<Clock> clocksInSortedOrder() {
        ArrayList<Clock> list = new ArrayList<>();
        for (Map.Entry<Clock, Integer> entry : clocks.entrySet()) {
            list.add(entry.getKey());
        }
        return list;
    }

    @Override
    public Iterator<Clock> iterator() {
        return clocks.keySet().iterator();
    }
}
