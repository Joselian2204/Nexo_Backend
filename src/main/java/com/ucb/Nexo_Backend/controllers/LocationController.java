package com.ucb.Nexo_Backend.controllers;

import com.ucb.Nexo_Backend.models.Location;
import com.ucb.Nexo_Backend.services.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class LocationController {
    @Autowired
    private LocationService service;
    @GetMapping(value = "/loc")
    public List<Location> getAll(){
        return this.service.getAll();
    }
}

