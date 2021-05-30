package com.ucb.Nexo_Backend.controllers;

import com.ucb.Nexo_Backend.models.*;
import com.ucb.Nexo_Backend.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class PredictionController {
    private PredictionService service;
    @Autowired
    public PredictionController(PredictionService service) {
        this.service = service;
    }


    @GetMapping(value = "/prediction/ar1/country/{id}")
    public List<Prediction> getCountries(@PathVariable String id,@RequestParam Integer cant,@RequestParam Integer filter){
        return service.getByDateCountryId(id,cant,filter);
    }

    @GetMapping(value = "/prediction/ar1/department/{id}")
    public List<Prediction> getDepartments(@PathVariable String id,@RequestParam Integer cant,@RequestParam Integer filter){
        return service.getByDateDepartmentId(id,cant,filter);
    }

    @GetMapping(value = "/prediction/ar1/municipality/{id}")
    public List<Prediction> getMunicipality(@PathVariable String id,@RequestParam Integer cant,@RequestParam Integer filter){
        return service.getByDateMunicipalityId(id,cant,filter);
    }



}
