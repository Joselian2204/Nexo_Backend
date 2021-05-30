package com.ucb.Nexo_Backend.services;

import com.ucb.Nexo_Backend.dto.HospitalRequest;
import com.ucb.Nexo_Backend.models.Department;
import com.ucb.Nexo_Backend.models.Hospital;
import com.ucb.Nexo_Backend.models.Transaction;
import com.ucb.Nexo_Backend.repository.DepartmentRepository;
import com.ucb.Nexo_Backend.repository.HospitalRepository;
import com.ucb.Nexo_Backend.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class HospitalService {
    private HospitalRepository hospitalRepository;
    private DepartmentRepository departmentRepository;
    private TransactionRepository transactionRepository;
    @Autowired
    public HospitalService(HospitalRepository hospitalRepository, TransactionRepository transactionRepository, DepartmentRepository departmentRepository){
        this.hospitalRepository=hospitalRepository;
        this.transactionRepository=transactionRepository;
        this.departmentRepository=departmentRepository;
    }

    public HospitalRequest create(HospitalRequest hospitalRequest, Transaction transaction){
        Hospital hospital = new Hospital();
        hospital = setHospital(hospitalRequest,hospital);
        hospital.setTxDate(transaction.getTxDate());
        hospital.setTxIdAdministrator(transaction.getTxIdAdmi());
        hospital.setTxHost(transaction.getTxHost());
        hospital.setTxUpdate(transaction.getTxUpdate());
        hospitalRepository.save(hospital);
        hospitalRequest = setHospitalRequest(hospitalRequest,hospital);
        return hospitalRequest;
    }
    public List<HospitalRequest> getAll(){
        List<Hospital> listHospital= this.hospitalRepository.findAll();
        List<HospitalRequest> listHospitalRequest= new ArrayList<>();
        for (Hospital hospital: listHospital){
            HospitalRequest hospitalRequest = new HospitalRequest();
            hospitalRequest = setHospitalRequest(hospitalRequest,hospital);
            Optional<Department> department = departmentRepository.findById(hospitalRequest.getIdDepartment());
            if (department.isPresent()) {
                hospitalRequest.setIdDepartment(department.get().getName());
            }
            listHospitalRequest.add(hospitalRequest);
        }
        return listHospitalRequest;
    }
    public Hospital setHospital(HospitalRequest hospitalRequest, Hospital hospital){
        hospital.setIdDepartment(hospitalRequest.getIdDepartment());
        hospital.setName(hospitalRequest.getName());
        hospital.setLocation(hospitalRequest.getLocation());
        hospital.setPhoneNumber(hospitalRequest.getPhoneNumber());
        hospital.setLng(hospitalRequest.getLng());
        hospital.setLat(hospitalRequest.getLat());
        return hospital;
    }
    public HospitalRequest setHospitalRequest(HospitalRequest hospitalRequest, Hospital hospital){
        hospitalRequest.setIdDepartment(hospital.getIdDepartment());
        hospitalRequest.setName(hospital.getName());
        hospitalRequest.setLocation(hospital.getLocation());
        hospitalRequest.setPhoneNumber(hospital.getPhoneNumber());
        hospitalRequest.setLng(hospital.getLng());
        hospitalRequest.setLat(hospital.getLat());
        hospitalRequest.setIdHospital(hospital.getIdHospital());
        return hospitalRequest;
    }
}
