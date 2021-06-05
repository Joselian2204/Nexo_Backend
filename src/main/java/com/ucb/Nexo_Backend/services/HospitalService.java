package com.ucb.Nexo_Backend.services;

import com.ucb.Nexo_Backend.dto.HospitalRequest;
import com.ucb.Nexo_Backend.models.Department;
import com.ucb.Nexo_Backend.models.Hospital;
import com.ucb.Nexo_Backend.models.Pharmacy;
import com.ucb.Nexo_Backend.models.Transaction;
import com.ucb.Nexo_Backend.repository.DepartmentRepository;
import com.ucb.Nexo_Backend.repository.HospitalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class HospitalService {
    private HospitalRepository hospitalRepository;
    private DepartmentRepository departmentRepository;

    @Autowired
    public HospitalService(HospitalRepository hospitalRepository,DepartmentRepository departmentRepository){
        this.hospitalRepository=hospitalRepository;
        this.departmentRepository=departmentRepository;
    }

    public HospitalRequest create(HospitalRequest hospitalRequest, Transaction transaction){
        Hospital hospital = new Hospital();
        int status = 1;
        hospital = setHospital(hospitalRequest,hospital);
        hospital.setStatus(status);
        setTransaction(hospital,transaction);
        hospitalRepository.save(hospital);
        hospitalRequest = setHospitalRequest(hospitalRequest,hospital);
        return hospitalRequest;
    }
    public HospitalRequest update(HospitalRequest hospitalRequest, Transaction transaction){
        Hospital hospital = new Hospital();
        int status = 1 ;
        hospital = setHospital(hospitalRequest,hospital);
        hospital.setIdHospital(hospitalRequest.getIdHospital());
        hospital.setStatus(status);
        setTransaction(hospital,transaction);
        hospitalRepository.save(hospital);
        hospitalRequest = setHospitalRequest(hospitalRequest,hospital);
        return hospitalRequest;
    }
    public void delete(int idHospital, Transaction transaction){
        int status = 0;
        hospitalRepository.updateStatus(status,idHospital,transaction.getTxHost(),transaction.getTxIdAdmi(),transaction.getTxUpdate());
    }
    public List<HospitalRequest> getAll(){
        int status = 1;
        List<Hospital> listHospital= this.hospitalRepository.findByStatus(status);
        List<HospitalRequest> listHospitalRequest= new ArrayList<>();
        List<Department> departments = departmentRepository.findAll();
        for (Hospital hospital: listHospital){
            HospitalRequest hospitalRequest = new HospitalRequest();
            hospitalRequest = setHospitalRequest(hospitalRequest,hospital);
            hospitalRequest.setIdDepartment(searchDepartment(departments,hospitalRequest.getIdDepartment()));
            listHospitalRequest.add(hospitalRequest);
        }
        return listHospitalRequest;
    }
    private Hospital setHospital(HospitalRequest hospitalRequest, Hospital hospital){
        hospital.setIdDepartment(hospitalRequest.getIdDepartment());
        hospital.setName(hospitalRequest.getName());
        hospital.setLocation(hospitalRequest.getLocation());
        hospital.setPhoneNumber(hospitalRequest.getPhoneNumber());
        hospital.setLng(hospitalRequest.getLng());
        hospital.setLat(hospitalRequest.getLat());
        return hospital;
    }
    private HospitalRequest setHospitalRequest(HospitalRequest hospitalRequest, Hospital hospital){
        hospitalRequest.setIdDepartment(hospital.getIdDepartment());
        hospitalRequest.setName(hospital.getName());
        hospitalRequest.setLocation(hospital.getLocation());
        hospitalRequest.setPhoneNumber(hospital.getPhoneNumber());
        hospitalRequest.setLng(hospital.getLng());
        hospitalRequest.setLat(hospital.getLat());
        hospitalRequest.setIdHospital(hospital.getIdHospital());
        return hospitalRequest;
    }
    private String searchDepartment(List<Department> departments, String id){
        String nameDepartment="";
        for(Department department: departments){
            if(department.getId().equals(id))
                nameDepartment = department.getName();
        }
        return nameDepartment;
    }
    private void setTransaction(Hospital hospital, Transaction transaction){
        hospital.setTxDate(transaction.getTxDate());
        hospital.setTxIdAdministrator(transaction.getTxIdAdmi());
        hospital.setTxHost(transaction.getTxHost());
        hospital.setTxUpdate(transaction.getTxUpdate());
    }
}
