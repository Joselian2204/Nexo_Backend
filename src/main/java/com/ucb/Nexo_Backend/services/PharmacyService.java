package com.ucb.Nexo_Backend.services;

import com.ucb.Nexo_Backend.dto.PharmacyRequest;
import com.ucb.Nexo_Backend.models.Department;
import com.ucb.Nexo_Backend.models.Pharmacy;
import com.ucb.Nexo_Backend.models.Transaction;
import com.ucb.Nexo_Backend.repository.DepartmentRepository;
import com.ucb.Nexo_Backend.repository.HospitalRepository;
import com.ucb.Nexo_Backend.repository.PharmacyRepository;
import com.ucb.Nexo_Backend.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PharmacyService {
    private PharmacyRepository pharmacyRepository;
    private DepartmentRepository departmentRepository;
    private TransactionRepository transactionRepository;

    @Autowired
    public PharmacyService(PharmacyRepository pharmacyRepository, TransactionRepository transactionRepository, DepartmentRepository departmentRepository) {
        this.pharmacyRepository = pharmacyRepository;
        this.transactionRepository = transactionRepository;
        this.departmentRepository=departmentRepository;
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
        List<Pharmacy> listPharmacy= this.pharmacyRepository.findAll();
        List<PharmacyRequest> listPharmacyRequest= new ArrayList<>();
        List<Department> departments = departmentRepository.findAll();
        for (Pharmacy pharmacy: listPharmacy){
            PharmacyRequest pharmacyRequest = new PharmacyRequest();
            pharmacyRequest = setPharmacyRequest(pharmacyRequest,pharmacy);
            pharmacyRequest.setIdDepartment(searchDepartment(departments,pharmacyRequest.getIdDepartment()));
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
        pharmacyRequest.setIdPharmacy(pharmacy.getIdPharmacy());
        pharmacyRequest.setIdDepartment(pharmacy.getIdDepartment());
        pharmacyRequest.setName(pharmacy.getName());
        pharmacyRequest.setLocation(pharmacy.getLocation());
        pharmacyRequest.setPhoneNumber(pharmacy.getPhoneNumber());
        pharmacyRequest.setLng(pharmacy.getLng());
        pharmacyRequest.setLat(pharmacy.getLat());
        pharmacyRequest.setIdPharmacy(pharmacy.getIdPharmacy());
        return pharmacyRequest;
    }
    private String searchDepartment(List<Department> departments, String id){
        String nameDepartment="";
        for(Department department: departments){
            if(department.getId().equals(id))
                nameDepartment = department.getName();
        }
        return nameDepartment;
    }

}
