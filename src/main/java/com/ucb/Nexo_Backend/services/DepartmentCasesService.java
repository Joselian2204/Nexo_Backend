package com.ucb.Nexo_Backend.services;

import com.ucb.Nexo_Backend.models.DepartmentCases;
import com.ucb.Nexo_Backend.repository.DepartmentCasesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentCasesService {
    private DepartmentCasesRepository repo;
    @Autowired
    public void setRepo(DepartmentCasesRepository repo){
        this.repo = repo;
    }
    public List<DepartmentCases> getByDepartmentId(String id){
        return repo.findByDepartmentId(id);
    }
}
