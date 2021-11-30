package com.schoudhary.DriverAllocation.models;

public class SignupRequest {
    private String driverId;

    public SignupRequest(String driverId) {
        this.driverId = driverId;
    }

    public String getDriverId() {
        return driverId;
    }
}
