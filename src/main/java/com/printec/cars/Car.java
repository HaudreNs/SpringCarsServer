package com.printec.cars;

public class Car {
    private int id;
    private Owner carOwner;
    private Model carModel;
    private Brand carBrand;
    private String regNumber;
    private double engineCapacity;
    private String color;
    private double horsepower;

    public Car() {}

    public Car(Owner carOwner, Model carModel, Brand carBrand, String regNumber, double engineCapacity, String color, double horsepower) {
        this.carOwner = carOwner;
        this.carModel = carModel;
        this.carBrand = carBrand;
        this.regNumber = regNumber;
        this.engineCapacity = engineCapacity;
        this.color = color;
        this.horsepower = horsepower;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public Car(int id, Owner carOwner, Model carModel, Brand carBrand, String regNumber, double engineCapacity, String color, double horsepower) {
        this.id = id;
        this.carOwner = carOwner;
        this.carModel = carModel;
        this.carBrand = carBrand;
        this.regNumber = regNumber;
        this.engineCapacity = engineCapacity;
        this.color = color;
        this.horsepower = horsepower;
    }

    public Owner getCarOwner() {
        return carOwner;
    }

    public Model getCarModel() {
        return carModel;
    }

    public Brand getCarBrand() {
        return carBrand;
    }

    public String getRegNumber() {
        return regNumber;
    }

    public double getEngineCapacity() {
        return engineCapacity;
    }

    public String getColor() {
        return color;
    }

    public double getHorsepower() {
        return horsepower;
    }

    public void setCarOwner(Owner carOwner) {
        this.carOwner = carOwner;
    }

    public void setCarModel(Model carModel) {
        this.carModel = carModel;
    }

    public void setCarBrand(Brand carBrand) {
        this.carBrand = carBrand;
    }

    public void setRegNumber(String regNumber) {
        this.regNumber = regNumber;
    }

    public void setEngineCapacity(double engineCapacity) {
        this.engineCapacity = engineCapacity;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setHorsepower(double horsepower) {
        this.horsepower = horsepower;
    }
}
