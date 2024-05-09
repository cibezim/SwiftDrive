package com.cibezim.swiftdrive.model;

import jakarta.persistence.*;

@Entity
@DiscriminatorValue("LUXURY_SUV")
public class LuxurySUV extends Car {

    public LuxurySUV() {
    }

    public LuxurySUV(String model, int year, String brand, int seatingCapacity) {
        super(model, year, brand, seatingCapacity);
    }

    @Override
    public String getCarType() {
        return "Luxury SUV";
    }
}
