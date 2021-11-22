package com.expressian.expressian.controllers;

import com.expressian.expressian.models.Customers;
import com.expressian.expressian.models.Vehicle;
import com.expressian.expressian.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
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
    public @ResponseBody
    Customers createCustomer(@RequestBody Customers newCustomer) {
        return repository.save(newCustomer);
    }


    @GetMapping("/getby/{firstName}")
    @ResponseBody
    public ResponseEntity<List<Customers>> getAllByFirstName(@PathVariable String firstName) {
        return new ResponseEntity<>(repository.getAllByFirstName(firstName), HttpStatus.OK);
    }

    @GetMapping("/searchby/{lastName}")
    @ResponseBody
    public ResponseEntity<List<Customers>> getAllByLastName(@PathVariable String lastName) {
        return new ResponseEntity<>(repository.findAllByLastName(lastName, Sort.by("lastName")), HttpStatus.OK);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<String> destroyCustomer(@PathVariable Long id) {
        repository.deleteById(id);
        return new ResponseEntity<>("Deleted", HttpStatus.OK);
    }
}
