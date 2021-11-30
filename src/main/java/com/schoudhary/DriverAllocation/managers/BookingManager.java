package com.schoudhary.DriverAllocation.managers;

import com.schoudhary.DriverAllocation.models.BookingRequest;

public interface BookingManager {

    Long bookRide(BookingRequest bookingRequest);

    String completeRide(Long bookingId);

}
