package com.cibezim.swiftdrive.model;

import jakarta.persistence.*;

@Entity
@DiscriminatorValue("COMPACT")
public class CompactCar extends Car {

    public CompactCar() {
    }

    public CompactCar(String model, int year, String brand, int seatingCapacity) {
        super(model, year, brand, seatingCapacity);
    }

    @Override
    public String getCarType() {
        return "Compact";
    }
}
