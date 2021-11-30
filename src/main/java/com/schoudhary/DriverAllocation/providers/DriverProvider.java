package com.schoudhary.DriverAllocation.providers;

import com.schoudhary.DriverAllocation.models.Driver;

public interface DriverProvider {
    Driver getAvailableDriver();

    void addDriver(Driver driver);
}
