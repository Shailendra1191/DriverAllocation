package com.schoudhary.DriverAllocation.models;

import com.schoudhary.DriverAllocation.constants.DriverStatus;

public class Driver {
    private String driverId;
    private DriverStatus status;

    public Driver(String driverId){
        this.driverId=driverId;
        status = DriverStatus.AVAILABLE;
    }

    public String getDriverId() {
        return driverId;
    }

    public DriverStatus getStatus() {
        return status;
    }
}
