package com.cibezim.swiftdrive.model;

import jakarta.persistence.*;

@Entity
@DiscriminatorValue("COMPACT_SUV")
public class CompactSUV extends Car {

    public CompactSUV() {
    }

    public CompactSUV(String model, int year, String brand, int seatingCapacity) {
        super(model, year, brand, seatingCapacity);
    }

    @Override
    public String getCarType() {
        return "Compact SUV";
    }
}
