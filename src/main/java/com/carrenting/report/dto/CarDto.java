package com.carrenting.report.dto;


//Fuer Fahrzeugdaten darzustellen, die vom Microservice "car" abgerufen werden.
public class CarDto {   // Car Data Transfer Object
    private int carID;
    private String licensePlate;
    private Integer mileage;
    private String brand;
    private String model;

    public int getCarID() {
        return carID;
    }

    public void setCarID(int carID) {
        this.carID = carID;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public Integer getMileage() {
        return mileage;
    }

    public void setMileage(Integer mileage) {
        this.mileage = mileage;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
}
