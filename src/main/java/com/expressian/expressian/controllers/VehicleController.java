package com.expressian.expressian.controllers;

import com.expressian.expressian.models.Vehicle;
import com.expressian.expressian.repositories.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/vehicle")

public class VehicleController {
    @Autowired
    private VehicleRepository repository;

    @GetMapping
    public @ResponseBody
    List<Vehicle> getVehicle() {
        return repository.findAll();
    }

    @GetMapping("/getby/{brand}")
    @ResponseBody
    public List<Vehicle> getByBrand(@PathVariable String brand) {
        return repository.getAllByBrand(brand);
    }

    @PostMapping
    public @ResponseBody Vehicle createVehicle(@RequestBody Vehicle newVehicle){
        return repository.save(newVehicle);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> destroyVehicle(@PathVariable(name = "id") Long id) {
        repository.deleteById(id);
        return new ResponseEntity<>("Deleted", HttpStatus.OK);
    }

    @DeleteMapping("/deleteby/{model}")
    public ResponseEntity<String> destroyVehicleByModel(@PathVariable(name = "model") String model) {
        repository.deleteByModel(model);
        return new ResponseEntity<>("Deleted", HttpStatus.OK);
    }

    @PutMapping("/{id}")
    @ResponseBody
    public ResponseEntity<Vehicle> updateVehicle(@PathVariable Long id, @RequestBody Vehicle updates){
        Vehicle vehicle = repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        if (updates.getBrand() != null) vehicle.setBrand(updates.getBrand());
        if (updates.getModel() != null) vehicle.setModel(updates.getModel());
        if (updates.getDoorAmount() != null) vehicle.setDoorAmount(updates.getDoorAmount());
        return new ResponseEntity<>(repository.save(vehicle), HttpStatus.CREATED);
    }


//    @GetMapping("/{id}")
//    public @ResponseBody Developer getOneDeveloper(@PathVariable Long id){
//        return repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST));
//    }

}
