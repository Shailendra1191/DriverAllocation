package com.schoudhary.DriverAllocation.exceptions;

public class DuplicateDriverException extends RuntimeException {

    public DuplicateDriverException(String driverId){
        super("Driver with id: "+driverId+ " already exists");
    }
}
