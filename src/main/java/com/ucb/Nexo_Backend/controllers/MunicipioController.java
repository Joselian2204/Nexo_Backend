package com.ucb.Nexo_Backend.controllers;

import com.ucb.Nexo_Backend.models.DepartmentCases;
import com.ucb.Nexo_Backend.models.Municipio;
import com.ucb.Nexo_Backend.models.MunicipioCases;
import com.ucb.Nexo_Backend.services.MunicipioCasesService;
import com.ucb.Nexo_Backend.services.MunicipioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
public class MunicipioController {
    private MunicipioService service;
    private MunicipioCasesService casesService;
    @Autowired
    public void setServices(MunicipioService service, MunicipioCasesService casesService){
        this.service = service;
        this.casesService = casesService;
    }
    @GetMapping(value = "/municipios")
    public List<Municipio> getMunicipios(){
        return this.service.getAll();
    }
    @GetMapping(value = "/municipio/{id}")
    public List<MunicipioCases> getCases(@PathVariable String id){
        return casesService.getByRegionId(id);
    }
}
