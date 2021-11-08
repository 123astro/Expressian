package com.expressian.expressian.controllers;

import com.expressian.expressian.models.Customers;
import com.expressian.expressian.models.Vehicle;
import com.expressian.expressian.repositories.CustomerRepository;
import com.expressian.expressian.repositories.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")

public class CustomerController {
    @Autowired
    private CustomerRepository repository;

    @GetMapping
    public @ResponseBody
    List<Customers> getCustomer() {
        return repository.findAll();
    }

    @PostMapping
    public @ResponseBody Customers createCustomer(@RequestBody Customers newCustomer){
        return repository.save(newCustomer);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<String> destroyCustomer(@PathVariable Long id) {
        repository.deleteById(id);
        return new ResponseEntity<>("Deleted", HttpStatus.OK);
    }
}
