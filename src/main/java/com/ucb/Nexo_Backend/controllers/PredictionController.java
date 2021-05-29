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


    @GetMapping(value = "/prediction/{id}")
    public List<Prediction> getCountries(@PathVariable String id){
        return service.getByDateCountryId(id);
    }

}
