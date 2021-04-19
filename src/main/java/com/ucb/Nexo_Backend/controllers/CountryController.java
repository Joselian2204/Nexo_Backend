package com.ucb.Nexo_Backend.controllers;

import com.ucb.Nexo_Backend.models.Country;
import com.ucb.Nexo_Backend.models.CountryCases;
import com.ucb.Nexo_Backend.services.CountryCasesService;
import com.ucb.Nexo_Backend.services.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class CountryController {
    private CountryService service;
    private CountryCasesService casesService;
    @Autowired
    public void setServices(CountryService service, CountryCasesService casesService){
        this.service = service;
        this.casesService = casesService;
    }
    @GetMapping(value = "/world")
    public List<Country> getCountries(){
        return service.getAll();
    }
    @GetMapping(value = "/country/{id}")
    public List<CountryCases> getCases(@PathVariable String id){
        return casesService.getByCountryId(id);
    }
    @GetMapping(value = "world_cases")
    public Country getTotal(){
        return service.getTotal();
    }
}
