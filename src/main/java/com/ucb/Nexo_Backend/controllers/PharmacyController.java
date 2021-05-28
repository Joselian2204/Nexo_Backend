package com.ucb.Nexo_Backend.controllers;

import com.ucb.Nexo_Backend.models.Hospital;
import com.ucb.Nexo_Backend.models.Pharmacy;
import com.ucb.Nexo_Backend.services.PharmacyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class PharmacyController {
    private PharmacyService service;

    @Autowired

    public PharmacyController(PharmacyService service) {
        this.service = service;
    }
    @GetMapping(value = "/pharmacy")
    public List<Pharmacy> getHospitals(){
        return service.getAll();
    }
}
