package com.ucb.Nexo_Backend.controllers;

import com.ucb.Nexo_Backend.models.CountryCases;
import com.ucb.Nexo_Backend.models.Municipality;
import com.ucb.Nexo_Backend.models.MunicipalityCases;
import com.ucb.Nexo_Backend.services.MunicipalityCasesService;
import com.ucb.Nexo_Backend.services.MunicipalityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class MunicipalityController {
    private MunicipalityService service;
    private MunicipalityCasesService casesService;
    @Autowired
    public void setServices(MunicipalityService service, MunicipalityCasesService casesService){
        this.service = service;
        this.casesService = casesService;
    }
    @GetMapping(value = "/municipios")
    public List<Municipality> getMunicipios(){
        return this.service.getAll();
    }
    @GetMapping(value = "/municipio/{id}")
    public List<MunicipalityCases> getCases(@PathVariable String id){
        return casesService.getByRegionId(id);
    }
    @GetMapping(value = "/municipios/{id}")
    public List<Municipality> getCasesByDepartment(@PathVariable String id){
        return service.getByDepartmentId(id);
    }
    @GetMapping(value = "/municipios/date")
    public List<MunicipalityCases> getDates(@RequestParam String id, @RequestParam String date1, @RequestParam String date2) throws ParseException {
        System.out.println("do");
        return casesService.getByDateId(id,date1,date2);
    }
}
