package com.ucb.Nexo_Backend.controllers;

import com.ucb.Nexo_Backend.models.Country;
import com.ucb.Nexo_Backend.models.CountryCases;
import com.ucb.Nexo_Backend.services.CountryCasesService;
import com.ucb.Nexo_Backend.services.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
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
    @GetMapping(value = "/datecountry")
    public List<CountryCases> getDates(@RequestParam("date")Date date1, @RequestParam("date") Date date2){

        return casesService.getByDateId(date1,date2);
    }

}
