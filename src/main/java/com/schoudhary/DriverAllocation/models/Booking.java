package com.schoudhary.DriverAllocation.models;

public class Booking {
    private Long bookingId;
    private String driverId;
    private Double distance;

    public Booking(Long bookingId,String driver, Double distance) {
        this.bookingId = bookingId;
        this.driverId = driver;
        this.distance = distance;
    }

    public Long getBookingId() {
        return bookingId;
    }

    public String getDriver() {
        return driverId;
    }

    public Double getDistance() {
        return distance;
    }
}
