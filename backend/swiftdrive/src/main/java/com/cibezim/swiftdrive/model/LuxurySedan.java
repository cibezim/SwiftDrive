package com.cibezim.swiftdrive.model;

import jakarta.persistence.*;

@Entity
@DiscriminatorValue("LUXURY_SEDAN")
public class LuxurySedan extends Car {

    public LuxurySedan() {
    }

    public LuxurySedan(String model, int year, String brand, int seatingCapacity) {
        super(model, year, brand, seatingCapacity);
    }

    @Override
    public String getCarType() {
        return "Luxury Sedan";
    }
}
