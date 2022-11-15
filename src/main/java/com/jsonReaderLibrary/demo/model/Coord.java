package com.widgetmeteo.demo.model;

public class Coord {

    String lon;

    String lat;

    public Coord() {
    }

    public Coord(String lon, String lan) {
        this.lon = lon;
        this.lat = lan;
    }

    public String getLon() {
        return lon;
    }

    public void setLon(String lon) {
        this.lon = lon;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }
}
