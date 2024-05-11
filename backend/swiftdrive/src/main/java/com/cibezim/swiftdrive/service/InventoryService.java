package com.cibezim.swiftdrive.service;

import com.cibezim.swiftdrive.model.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class InventoryService {
    private List<Car> cars;

    public InventoryService() {
        this.cars = new ArrayList<>();
        initializeInventory();
    }

    private void initializeInventory() {
        for (int i = 0; i < 10; i++) {
            cars.add(new CompactCar("Corolla", 2022, "Toyota", 5));
            cars.add(new CompactCar("Sentra", 2022, "Nissan", 5));
            cars.add(new CompactCar("Cruze", 2022, "Chevrolet", 5));
            cars.add(new CompactCar("Focus", 2022, "Ford", 5));
            cars.add(new MidSizeSedan("Camry", 2022, "Toyota", 5));
            cars.add(new MidSizeSedan("Altima", 2022, "Nissan", 5));
            cars.add(new MidSizeSedan("Malibu", 2022, "Chevrolet", 5));
            cars.add(new MidSizeSedan("Accord", 2022, "Honda", 5));
            cars.add(new FullSizeSedan("Taurus", 2023, "Ford", 5));
            cars.add(new FullSizeSedan("Impala", 2023, "Chevrolet", 5));
            cars.add(new FullSizeSedan("Toyota", 2023, "Avalon", 5));
            cars.add(new FullSizeSedan("Maxima", 2023, "Nissan", 5));
            cars.add(new CompactSUV("Compass", 2022, "Jeep", 5));
            cars.add(new CompactSUV("Escape", 2022, "Ford", 5));
            cars.add(new CompactSUV("Trax", 2022, "Chevrolet", 5));
            cars.add(new CompactSUV("RAV4", 2022, "Toyota", 5));
            cars.add(new MidSizeSUV("Outback", 2022, "Subaru", 5));
            cars.add(new MidSizeSUV("Grand Cherokee", 2022, "Jeep", 5));
            cars.add(new MidSizeSUV("Explorer", 2022, "Ford", 5));
            cars.add(new MidSizeSUV("Blazer", 2022, "Chevrolet", 5));
            cars.add(new FullSizeSUV("Tahoe", 2023, "Chevrolet", 7));
            cars.add(new FullSizeSUV("Expedition", 2023, "Ford", 7));
            cars.add(new FullSizeSUV("Yukon", 2023, "GMC", 7));
            cars.add(new FullSizeSUV("Sequoia", 2023, "Toyota", 7));
            cars.add(new LuxurySedan("5 Series", 2022, "BMW", 5));
            cars.add(new LuxurySedan("E-Class", 2022, "Mercedes-Benz", 5));
            cars.add(new LuxurySedan("A6", 2022, "Audi", 5));
            cars.add(new LuxurySedan("ES", 2022, "Lexus", 5));
            cars.add(new LuxurySUV("GLC", 2022, "Mercedes-Benz", 5));
            cars.add(new LuxurySUV("Q5", 2022, "Audi", 5));
            cars.add(new LuxurySUV("X6", 2022, "BMW", 5));
            cars.add(new LuxurySUV("RX", 2022, "Lexus", 5));
        }
    }

    public List<Car> getAllCars() {
        return cars;
    }

    public void addCar(Car car) {
        cars.add(car);
    }

    public void removeCar(Car car) {
        cars.remove(car);
    }

    public List<Car> getCarsByType(String carType) {
        return cars.stream()
                .filter(car -> car.getClass().getSimpleName().equalsIgnoreCase(carType))
                .collect(Collectors.toList());
    }

    public void removeCarById(Long id) {
        cars.removeIf(car -> car.getId().equals(id));
    }

    public void updateCar(Car car) {
        cars.stream()
                .filter(c -> c.getId().equals(car.getId()))
                .findFirst()
                .ifPresent(c -> {
                    c.setModel(car.getModel());
                    c.setYear(car.getYear());
                    c.setBrand(car.getBrand());
                    c.setSeatingCapacity(car.getSeatingCapacity());
                });
    }
}
