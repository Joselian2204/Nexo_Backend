package com.ucb.Nexo_Backend.controllers;

import com.ucb.Nexo_Backend.models.Country;
import com.ucb.Nexo_Backend.services.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CountryController {
    private CountryService service;
    @Autowired
    public void setService(CountryService service){
        this.service = service;
    }
    @GetMapping(value = "/world")
    public List<Country> getCountries(){
        return service.getAll();
    }
}
