package com.cibezim.swiftdrive.model;

import jakarta.persistence.*;

@Entity
@DiscriminatorValue("FULLSIZE_SEDAN")
public class FullSizeSedan extends Car {

    public FullSizeSedan() {
    }

    public FullSizeSedan(String model, int year, String brand, int seatingCapacity) {
        super(model, year, brand, seatingCapacity);
    }

    @Override
    public String getCarType() {
        return "Full-Size Sedan";
    }
}
