package com.expressian.expressian.models;

import javax.persistence.*;

@Entity
//@Table(name="vehicle")
public class Vehicle {
    @Id
    @GeneratedValue
    private Long id;
    @ManyToOne
    @JoinColumn(name = "store_id", referencedColumnName = "id")
    private Store store;
    private String brand;
    private String model;
    private Integer doorAmount;

    @OneToOne
    private Location location;

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Vehicle() {}

    public Vehicle(String brand, String model, Integer doorAmount, Store store) {
        this.brand = brand;
        this.model = model;
        this.doorAmount = doorAmount;
        this.store = store;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

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
