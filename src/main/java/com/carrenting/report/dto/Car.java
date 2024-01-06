package com.carrenting.report.dto;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "car")
@Getter
@Setter
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int carID;
    private String brand;
    private String model;
    private String licensePlate;
    private Integer mileage;

    public Car() {}

    public Car(String brand, String model, String licensePlate, int mileage) {
        this.brand = brand;
        this.model = model;
        this.licensePlate = licensePlate;
        this.mileage = mileage;
    }
}