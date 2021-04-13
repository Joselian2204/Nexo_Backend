package com.ucb.Nexo_Backend.services;

import com.ucb.Nexo_Backend.models.Location;
import com.ucb.Nexo_Backend.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationService {
    @Autowired
    private LocationRepository repo;
    public List<Location> getAll(){
        return this.repo.findAll();
    }
}