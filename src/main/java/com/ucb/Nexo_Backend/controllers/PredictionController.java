package com.ucb.Nexo_Backend.controllers;

import com.ucb.Nexo_Backend.dto.PredictionRequest;
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
    public List<PredictionRequest> getCountries(@PathVariable String id,@RequestParam Integer cant,@RequestParam Integer filter){
        return service.getByDateCountryId(id,cant,filter);
    }

    @GetMapping(value = "/prediction/ar1/department/{id}")
    public List<PredictionRequest> getDepartments(@PathVariable String id,@RequestParam Integer cant,@RequestParam Integer filter){
        return service.getByDateDepartmentId(id,cant,filter);
    }

    @GetMapping(value = "/prediction/ar1/municipio/{id}")
    public List<PredictionRequest> getMunicipality(@PathVariable String id,@RequestParam Integer cant,@RequestParam Integer filter){
        return service.getByDateMunicipalityId(id,cant,filter);
    }

    @GetMapping(value = "/prediction/mtx/country/{id}")
    public List<PredictionRequest> getMatrixCountries(@PathVariable String id, @RequestParam Integer cant, @RequestParam Integer filter){
        return service.getLinealPredictionByDateCountryId(id,cant,filter);
    }
    @GetMapping(value = "/prediction/mtx/department/{id}")
    public List<PredictionRequest> getMatrixDepartment(@PathVariable String id, @RequestParam Integer cant, @RequestParam Integer filter){
        return service.getLinealPredictionByDateDepartmentId(id,cant,filter);
    }
    @GetMapping(value = "/prediction/mtx/municipio/{id}")
    public List<PredictionRequest> getMatrixMunicipality(@PathVariable String id, @RequestParam Integer cant, @RequestParam Integer filter){
        return service.getLinealPredictionByDateMunicipalityId(id,cant,filter);
    }



}
