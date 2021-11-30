package com.schoudhary.DriverAllocation.models;

public class BookingRequest {
    private double distance;

    public BookingRequest(double dist){
        this.distance = dist;
    }

    public double getDistance() {
        return distance;
    }
}
