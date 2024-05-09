package com.cibezim.swiftdrive.model;

import jakarta.persistence.*;

@Entity
@DiscriminatorValue("MIDSIZE_SEDAN")
public class MidsizeSedan extends Car {

    public MidsizeSedan() {
    }

    public MidsizeSedan(String model, int year, String brand, int seatingCapacity) {
        super(model, year, brand, seatingCapacity);
    }

    @Override
    public String getCarType() {
        return "Midsize Sedan";
    }
}
