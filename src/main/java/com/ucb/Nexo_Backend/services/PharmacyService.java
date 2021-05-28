package com.ucb.Nexo_Backend.services;


import com.ucb.Nexo_Backend.models.Hospital;
import com.ucb.Nexo_Backend.models.Pharmacy;
import com.ucb.Nexo_Backend.models.Transaction;
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
    public Pharmacy create(Pharmacy pharmacy, Transaction transaction){
        pharmacy.setTxDate(transaction.getTxDate());
        pharmacy.setTxIdAdministrator(transaction.getTxIdAdmi());
        pharmacy.setTxHost(transaction.getTxHost());
        pharmacy.setTxUpdate(transaction.getTxUpdate());

        System.out.println("Create Service");
        System.out.println(pharmacy);
        pharmacyRepository.save(pharmacy);

        return pharmacy;
    }
    public List<Pharmacy> getAll(){
        return this.pharmacyRepository.findAll();
    }

}
