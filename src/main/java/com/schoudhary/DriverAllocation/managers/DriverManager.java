package com.schoudhary.DriverAllocation.managers;

import com.schoudhary.DriverAllocation.constants.DriverStatus;
import com.schoudhary.DriverAllocation.models.Driver;
import com.schoudhary.DriverAllocation.models.SignupRequest;

public interface DriverManager {
    void signUp(SignupRequest signupRequest);

    Driver getDriverById(String driverId);

    void updateDriverStatus(String driverId, DriverStatus status);
}
