package com.cibezim.swiftdrive.model;

import jakarta.persistence.*;

@Entity
@DiscriminatorValue("MIDSIZE_SUV")
public class MidSizeSUV extends Car {

    public MidSizeSUV() {
    }

    public MidSizeSUV(String model, int year, String brand, int seatingCapacity) {
        super(model, year, brand, seatingCapacity);
    }

    @Override
    public String getCarType() {
        return "Midsize SUV";
    }
}
