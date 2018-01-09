package com.oracle.model;

public class Track {
    //The name of the track (e.g., “Yellow Submarine”)
    private String name;

    public Track(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
