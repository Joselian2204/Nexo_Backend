package com.ucb.Nexo_Backend.controllers;

import com.ucb.Nexo_Backend.models.Hospital;
import com.ucb.Nexo_Backend.models.Pharmacy;
import com.ucb.Nexo_Backend.models.Transaction;
import com.ucb.Nexo_Backend.services.PharmacyService;
import com.ucb.Nexo_Backend.util.AdministratorUtil;
import com.ucb.Nexo_Backend.util.TransactionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/pharmacy")
public class PharmacyController {
    private PharmacyService service;

    @Autowired

    public PharmacyController(PharmacyService service) {
        this.service = service;
    }
    @GetMapping()
    public List<Pharmacy> getHospitals(){
        return service.getAll();
    }

    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public Pharmacy create(@RequestBody Pharmacy pharmacy, HttpServletRequest request) {
        TransactionUtil transactionUtil=new TransactionUtil();
        AdministratorUtil administratorUtil=new AdministratorUtil();
        Integer idAdmi=administratorUtil.getIdAdministrator();
        System.out.println(idAdmi);
        Transaction transaction = transactionUtil.createTransaction(request);
        transaction.setTxIdAdmi(idAdmi);
        pharmacy=service.create(pharmacy,transaction);
        return pharmacy;
    }
}
