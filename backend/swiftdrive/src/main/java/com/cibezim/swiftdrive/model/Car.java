package com.cibezim.swiftdrive.model;


import jakarta.persistence.*;

@Entity
@Table(name = "cars")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "car_type", discriminatorType = DiscriminatorType.STRING)
public abstract class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "model")
    private String model;
    @Column(name = "year")
    private int year;
    @Column(name = "brand")
    private String brand;
    @Column(name = "seating_capacity")
    private int seatingCapacity;
    @Column(name = "car_type", insertable = false, updatable = false)
    private String carType;


    public Car() {
    }

    public Car(String model, int year, String brand, int seatingCapacity) {
        this.model = model;
        this.year = year;
        this.brand = brand;
        this.seatingCapacity = seatingCapacity;
        this.carType = getCarType();
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
