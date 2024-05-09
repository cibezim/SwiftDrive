package com.cibezim.swiftdrive.model;

import jakarta.persistence.*;

@Entity
@DiscriminatorValue("MIDSIZE_SEDAN")
public class MidSizeSedan extends Car {

    public MidSizeSedan() {
    }

    public MidSizeSedan(String model, int year, String brand, int seatingCapacity) {
        super(model, year, brand, seatingCapacity);
    }

    @Override
    public String getCarType() {
        return "Midsize Sedan";
    }
}
