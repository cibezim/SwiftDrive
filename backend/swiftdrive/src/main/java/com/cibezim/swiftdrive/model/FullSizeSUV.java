package com.cibezim.swiftdrive.model;

import jakarta.persistence.*;

@Entity
@DiscriminatorValue("FULLSIZE_SUV")
public class FullSizeSUV extends Car {

    public FullSizeSUV() {
    }

    public FullSizeSUV(String model, int year, String brand, int seatingCapacity) {
        super(model, year, brand, seatingCapacity);
    }

    @Override
    public String getCarType() {
        return "Full-Size SUV";
    }
}
