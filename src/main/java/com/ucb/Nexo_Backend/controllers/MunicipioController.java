package com.ucb.Nexo_Backend.controllers;

import com.ucb.Nexo_Backend.models.Municipio;
import com.ucb.Nexo_Backend.services.MunicipioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MunicipioController {
    private MunicipioService service;
    @Autowired
    public void setServices(MunicipioService service){
        this.service = service;
    }
    @GetMapping(value = "/municipios")
    public List<Municipio> getMunicipios(){
        return this.service.getAll();
    }
}
