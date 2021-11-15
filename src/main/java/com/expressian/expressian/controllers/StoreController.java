package com.expressian.expressian.controllers;

import com.expressian.expressian.models.Store;
import com.expressian.expressian.repositories.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/store")


public class StoreController {
    @Autowired
    private StoreRepository repository;
    @GetMapping
    public List<Store> getAllStores(){
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public @ResponseBody Store getStoreById(@PathVariable Long id){
        return repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public @ResponseBody ResponseEntity<Store> createStore(@RequestBody Store store){
        return new ResponseEntity<>(repository.save(store), HttpStatus.OK);
    }

}
