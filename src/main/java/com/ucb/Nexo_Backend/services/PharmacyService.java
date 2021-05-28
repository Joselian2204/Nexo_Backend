package com.ucb.Nexo_Backend.services;


import com.ucb.Nexo_Backend.models.Pharmacy;
import com.ucb.Nexo_Backend.repository.PharmacyRepository;
import com.ucb.Nexo_Backend.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public List<Pharmacy> getAll(){
        return this.pharmacyRepository.findAll();
    }

}
