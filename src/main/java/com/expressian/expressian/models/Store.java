package com.expressian.expressian.models;


import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.lang.model.element.Name;
import javax.persistence.*;
import java.lang.invoke.SerializedLambda;
import java.util.List;
import java.util.Set;


@Entity

public class Store {
    @Id
    @GeneratedValue
    private Long id;
    private String storeName;
    @OneToMany
    @JoinColumn(name = "store_id", referencedColumnName = "id")
    private List<Vehicle> vehicles;

    @JsonManagedReference
    @ManyToMany
    @JoinTable(
            name = "store_customer",
            joinColumns = @JoinColumn(name = "store_id"),
            inverseJoinColumns = @JoinColumn(name = "customer_id")
    )

    Set<Customers> customers;

    public Store(String storeName, List<Vehicle> vehicles, Set<Customers> customers) {
        this.storeName = storeName;
        this.vehicles = vehicles;
        this.customers = customers;
    }

    public Set<Customers> getCustomers() {
        return customers;
    }

    public void setCustomers(Set<Customers> customers) {
        this.customers = customers;
    }

    public Store() {
    }

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
