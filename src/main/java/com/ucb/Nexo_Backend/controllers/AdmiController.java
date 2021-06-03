package com.ucb.Nexo_Backend.controllers;

import com.ucb.Nexo_Backend.dto.AdministratorRequest;

import com.ucb.Nexo_Backend.services.AdministratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
public class AdmiController {

    private AdministratorService service;
    @Autowired
    public AdmiController(AdministratorService service){
        this.service=service;
    }

    @RequestMapping(path="/administrator/login",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
    public AdministratorRequest SignIn(@RequestBody AdministratorRequest admiRequest) {

        return service.SignIn(admiRequest);
    }

}
