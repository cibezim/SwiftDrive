package com.cibezim.swiftdrive.controller;

import com.cibezim.swiftdrive.model.Car;
import com.cibezim.swiftdrive.service.InventoryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public class CarController {
    private final InventoryService inventoryService;

    public CarController(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }

    @GetMapping
    public List<Car> getAllCars() {
        return inventoryService.getAllCars();
    }

    @PostMapping
    public void addCar(@RequestBody Car car) {
        inventoryService.addCar(car);
    }
}
