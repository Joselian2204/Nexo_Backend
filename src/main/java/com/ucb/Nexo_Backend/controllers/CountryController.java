package com.ucb.Nexo_Backend.controllers;

import com.ucb.Nexo_Backend.models.Country;
import com.ucb.Nexo_Backend.models.CountryCases;
import com.ucb.Nexo_Backend.services.CountryCasesService;
import com.ucb.Nexo_Backend.services.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
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
    public List<CountryCases> getCases(@PathVariable String id, @RequestParam String date1, @RequestParam String date2) throws ParseException{
        if(date1 == "" || date2 == ""){
            return casesService.getByCountryId(id);
        }
        else {
            return casesService.getByDateId(id,date1,date2);
        }
    }
    @GetMapping(value = "world_cases")
    public Country getTotal(){
        return service.getTotal();
    }
    @GetMapping(value = "/country")
    public List<CountryCases> getDates(@RequestParam String id,@RequestParam String date1, @RequestParam String date2) throws ParseException {
        return casesService.getByDateId(id,date1,date2);
    }
    @GetMapping(value = "/country/average")
    public CountryCases getCases(@RequestParam String id){
        System.out.println("Estoy aca");
        return casesService.getAverage(id);
    }

}
