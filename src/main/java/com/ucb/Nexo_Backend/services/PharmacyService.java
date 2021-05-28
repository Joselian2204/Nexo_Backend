package com.ucb.Nexo_Backend.services;

import com.ucb.Nexo_Backend.dto.PharmacyRequest;
import com.ucb.Nexo_Backend.models.Pharmacy;
import com.ucb.Nexo_Backend.models.Transaction;
import com.ucb.Nexo_Backend.repository.PharmacyRepository;
import com.ucb.Nexo_Backend.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class PharmacyService {
    private PharmacyRepository pharmacyRepository;
    private TransactionRepository transactionRepository;

    @Autowired
    public PharmacyService(PharmacyRepository pharmacyRepository, TransactionRepository transactionRepository) {
        this.pharmacyRepository = pharmacyRepository;
        this.transactionRepository = transactionRepository;
    }
    public PharmacyRequest create(PharmacyRequest pharmacyRequest, Transaction transaction){
        Pharmacy pharmacy = new Pharmacy();
        pharmacy = setPharmacy(pharmacyRequest,pharmacy);
        pharmacy.setTxDate(transaction.getTxDate());
        pharmacy.setTxIdAdministrator(transaction.getTxIdAdmi());
        pharmacy.setTxHost(transaction.getTxHost());
        pharmacy.setTxUpdate(transaction.getTxUpdate());
        System.out.println("Create Service");
        System.out.println(pharmacy);
        pharmacy = pharmacyRepository.save(pharmacy);
        pharmacyRequest = setPharmacyRequest(pharmacyRequest,pharmacy);

        return pharmacyRequest;
    }
    public List<PharmacyRequest> getAll(){
        PharmacyRequest pharmacyRequest = new PharmacyRequest();
        List<Pharmacy> listPharmacy= this.pharmacyRepository.findAll();
        List<PharmacyRequest> listPharmacyRequest= new ArrayList<>();
        for (Pharmacy pharmacy: listPharmacy){
            pharmacyRequest = setPharmacyRequest(pharmacyRequest,pharmacy);
            listPharmacyRequest.add(pharmacyRequest);
        }
        return listPharmacyRequest;
    }
    public Pharmacy setPharmacy(PharmacyRequest pharmacyRequest, Pharmacy pharmacy){
        pharmacy.setIdDepartment(pharmacyRequest.getIdDepartment());
        pharmacy.setName(pharmacyRequest.getName());
        pharmacy.setLocation(pharmacyRequest.getLocation());
        pharmacy.setPhoneNumber(pharmacyRequest.getPhoneNumber());
        pharmacy.setLng(pharmacyRequest.getLng());
        pharmacy.setLat(pharmacyRequest.getLat());
        return pharmacy;
    }
    public PharmacyRequest setPharmacyRequest(PharmacyRequest pharmacyRequest, Pharmacy pharmacy){
        pharmacyRequest.setIdDepartment(pharmacy.getIdDepartment());
        pharmacyRequest.setName(pharmacy.getName());
        pharmacyRequest.setLocation(pharmacy.getLocation());
        pharmacyRequest.setPhoneNumber(pharmacy.getPhoneNumber());
        pharmacyRequest.setLng(pharmacy.getLng());
        pharmacyRequest.setLat(pharmacy.getLat());
        pharmacyRequest.setIdPharmacy(pharmacy.getIdPharmacy());
        return pharmacyRequest;
    }

}
