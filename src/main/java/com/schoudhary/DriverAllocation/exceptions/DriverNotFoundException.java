package com.schoudhary.DriverAllocation.exceptions;

public class DriverNotFoundException extends RuntimeException {
    public DriverNotFoundException(String driverId) {
        super("Driver with ID: "+driverId+" not registered with us.");
    }
}
