package com.expressian.expressian.models;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Set;

@Entity
//@Table(name="customer")
public class Customers {
    @Id
    @GeneratedValue
    private Long id;
    private String firstName;
    private String lastName;
    private Integer age;

    @JsonBackReference

    @ManyToMany
    @JoinTable(
            name = "store_customer",
            inverseJoinColumns = @JoinColumn(name = "store_id"),
            joinColumns = @JoinColumn(name = "customer_id")
    )

    Set<Store> stores;

    public Customers(String firstName, String lastName, Integer age, Set<Store> stores) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.stores = stores;
    }

    public Customers() {
    }

    public Set<Store> getStores() {
        return stores;
    }

    public void setStores(Set<Store> stores) {
        this.stores = stores;
    }

    public Long getId() {
        return id;
    }

    // no set needed for ID
    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
