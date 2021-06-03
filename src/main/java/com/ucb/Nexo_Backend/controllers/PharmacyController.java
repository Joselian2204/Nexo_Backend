package com.ucb.Nexo_Backend.controllers;

import com.ucb.Nexo_Backend.dto.HospitalRequest;
import com.ucb.Nexo_Backend.dto.PharmacyRequest;
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
    public List<PharmacyRequest> getHospitals(){
        return service.getAll();
    }

    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public PharmacyRequest create(@RequestBody PharmacyRequest pharmacyRequest, HttpServletRequest request) {
        TransactionUtil transactionUtil=new TransactionUtil();
        AdministratorUtil administratorUtil=new AdministratorUtil();
        Integer idAdmi=administratorUtil.getIdAdministrator();
        Transaction transaction = transactionUtil.createTransaction(request);
        transaction.setTxIdAdmi(idAdmi);
        pharmacyRequest=service.create(pharmacyRequest,transaction);
        return pharmacyRequest;
    }
    @RequestMapping(method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public PharmacyRequest update(@RequestBody PharmacyRequest pharmacyRequest, HttpServletRequest request) {
        TransactionUtil transactionUtil=new TransactionUtil();
        AdministratorUtil administratorUtil=new AdministratorUtil();
        Integer idAdmi=administratorUtil.getIdAdministrator();
        Transaction transaction = transactionUtil.createTransaction(request);
        transaction.setTxIdAdmi(idAdmi);
        pharmacyRequest=service.update(pharmacyRequest,transaction);
        return pharmacyRequest;
    }
}
