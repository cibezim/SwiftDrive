package com.cibezim.swiftdrive.model;

public abstract class Car {

    private Long id;
    private String model;
    private int year;
    private String brand;
    private int seatingCapacity;

    public Car() {

    }

    public Car(String model, int year, String brand, int seatingCapacity) {
        this.model = model;
        this.year = year;
        this.brand = brand;
        this.seatingCapacity = seatingCapacity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getSeatingCapacity() {
        return seatingCapacity;
    }

    public void setSeatingCapacity(int seatingCapacity) {
        this.seatingCapacity = seatingCapacity;
    }

    public abstract String getCarType();
}
