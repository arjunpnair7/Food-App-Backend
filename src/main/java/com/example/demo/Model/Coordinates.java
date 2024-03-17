package com.example.demo.Model;

public class Coordinates {
    private double latitude;
    private double longitude;

    // Default constructor (required for JSON serialization/deserialization)
    public Coordinates() {}

    // Parameterized constructor
    public Coordinates(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    // Getters and setters
    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
}

