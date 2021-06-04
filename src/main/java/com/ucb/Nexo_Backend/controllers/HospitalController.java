package com.ucb.Nexo_Backend.controllers;

import com.ucb.Nexo_Backend.dto.HospitalRequest;
import com.ucb.Nexo_Backend.models.Transaction;
import com.ucb.Nexo_Backend.services.HospitalService;
import com.ucb.Nexo_Backend.util.AdministratorUtil;
import com.ucb.Nexo_Backend.util.TransactionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
//@RequestMapping(value = "/hospital")
public class HospitalController {
    private HospitalService service;
    @Autowired

    public HospitalController(HospitalService service) {
        this.service = service;
    }
    @RequestMapping(value = "/hospital",method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public HospitalRequest create(@RequestBody HospitalRequest hospitalRequest, HttpServletRequest request) {
        TransactionUtil transactionUtil=new TransactionUtil();
        AdministratorUtil administratorUtil=new AdministratorUtil();
        Integer idAdmi=administratorUtil.getIdAdministrator();
        System.out.println(idAdmi);
        Transaction transaction = transactionUtil.createTransaction(request);
        transaction.setTxIdAdmi(idAdmi);
        hospitalRequest=service.create(hospitalRequest,transaction);
        return hospitalRequest;
    }
    @RequestMapping(value = "/hospital",method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public HospitalRequest update(@RequestBody HospitalRequest hospitalRequest, HttpServletRequest request) {
        TransactionUtil transactionUtil=new TransactionUtil();
        AdministratorUtil administratorUtil=new AdministratorUtil();
        Integer idAdmi=administratorUtil.getIdAdministrator();
        System.out.println(idAdmi);
        Transaction transaction = transactionUtil.createTransaction(request);
        transaction.setTxIdAdmi(idAdmi);
        hospitalRequest=service.update(hospitalRequest,transaction);
        return hospitalRequest;
    }
    @RequestMapping(value = "/hospital/{idHospital}",method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public String update(@PathVariable Integer idHospital, HttpServletRequest request) {
        service.delete(idHospital);
        return "Eliminado";
    }
    @GetMapping(value = "/hospital")
    public List<HospitalRequest> getHospitals(){
        return service.getAll();
    }
}
