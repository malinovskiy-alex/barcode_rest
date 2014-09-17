package com.malinovskiy.barcodereader.domain;

/**
 * Created by malinovsky on 9/17/2014.
 */
public enum EntryType {
    PICKUP("Pickup"), ARRIVAL("Arrival"), DEPARTURE("Departure");
    private String name;

    private EntryType(String name) {
        this.name = name;
    }

    public String toString() {
        return name;
    }
}
