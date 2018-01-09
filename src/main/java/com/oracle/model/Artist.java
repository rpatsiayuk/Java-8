package com.oracle.model;


public class Artist {

    //The name of the artist (e.g., “The Beatles”)
    private String name;
    //A set of other artists who comprise this group (e.g., “John Lennon”);this field might be empty
    private String members;
    //The primary location of origin of the group (e.g., “Liverpool”).
    private String origin;

    public Artist(String name, String members, String origin) {
        this.name = name;
        this.members = members;
        this.origin = origin;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMembers() {
        return members;
    }

    public void setMembers(String members) {
        this.members = members;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    @Override
    public String toString() {
        return "Artist{" +
                "name='" + name + '\'' +
                ", members='" + members + '\'' +
                ", origin='" + origin + '\'' +
                '}';
    }
}
