package com.schoudhary.DriverAllocation.managers;

import com.schoudhary.DriverAllocation.commons.IdGenerator;
import com.schoudhary.DriverAllocation.constants.DriverStatus;
import com.schoudhary.DriverAllocation.exceptions.BookingNotFoundException;
import com.schoudhary.DriverAllocation.exceptions.DriverNotAvailableException;
import com.schoudhary.DriverAllocation.models.Booking;
import com.schoudhary.DriverAllocation.models.BookingRequest;
import com.schoudhary.DriverAllocation.models.Driver;
import com.schoudhary.DriverAllocation.providers.DriverProvider;

import java.util.HashMap;
import java.util.Map;

public class DefaultBookingManager implements BookingManager {
    private final Map<Long, Booking> bookingRepo = new HashMap<>();
    private final DriverProvider driverProvider;
    private final DriverManager driverManager;
    private IdGenerator idGenerator = new IdGenerator();

    public DefaultBookingManager(DriverProvider driverProvider, DriverManager driverManager){
        this.driverProvider=driverProvider;
        this.driverManager = driverManager;
    }

    @Override
    public Long bookRide(BookingRequest bookingRequest) {
        Driver driver = driverProvider.getAvailableDriver();
        if(driver ==null){
            throw new DriverNotAvailableException();
        }

        driverManager.updateDriverStatus(driver.getDriverId(), DriverStatus.BOOKED);
        Booking booking= new Booking(idGenerator.getNewId(),driver.getDriverId(),bookingRequest.getDistance());

        bookingRepo.put(booking.getBookingId(),booking);

        return booking.getBookingId();
    }

    @Override
    public String completeRide(Long bookingId) {
        Booking booking = bookingRepo.get(bookingId);
        if(booking==null){
            throw new BookingNotFoundException(bookingId);
        }

        String driverId = booking.getDriver();
        driverManager.updateDriverStatus(driverId, DriverStatus.AVAILABLE);

        Driver driver = driverManager.getDriverById(driverId);
        driverProvider.addDriver(driver);

        return driverId;
    }
}
