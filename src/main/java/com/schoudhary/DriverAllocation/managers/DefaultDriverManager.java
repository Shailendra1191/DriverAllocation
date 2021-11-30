package com.schoudhary.DriverAllocation.managers;

import com.schoudhary.DriverAllocation.constants.DriverStatus;
import com.schoudhary.DriverAllocation.exceptions.DriverNotFoundException;
import com.schoudhary.DriverAllocation.exceptions.DuplicateDriverException;
import com.schoudhary.DriverAllocation.models.Driver;
import com.schoudhary.DriverAllocation.models.SignupRequest;
import com.schoudhary.DriverAllocation.providers.DriverProvider;

import java.util.HashMap;
import java.util.Map;

public class DefaultDriverManager implements DriverManager{

    Map<String, Driver> driverRepo = new HashMap<>();
    DriverProvider driverProvider;

    public DefaultDriverManager(DriverProvider provider){
        driverProvider = provider;
    }
    @Override
    public void signUp(SignupRequest signupRequest) {
        if(driverRepo.containsKey(signupRequest.getDriverId())){
            throw new DuplicateDriverException(signupRequest.getDriverId());
        }
        Driver driver = new Driver(signupRequest.getDriverId());
        driverRepo.put(signupRequest.getDriverId(),driver);
        driverProvider.addDriver(driver);
    }

    @Override
    public Driver getDriverById(String driverId) {
        return driverRepo.get(driverId);
    }

    @Override
    public void updateDriverStatus(String driverId, DriverStatus status) {
        Driver driver = driverRepo.get(driverId);
        if(driver==null){
            throw new DriverNotFoundException(driverId);
        }
    }


}
