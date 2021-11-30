package com.schoudhary.DriverAllocation.providers;

import com.schoudhary.DriverAllocation.models.Driver;

import java.util.LinkedList;
import java.util.Queue;

public class QueueBasedDriverProvider implements DriverProvider {
    private final Queue<Driver> drivers = new LinkedList<>();
    @Override
    public Driver getAvailableDriver() {
        if(drivers.isEmpty()){
            return null;
        }
        return drivers.poll();
    }

    @Override
    public void addDriver(Driver driver) {
        drivers.offer(driver);
    }
}
