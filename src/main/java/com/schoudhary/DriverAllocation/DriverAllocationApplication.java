package com.schoudhary.DriverAllocation;

import com.schoudhary.DriverAllocation.exceptions.DriverNotAvailableException;
import com.schoudhary.DriverAllocation.managers.BookingManager;
import com.schoudhary.DriverAllocation.managers.DefaultBookingManager;
import com.schoudhary.DriverAllocation.managers.DefaultDriverManager;
import com.schoudhary.DriverAllocation.managers.DriverManager;
import com.schoudhary.DriverAllocation.models.BookingRequest;
import com.schoudhary.DriverAllocation.models.SignupRequest;
import com.schoudhary.DriverAllocation.providers.DriverProvider;
import com.schoudhary.DriverAllocation.providers.QueueBasedDriverProvider;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class DriverAllocationApplication {

	public static void main(String[] args) {
		SpringApplication.run(DriverAllocationApplication.class, args);

		DriverProvider driverProvider = new QueueBasedDriverProvider();
		DriverManager driverManager = new DefaultDriverManager(driverProvider);
		BookingManager bookingManager = new DefaultBookingManager(driverProvider,driverManager);


		Scanner sc = new Scanner(System.in);
		System.out.println("Usage:\n register_driver <driverID> \n dispatch_driver_for_a_booking <booking distance> " +
				"\n complete_booking <booking_id> ");
		while(true){
			try {
				String[] command = sc.nextLine().split(" ");
				switch (command[0]){
					case "register_driver": {
						driverManager.signUp(new SignupRequest(command[1]));
						System.out.println(driverManager.getDriverById(command[1]));
						break;
					}
					case "dispatch_driver_for_a_booking": {
						try{
							Long bookingId = bookingManager.bookRide(new BookingRequest(Double.parseDouble(command[1])));
							System.out.println("Ride booked with booking id:"+bookingId);
						}catch (DriverNotAvailableException ex){
							System.out.println("Sorry, No driver available at this moment");
						}
						break;
					}
					case "complete_booking": {
						String driverId = bookingManager.completeRide(Long.parseLong(command[1]));
						System.out.println("Driver Released: "+driverId);
						break;
					}
					default: throw new IllegalArgumentException("Invalid command please check usage");

				}
			}catch (Exception e){
				System.out.println(e.getMessage());
			}
		}
	}

}
