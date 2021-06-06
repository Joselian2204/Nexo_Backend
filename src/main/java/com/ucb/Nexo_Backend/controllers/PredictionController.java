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
    public List<PredictionRequest> getAR1Countries(@PathVariable String id,@RequestParam Integer cant,@RequestParam Integer filter){
        return service.getAR1ByDateCountryId(id,cant,filter);
    }

    @GetMapping(value = "/prediction/ar1/department/{id}")
    public List<PredictionRequest> getAR1Departments(@PathVariable String id,@RequestParam Integer cant,@RequestParam Integer filter){
        return service.getAR1ByDateDepartmentId(id,cant,filter);
    }

    @GetMapping(value = "/prediction/ar1/municipio/{id}")
    public List<PredictionRequest> getAR1Municipality(@PathVariable String id,@RequestParam Integer cant,@RequestParam Integer filter){
        return service.getAR1ByDateMunicipalityId(id,cant,filter);
    }

    @GetMapping(value = "/prediction/ar2/country/{id}")
    public List<PredictionRequest> getAR2Countries(@PathVariable String id,@RequestParam Integer cant,@RequestParam Integer filter){
        return service.getAR2ByDateCountryId(id,cant,filter);
    }

    @GetMapping(value = "/prediction/ar2/department/{id}")
    public List<PredictionRequest> getAR2Departments(@PathVariable String id,@RequestParam Integer cant,@RequestParam Integer filter){
        return service.getAR2ByDateDepartmentId(id,cant,filter);
    }

    @GetMapping(value = "/prediction/ar2/municipio/{id}")
    public List<PredictionRequest> getAR2Municipality(@PathVariable String id,@RequestParam Integer cant,@RequestParam Integer filter){
        return service.getAR2ByDateMunicipalityId(id,cant,filter);
    }


    @GetMapping(value = "/prediction/arima/country/{id}")
    public List<PredictionRequest> getARIMACountries(@PathVariable String id,@RequestParam Integer cant,@RequestParam Integer filter){
        return service.getARIMAByDateCountryId(id,cant,filter);
    }

    @GetMapping(value = "/prediction/arima/department/{id}")
    public List<PredictionRequest> getARIMADepartments(@PathVariable String id,@RequestParam Integer cant,@RequestParam Integer filter){
        return service.getARIMAByDateDepartmentId(id,cant,filter);
    }

    @GetMapping(value = "/prediction/arima/municipio/{id}")
    public List<PredictionRequest> getARIMAMunicipality(@PathVariable String id,@RequestParam Integer cant,@RequestParam Integer filter){
        return service.getARIMAByDateMunicipalityId(id,cant,filter);
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



    @GetMapping(value = "/prediction/gray/country/{id}")
    public List<PredictionRequest> getGRAYCountries(@PathVariable String id,@RequestParam Integer cant,@RequestParam Integer filter){
        return service.getGRAYByDateCountryId(id,cant,filter);
    }

    @GetMapping(value = "/prediction/gray/department/{id}")
    public List<PredictionRequest> getGRAYDepartments(@PathVariable String id,@RequestParam Integer cant,@RequestParam Integer filter){
        return service.getGRAYByDateDepartmentId(id,cant,filter);
    }

    @GetMapping(value = "/prediction/gray/municipio/{id}")
    public List<PredictionRequest> getGRAYMunicipality(@PathVariable String id,@RequestParam Integer cant,@RequestParam Integer filter){
        return service.getGRAYByDateMunicipalityId(id,cant,filter);
    }


}
