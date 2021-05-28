package com.ucb.Nexo_Backend.services;

import com.ucb.Nexo_Backend.models.Country;
import com.ucb.Nexo_Backend.models.Hospital;
import com.ucb.Nexo_Backend.models.Transaction;
import com.ucb.Nexo_Backend.repository.HospitalRepository;
import com.ucb.Nexo_Backend.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HospitalService {
    private HospitalRepository hospitalRepository;
    private TransactionRepository transactionRepository;
    @Autowired
    public HospitalService(HospitalRepository hospitalRepository, TransactionRepository transactionRepository){
        this.hospitalRepository=hospitalRepository;
        this.transactionRepository=transactionRepository;
    }

    public Hospital create(Hospital hospital, Transaction transaction){
        hospital.setTxDate(transaction.getTxDate());
        hospital.setTxIdAdministrator(transaction.getTxIdAdmi());
        hospital.setTxHost(transaction.getTxHost());
        hospital.setTxUpdate(transaction.getTxUpdate());
        hospitalRepository.save(hospital);
        //hospital.setIdHospital(transactionRepository.createSQLQuery("SELECT LAST_INSERT_ID()"));
        return hospital;
    }
    public List<Hospital> getAll(){
        return this.hospitalRepository.findAll();
    }
}
