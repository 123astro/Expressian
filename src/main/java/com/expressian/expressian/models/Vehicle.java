package com.expressian.expressian.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
//@Table(name="vehicle")
public class Vehicle {
    @Id
    @GeneratedValue
    private Long id;
    private String brand;
    private String model;
    private Integer doorAmount;

    public Vehicle(String brand, String model, Integer doorAmount) {
        this.brand = brand;
        this.model = model;
        this.doorAmount = doorAmount;
    }

    public Vehicle() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Integer getDoorAmount() {
        return doorAmount;
    }

    public void setDoorAmount(Integer doorAmount) {
        this.doorAmount = doorAmount;
    }
}
