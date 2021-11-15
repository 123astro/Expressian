package com.expressian.expressian.models;


import javax.lang.model.element.Name;
import javax.persistence.*;
import java.util.List;


@Entity

public class Store {
    @Id
    @GeneratedValue
    private Long id;
    private String storeName;
    @OneToMany
    @JoinColumn(name = "store_id", referencedColumnName = "id")
    private List<Vehicle> vehicles;

    public Store(String storeName, List<Vehicle> vehicles){
        this.storeName = storeName;
        this.vehicles = vehicles;
    }

    public Store(){}

    public List<Vehicle> getVehicles() {
        return vehicles;
    }

    public void setVehicles(List<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

    public Long getId() {
        return id;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }
}
