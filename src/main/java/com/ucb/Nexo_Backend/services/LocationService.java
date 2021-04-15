package com.ucb.Nexo_Backend.services;

import com.ucb.Nexo_Backend.models.Location;
import com.ucb.Nexo_Backend.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationService {
    private LocationRepository repo;
    @Autowired
    public void setRepo(LocationRepository repo){
        this.repo = repo;
    }
    public List<Location> getAll(){
        return this.repo.findAll();
    }
}