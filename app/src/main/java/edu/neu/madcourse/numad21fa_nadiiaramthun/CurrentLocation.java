package edu.neu.madcourse.numad21fa_nadiiaramthun;

import java.util.Objects;

public class CurrentLocation {
    private double longitude;
    private double latitude;

    public CurrentLocation() {
        longitude = 0;
        latitude = 0;
    }

    public double getLongitude() {
        return longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CurrentLocation location = (CurrentLocation) o;
        return Double.compare(location.longitude, longitude) == 0 && Double.compare(location.latitude, latitude) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(longitude, latitude);
    }

    @Override
    public String toString() {
        return "Location{" +
                "longitude=" + longitude +
                ", latitude=" + latitude +
                '}';
    }
}
