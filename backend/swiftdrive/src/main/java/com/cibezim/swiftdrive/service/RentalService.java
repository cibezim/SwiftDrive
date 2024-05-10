package com.cibezim.swiftdrive.service;

import com.cibezim.swiftdrive.model.Car;
import com.cibezim.swiftdrive.model.Rental;
import com.cibezim.swiftdrive.repository.RentalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;

@Service
public class RentalService {

    @Autowired
    private RentalRepository rentalRepository;

    public Rental createRental(Rental rental) {
        // Perform validation or business logic if needed
        return rentalRepository.save(rental);
    }

    public Rental getRentalById(Long rentalId) {
        return rentalRepository.findById(rentalId)
                .orElseThrow(() -> new RuntimeException("Rental not found"));
    }

    public void updateRental(Long rentalId, Rental updatedRental) {
        Rental existingRental = rentalRepository.findById(rentalId)
                .orElseThrow(() -> new RuntimeException("Rental not found"));

        // Update rental properties
        existingRental.setUser(updatedRental.getUser());
        existingRental.setCar(updatedRental.getCar());
        existingRental.setRentalDate(updatedRental.getRentalDate());
        existingRental.setReturnDate(updatedRental.getReturnDate());

        // Calculate and update total price based on updated rental details
        double totalPrice = calculateTotalPrice(existingRental);
        existingRental.setTotalPrice(totalPrice);

        // Save the updated rental to the repository
        rentalRepository.save(existingRental);
    }

    public void deleteRental(Long rentalId) {
        Rental rentalToDelete = rentalRepository.findById(rentalId)
                .orElseThrow(() -> new RuntimeException("Rental not found"));

        rentalRepository.delete(rentalToDelete);
    }

    private double calculateTotalPrice(Rental rental) {
        // Calculate rental duration in hours
        LocalDateTime rentalDate = rental.getRentalDate();
        LocalDateTime returnDate = rental.getReturnDate();
        Duration duration = Duration.between(rentalDate, returnDate);
        long hours = duration.toHours();

        // Get the hourly rate based on the car type
        double hourlyRate = getHourlyRateByCarType(rental.getCar());

        // Calculate total price based on duration and hourly rate
        double totalPrice = hours * hourlyRate;

        return totalPrice;
    }

    private double getHourlyRateByCarType(Car car) {
        // Retrieve car type from the provided car object
        String carType = car.getCarType();

        // Assign hourly rates based on the car type
        switch (carType) {
            case "Compact":
                return 20.0; // $20 per hour for Compact cars
            case "Midsize Sedan":
                return 25.0; // $25 per hour for Midsize Sedans
            case "Fullsize Sedan":
                return 30.0; // $30 per hour for Fullsize Sedans
            case "Luxury Sedan":
                return 50.0; // $50 per hour for Luxury Sedans
            case "Compact SUV":
                return 30.0; // $30 per hour for Compact SUVs
            case "Midsize SUV":
                return 40.0; // $40 per hour for Midsize SUVs
            case "Fullsize SUV":
                return 50.0; // $50 per hour for Fullsize SUVs
            case "Luxury SUV":
                return 75.0; // $75 per hour for Luxury SUVs
            default:
                return 0.0; // Default rate (customize as needed)
        }
    }
}
